package Contapackage;

public abstract class CONTA {
	
	protected double dinheiro = 2000;
	
	//Construtor vazio
	public CONTA() {}
	
	//Construtor cheio
	public CONTA(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	//Métodos
	public double Transferir() {
		return this.dinheiro = dinheiro;
	}
	public double Depositar() {
		return this.dinheiro + dinheiro;
	}
	public double Sacar() {
		return this.dinheiro - dinheiro;
	}
	public double Saldo() {
		return this.dinheiro;
	}
	
	//Gets e Sets
	public double getDinheiro() {
		return this.dinheiro;
	}
	public double setDinheiro() {
		return this.dinheiro = dinheiro;
	}
}
