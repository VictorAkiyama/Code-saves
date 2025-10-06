public class Poupanca extends ContaCliente {
    
    protected String codigoPoupanca;
    protected String senhaPoupanca;
    
    //Construtor vazio
    public Poupanca() {}
    
    //Construtor cheio
    public Poupanca(String nome, String cpf, String codigo, String senha, double dinheiro, double renda, String codigoPoupanca, String senhaPoupanca) {
        super(nome, cpf, codigo, senha, dinheiro, renda);
        this.codigoPoupanca = codigoPoupanca;
        this.senhaPoupanca = senhaPoupanca;
    }
    
	@Override
	public void transferir(double qtd_transferir, ContaCliente conta_destino) {
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
	    return this.getcodigoPoupanca();
	}
	public String mostrarCodigoCorrente() {
	    return "none";
	}
	
	//Gets e Sets
	public String getcodigoPoupanca() {
	    return this.codigoPoupanca;
	}
}
