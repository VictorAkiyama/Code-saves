package SistemaClinicaOdontologicaPackage;

import java.util.Scanner; //biblioteca input

public class Consulta implements Atendimento {

	private int id_consulta;
	private Dentista dentista;
	private Paciente paciente;
	private int horario;
	private String detalhes;
	private Acompanhamento acompanhamento;
	private Pagamento pagamento;

	// construtor vazio
	public Consulta() {
	}

	// construtor
	public Consulta(int id_consulta, Dentista dentista, Paciente paciente, int horario, String detalhes,
			Acompanhamento acompanhamento, Pagamento pagamento) {
		this.id_consulta = id_consulta;
		this.dentista = dentista;
		this.paciente = paciente;
		this.horario = horario;
		this.detalhes = detalhes;
		this.acompanhamento = acompanhamento;
		this.pagamento = pagamento;
	}

	Scanner input = new Scanner(System.in); //objeto input
	
	// métodos
	public Consulta marcar(Consulta consulta, Sistema sistema, int numero_id, Agenda agenda) {
		// usuário digitando os dados
		// -- dados dentista --
		System.out.println("Digite o nome do Dentista: ");
		String nomeDentista = input.nextLine();
		System.out.println("Digite o gênero do Dentista: ");
		String generoDentista = input.nextLine();
		System.out.println("Digite o grau de certificação do Dentista: ");
		String certificacaoDentista = input.nextLine();
		System.out.println("Digite a especialização do Dentista: ");
		String capacitacaoDentista = input.nextLine();
		// colocando as informações digitadas para um objeto dentista
		Dentista dentista = new Dentista(nomeDentista, generoDentista, certificacaoDentista, capacitacaoDentista);
		
		// -- dados paciente --
		System.out.println("Digite o nome do Paciente: ");
		String nomePaciente = input.nextLine();
		System.out.println("Digite o gênero do Paciente: ");
		String generoPaciente = input.nextLine();
		// colocando as informações digitadas para um objeto paciente
		Paciente paciente = new Paciente(nomePaciente, generoPaciente);
		
		// -- dados pagamento --
		System.out.println("Digite o valor da consulta: ");
		while (!input.hasNextDouble()) {
		    String inputInvalido = input.next(); // lê e descarta o input inválido
		    System.out.println("\n\n '" + inputInvalido + "' Não é válido. Tente denovo: ");
		}
		double valorConsulta = input.nextDouble();
		input.nextLine(); // limpa o enter do input anterior
		System.out.println("Digite a forma de pagamento: ");
		String formaPagamento = input.nextLine();
		// colocando as informações digitadas para um objeto pagamento
		Pagamento pagamento = new Pagamento(valorConsulta, consulta, formaPagamento);
		
		// -- dado horario --
		System.out.println("Digite o horário da consulta: ");
		// fica iterando indefinidamente até um input válido
		while (!input.hasNextInt()) {
		    String inputInvalido = input.next(); // lê e descarta o input inválido
		    System.out.println("\n\n '" + inputInvalido + "' Não é válido. Tente denovo: ");
		}
		int horario = input.nextInt();
		input.nextLine(); // limpa o enter do input anterior
		
		//verifica o horario, se o horario faz sentido o retora, senão continua a pedir horario
		horario = verificaHorarioConsulta(horario);
		
		
		// -- dado detalhes --
		System.out.println("Digite os detalhes do procedimento da consulta: ");
		String detalhes = input.nextLine();
		
		// objeto acompanhamento vazio criado para criar consulta
		Acompanhamento acompanhamento = new Acompanhamento();
		
		// atribui numero_id para id, que vai ser atribuido para a nova consulta
		int id = numero_id;
		
		// -- cria consulta --
		Consulta consultaMarcada = sistema.CriarConsulta(id, dentista, paciente, horario, detalhes, acompanhamento, pagamento);
		
		// mostra se foi marcado com sucesso ou não
		if (consultaMarcada.paciente != null && consultaMarcada.dentista != null) {
			System.out.println("\nConsulta " + consultaMarcada.id_consulta + ", marcada com Dr." + consultaMarcada.dentista.getnome() + " para " + consultaMarcada.paciente.getnome() + " para às " + consultaMarcada.horario + ":00\nDetalhes: " + consultaMarcada.detalhes + ", " + consultaMarcada.pagamento + "\n");
		} else {
			System.out.println("Erro de agendamento");
		}
		return consultaMarcada;
	}

