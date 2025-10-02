public class Corrente extends ContaCliente{
	
	protected String codigoCorrente;
	protected String senhaCorrente;
	
	//Construtor vazio
	public Corrente() {}
	
	//Construtor cheio
    public Corrente(String nome, String cpf, String codigo, String senha, double dinheiro, double renda, String codigoCorrente, String senhaCorrente) {
        super(nome, cpf, codigo, senha, dinheiro, renda);
        this.codigoCorrente = codigoCorrente;
        this.senhaCorrente = senhaCorrente;
    }
	
	@Override
	public void transferir(double qtd_transferir, ContaCliente contaDestino) {
		this.setDinheiro(this.getDinheiro() - qtd_transferir);
		conta_destino.setDinheiro(conta_destino.getDinheiro() + qtd_transferir);
	}
	public void depositar(double qtd_depositar) {
		this.setDinheiro(this.getDinheiro() + qtd_depositar);
	}
	public void sacar(double qtd_sacar) {
		this.setDinheiro(this.getDinheiro() - qtd_sacar);
	}
	public double saldo() {
		return this.getDinheiro();
	}
	public void render(double renda) {
	    this.setDinheiro(getDinheiro() * renda);
	}
	public String mostrarCodigoPoupanca() {
	    return "none";
	}
	public String mostrarCodigoCorrente() {
	    return this.getcodigoCorrente();
	}
	
	//Gets e Sets
	public String getcodigoCorrente() {
	    return this.codigoCorrente;
	}
}
