'''
Escreva um programa que permite ao usuário cadastrar nomes de pessoas e listar todos os nomes cadastrados. Os dados devem ser registrados em um arquivo. O programa deve mostrar um menu que permita ao usuário escolher qual funcionalidade que realizar.
'''

def cadastrar_nome(arquivo_de_registro):
    nome = input('Digite um nome: ')

    arquivo = open(arquivo_de_registro, 'a')
    arquivo.write(nome + '\n')                          # to write each "nome" in a different line of file "arquivo_de_registro"
    arquivo.close()


def listar_nomes(arquivo_de_registro):
    arquivo = open(arquivo_de_registro, 'r')
    nomes = arquivo.readlines()                         # to read each "nome" from a different line
    for nome in nomes:
        print(nome)
    arquivo.close()


if __name__ == "__main__":                              # to see if the name of this file is "main.py"
    arquivo_de_registro = "nomes.txt"
    respostaUsuario = ""
    while respostaUsuario.lower() != "n":
        print("----------- Cadastro de Nomes -----------")
        print("1: Cadastrar um novo nome")
        print("2: Listar todos os nomes cadastrados")
        print("-----------------------------------------")

        opcaoMenu = input("Digite a opção que deseja (1 ou 2): ")
        if opcaoMenu == "1":
            cadastrar_nome(arquivo_de_registro)
        elif opcaoMenu == "2":
            listar_nomes(arquivo_de_registro)

        respostaUsuario = input("Deseja continuar? ('s' ou 'n'): ")

    print("Fim do programa")