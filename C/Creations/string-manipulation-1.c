#include <stdio.h>
#include <string.h>

void inverter(char array[], char array_invertido[]) {
    
    int i;
    int len = strlen(array);
    int j = len - 1;

    // faz loop no "array" do começo ao fim, e faz loop no "array_invertido" do fim até o começo
    for (i = 0; i < len; i++) {
        array_invertido[j] = array[i];
        j--;
    }

    array_invertido[len] = '\0';
}

void baguncar(char array[], char array_baguncado[]) {

    int i;
    int len = strlen(array);
    char caractere_array_ASCII;

    for (i = 0; i < len; i++) {
        caractere_array_ASCII = (int)array[i];  // obtem o valor ASCII do caractere de array
        caractere_array_ASCII ++;   // aumenta o valor ASCII por um
        array_baguncado[i] = (char)caractere_array_ASCII;   // atribui o valor ASCII convertido em caractere no array_baguncado
    }

    array_baguncado[len] = '\0';
}

int main() {
    
    char array[10];
    char array_invertido[10];
    char array_baguncado[10];

    printf("Digite o conteúdo do array: ");
    scanf("%9s", array);

    inverter(array, array_invertido);
    printf("\nArray invertido: %s", array_invertido);

    baguncar(array, array_baguncado);
    printf("\nArray bagunçado: %s", array_baguncado);
}


// VERSÃO 1.0
// ERROS:
// 1. Ambos "array_invertido" e "array_baguncado" são arrays, e arrays não podem ser atribuidos
//      Exemplo: array1 = array2;
// 2. Arrays não precisem ser referenciados através de "&" nas funções, as arrays já apontam para seu conteúdo
//      Exemplo: inverter(&array, &array_invertido) -> inverter(array, array_invertido)
/*

#include <stdio.h>

char inverter(char array[], char array_invertido[]) {
    
    int i;
    int j = 8;

    // faz loop no "array" do começo ao fim, e faz loop no "array_invertido" do fim até o começo
    for (i = 0; i < 9; i++) {
        array_invertido[j] = array[i];
        j--;
    }

    return array_invertido;
}

char baguncar(char array[], char array_baguncado[]) {}

int main() {
    
    char array[10];
    char array_invertido[10];
    char array_baguncado[10];

    printf("Digite o conteúdo do array: ");
    scanf("%9s", array);

    array_invertido = inverter(&array, &array_invertido);
    printf("\nArray invertido: %s", array_invertido);

    array_baguncado = baguncar(&array, &array_baguncado);
    printf("\nArray bagunçado: %s", array_baguncado);
}

*/


// VERSÃO 1.1
// ERROS RESOLVIDOS:
// 1. Ambos "array_invertido" e "array_baguncado" são arrays, e arrays não podem ser atribuidos
// 2. Arrays não precisem ser referenciados através de "&" nas funções, as arrays já apontam para seu conteúdo
// ADIÇÕES:
// 1. "array_invertido[9] = '\0';" adicionado na função inverter();
//      Para servir como sinal para parar no final do array ao mostrá-lo com printf()
// ERROS:
// 1. O "array" com menos de 9 caracteres não funciona ao ser invertido
//      Exemplo: o usuário digita "12345" para o array, e ao ser invertido na função, o novo array invertido fica vazio
/*

#include <stdio.h>

void inverter(char array[], char array_invertido[]) {
    
    int i;
    int j = 8;

    // faz loop no "array" do começo ao fim, e faz loop no "array_invertido" do fim até o começo
    for (i = 0; i < 9; i++) {
        array_invertido[j] = array[i];
        j--;
    }

    array_invertido[9] = '\0';
}

void baguncar(char array[], char array_baguncado[]) {}

int main() {
    
    char array[10];
    char array_invertido[10];
    char array_baguncado[10];

    printf("Digite o conteúdo do array: ");
    scanf("%9s", array);

    inverter(array, array_invertido);
    printf("\nArray invertido: %s", array_invertido);

    baguncar(array, array_baguncado);
    printf("\nArray bagunçado: %s", array_baguncado);
}

*/


// VERSÃO 1.2
// ERROS RESOLVIDOS:
// 1. O "array" com menos de 9 caracteres não funciona ao ser invertido
//      Solução: utilizar a função "strlen()" para pegar a largura do array, independente de sua largura, agora o array invertido fica certo
/*

#include <stdio.h>
#include <string.h>

void inverter(char array[], char array_invertido[]) {
    
    int i;
    int len = strlen(array);
    int j = len - 1;

    // faz loop no "array" do começo ao fim, e faz loop no "array_invertido" do fim até o começo
    for (i = 0; i < len; i++) {
        array_invertido[j] = array[i];
        j--;
    }

    array_invertido[len] = '\0';
}

void baguncar(char array[], char array_baguncado[]) {}

int main() {
    
    char array[10];
    char array_invertido[10];
    char array_baguncado[10];

    printf("Digite o conteúdo do array: ");
    scanf("%9s", array);

    inverter(array, array_invertido);
    printf("\nArray invertido: %s", array_invertido);

    baguncar(array, array_baguncado);
    printf("\nArray bagunçado: %s", array_baguncado);
}

*/


// VERSÃO 1.3 - FINAL
// ADIÇÕES:
// 1. A função "bagunçar";
//      Pega cada caractere do array, transforma em ASCII, aumento o valor ASCII em um, transforma o ASCII em caractere e atribui a array_baguncado
/*

#include <stdio.h>
#include <string.h>

void inverter(char array[], char array_invertido[]) {
    
    int i;
    int len = strlen(array);
    int j = len - 1;

    // faz loop no "array" do começo ao fim, e faz loop no "array_invertido" do fim até o começo
    for (i = 0; i < len; i++) {
        array_invertido[j] = array[i];
        j--;
    }

    array_invertido[len] = '\0';
}

void baguncar(char array[], char array_baguncado[]) {

    int i;
    int len = strlen(array);
    char caractere_array_ASCII;

    for (i = 0; i < len; i++) {
        caractere_array_ASCII = (int)array[i];  // obtem o valor ASCII do caractere de array
        caractere_array_ASCII ++;   // aumenta o valor ASCII por um
        array_baguncado[i] = (char)caractere_array_ASCII;   // atribui o valor ASCII convertido em caractere no array_baguncado
    }

    array_baguncado[len] = '\0';
}

int main() {
    
    char array[10];
    char array_invertido[10];
    char array_baguncado[10];

    printf("Digite o conteúdo do array: ");
    scanf("%9s", array);

    inverter(array, array_invertido);
    printf("\nArray invertido: %s", array_invertido);

    baguncar(array, array_baguncado);
    printf("\nArray bagunçado: %s", array_baguncado);
}

*/