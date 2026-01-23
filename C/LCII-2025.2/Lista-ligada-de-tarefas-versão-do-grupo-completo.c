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
void adicionar(Item **lista, int posicao){ //**lista: pega o ponteiro do ponteiro da lista
        char tarefa[50]; // variável que recebe o texto digitado

        printf("**************Adicionar tarefa**************\n");
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
void excluir(Item **lista) {

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
    
    int posicao = 1; // essencial para que o valor "posição" das listas sejam incrementais
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
            excluir(&lista); 

        } else if (opcao == 'l'){
            limpar();
            lerLista(lista);
    
        } else if(opcao == 'a'){
            limpar();
            adicionar(&lista, posicao);
            posicao += 1;

        } else if(opcao != 's'){
            printf("opcao invalida, pressione ENTER para continuar...");
            getchar();
        }
        printf("******************************************** \n" );
    
    }

    return 0;
}
