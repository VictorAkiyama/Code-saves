public abstract class CONTA_CLIENTE {
	
	protected String nome;
	protected String cpf;
	protected String codigo;
	protected String senha;
	private double dinheiro;
	protected double renda;
	
	//Construtor vazio
	public CONTA_CLIENTE() {}
	
	//Construtor cheio
    public CONTA_CLIENTE(String nome, String cpf, String codigo, String senha, double dinheiro, double renda) {
        this.nome = nome;
        this.cpf = cpf;
        this.codigo = codigo;
        this.senha = senha;
        this.dinheiro = dinheiro;
        this.renda = renda;
    }
	
	//Métodos
	public abstract void Transferir(double qtd_transferir, CONTA_CLIENTE conta_destino);
	public abstract void Depositar(double qtd_depositar);
	public abstract void Sacar(double qtd_sacar);
	public abstract double Saldo();
	public abstract void Render(double renda);
	public abstract String Mostrar_codigo_poupanca();
	public abstract String Mostrar_codigo_corrente();
	
	//Gets e Sets
	public double getDinheiro() {
		return this.dinheiro;
	}
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
}