	public Consulta remarcar(Consulta consulta, Sistema sistema, Agenda agenda, int id_consulta_selecionada) {
		
		// usuário digitando os dados
		// -- dados dentista --
		System.out.println("Digite o nome do Dentista: ");
		String nomeDentista = input.nextLine();
		System.out.println("Digite o gênero do Dentista: ");
		String generoDentista = input.nextLine();
		System.out.println("Digite o grau de certificação do Dentista: ");
		String certificacaoDentista = input.nextLine();
		System.out.println("Digite a especialização do Dentista: ");
		String capacitacaoDentista = input.nextLine();
		// colocando as informações digitadas para um objeto dentista
		Dentista dentista = new Dentista(nomeDentista, generoDentista, certificacaoDentista, capacitacaoDentista);
		
		// -- dados paciente --
		System.out.println("Digite o nome do Paciente: ");
		String nomePaciente = input.nextLine();
		System.out.println("Digite o gênero do Paciente: ");
		String generoPaciente = input.nextLine();
		// colocando as informações digitadas para um objeto paciente
		Paciente paciente = new Paciente(nomePaciente, generoPaciente);
		
		// -- dados pagamento --
		System.out.println("Digite o valor da consulta: ");
		while (!input.hasNextDouble()) {
		    String inputInvalido = input.next(); // lê e descarta o input inválido
		    System.out.println("\n\n '" + inputInvalido + "' Não é válido. Tente denovo: ");
		}
		double valorConsulta = input.nextDouble();
		input.nextLine(); // limpa o enter do input anterior
		System.out.println("Digite a forma de pagamento: ");
		String formaPagamento = input.nextLine();
		// colocando as informações digitadas para um objeto pagamento
		Pagamento pagamento = new Pagamento(valorConsulta, consulta, formaPagamento);
		
		// -- dado horario --
		System.out.println("Digite o horário da consulta: ");
		// fica iterando indefinidamente até um input válido
		while (!input.hasNextInt()) {
		    String inputInvalido = input.next(); // lê e descarta o input inválido
		    System.out.println("\n\n '" + inputInvalido + "' Não é válido. Tente denovo: ");
		}
		int horario = input.nextInt();
		input.nextLine(); // limpa o enter do input anterior
		
		//verifica o horario, se o horario faz sentido o retora, senão continua a pedir horario
		horario = verificaHorarioConsulta(horario);
		
		// -- dado detalhes --
		System.out.println("Digite os detalhes do procedimento da consulta: ");
		String detalhes = input.nextLine();
		
		// objeto acompanhamento vazio criado para criar consulta
		Acompanhamento acompanhamento = new Acompanhamento();
		
		// atribui o ID da consulta selecionada anteriormente nessa variável para ser usado ao criar a consulta remarcada
		int id = id_consulta_selecionada;
		
		// -- cria consulta --
		Consulta consultaRemarcada = sistema.CriarConsulta(id, dentista, paciente, horario, detalhes, acompanhamento, pagamento);
		
		// mostra se foi remarcado com sucesso ou não
		if (consultaRemarcada.paciente != null && consultaRemarcada.dentista != null) {
			System.out.println("\nConsulta " + consultaRemarcada.id_consulta + ", foi remarcada com Dr." + consultaRemarcada.dentista.getnome() + " para " + consultaRemarcada.paciente.getnome() + " para às " + consultaRemarcada.horario + ":00\nDetalhes: " + consultaRemarcada.detalhes + ", " + consultaRemarcada.pagamento + "\n");
		} else {
			System.out.println("Erro de agendamento");
		}
		return consultaRemarcada;
	}

