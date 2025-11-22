package SistemaClinicaOdontologicaPackage;

public class Paciente {
	
	public String nome;
	public String genero;
	private double cpf;
	
	//construtor
	public Paciente() {}
	
	public Paciente(String nome, String genero) {
		this.nome = nome;
		this.genero = genero;
	}
	
	//gets e sets
	public double getcpf() {
		return cpf;
	}
	public void setcpf(double cpf) {
		this.cpf = cpf;
	}
}
