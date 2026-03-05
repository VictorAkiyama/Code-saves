package SistemaClinicaOdontologicaPackage;

import java.util.Scanner; //biblioteca input

public class Sistema {
	
	//construtor
	public Sistema() {}
	
	//métodos
	public Consulta CriarConsulta(int id_consulta, Dentista dentista, Paciente paciente, int horario, String detalhes, Acompanhamento acompanhamento, Pagamento pagamento) {
        Consulta novaConsulta = new Consulta(id_consulta, dentista, paciente, horario, detalhes, acompanhamento, pagamento);
        return novaConsulta;
    }
	public Consulta CriarConsulta() {
		Consulta novaConsulta = new Consulta();
		return novaConsulta;
	}
	
	//numero criado para servir como id para as consultas, incrementa quando se marca uma consulta
	int numero_id = 1000;
	
	//numero de ID da consulta selecionada, das opções remarcar e cancelar consulta
	int id_consulta_selecionada = 0;
	
	//horario da consulta selecionada, das opções remarcar e cancelar consulta
	int horario_consulta_selecionada = 0;
	
	//horario de acompanhamento, das opções marcar, remarcar e cancelar acompanhamento
	int horario_acompanhamento_consulta_selecionada = 0;
	
	public void interacao(int opcao, Consulta consulta, Sistema sistema, Consulta consultaLista[], Agenda agenda) {
		//lista de opções
		if (opcao == 1) {
			System.out.println("Opção para marcar consulta selecionada");
			consulta = consulta.marcar(consulta, sistema, numero_id, agenda);
			numero_id = incrementaID(numero_id);
			chamaColocaHorarioConsultaAgenda(consulta, agenda);
			colocarNovaConsultaEmLista(consulta, consultaLista);
			mostrarListadeConsultas(consultaLista);
			chamaMostrarAgenda(agenda);
		}
		else if (opcao == 2) {
			System.out.println("Opção para remarcar consulta selecionada");
			id_consulta_selecionada = selecionarIDconsultaNaListadeConsultas(consultaLista);
			// se a consulta foi encontrada, continua
			if (id_consulta_selecionada >= 0) {
				horario_consulta_selecionada = pegarHorarioConsultaSelecionada(consultaLista, id_consulta_selecionada); // pega horario da consulta selecionada
				chamaRemoverHorarioConsultaAgenda(agenda, horario_consulta_selecionada);
				consulta = consulta.remarcar(consulta, sistema, agenda, id_consulta_selecionada);
				chamaColocaHorarioConsultaAgenda(consulta, agenda);
				colocarConsultaRemarcadaEmLista(consulta, consultaLista);
				mostrarListadeConsultas(consultaLista);
				chamaMostrarAgenda(agenda);
			}
			// se não foi encontrada, volta para o menu principal
			else {
				return;
			}
		}
		else if (opcao == 3) {
			System.out.println("Opção para cancelar consulta selecionada");
			id_consulta_selecionada = selecionarIDconsultaNaListadeConsultas(consultaLista);
			// se a consulta foi encontrada, continua
			if (id_consulta_selecionada >= 0) {
				horario_consulta_selecionada = pegarHorarioConsultaSelecionada(consultaLista, id_consulta_selecionada); // pega horario da consulta selecionada
				chamaRemoverHorarioConsultaAgenda(agenda, horario_consulta_selecionada);
				consulta.cancelar(consulta, sistema, consultaLista, id_consulta_selecionada);
				mostrarListadeConsultas(consultaLista);
				chamaMostrarAgenda(agenda);
			}
			// se não foi encontrada, volta para o menu principal
			else {
				return;
			}
		}
		else if (opcao == 4) {
			System.out.println("Opção para marcar acompanhamento selecionada");
			id_consulta_selecionada = selecionarIDconsultaNaListadeConsultas(consultaLista);
			if (id_consulta_selecionada >= 0) {
				consulta = consulta.marcarAcompanhamento(consultaLista, id_consulta_selecionada, agenda);
				chamaColocaHorarioAcompanhamentoAgenda(consulta, agenda);
				mostrarListadeConsultas(consultaLista);
				chamaMostrarAgenda(agenda);
			}
			// se não foi encontrada, volta para o menu principal
			else {
				return;
			}
		}
		else if (opcao == 5) {
			System.out.println("Opção para remarcar acompanhamento selecionada");
			id_consulta_selecionada = selecionarIDconsultaNaListadeConsultas(consultaLista);
			if (id_consulta_selecionada >= 0) {
				horario_acompanhamento_consulta_selecionada = pegarHorarioAcompanhamentoDaConsultaSelecionada(consultaLista, id_consulta_selecionada); // pega horario do acompanhamento da consulta selecionada
				chamaRemoverHorarioAcompanhamentoAgenda(agenda, horario_acompanhamento_consulta_selecionada);
				consulta = consulta.remarcarAcompanhamento(consultaLista, id_consulta_selecionada, agenda);
				chamaColocaHorarioAcompanhamentoAgenda(consulta, agenda);
				mostrarListadeConsultas(consultaLista);
				chamaMostrarAgenda(agenda);
			}
			// se não foi encontrada, volta para o menu principal
			else {
				return;
			}
		}
		else if (opcao == 6) {
			System.out.println("Opção para cancelar acompanhamento selecionada");
			id_consulta_selecionada = selecionarIDconsultaNaListadeConsultas(consultaLista);
			if (id_consulta_selecionada >= 0) {
				horario_acompanhamento_consulta_selecionada = pegarHorarioAcompanhamentoDaConsultaSelecionada(consultaLista, id_consulta_selecionada); // pega horario do acompanhamento da consulta selecionada
				chamaRemoverHorarioAcompanhamentoAgenda(agenda, horario_acompanhamento_consulta_selecionada);
				consulta = consulta.cancelarAcompanhamento(consultaLista, id_consulta_selecionada, agenda);
				mostrarListadeConsultas(consultaLista);
				chamaMostrarAgenda(agenda);
			}
			// se não foi encontrada, volta para o menu principal
			else {
				return;
			}
		}
		else {
			System.out.println("\n\n" + opcao + " Não é uma opção válida, tente novamente");
		}
	}
	
