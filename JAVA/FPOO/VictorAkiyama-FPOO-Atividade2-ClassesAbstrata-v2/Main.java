public class Main {
	public static void main(String[] args) {
		
		CONTA_CLIENTE conta_poupanca = new POUPANCA("Lucas", "666.666.666-66", "15986", "senhaconta", 2000, 1.005, "15986-P", "senhapoupanca");
		CONTA_CLIENTE conta_corrente = new CORRENTE("Lucas", "666.666.666-66", "15986", "senhaconta", 2000, 0, "15986-C", "senhacorrente");
		
		conta_corrente.Transferir(100, conta_poupanca);
		
		conta_poupanca.Depositar(100);
		conta_poupanca.Render(conta_poupanca.renda);
		
		conta_corrente.Sacar(500);
		
		System.out.println("Poupança: " + conta_poupanca.nome + " " + conta_poupanca.cpf + " " + conta_poupanca.Mostrar_codigo_poupanca() + " " + conta_poupanca.Saldo());
		System.out.println("Corrente: " + conta_corrente.nome + " " + conta_corrente.cpf + " " + conta_corrente.Mostrar_codigo_corrente() + " " + conta_corrente.Saldo());
	}
}
