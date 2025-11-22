package SistemaClinicaOdontologicaPackage;

public class Acompanhamento {

	public Consulta consulta;
	public double horario;
	
	//construtor
	public Acompanhamento() {};
	
	public Acompanhamento(Consulta consulta, double horario) {
		this.consulta = consulta;
		this.horario = horario;
	}
	
	//métodos
	public Acompanhamento marcar(Consulta consulta, int horario) {
		Acompanhamento acompanhamento = new Acompanhamento(consulta, horario);
		if (consulta != null) {
			System.out.println("Acompanhamento marcado com Dr." + consulta.dentista.nome + ", para o paciente: " + consulta.paciente.nome + " às " + horario + ":00.");
		}
		return acompanhamento;
	}
	
	public void remarcar() {};
	
	public void cancelar() {};
}