	// usado para incrementar o numero usado para ID, depois de criar uma consulta
	public int incrementaID(int numero_id) {
		numero_id ++;
		return numero_id;
	}
	
	public Consulta colocarNovaConsultaEmLista(Consulta consulta, Consulta consultaLista[]) {
		int i;
		for (i = 0; i < consultaLista.length; i++) {
			if (consultaLista[i] == null) {
				consultaLista[i] = consulta;
				//sai do loop
				return consultaLista[i];
			}
		}
		//limpa consultaInteracao
		return consultaLista[i];
	}
	
	public Consulta colocarConsultaRemarcadaEmLista(Consulta consulta, Consulta consultaLista[]) {
		int i;
		for (i = 0; i < consultaLista.length; i++) {
			if (consulta.getid_consulta() == consultaLista[i].getid_consulta()) {
				consultaLista[i] = consulta;
				//sai do loop
				return consultaLista[i];
			}
		}
		//limpa consultaInteracao
		return consultaLista[i];
	}
	
	public void mostrarListadeConsultas(Consulta consultaLista[]) {
		int i;
		int j = 1; // usado para número posição
		System.out.println("\nLista de consultas:");
		for (i = 0; i < consultaLista.length; i++) {
			if (consultaLista[i] == null) {
				System.out.println(j + " Nenhuma consulta marcada aqui.");
			}
			else {
				if (consultaLista[i].getacompanhamento().gethorario() != 0) {
					System.out.println(j + " ID: " + consultaLista[i].getid_consulta() + ", Dr." + consultaLista[i].getdentista().getnome() + ", paciente: " + consultaLista[i].getpaciente().getnome() + ", horário: " + consultaLista[i].gethorario() + ":00, Detalhes: " + consultaLista[i].getdetalhes() + ", " + consultaLista[i].getacompanhamento() + ", " + consultaLista[i].getpagamento() + ";");
				}
				else {
					System.out.println(j + " ID: " + consultaLista[i].getid_consulta() + ", Dr." + consultaLista[i].getdentista().getnome() + ", paciente: " + consultaLista[i].getpaciente().getnome() + ", horário: " + consultaLista[i].gethorario() + ":00, Detalhes: " + consultaLista[i].getdetalhes() + ", Nenhum acompanhamento marcado, " + consultaLista[i].getpagamento() + ";");
				}
			}
			j++; // aumenta o número posição
		}
	}
	