	public void cancelar(Consulta consulta, Sistema sistema, Consulta consultaLista[], int id_consulta_selecionada) {
		int i;
		
		// torna a consulta selecionada em null na lista
		for (i = 0; i < consultaLista.length; i++) {
			if (consultaLista[i] != null && consultaLista[i].getid_consulta() == id_consulta_selecionada) {
				consultaLista[i] = null;
				break;
			}
		}
		
		System.out.println("A consulta de id: " + id_consulta_selecionada + " foi cancelada.");
	}

	public Consulta marcarAcompanhamento(Consulta consultaLista[], int id_consulta_selecionada, Agenda agenda) {
		Consulta consulta = new Consulta();
		
		int i;
		//pega a consulta com o id_consulta_selecionada
		for (i = 0; i < consultaLista.length; i++) {
			if (consultaLista[i] != null && consultaLista[i].getid_consulta() == id_consulta_selecionada) {
				consulta = consultaLista[i];
				break;
			}
		}
		
		// -- dado dentista --
		System.out.println("\nDigite o nome do Dentista: ");
		String nomeDentista = input.nextLine();
		
		// -- dado horario --
		System.out.println("Digite o horário do acompanhamento: ");
		// fica iterando indefinidamente até um input válido
		while (!input.hasNextInt()) {
		    String inputInvalido = input.next(); // lê e descarta o input inválido
		    System.out.println("\n\n '" + inputInvalido + "' Não é válido. Tente denovo: ");
		}
		int horario = input.nextInt();
		input.nextLine(); // limpa o enter do input anterior
		
		Acompanhamento novoAcompanhamento = new Acompanhamento();
		
		//verifica o horario, se o horario faz sentido o retora, senão continua a pedir horario
		horario = novoAcompanhamento.verificaHorarioAcompanhamento(horario);
		//verifica se o horario faz conflito na agenda
		horario = novoAcompanhamento.verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
		
		//cria o acompanhamento com os dados 
		novoAcompanhamento = novoAcompanhamento.marcar(consulta, nomeDentista, horario);
		//coloca o acompanhamento na consulta
		consulta.setacompanhamento(consulta, novoAcompanhamento.getnomeDentista(), novoAcompanhamento.gethorario());
		
		int j;
		//recoloca a consulta na lista
		for (j = 0; j < consultaLista.length; j++) {
			if (consultaLista[i] != null && consultaLista[i].getid_consulta() == id_consulta_selecionada) {
				consultaLista[i] = consulta;
				break;
			}
		}
		
		return consulta;
	}

	public Consulta remarcarAcompanhamento(Consulta consultaLista[], int id_consulta_selecionada, Agenda agenda) {
		Consulta consulta = new Consulta();
		
		int i;
		//pega a consulta com o id_consulta_selecionada
		for (i = 0; i < consultaLista.length; i++) {
			if (consultaLista[i] != null && consultaLista[i].getid_consulta() == id_consulta_selecionada) {
				consulta = consultaLista[i];
				break;
			}
		}
		
		// -- dado dentista --
		System.out.println("\nDigite o nome do Dentista: ");
		String nomeDentista = input.nextLine();
		
		// -- dado horario --
		System.out.println("Digite o horário do acompanhamento: ");
		// fica iterando indefinidamente até um input válido
		while (!input.hasNextInt()) {
		    String inputInvalido = input.next(); // lê e descarta o input inválido
		    System.out.println("\n\n '" + inputInvalido + "' Não é válido. Tente denovo: ");
		}
		int horario = input.nextInt();
		input.nextLine(); // limpa o enter do input anterior
		
		Acompanhamento novoAcompanhamento = new Acompanhamento();
		
		//verifica o horario, se o horario faz sentido o retora, senão continua a pedir horario
		horario = novoAcompanhamento.verificaHorarioAcompanhamento(horario);
		horario = novoAcompanhamento.verificaHorarioAcompanhamentoNaAgenda(horario, agenda);
		
		//cria o acompanhamento com os dados 
		novoAcompanhamento = novoAcompanhamento.marcar(consulta, nomeDentista, horario);
		//coloca o acompanhamento na consulta
		consulta.setacompanhamento(consulta, novoAcompanhamento.getnomeDentista(), novoAcompanhamento.gethorario());
		
		int j;
		//recoloca a consulta na lista
		for (j = 0; j < consultaLista.length; j++) {
			if (consultaLista[i] != null && consultaLista[i].getid_consulta() == id_consulta_selecionada) {
				consultaLista[i] = consulta;
				break;
			}
		}
		
		return consulta;
	}

