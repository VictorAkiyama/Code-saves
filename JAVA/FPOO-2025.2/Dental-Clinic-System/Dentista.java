package SistemaClinicaOdontologicaPackage;

public class Dentista extends Profissional{
	
	private String capacitacao;
	
	//construtor
	public Dentista() {}
	
	public Dentista(String nome, String genero, String certificacoes, String capacitacao) {
        super(nome, genero, certificacoes);
        this.capacitacao = capacitacao;
    }
	
	//gets e sets
	public String getcapacitacao() {
		return capacitacao;
	}
	public void setcapacticacao(String capacitacao) {
		this.capacitacao = capacitacao;
	}
}
