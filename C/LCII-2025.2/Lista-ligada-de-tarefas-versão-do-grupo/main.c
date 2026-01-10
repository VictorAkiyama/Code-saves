#include <stdio.h>  // funções scanf e printf (entrada e saída)
#include <string.h> // funções strcpy, strcspn e getchar
#include <stdlib.h> // funções malloc e free (manipulação de memória)


//cria um struct com a tarefa e um ponteiro para o proximo item
struct Item {
    char tarefa[50];

    struct Item *prox; //ponteiro que uarda um endereço de memória que aponta para outro Item.
    //Assim, cada Item sabe onde está o próximo, formando uma lista ordenada.
    //Se prox for NULL, significa que não existe próximo Item e a lista termina ali.

}; 

typedef struct Item Item; //define um apelido para struct Item

// Cria um novo Item
struct Item* criarItem(char *texto) {

    // malloc aloca um espaço na memória do tamanho do Item
    Item *novo = malloc(sizeof(Item));

    // copia o texto da tarefa para dentro do campo tarefa do novo Item
    strcpy(novo->tarefa, texto);

    novo->prox = NULL; // quando criado, ele aponta para NULL

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
        printf("- %s\n", atual->tarefa); // imprime a tarefa do Item atual
        atual = atual->prox;   // vai para o próximo Item
        }
    } else {
        printf("Nenhuma tarefa para fazer!\n");
    }

    printf("\nPressione ENTER para continuar...\n");
    getchar(); // espera usuário apertar enter
}

// adiciona a tarefa
void adicionar(Item **lista){ //**lista: pega o ponteiro do ponteiro da lista
        char tarefa[50]; // variável que recebe o texto digitado

        printf("**************Adicionar tarefa**************\n");
        printf("Escreva a tarefa:\n");

        // fgets(variavel, tamanho, stdin):
        // igual ao scanf, mas permite espaços
        fgets(tarefa, 50, stdin);

        // troca o \n pelo \0 para não salvar a quebra de linha
        tarefa[strcspn(tarefa, "\n")] = '\0';

        // cria um Item com a tarefa do usuário
        Item *novo = criarItem(tarefa);

        // novo->prox aponta para o antigo primeiro item da lista
        novo->prox = *lista;

        // o novo agora vira o primeiro da lista
        *lista = novo;

        printf("Adicionada a tarefa:\n\n  %s\n\n", tarefa);
        printf("Pressione ENTER para continuar...\n");
        getchar(); // igual input()
}


// troca a tarefa de um Item por uma nova
void alterar(Item *lista) {

    char antiga[50]; // guarda o nome que será buscado
    char nova[50];   // guarda o novo nome da tarefa

    printf("******************Alterar tarefa******************\n\n");
    printf("Digite exatamente a tarefa que deseja alterar:\n");
    fgets(antiga, 50, stdin); // recebe a tarefa antiga
    antiga[strcspn(antiga, "\n")] = '\0'; // remove o ENTER

    Item *atual = lista; // ponteiro para percorrer a lista

    // percorre a lista
    while (atual != NULL) {

        // compara tarefa atual com a tarefa digitada
        if (strcmp(atual->tarefa, antiga) == 0) {

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

    char nome[50]; // guarda o nome da tarefa a excluir

    printf("******************Excluir tarefa**********************\n\n");
    printf("Digite exatamente a tarefa que deseja excluir:\n");
    fgets(nome, 50, stdin);
    nome[strcspn(nome, "\n")] = '\0';

    Item *atual = *lista;     // ponteiro que caminha pela lista
    Item *anterior = NULL;    // guarda o Item anterior

    // percorre a lista até achar a tarefa
    while (atual != NULL) {

        // testa se é a tarefa que queremos excluir
        if (strcmp(atual->tarefa, nome) == 0) {

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

    struct Item *lista = NULL; //cria o ponteiro do Item como NULL (lista vazia)
    char opcao = 'x'; // variável que guarda a opção do usuário
    
    while (opcao != 's'){

        limpar();
        // menu inicial
        printf("*********************** MENU *******************************\n \n");
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
            imprimirLista(lista);
    
        } else if(opcao == 'a'){
            limpar();
            adicionar(&lista);
            
        } else if(opcao != 's'){
            printf("opcao invalida, pressione ENTER para continuar...");
            getchar();
        }
        printf("****************************************************** \n" );
    
    }

    return 0;
}
