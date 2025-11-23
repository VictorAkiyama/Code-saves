package SistemaClinicaOdontologicaPackage;

public class Acompanhamento {

	public Consulta consulta;
	public int horario;
	
	//construtor
	public Acompanhamento() {};
	
	public Acompanhamento(Consulta consulta, int horario) {
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
	
	public Acompanhamento remarcar(Consulta consulta, int horario) {
		Acompanhamento acompanhamento = new Acompanhamento(consulta, horario);
		if (consulta != null) {
			System.out.println("Acompanhamento remarcado com Dr." + consulta.dentista.nome + ", para o paciente: " + consulta.paciente.nome + " às " + horario + ":00.");
		}
		return acompanhamento;
	}
	
	public Acompanhamento cancelar(Consulta consulta) {
		Acompanhamento acompanhamento = new Acompanhamento(consulta, horario);
		if (consulta != null) {
			System.out.println("Acompanhamento de consulta: " + consulta.id_consulta + " cancelado.");
		}
		return acompanhamento;
	}
	
	//para mostrar acompanhamento ao chama-lo
	@Override
	public String toString() {
		return "Acompanhamento da consulta marcado às: " + horario + ":00";
	}
 }
