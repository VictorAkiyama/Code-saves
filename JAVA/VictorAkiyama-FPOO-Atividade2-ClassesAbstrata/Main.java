package Contapackage;

public class Main {
	public static void main(String[] args) {
		
		CONTA_CLIENTE conta_poupanca = new POUPANCA("Lucas", "666.666.666-66", 2000, 1.005);
		CONTA_CLIENTE conta_corrente = new CORRENTE("Lucas", "666.666.666-66", 2000, 0);
		
		conta_corrente.Transferir(100, conta_poupanca);
		
		conta_poupanca.Depositar(100);
		conta_poupanca.Render(conta_poupanca.renda);
		
		conta_corrente.Sacar(500);
		
		System.out.println("Poupança: " + conta_poupanca.nome + " " + conta_poupanca.cpf + " " + conta_poupanca.Saldo());
		System.out.println("Corrente: " + conta_corrente.nome + " " + conta_corrente.cpf + " " + conta_corrente.Saldo());
	}
}
