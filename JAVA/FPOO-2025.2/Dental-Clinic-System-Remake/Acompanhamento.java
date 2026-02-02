package SistemaClinicaOdontologicaPackage;

public class Acompanhamento {

	private Consulta consulta;
	private int horario;
	
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
			System.out.println("Acompanhamento marcado com Dr." + consulta.getdentista().getnome() + ", para o paciente: " + consulta.getpaciente().getnome() + " às " + horario + ":00.");
		}
		return acompanhamento;
	}
	
	public Acompanhamento remarcar(Consulta consulta, int horario) {
		Acompanhamento acompanhamento = new Acompanhamento(consulta, horario);
		if (consulta != null) {
			System.out.println("Acompanhamento remarcado com Dr." + consulta.getdentista().getnome() + ", para o paciente: " + consulta.getpaciente().getnome() + " às " + horario + ":00.");
		}
		return acompanhamento;
	}
	
	public Acompanhamento cancelar(Consulta consulta) {
		Acompanhamento acompanhamento = new Acompanhamento(consulta, horario);
		if (consulta != null) {
			System.out.println("Acompanhamento de consulta: " + consulta.getid_consulta() + " cancelado.");
		}
		return acompanhamento;
	}
	
	//para mostrar acompanhamento ao chama-lo
	@Override
	public String toString() {
		return "Acompanhamento da consulta marcado às: " + horario + ":00";
	}
	
	//gets e sets
	public Consulta getconsulta() {
		return consulta;
	}
	public void setconsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	public int gethorario() {
		return horario;
	}
	public void sethorario(int horario) {
		this.horario = horario;
	}
 }
