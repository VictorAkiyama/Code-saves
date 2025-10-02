public class POUPANCA extends CONTA_CLIENTE {
    
    protected String codigo_poupanca;
    protected String senha_poupanca;
    
    //Construtor vazio
    public POUPANCA() {}
    
    //Construtor cheio
    public POUPANCA(String nome, String cpf, String codigo, String senha, double dinheiro, double renda, String codigo_poupanca, String senha_poupanca) {
        super(nome, cpf, codigo, senha, dinheiro, renda);
        this.codigo_poupanca = codigo_poupanca;
        this.senha_poupanca = senha_poupanca;
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
	public String Mostrar_codigo_poupanca() {
	    return this.getcodigo_poupanca();
	}
	public String Mostrar_codigo_corrente() {
	    return "none";
	}
	
	//Gets e Sets
	public String getcodigo_poupanca() {
	    return this.codigo_poupanca;
	}
}
