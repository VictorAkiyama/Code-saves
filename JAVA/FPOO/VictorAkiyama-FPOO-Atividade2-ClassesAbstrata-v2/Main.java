public class Main {
	public static void main(String[] args) {
		
		ContaCliente conta_poupanca = new Poupanca("Lucas", "666.666.666-66", "15986", "senhaconta", 2000, 1.005, "15986-P", "senhapoupanca");
		ContaCliente conta_corrente = new Corrente("Lucas", "666.666.666-66", "15986", "senhaconta", 2000, 0, "15986-C", "senhacorrente");
		
		conta_corrente.transferir(100, conta_poupanca);
		
		conta_poupanca.depositar(100);
		conta_poupanca.render(conta_poupanca.renda);
		
		conta_corrente.sacar(500);
		
		System.out.println("Poupança: " + conta_poupanca.nome + " " + conta_poupanca.cpf + " " + conta_poupanca.mostrarCodigoPoupanca() + " " + conta_poupanca.saldo());
		System.out.println("Corrente: " + conta_corrente.nome + " " + conta_corrente.cpf + " " + conta_corrente.mostrarCodigoCorrente() + " " + conta_corrente.saldo());
	}
}
