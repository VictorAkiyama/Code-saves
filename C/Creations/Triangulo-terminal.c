/*Desenhar um triângulo no terminal*/
'''
Desenhar um triângulo no terminal:
10) Faça um programa que leia um valor N representando uma altura de um
triângulo, e em seguida, o programa deve desenhar um triângulo conforme o
exemplo abaixo.

____*____
___***___
__*****__
_*******_
*********

'''

#include <stdio.h>

int main()
{
    int altura, nivel, quantidadeElementos, espacoTriangulo, espacoVazio, printRepeticao;
    char *elementoTriangulo, *elementoVazio;
    espacoTriangulo = 1;
    espacoVazio = 1;
    elementoTriangulo = "*";
    elementoVazio = "_";
    
    printf("Triângulo de altura: ");
    scanf("%i", &altura);
    
    for (nivel = 1; nivel <= altura; nivel += 1){
        quantidadeElementos = altura + (altura - 1);
        if (espacoTriangulo <= quantidadeElementos){
            espacoVazio = (quantidadeElementos - espacoTriangulo) / 2;
            if (espacoTriangulo == 1){
                espacoTriangulo = espacoTriangulo + 1;
            }
            else{
                espacoTriangulo = espacoTriangulo + 2;
            }
            for (printRepeticao = 1; printRepeticao <= espacoVazio; printRepeticao ++){
                printf("%s", elementoVazio);
            }
            for (printRepeticao = 1; printRepeticao < espacoTriangulo; printRepeticao ++){
                printf("%s", elementoTriangulo);
            }
            for (printRepeticao = 1; printRepeticao <= espacoVazio; printRepeticao ++){
                printf("%s", elementoVazio);
            }
            printf("\n");
        }
    }
}
