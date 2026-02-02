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
	public Consulta marcar(Consulta consulta, Sistema sistema, int numero_id) {
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
		double valorConsulta = input.nextDouble();
		input.nextLine(); // limpa o enter do input anterior
		System.out.println("Digite a forma de pagamento: ");
		String formaPagamento = input.nextLine();
		// colocando as informações digitadas para um objeto pagamento
		Pagamento pagamento = new Pagamento(valorConsulta, consulta, formaPagamento);
		
		// -- dado horario --
		System.out.println("Digite o horário da consulta: ");
		int horario = input.nextInt();
		input.nextLine(); // limpa o enter do input anterior
		
		// -- dado detalhes --
		System.out.println("Digite os detalhes do procedimento da consulta: ");
		String detalhes = input.nextLine();
		
		// objeto acompanhamento vazio criado para criar consulta
		Acompanhamento acompanhamento = new Acompanhamento();
		
		// atribui numero_id para id, que vai ser atribuido para a nova consulta
		System.out.println("\nteste numero_id: " + numero_id + "\n");
		int id = numero_id;
		
		// -- cria consulta --
		Consulta consultaSimulacao = sistema.CriarConsulta(id, dentista, paciente, horario, detalhes, acompanhamento, pagamento);
		
		/*
		Dentista dentista = new Dentista("Luis", "M", "Mestrado", "Odontopediatria");
		Paciente paciente = new Paciente("Ricardo", "M");
		Pagamento pagamento = new Pagamento(150.00, consulta, "Pix");
		Acompanhamento acompanhamento = new Acompanhamento();
		Consulta consultaSimulacao = sistema.CriarConsulta(2355, dentista, paciente, 15, "Implante dentário", acompanhamento, pagamento);
		*/
		// mostra de foi marcado com sucesso ou não
		if (consultaSimulacao.paciente != null && consultaSimulacao.dentista != null) {
			System.out.println("\nConsulta " + consultaSimulacao.id_consulta + ", marcada com Dr." + consultaSimulacao.dentista.getnome() + " para " + consultaSimulacao.paciente.getnome() + " para às " + consultaSimulacao.horario + ":00\nDetalhes: " + consultaSimulacao.detalhes + ", " + consultaSimulacao.pagamento + "\n");
		} else {
			System.out.println("Erro de agendamento");
		}
		return consultaSimulacao;
	}

	public Consulta remarcar(Consulta consulta, Sistema sistema, Agenda agenda) {
		
		//TODO: fazer o mesmo sistema de input do marcar() e fazer o remarcar manter o ID da consulta o mesmo, o resto pode ser mudado por input
		
		/* remove da agenda o horario da consulta antiga
		sistema.chamaRemoverHorarioConsultaAgenda(consulta, agenda);*/

		System.out.println("\nDigite o nome do Doutor, paciente, horário, detalhes e forma de pagamento da consulta:  ");
		// simulação do usuário digitando os dados
		Dentista dentista = new Dentista("Luis", "M", "Mestrado", "Odontopediatria");
		Paciente paciente = new Paciente("Ricardo", "M");
		Pagamento pagamento = new Pagamento(150.00, consulta, "Pix");
		Acompanhamento acompanhamento = new Acompanhamento();
		// remarcado para as 18 horas
		Consulta consultaSimulacao = sistema.CriarConsulta(2355, dentista, paciente, 18, "Implante dentário",
				acompanhamento, pagamento);
		// mostra de foi marcado com sucesso ou não
		if (consultaSimulacao.paciente != null && consultaSimulacao.dentista != null) {
			System.out.println("\nConsulta " + consultaSimulacao.id_consulta + ", foi remarcada com Dr." + consultaSimulacao.dentista.getnome() + " para " + consultaSimulacao.paciente.getnome() + " para às " + consultaSimulacao.horario + ":00\nDetalhes: " + consultaSimulacao.detalhes + ", " + consultaSimulacao.pagamento + "\n");
		} else {
			System.out.println("Erro de agendamento");
		}
		return consultaSimulacao;
	}

	public Consulta cancelar(Consulta consulta, Sistema sistema, Consulta consultaLista[]) {
		// interagir com a lista e remover a selecionada por usuário
		System.out.println("\nQual das consultas deseja cancelar: ");
		int i, j;
		for (i = 0, j = 1; i < 10; i++, j++) {
			if (consultaLista[i] != null) {
				System.out.println("Opção" + j + ": " + "Consulta " + i + " - " + consultaLista[i].id_consulta + ", " + consultaLista[i].dentista.getnome() + ", " + consultaLista[i].paciente.getnome() + ", " + consultaLista[i].horario + ":00, " + consultaLista[i].detalhes + ", " + consultaLista[i].acompanhamento + ", " + consultaLista[i].pagamento + ";");
			} else {
				System.out.println("Opção" + j + ": " + "Consulta " + i + " - " + consultaLista[i]);
			}
		}
		// classe que preserva horario
		Consulta consultaOpcaoHorario = new Consulta();
		// simula a escolha do usuário de cancelar a primeira consulta
		int opcao = 1;
		if (opcao == 1) {
			// preservando em uma nova classe, para que seja possível remover da agenda
			// utilizando como referencia o horario da classe
			consultaOpcaoHorario.horario = consultaLista[0].horario;
			// apagando
			consultaLista[0] = null;
			System.out.println("A consulta de opção: " + opcao + " foi cancelada.");
		} else if (opcao != 1) {
			// preservando em uma nova classe, para que seja possível remover da agenda
			// utilizando como referencia o horario da classe
			consultaOpcaoHorario.horario = consultaLista[opcao].horario;
			// apagando
			consultaLista[opcao] = null;
			System.out.println("A consulta de opção: " + opcao + " foi cancelada.");
		}
		return consultaOpcaoHorario;
	}

	public Consulta marcarAcompanhamento(Consulta consultaLista[], int opcao2) {
		Acompanhamento novoAcompanhamento = new Acompanhamento();
		// simula o usuário marcando um retorno
		Consulta consulta = consultaLista[opcao2];
		consulta.acompanhamento = novoAcompanhamento.marcar(consulta, 9);
		return consulta;
	}

	public Consulta remarcarAcompanhamento(Consulta consultaLista[], int opcao2) {
		Acompanhamento novoAcompanhamento = new Acompanhamento();
		// simula o usuário remarcando um retorno
		Consulta consulta = consultaLista[opcao2];
		consulta.acompanhamento = novoAcompanhamento.remarcar(consulta, 13);
		;
		return consulta;
	}

	public Consulta cancelarAcompanhamento(Consulta consultaLista[], int opcao2) {
		Acompanhamento novoAcompanhamento = new Acompanhamento();
		// simula o usuário remarcando um retorno
		Consulta consulta = consultaLista[opcao2];
		consulta.acompanhamento = novoAcompanhamento.cancelar(consulta);
		;
		return consulta;
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

	public void setacompanhamento(Consulta consulta, int horario) {
		this.acompanhamento = new Acompanhamento(consulta, horario);
	}

	public Pagamento getpagamento() {
		return pagamento;
	}

	public void setpagamento(double valor, Consulta consulta, String forma) {
		this.pagamento = new Pagamento(valor, consulta, forma);
	}
}
