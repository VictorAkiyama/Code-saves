package SistemaClinicaOdontologicaPackage;

import java.util.Scanner;

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
	
	Scanner input = new Scanner(System.in); //objeto input
	
	public int verificaHorarioAcompanhamento(int horario) {
		if (horario < 8 || horario > 18) {
			System.out.println("\n\nO horário digitado não é disponível no horario de atendimento da clínica.\n\n");
			System.out.println("Digite o horário do acompanhamento: ");
			horario = input.nextInt();
			input.nextLine(); // limpa o enter do input anterior
			horario = verificaHorarioAcompanhamento(horario);
			return horario;
		}
		else {
			return horario;
		}
	}
	
	//verifica se o horario do acompanhamento está em conflito com algum outro na agenda
	public int verificaHorarioAcompanhamentoNaAgenda(int horario, Agenda agenda) {
		switch (horario) {
			case 8:
				if (agenda.gethora8() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 9:
				if (agenda.gethora9() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 10:
				if (agenda.gethora10() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 11:
				if (agenda.gethora11() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 12:
				if (agenda.gethora12() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 13:
				if (agenda.gethora13() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 14:
				if (agenda.gethora14() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 15:
				if (agenda.gethora15() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 16:
				if (agenda.gethora16() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 17:
				if (agenda.gethora17() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			case 18:
				if (agenda.gethora18() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioAcompanhamento(horario);
					horario = verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
				}
				return horario;
			default:
				System.out.println("ERRO, talvez o verificador de horário falhou e não chegou a esse método corretamente");
				return horario;
		}
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
