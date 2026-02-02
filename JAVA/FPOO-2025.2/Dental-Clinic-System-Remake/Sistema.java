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
	
	public void interacao(int opcao, Consulta consulta, Sistema sistema, Consulta consultaLista[], Agenda agenda) {
		//lista de opções
		if (opcao == 1) {
			System.out.println("Opção para marcar consulta selecionada");
			consulta = consulta.marcar(consulta, sistema, numero_id);
			numero_id = incrementaID(numero_id);
			chamaColocaHorarioConsultaAgenda(consulta, agenda);
			colocarNovaConsultaEmLista(consulta, consultaLista);
			mostrarListadeConsultas(consultaLista);
			chamaMostrarAgenda(agenda);
		}
		else if (opcao == 2) {
			System.out.println("Opção para remarcar consulta selecionada");
			id_consulta_selecionada = selecionarConsultaNaListadeConsultas(consultaLista);
			// se a consulta foi encontrada, continua
			if (id_consulta_selecionada >= 0) {
				//TODO: sistema de remover o horario da consulta selecionada na agenda e colocar denovo a mesma consulta com horário diferente na agenda
				consulta = consulta.remarcar(consulta, sistema, agenda);
				chamaColocaHorarioConsultaAgenda(consulta, agenda);
			}
			// se não foi encontrada, volta para o menu principal
			else {
				return;
			}
		}
		else if (opcao == 3) {
			System.out.println("Opção para cancelar consulta selecionada");
			consulta = consulta.cancelar(consulta, sistema, consultaLista);
		}
		else if (opcao == 4) {
			System.out.println("Opção para marcar acompanhamento selecionada\nQual das consultas deseja marcar um acompanhamento:");
			sistema.mostrarListadeConsultas(consultaLista);
			//simula o usuário selecionando uma das consultas
			consulta = consulta.marcarAcompanhamento(consultaLista, 0);
		}
		else if (opcao == 5) {
			System.out.println("Opção para remarcar acompanhamento selecionada\nQual das consultas deseja remarcar um acompanhamento:");
			sistema.mostrarListadeConsultas(consultaLista);
			//simula o usuário selecionando uma das consultas
			consulta = consulta.remarcarAcompanhamento(consultaLista, 0);
		}
		else if (opcao == 6) {
			System.out.println("Opção para cancelar acompanhamento selecionada\nQual das consultas deseja cancelar o acompanhamento:");
			sistema.mostrarListadeConsultas(consultaLista);
			//simula o usuário selecionando uma das consultas
			consulta = consulta.cancelarAcompanhamento(consultaLista, 0);
		}
		else {
			System.out.println(opcao + " Não é uma opção válida, tente novamente");
		}
	}
	
	// usado para incrementar o numero usado para ID, depois de criar uma consulta
	public int incrementaID(int numero_id) {
		numero_id ++;
		return numero_id;
	}
	
	public Consulta colocarNovaConsultaEmLista(Consulta consulta, Consulta consultaLista[]) {
		int i;
		for (i = 0; i < 10; i++) {
			if (consultaLista[i] == null) {
				consultaLista[i] = consulta;
				//sai do loop
				return consultaLista[i];
			}
		}
		//limpa consultaInteracao
		return consultaLista[i];
	}
	
	public Consulta colocarConsultaRemarcadaEmLista(Consulta consultaInteracao, Consulta consultaLista[]) {
		int i;
		for (i = 0; i < 10; i++) {
			if (consultaInteracao.getid_consulta() == consultaLista[i].getid_consulta()) {
				consultaLista[i] = consultaInteracao;
				//sai do loop
				return consultaLista[i];
			}
		}
		//limpa consultaInteracao
		return consultaLista[i];
	}
	
	public void mostrarListadeConsultas(Consulta consultaLista[]) {
		int i;
		System.out.println("\nLista de consultas:");
		for (i = 0; i < 10; i++) {
			if (consultaLista[i] == null) {
				System.out.println(i + " Nenhuma consulta marcada aqui.");
			}
			else {
				System.out.println(i + " " + consultaLista[i].getid_consulta() + ", " + consultaLista[i].getdentista().getnome() + ", " + consultaLista[i].getpaciente().getnome() + ", " + consultaLista[i].gethorario() + ":00, " + consultaLista[i].getdetalhes() + ", " + consultaLista[i].getacompanhamento() + ", " + consultaLista[i].getpagamento() + ";");
			}
		}
	}
	
	Scanner input = new Scanner(System.in); //objeto input
	
	public int selecionarConsultaNaListadeConsultas(Consulta consultaLista[]) {
		int i;
		int indiceDaConsultaNaLista = 0;
		int verificador = 0;
		int valor_a_retornar = 0; // usado para retornar da função
		
		mostrarListadeConsultas(consultaLista); // mostra lista para o usuário ter uma referência
		System.out.println("\nSelecione uma consulta da lista pelo ID: ");
		int IDconsultaSelecionada = input.nextInt(); // pega o id digitado
		input.nextLine(); // limpa o enter do input anterior
		
		for (i = 0; i < 10; i++) {
			// procura pela consulta com o ID selecionado
			if (consultaLista[i].getid_consulta() == IDconsultaSelecionada) {
				// pega o indice da consulta procurada na lista
				indiceDaConsultaNaLista = i;
				// altera o valor do verificador 
				verificador = 1;
				break;
			}
		}
		
		// se a consulta com o ID foi encontrado
		if (verificador == 1) {
			System.out.println("\n\nConsulta com o ID foi encontrado.\n\n");
			valor_a_retornar = indiceDaConsultaNaLista;
		}
		else if (verificador == 0) {
			System.out.println("\n\nConsulta com o ID não foi encontrado.\n\n");
			valor_a_retornar = -1;
		}
		
		// sim, é estranho. Mas foi a única forma já que a função não aceita se eu retornar dentro do if else :)
		return valor_a_retornar;
	}
	
	public void chamaColocaHorarioConsultaAgenda(Consulta consulta, Agenda agenda) {
		agenda.colocaHorarioConsultaAgenda(consulta);
	}
	
	public void chamaRemoverHorarioConsultaAgenda(Consulta consultaInteracao, Agenda agenda) {
		agenda.removerHorarioConsultaAgenda(consultaInteracao);
	}
	
	public void chamaColocaHorarioAcompanhamentoAgenda(Consulta consultaInteracao, Agenda agenda) {
		agenda.colocaHorarioAcompanhamentoAgenda(consultaInteracao);
	}
	
	public void chamaRemoverHorarioAcompanhamentoAgenda(Consulta consultaInteracaoAnterior, Agenda agenda) {
		agenda.removerHorarioAcompanhamentoAgenda(consultaInteracaoAnterior);
	}
	
	public void chamaMostrarAgenda(Agenda agenda) {
		agenda.mostrarAgenda();
	}
	
	public void chamaLimpaAgenda(Agenda agenda) {
		agenda.LimpaAgenda();
	}
}
