#include <stdio.h>
#include <stdlib.h>

struct no_de_lista {
    //informação
    int valor;
    //ponteiro que aponta para o proximo
    struct no_de_lista * proximo;
};

int main() {
    // ponteiro que aponta para uma nova instancia de no_de_lista
    struct no_de_lista * lista;
    // aloca memoria para o ponteiro
    lista = malloc(sizeof(struct no_de_lista));
    //atribui valor para informação
    lista->valor = 10;

    // aloca memoria para o proximo*1 ponteiro
    lista->proximo = malloc(sizeof(struct no_de_lista));
    //atribui valor para o proximo*1
    lista->proximo->valor = 15;

    // aloca memoria para o proximo do proximo*2 ponteiro
    lista->proximo->proximo = malloc(sizeof(struct no_de_lista));
    //atribui valor para o proximo*2
    lista->proximo->proximo->valor = 30;

    // não aloca memoria para o proximo do proximo do proximo*3 ponteiro
    lista->proximo->proximo->proximo = NULL;

    // ponteiro do percorredor, que aponta para o endereço atual da lista, para que fique no endereço de ponteiro inicial
    struct no_de_lista * percorredor = lista;
    // para que o percorredor obtenha os proximos ponteiros
    while(percorredor != NULL) {
        // obtem o ponteiro da informação do proximo atual, como também o endereço do percorredor e do proximo
        printf("Para endereço: %d; O valor de: %d; E o ponteiro para o próximo: %d\n", percorredor, percorredor->valor, percorredor->proximo);
        // percorredor é o que obtem o endereço do proximo ponteiro "proximo"
        percorredor = percorredor->proximo;
    }
}
