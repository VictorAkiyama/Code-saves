#include <stdio.h>  // funções scanf e printf (entrada e saída)
#include <string.h> // funções strcpy, strcspn e getchar
#include <stdlib.h> // funções malloc e free (manipulação de memória) - atoi (converte numero em string para int)


//cria um struct com a tarefa e um ponteiro para o proximo item
struct Item {
    int posicao; //identificador da tarefa na lista
    char tarefa[50];

    struct Item *prox; //ponteiro que uarda um endereço de memória que aponta para outro Item.
    //Assim, cada Item sabe onde está o próximo, formando uma lista ordenada.
    //Se prox for NULL, significa que não existe próximo Item e a lista termina ali.

};

typedef struct Item Item; //define um apelido para struct Item

// Cria um novo Item
struct Item* criarItem(char *texto, int posicao) {

    // malloc aloca um espaço na memória do tamanho do Item
    Item *novo = malloc(sizeof(Item));  //ponteiro que possui o endereço de memória do novo nodo

    // copia o texto da tarefa para dentro do campo tarefa do novo Item
    strcpy(novo->tarefa, texto);    //strcpy(destino, origem) move a string do ponteiro "*texto" para a tarefa do novo nodo

    novo->prox = NULL; // quando criado, ele aponta para NULL. Ponteiro do novo nodo vazio

    novo->posicao = posicao; // posicao do novo nodo atribuído

    return novo; // retorna o novo Item criado
}

//limpa o terminal dependendo do SO
void limpar() {
#ifdef _WIN32 //se _WIN32 estiver definido
    system("cls");
#else
    system("clear");
#endif
}


// Mostrar lista inteira de tarefas
void imprimirLista(Item *lista) {
    Item *atual = lista; // ponteiro auxiliar para percorrer a lista

    printf("**************Lista de tarefas**************\n\n");

    // percorre enquanto houver item na lista
    if (atual != NULL){
        while (atual != NULL) {
        printf("- Tarefa %d: %s\n", atual->posicao, atual->tarefa); // imprime a tarefa do Item atual, pega a tarefa do endereco de atual
        atual = atual->prox;   // vai para o próximo Item/nodo
        }
    } else {
        printf("Nenhuma tarefa para fazer!\n");
    }

    printf("\n********************************************\n\n");
}

void lerLista(struct Item*lista) {
    struct Item *atual = lista;
    imprimirLista(atual);
    printf("\nPressione ENTER para continuar...\n");
    getchar();
}

