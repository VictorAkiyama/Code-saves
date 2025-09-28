package Contapackage;

public class POUPANCA extends CONTA_CLIENTE {
    
    //Construtor vazio
    public POUPANCA() {}
    
    //Construtor cheio
    public POUPANCA(String nome, String cpf, double dinheiro, double renda) {
        super(nome, cpf, dinheiro, renda);
    }
    
	@Override
	public void Transferir(double qtd_transferir, CONTA_CLIENTE conta_destino) {
		this.setDinheiro(this.getDinheiro() - qtd_transferir);
		conta_destino.setDinheiro(conta_destino.getDinheiro() + qtd_transferir);
	}
	public double Depositar(double qtd_depositar) {
		return this.getDinheiro() + qtd_depositar;
	}
	public double Sacar(double qtd_sacar) {
		return this.getDinheiro() - qtd_sacar;
	}
	public double Saldo() {
		return this.getDinheiro();
	}
	public double Renda() {
	    return this.getDinheiro() * renda;
	}
}
