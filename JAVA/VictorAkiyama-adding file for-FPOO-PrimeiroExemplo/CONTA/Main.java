package exemplo_conta;

public class Main {
	public static void main (String[] args) {
		
		//INSTANCIANDO (CRIANDO OBJETO) conta
		CONTA conta = new CONTA();
		
		//ESTABELECENDO VALOR DOS ATRIBUTOS
		conta.nome = "Jumpierto";
		conta.numero = "10101010";
		conta.saldo = 1000;
		
		//ANTES DO METÓDO
		System.out.println(conta.nome + " " + conta.numero + " " + conta.saldo);
		
		//SACANDO
		conta.sacarSaldo();
		System.out.println(conta.saldo);
		
		//DEPOSITANDO
		conta.depositarSaldo();
		System.out.println(conta.saldo);
	}
}
