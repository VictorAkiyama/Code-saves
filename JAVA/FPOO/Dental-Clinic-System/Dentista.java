package SistemaClinicaOdontologicaPackage;

public class Dentista extends Profissional{
	
	public String capacitacao;
	
	//construtor
	public Dentista() {}
	
	public Dentista(String nome, String genero, String certificacoes, String capacitacao) {
        super(nome, genero, certificacoes);
        this.capacitacao = capacitacao;
    }
}