	public Consulta cancelarAcompanhamento(Consulta consultaLista[], int id_consulta_selecionada, Agenda agenda) {
		Consulta consulta = new Consulta();
		
		int i;
		//pega a consulta com o id_consulta_selecionada
		for (i = 0; i < consultaLista.length; i++) {
			if (consultaLista[i] != null && consultaLista[i].getid_consulta() == id_consulta_selecionada) {
				consulta = consultaLista[i];
				break;
			}
		}
		
		Acompanhamento acompanhamentoCancelado = new Acompanhamento();
		
		acompanhamentoCancelado = acompanhamentoCancelado.cancelar(consulta);
		consulta.setacompanhamento(consulta, acompanhamentoCancelado.getnomeDentista(), acompanhamentoCancelado.gethorario());
		
		return consulta;
	}
	
	//verifica o horario digitado se está no período de atendimento da clínica
	public int verificaHorarioConsulta(int horario) {
		if (horario < 8 || horario > 18) {
			System.out.println("\n\nO horário digitado não é disponível no horario de atendimento da clínica.\n\n");
			System.out.println("Digite o horário da consulta: ");
			horario = input.nextInt();
			input.nextLine(); // limpa o enter do input anterior
			horario = verificaHorarioConsulta(horario);
			return horario;
		}
		else {
			return horario;
		}
	}
	
	//verifica se o horario da consulta está em conflito com algum outro na agenda
	public int verificaHorarioConsultaNaAgenda(int horario, Agenda agenda) {
		switch (horario) {
			case 8:
				if (agenda.gethora8() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 9:
				if (agenda.gethora9() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 10:
				if (agenda.gethora10() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 11:
				if (agenda.gethora11() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 12:
				if (agenda.gethora12() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 13:
				if (agenda.gethora13() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 14:
				if (agenda.gethora14() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 15:
				if (agenda.gethora15() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 16:
				if (agenda.gethora16() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 17:
				if (agenda.gethora17() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			case 18:
				if (agenda.gethora18() == true) {
					System.out.println("\nO horário já está ocupado, escolha outro.\n");
					System.out.println("Digite o horário da consulta: ");
					horario = input.nextInt();
					input.nextLine(); // limpa o enter do input anterior
					horario = verificaHorarioConsulta(horario);
					horario = verificaHorarioConsultaNaAgenda(horario, agenda);
				}
				return horario;
			default:
				System.out.println("ERRO, talvez o verificador de horário falhou e não chegou a esse método corretamente");
				return horario;
		}
	}
	
	// gets e sets
	public int getid_consulta() {
		return id_consulta;
	}

	public void setid_consulta(int id_consulta) {
		this.id_consulta = id_consulta;
	}

	public Dentista getdentista() {
		return dentista;
	}

	public void setdentista(Dentista dentista) {
		this.dentista = dentista;
	}

	public Paciente getpaciente() {
		return paciente;
	}

	public void setpaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public int gethorario() {
		return horario;
	}

	public void sethorario(int horario) {
		this.horario = horario;
	}

	public String getdetalhes() {
		return detalhes;
	}

	public void setdetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public Acompanhamento getacompanhamento() {
		return acompanhamento;
	}

	public void setacompanhamento(Consulta consulta, String nomeDentista, int horario) {
		this.acompanhamento = new Acompanhamento(consulta, nomeDentista, horario);
	}

	public Pagamento getpagamento() {
		return pagamento;
	}

	public void setpagamento(double valor, Consulta consulta, String forma) {
		this.pagamento = new Pagamento(valor, consulta, forma);
	}
}
