// adicionar tarefa

#include <stdio.h> // scanf e printf (entrada e saida)
#include <string.h> // strcpy e strcspn
#include <stdlib.h> // malloc e free (manipulacao de memoria)

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
    printf("\ndigite o numero da tarefa na lista que deseja alterar: ");
    
    int posicaoSelecionada;
    scanf("%d", &posicaoSelecionada);
    getchar(); //pega o espaço que conclui o scanf acima, para que o fgets abaixo nao detecte o espaço e passe direto

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
            //sai do loop
            return;
        }
        else {
            atual = atual->prox;
        }
    }
}

// adiciona a tarefa
void adicionar(struct Item **lista, int posicao){ //**lista: pega o ponteiro do ponteiro da lista
        char tarefa[50];
        
        printf("**************Adicionar tarefas**************\n");
        printf("Escreva a tarefa: ");
        
        //fgets(variavel, tamanho, stdin)
        //igual o scanf mas para strings completas com espaços
        fgets(tarefa, 50, stdin);
        
        system("cls"); // limpa o terminal
        
        //troca o \n pelo \0 para não printar o enter
        //strcspn(variavel, char) -> retorna a posicao do char na string
        tarefa[strcspn(tarefa, "\n")] = '\0';
        
        struct Item *novo = criarItem(tarefa, posicao); // cria um nodo com a tarefa do usuario
        novo->prox = *lista;   // o ponteiro de nodo "novo" agora aponta para NULL
        *lista = novo;  // o valor e ponteiro do nodo inicial (cabeça) muda para o novo nodo
        
        printf("Adicionada a tarefa:\n\n  %s\n\n",tarefa);
        printf("Pressione qualquer tecla para continuar...\n");
        getchar(); // igual input()
        system("cls");

    }
    
int main(){
    struct Item *lista = NULL; //o primeiro ponteiro (cabeça) que aponta para NULL, criando a lista como NULL
    
    int posicao = 1; // essencial para que o valor "posição" das listas sejam incrementais
    int loop = 1;
    while (loop == 1) {
        printf("****************************************************** \n \n" );
        printf("Digite a letra [a] se quiser alterar uma tarefa \n");
        printf("Digite a letra [e] se quiser excluir uma tarefa \n" );
        printf("Digite a letra [l] se quiser ler as tarefas \n" );
        printf("Digite a letra [d] se quiser adicionar uma tarefa \n \n" );


        char opcao;
        printf("Digite uma opcao: ");
        scanf(" %c", &opcao);
        getchar();
        
        if(opcao == 'a'){
            system("cls");
            alterar(lista);
        } else if (opcao == 'e'){
            //FAZER
        } else if (opcao == 'l'){
            system("cls");
            imprimirLista(lista);
            printf("\nPressione qualquer tecla para continuar...\n");
            getchar();
        } else if(opcao == 'd'){
            adicionar(&lista, posicao);
            posicao += 1;
        }
        printf("****************************************************** \n" );
    }
   
    return 0;
}

//dicas: codeguru
