package SistemaClinicaOdontologicaPackage;

public class Acompanhamento {

	private Consulta consulta;
	private String nomeDentista;
	private int horario;
	
	//construtor
	public Acompanhamento() {};
	
	public Acompanhamento(Consulta consulta, String nomeDentista, int horario) {
		this.consulta = consulta;
		this.nomeDentista = nomeDentista;
		this.horario = horario;
	}
	
	//métodos
	public Acompanhamento marcar(Consulta consulta, String nomeDentista, int horario) {
		Acompanhamento acompanhamento = new Acompanhamento(consulta, nomeDentista, horario);
		if (consulta != null) {
			System.out.println("Acompanhamento marcado com Dr." + acompanhamento.getnomeDentista() + ", para o paciente: " + consulta.getpaciente().getnome() + " às " + acompanhamento.gethorario() + ":00.");
		}
		return acompanhamento;
	}
	
	public Acompanhamento remarcar(Consulta consulta, String nomeDentista, int horario) {
		Acompanhamento acompanhamento = new Acompanhamento(consulta, nomeDentista, horario);
		if (consulta != null) {
			System.out.println("Acompanhamento remarcado com Dr." + acompanhamento.getnomeDentista() + ", para o paciente: " + consulta.getpaciente().getnome() + " às " + acompanhamento.gethorario() + ":00.");
		}
		return acompanhamento;
	}
	
	public Acompanhamento cancelar(Consulta consulta) {
		String nomeDentista = null;
		int horario = 0;
		Acompanhamento acompanhamento = new Acompanhamento(consulta, nomeDentista, horario);
		if (consulta != null) {
			System.out.println("Acompanhamento de consulta: " + consulta.getid_consulta() + "com o Dr." + acompanhamento.getnomeDentista() + " marcado às " + acompanhamento.gethorario() + ":00, foi cancelado.");
		}
		return acompanhamento;
	}
	
	//para mostrar acompanhamento ao chama-lo
	@Override
	public String toString() {
		return "Acompanhamento da consulta marcado às: " + horario + ":00, com o Dr: " + nomeDentista;
	}
	
	//gets e sets
	public Consulta getconsulta() {
		return consulta;
	}
	public void setconsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	
	public String getnomeDentista() {
		return nomeDentista;
	}
	public void setnomeDentista(String nomeDentista) {
		this.nomeDentista = nomeDentista;
	}
	
	public int gethorario() {
		return horario;
	}
	public void sethorario(int horario) {
		this.horario = horario;
	}
 }
