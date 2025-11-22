package SistemaClinicaOdontologicaPackage;

public abstract class Profissional {

	public String nome;
	public String genero;
	public String certificacoes;
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
