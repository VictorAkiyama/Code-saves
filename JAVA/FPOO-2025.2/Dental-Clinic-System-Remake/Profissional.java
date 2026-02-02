package SistemaClinicaOdontologicaPackage;

public abstract class Profissional {

	private String nome;
	private String genero;
	private String certificacoes;
	private double salario;
	private double cpf;
	
	//construtor
	public Profissional() {}
	
	public Profissional(String nome, String genero, String certificacoes) {
		this.nome = nome;
		this.genero = genero;
		this.certificacoes = certificacoes;
	}
	
	//gets e sets
	public String getnome() {
		return nome;
	}
	public void setnome(String nome) {
		this.nome = nome;
	}
	
	public String getgenero() {
		return genero;
	}
	public void setgenero(String genero) {
		this.genero = genero;
	}
	
	public String getcertificacoes() {
		return certificacoes;
	}
	public void setcertificacoes(String certificacoes) {
		this.certificacoes = certificacoes;
	}
	
	public double getcpf() {
		return cpf;
	}
	public void setcpf(double cpf) {
		this.cpf = cpf;
	}
	
	public double getsalario() {
		return salario;
	}
	public void setsalario(double salario) {
		this.salario = salario;
	}
}
