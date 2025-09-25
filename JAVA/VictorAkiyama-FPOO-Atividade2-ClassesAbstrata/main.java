package Contapackage;

public class main {
	public static void main(String[] args) {
		
		CONTA conta1 = new POUPANCA();
		CONTA conta2 = new CORRENTE();
		
		conta1.Transferir();
		conta1.Saldo();
		conta2.Saldo();
		
		System.out.println(conta1.dinheiro + " " + conta2.dinheiro);
	}
}
