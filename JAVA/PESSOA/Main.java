package exemplo_pessoa;

public class Main {

	public static void main (String[] args) {
		//System.out.println("Olá mundo!");
		
		//INSTANCIANDO (CRIANDO OBJETO) PESSOA
		Pessoa pessoa = new Pessoa();
		
		//INSERINDO INFORMAÇÔES NA PESSOA
		pessoa.nome = "Adilsberto";
		pessoa.idade = 100;
		pessoa.cpf = "1111";
		
		//INSTANCIANDO UM NOVO OBJETO
		Pessoa pessoa2 = new Pessoa();
		
		pessoa2.nome = "Juciscreia";
		pessoa2.idade = 15;
		pessoa2.cpf = "222222222";
		
		//MOSTRANDO NOME E IDADE
		System.out.println("O " + pessoa.nome + " tem: " + pessoa.idade);
		System.out.println("O " + pessoa2.nome + " tem: " + pessoa2.idade);
		
		//USANDO METÓDO PARA AUMENTAR IDADE
		pessoa.acrescentarIdade();
		
		//MOSTRAR DENOVO
		System.out.println("O " + pessoa.nome + " tem: " + pessoa.idade);
		System.out.println("O " + pessoa2.nome + " tem: " + pessoa2.idade);
	}	
}
