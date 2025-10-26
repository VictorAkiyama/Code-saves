/*Classificador de triângulo*/
''' Dados três valores A, B e C, verificar se eles podem ser os comprimentos dos lados de
um triângulo. Caso for, verificar se é um triângulo equilátero, isósceles ou escaleno. A
condição básica para ser um triângulo é que qualquer lado do triângulo não pode ser
maior ou igual do que a soma dos outros dois lados. Entrada: três valores que
representam lados do suposto triângulo (A, B e C). Saída: mensagem dizendo qual tipo
de triângulo se encaixa ou dizer que não é um triângulo se for o caso. '''

#include <stdio.h>
int main() {
int A, B, C;
  scanf("%i %i %i", &A, &B, &C);
  if (A<B+C && B<A+C && C<A+B) {
    printf("Forma um trângulo");
    if (A==B && B==C) {
      printf("equilátero");
    }
    else if (A==B || B==C || A==C) {
      printf("isósceles");
    }
    else {
      printf("escaleno");
    }
  }
  else {
    printf("Não forma um triângulo");
  }
}
