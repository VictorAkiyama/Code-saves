// adicionar tarefa

#include <stdio.h> // scanf e printf (entrada e saida)
#include <string.h> // strcpy e strcspn
#include <stdlib.h> // malloc e free (manipulacao de memoria) - atoi (converte numero em string para int)

//cria um struct com a tarefa e um ponteiro para o proximo item
struct Item {
    int posicao; //identificador da tarefa na lista
    char tarefa[50]; // recebe uma string de 50 caracteres no maximo
    
    struct Item *prox;//Este campo guarda um endereço de memória que aponta para outro nodo.
    //Assim, cada nodo sabe onde está o próximo, formando uma corrente.
    //Se prox for NULL, significa que não existe próximo nodo e a lista termina ali.
    
}; //define um apelido para struct Nodo

// Cria um novo nodo
struct Item* criarItem(char *texto, int posicao) {
    
    struct Item *novo = malloc(sizeof(struct Item)); //ponteiro que possui o endereço de memória do novo nodo
    strcpy(novo->tarefa, texto); //strcpy(destino, origem) move a string do ponteiro "*texto" para a tarefa do novo nodo
    novo->prox = NULL; // ponteiro do novo nodo vazio
    novo->posicao = posicao; // posicao do novo nodo atribuído
    return novo;
}

// Imprime a lista inteira
void imprimirLista(struct Item *lista) {
    struct Item *atual = lista;
    
    printf("\n**************Lista de tarefas**************\n\n");

    while (atual != NULL) {
        printf("- Tarefa %d: %s\n", atual->posicao, atual->tarefa); // do endereco de atual pega a tarefa
        atual = atual->prox;   // vai para o próximo nodo
    }
}

void alterar(struct Item *lista) {
    struct Item *atual = lista;
    imprimirLista(atual);

    char buffer[10]; // define o tamanho máximo da entrada
    int posicaoSelecionada;
    printf("\ndigite o numero da tarefa na lista que deseja alterar: ");
    fgets(buffer, sizeof(buffer), stdin);
    buffer[strcspn(buffer, "\n")] = '\0';  // remove quebra linha
    posicaoSelecionada = atoi(buffer); //atoi() pega o número representado em string e devolva um número inteiro correspondente

    while (atual != NULL) {
        if (atual->posicao == posicaoSelecionada) {
            //mostra a tarefa selecionada
            printf("Tarefa '%s' de posicao %d selecionada\n", atual->tarefa, atual->posicao);
            //obtém a nova tarefa para a posição
            printf("Digite a nova tarefa: ");
            char novaTarefa[50];
            fgets(novaTarefa, 50, stdin);
            //remove o enter \n e o troca por \0
            novaTarefa[strcspn(novaTarefa, "\n")] = '\0';
            //coloca nova tarefa na posicao
            strcpy(atual->tarefa, novaTarefa);
            printf("\nTarefa alterada com sucesso\n");
            printf("\nPressione qualquer tecla para continuar...\n");
            getchar();
            printf("\033[2J\033[H");
            //sai do loop
            return;
        }
        else {
            atual = atual->prox;
        }
    }
}

void excluir(struct Item *lista) {
    struct Item *atual = lista;
    imprimirLista(atual);

    char buffer[10];
    int posicaoSelecionada;
    printf("\ndigite o numero da tarefa na lista que deseja excluir: ");
    fgets(buffer, sizeof(buffer), stdin);
    buffer[strcspn(buffer, "\n")] = '\0';
    posicaoSelecionada = atoi(buffer);

    while (atual != NULL) {
        if (atual->posicao == posicaoSelecionada) {
            //mostra a tarefa selecionada
            printf("Tarefa '%s' de posicao %d selecionada\n", atual->tarefa, atual->posicao);
            
            //limpa a tarefa
            char tarefaLimpa[50] = "";
            strcpy(atual->tarefa, tarefaLimpa);

            printf("\nTarefa excluída com sucesso\n");
            printf("\nPressione qualquer tecla para continuar...\n");
            getchar();
            printf("\033[2J\033[H");
            //sai do loop
            return;
        }
        else {
            atual = atual->prox;
        }
    }
}

void lerLista(struct Item *lista) {
    struct Item *atual = lista;
    imprimirLista(atual);
    printf("\nPressione qualquer tecla para continuar...\n");
    getchar();
    printf("\033[2J\033[H");
}

// adiciona a tarefa
void adicionar(struct Item **lista, int posicao){ //**lista: pega o ponteiro do ponteiro da lista
        char tarefa[50];
        
        printf("**************Adicionar tarefas**************\n");
        printf("Escreva a tarefa: ");
        
        //fgets(variavel, tamanho, stdin)
        //igual o scanf mas para strings completas com espaços
        fgets(tarefa, 50, stdin);
        
        printf("\033[2J\033[H"); // limpa o terminal
        
        //troca o \n pelo \0 para não printar o enter
        //strcspn(variavel, char) -> retorna a posicao do char na string
        tarefa[strcspn(tarefa, "\n")] = '\0';
        
        struct Item *novo = criarItem(tarefa, posicao); // cria um nodo com a tarefa do usuario
        novo->prox = *lista;   // o ponteiro de nodo "novo" agora aponta para NULL
        *lista = novo;  // o valor e ponteiro do nodo inicial (cabeça) muda para o novo nodo
        
        printf("Adicionada a tarefa:\n\n  %s\n\n", tarefa);
        printf("Pressione qualquer tecla para continuar...\n");
        getchar(); // igual input()
        printf("\033[2J\033[H");

    }
    
int main(){
    struct Item *lista = NULL; //o primeiro ponteiro (cabeça) que aponta para NULL, criando a lista como NULL
    
    int posicao = 1; // essencial para que o valor "posição" das listas sejam incrementais
    int loop = 1;
    char buffer[10]; // essencial para o fgets() que pega a opção
    while (loop == 1) {
        printf("****************************************************** \n \n" );
        printf("Digite a letra [a] se quiser alterar uma tarefa \n");
        printf("Digite a letra [e] se quiser excluir uma tarefa \n" );
        printf("Digite a letra [l] se quiser ler as tarefas \n" );
        printf("Digite a letra [d] se quiser adicionar uma tarefa \n \n" );


        char opcao;
        printf("Digite uma opcao: ");
        fgets(buffer, 10, stdin);
        buffer[strcspn(buffer, "\n")] = '\0';
        opcao = buffer[0];
        
        if(opcao == 'a'){
            printf("\033[2J\033[H");
            alterar(lista);
        } else if (opcao == 'e'){
            printf("\033[2J\033[H");
            excluir(lista);
        } else if (opcao == 'l'){
            printf("\033[2J\033[H");
            lerLista(lista);
        } else if(opcao == 'd'){
            adicionar(&lista, posicao);
            posicao += 1;
        }
        printf("****************************************************** \n" );
    }
   
    return 0;
}

//dicas: codeguru