// adiciona a tarefa
void adicionar(Item **lista, int *posicao_atual, int posicoes_ocupadas[], int *total_posicoes_ocupadas){ //**lista: pega o ponteiro do ponteiro da lista
        char tarefa[50]; // variável que recebe o texto digitado

        printf("**************Adicionar tarefa**************\n");
        printf("Quer colocar a nova tarefa em uma posicao especifica?\n\n");
        printf("1. Digite a letra [s] se sim. \n" );
        printf("2. Digite qualquer outra letra se nao. \n\n");
        
        char opcao2 = 'x';
        printf("Digite uma opcao: ");
        scanf(" %c", &opcao2);
        getchar();// tira o ENTER que sobra
        
        int posicaoSelecionada;
        int posicao;
        int len = *total_posicoes_ocupadas;
        int verificador = 0;
        if (opcao2 == 's') {
            printf("\n\nDigite a posicao da nova tarefa: " );
            scanf("%d", &posicaoSelecionada);
            getchar();
            
            int i; // verifica se a posicao esta ocupada para ser usada
            for (i = 0; i < len; i++) {
                if (posicaoSelecionada == posicoes_ocupadas[i]) {
                    verificador = 1;
                    break;
                }
            }
            
            //mostra se a posicao foi encontrada na lista posições_ocupadas[]
            if (verificador == 1) {
                printf("\n\nPosicao esta ocupada.\n");
                printf("Pressione ENTER para continuar...\n");
                getchar();
                return;
            }
            //mostra se a posicao não foi encontrada na lista posições_ocupadas[]
            else if (verificador == 0) {
                posicao = posicaoSelecionada; //atribui a posição selecionada para a posição, que vai ser usada ao criar a tarefa no criarItem(tarefa, posicao)
                printf("\n\nPosicao esta livre.\n");
            }
        } else {
            printf("\n\nA tarefa vai possuir a posicao mais recente.\n\n");
            //atribui a posição_atual para a posição
            posicao = *posicao_atual;
            //aumenta posição_atual, usado para quando o usuario opta por nao escolher uma posição para a tarefa
            (*posicao_atual)++;
        }

        //atribui a posição da tarefa na lista de posições_ocupadas[]
        posicoes_ocupadas[*total_posicoes_ocupadas] = posicao;
        //aumenta o total
        (*total_posicoes_ocupadas)++;


        printf("Escreva a tarefa:\n");

        // fgets(variavel, tamanho, stdin):
        // igual ao scanf, mas permite espaços
        fgets(tarefa, 50, stdin);

        // troca o \n pelo \0 para não salvar a quebra de linha
        // strcspn(variavel, char) -> retorna a posicao do char na string
        tarefa[strcspn(tarefa, "\n")] = '\0';

        // cria um Item com a tarefa do usuário
        Item *novo = criarItem(tarefa, posicao); // cria um nodo com a tarefa do usuario

        // novo->prox aponta para o antigo primeiro item da lista
        novo->prox = *lista;    // o ponteiro de nodo "novo" agora aponta para NULL

        // o novo agora vira o primeiro da lista
        *lista = novo;  // o valor e ponteiro do nodo inicial (cabeça) muda para o novo nodo

        printf("Adicionada a tarefa:\n\n  %s\n\n", tarefa);
        printf("Pressione ENTER para continuar...\n");
        getchar(); // igual input()
}


// troca a tarefa de um Item por uma nova
void alterar(Item *lista) {
    Item *atual = lista; // ponteiro para percorrer a lista

    char buffer[10]; // define o tamanho máximo da entrada
    int posicaoSelecionada; // guarda a posicao que será buscado
    char nova[50];   // guarda o novo conteúdo da tarefa

    imprimirLista(atual); // mostra lista de tarefas

    printf("******************Alterar tarefa******************\n\n");
    printf("Digite a posicao da tarefa que deseja alterar:\n");
    fgets(buffer, sizeof(buffer), stdin);
    buffer[strcspn(buffer, "\n")] = '\0';  // remove quebra linha
    posicaoSelecionada = atoi(buffer); //atoi() pega o número representado em string e devolva um número inteiro correspondente

    // percorre a lista
    while (atual != NULL) {

        // compara a posicao da tarefa atual com a posicao digitada
        if (atual->posicao == posicaoSelecionada) {
            
            //mostra a tarefa selecionada
            printf("Tarefa '%s' de posicao %d selecionada\n", atual->tarefa, atual->posicao);

            //obtém a nova tarefa para a posição
            printf("Digite a nova tarefa:\n");
            fgets(nova, 50, stdin);
            nova[strcspn(nova, "\n")] = '\0';

            strcpy(atual->tarefa, nova); // substitui o texto da tarefa

            printf("Tarefa alterada!\n");
            printf("Pressione ENTER para continuar...\n");
            getchar();
            return;
        }

        atual = atual->prox; // avança para o proximo Item na lista
    }

    // se não encontrou a tarefa
    printf("Tarefa nao encontrada.\n");
    printf("Pressione ENTER para continuar...\n");
    getchar();
}


