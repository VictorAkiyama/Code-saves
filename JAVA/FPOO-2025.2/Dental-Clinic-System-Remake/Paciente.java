package SistemaClinicaOdontologicaPackage;

public class Paciente {
	
	private String nome;
	private String genero;
	private double cpf;
	
	//construtor
	public Paciente() {}
	
	public Paciente(String nome, String genero) {
		this.nome = nome;
		this.genero = genero;
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
	
	public double getcpf() {
		return cpf;
	}
	public void setcpf(double cpf) {
		this.cpf = cpf;
	}
}
