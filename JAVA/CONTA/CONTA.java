package exemplo_conta;

public class CONTA {
	String nome;
	String numero;
	int saldo;
	
	public void sacarSaldo() {
		saldo = saldo - 1;
	}
	
	public void depositarSaldo() {
		saldo = saldo + 1;
	}
}