// exclui o Item da lista
void excluir(Item **lista, int posicoes_ocupadas[], int *total_posicoes_ocupadas) {

    char buffer[10]; // limite para entrada do usuario para posicaoSelecionada
    int posicaoSelecionada; // guarda a posicao da tarefa a excluir

    Item *atual = *lista;     // ponteiro que caminha pela lista
    Item *anterior = NULL;    // guarda o Item anterior

    imprimirLista(atual); // mostra lista de tarefas

    printf("******************Excluir tarefa**********************\n\n");
    printf("Digite a posicao da tarefa que deseja excluir:\n");
    fgets(buffer, sizeof(buffer), stdin);
    buffer[strcspn(buffer, "\n")] = '\0';
    posicaoSelecionada = atoi(buffer);

    // percorre a lista até achar a tarefa
    while (atual != NULL) {

        // testa se é a tarefa que queremos excluir
        if (atual->posicao == posicaoSelecionada) {

            //mostra a tarefa selecionada
            printf("Tarefa '%s' de posicao %d selecionada\n", atual->tarefa, atual->posicao);

            // se for o primeiro item
            if (anterior == NULL) {
                *lista = atual->prox;
            }
            // se for um item do meio ou fim
            else {
                anterior->prox = atual->prox;
            }

            free(atual); // libera memória

            int i, j;
            int len = *total_posicoes_ocupadas;
            // deleta a posicao selecionada da lista de posicoes ocupadas
            for (i = 0; i < len; i++) {
                if (posicaoSelecionada == posicoes_ocupadas[i]) {
                    // a partir da posição selecionada, ocorre o abaixo, deletando o índice aonde a posição selecionada estava
                    // leva os elementos uma casa para a esquerda na lista posicoes_ocupadas[]
                    for (j = i; j < len - 1; j++) {     // (j < len - 1) essa expressão é para evitar que dê erro de índice fora de alcance
                        posicoes_ocupadas[j] = posicoes_ocupadas[j + 1];
                    }
                    (*total_posicoes_ocupadas)--; //diminui o total de posições ocupadas
                    break;
                }
            }

            printf("Tarefa excluida!\n");
            printf("Pressione ENTER para continuar...\n");
            getchar();
            return;
        }

        anterior = atual;       // avança o anterior
        atual = atual->prox;    // avança o atual
    }

    // se não achou a tarefa
    printf("Tarefa nao encontrada.\n");
    printf("Pressione ENTER para continuar...\n");
    getchar();
}




int main(){

    struct Item *lista = NULL; //o primeiro ponteiro (cabeça) que aponta para NULL, criando a lista como NULL
    char opcao = 'x'; // variável que guarda a opção do usuário
    
    int posicoes_ocupadas[100]; // total de 100 posições para 100 tarefas
    int total_posicoes_ocupadas = 0; // quantidade de posições ocupadas, usado no adicionar
    int posicao_atual = 1; // essencial para que o valor "posição" das listas sejam incrementais
    while (opcao != 's'){

        limpar();
        // menu inicial
        printf("******************* MENU *******************\n \n");
        printf("Digite a letra [a] para adicionar uma tarefa. \n" );
        printf("Digite a letra [m] para mudar uma tarefa. \n");
        printf("Digite a letra [e] para excluir uma tarefa. \n");
        printf("Digite a letra [l] para ler as tarefas. \n");
        printf("Digite a letra [s] para sair. \n \n" );

        
        printf("Digite uma opcao: ");
        
        scanf(" %c", &opcao); // lê uma letra 
        getchar();// tira o ENTER que sobra

        // verifica a opção escolhida
        if(opcao == 'm'){
            limpar();
            alterar(lista); 
            
        } else if (opcao == 'e'){
            limpar();
            excluir(&lista, posicoes_ocupadas, &total_posicoes_ocupadas); 

        } else if (opcao == 'l'){
            limpar();
            lerLista(lista);
    
        } else if(opcao == 'a'){
            limpar();
            adicionar(&lista, &posicao_atual, posicoes_ocupadas, &total_posicoes_ocupadas);

        } else if(opcao != 's'){
            printf("opcao invalida, pressione ENTER para continuar...");
            getchar();
        }
        printf("******************************************** \n" );
    
    }

    return 0;
}
