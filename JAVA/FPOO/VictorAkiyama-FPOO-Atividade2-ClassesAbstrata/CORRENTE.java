package Contapackage;

public class CORRENTE extends CONTA_CLIENTE{
	
	//Construtor vazio
	public CORRENTE() {}
	
	//Construtor cheio
    public CORRENTE(String nome, String cpf, double dinheiro, double renda) {
        super(nome, cpf, dinheiro, renda);
    }
	
	@Override
	public void Transferir(double qtd_transferir, CONTA_CLIENTE conta_destino) {
		this.setDinheiro(this.getDinheiro() - qtd_transferir);
		conta_destino.setDinheiro(conta_destino.getDinheiro() + qtd_transferir);
	}
	public void Depositar(double qtd_depositar) {
		this.setDinheiro(this.getDinheiro() + qtd_depositar);
	}
	public void Sacar(double qtd_sacar) {
		this.setDinheiro(this.getDinheiro() - qtd_sacar);
	}
	public double Saldo() {
		return this.getDinheiro();
	}
	public void Render(double renda) {
	    this.setDinheiro(getDinheiro() * renda);
	}
}