	Scanner input = new Scanner(System.in); //objeto input
	
	public int selecionarIDconsultaNaListadeConsultas(Consulta consultaLista[]) {
		int i;
		int verificador = 0;
		int valor_a_retornar = 0; // usado para retornar da função
		
		mostrarListadeConsultas(consultaLista); // mostra lista para o usuário ter uma referência
		System.out.println("\nSelecione uma consulta da lista pelo ID: ");
		int IDconsultaSelecionada = input.nextInt(); // pega o id digitado
		//input.nextLine(); // limpa o enter do input anterior
		
		for (i = 0; i < consultaLista.length; i++) {
			// procura pela consulta com o ID selecionado
			if (consultaLista[i] != null && consultaLista[i].getid_consulta() == IDconsultaSelecionada) {
				// altera o valor do verificador
				verificador = 1;
				break;
			}
		}
		
		// se a consulta com o ID foi encontrado
		if (verificador == 1) {
			System.out.println("\n\nConsulta com o ID foi encontrado.\n\n");
			valor_a_retornar = IDconsultaSelecionada;
		}
		else if (verificador == 0) {
			System.out.println("\n\nConsulta com o ID não foi encontrado.\n\n");
			valor_a_retornar = -1;
		}
		
		// sim, é estranho. Mas foi a única forma já que a função não aceita se eu retornar dentro do if else :)
		return valor_a_retornar;
	}
	
	public int pegarHorarioConsultaSelecionada(Consulta consultaLista[], int id_consulta_selecionada) {
		int i;
		int horarioDaConsultaNaAgenda = 0;
		
		for (i = 0; i < consultaLista.length; i++) {
			// procura pela consulta com o ID selecionado
			if (consultaLista[i] != null && consultaLista[i].getid_consulta() == id_consulta_selecionada) {
				// pega o HORARIO da consulta procurada na lista
				horarioDaConsultaNaAgenda = consultaLista[i].gethorario();
				break;
			}
		}
		
		return horarioDaConsultaNaAgenda;
	}
	
	public int pegarHorarioAcompanhamentoDaConsultaSelecionada(Consulta consultaLista[], int id_consulta_selecionada) {
		int i;
		int horarioDoAcompanhamentoNaAgenda = 0;
		
		for (i = 0; i < consultaLista.length; i++) {
			// procura pela consulta com o ID selecionado
			if (consultaLista[i] != null && consultaLista[i].getid_consulta() == id_consulta_selecionada) {
				// pega o HORARIO do acompanhamento da consulta procurada na lista
				horarioDoAcompanhamentoNaAgenda = consultaLista[i].getacompanhamento().gethorario();
				break;
			}
		}
		
		return horarioDoAcompanhamentoNaAgenda;
	}
	
	public void chamaColocaHorarioConsultaAgenda(Consulta consulta, Agenda agenda) {
		agenda.colocaHorarioConsultaAgenda(consulta);
	}
	
	public void chamaRemoverHorarioConsultaAgenda(Agenda agenda, int horario_consulta_selecionada) {
		agenda.removerHorarioConsultaAgenda(horario_consulta_selecionada);
	}
	
	public void chamaColocaHorarioAcompanhamentoAgenda(Consulta consulta, Agenda agenda) {
		agenda.colocaHorarioAcompanhamentoAgenda(consulta);
	}
	
	public void chamaRemoverHorarioAcompanhamentoAgenda(Agenda agenda, int horario_acompanhamento_consulta_selecionada) {
		agenda.removerHorarioAcompanhamentoAgenda(horario_acompanhamento_consulta_selecionada);
	}
	
	public void chamaMostrarAgenda(Agenda agenda) {
		agenda.mostrarAgenda();
	}
	
	public void chamaLimpaAgenda(Agenda agenda) {
		agenda.LimpaAgenda();
	}
}
