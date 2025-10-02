public abstract class ContaCliente {
	
	protected String nome;
	protected String cpf;
	protected String codigo;
	protected String senha;
	private double dinheiro;
	protected double renda;
	
	//Construtor vazio
	public ContaCliente() {}
	
	//Construtor cheio
    public ContaCliente(String nome, String cpf, String codigo, String senha, double dinheiro, double renda) {
        this.nome = nome;
        this.cpf = cpf;
        this.codigo = codigo;
        this.senha = senha;
        this.dinheiro = dinheiro;
        this.renda = renda;
    }
	
	//Métodos
	public abstract void transferir(double qtd_transferir, CONTA_CLIENTE conta_destino);
	public abstract void depositar(double qtd_depositar);
	public abstract void sacar(double qtd_sacar);
	public abstract double saldo();
	public abstract void render(double renda);
	public abstract String mostrarCodigoPoupanca();
	public abstract String mostrarCodigoCorrente();
	
	//Gets e Sets
	public double getDinheiro() {
		return this.dinheiro;
	}
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
}
