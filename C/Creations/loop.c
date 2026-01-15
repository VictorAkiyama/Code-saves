#include <stdio.h>
#include <string.h>

int main() {

    //boa prática estabelecer uma quantidade de caracteres para a lista char
    char continuar[10] = "TRUE";
    int cont = 0;

    while (strcmp(continuar, "TRUE") == 0) {
        // as condicionais precisam de "cont != 0", senão vai ativar ambos as condicionais
        if (cont % 50000000 == 0 && cont != 0) {
            printf("...\n");
        }
        if (cont % 500000000 == 0 && cont != 0) {
            printf("Digite a palavra 'TRUE' para continuar: ");
            //sem "\n", senão o input fica esperando para sempre
            scanf("%9s", continuar);
        }
        cont += 1;
    }

    return 0;
}
