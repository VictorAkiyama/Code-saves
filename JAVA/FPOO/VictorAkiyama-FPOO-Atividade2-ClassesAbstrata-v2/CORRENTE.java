public class CORRENTE extends CONTA_CLIENTE{
	
	protected String codigo_corrente;
	protected String senha_corrente;
	
	//Construtor vazio
	public CORRENTE() {}
	
	//Construtor cheio
    public CORRENTE(String nome, String cpf, String codigo, String senha, double dinheiro, double renda, String codigo_corrente, String senha_corrente) {
        super(nome, cpf, codigo, senha, dinheiro, renda);
        this.codigo_corrente = codigo_corrente;
        this.senha_corrente = senha_corrente;
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
	    return "none";
	}
	public String Mostrar_codigo_corrente() {
	    return this.getcodigo_corrente();
	}
	
	//Gets e Sets
	public String getcodigo_corrente() {
	    return this.codigo_corrente;
	}
}
