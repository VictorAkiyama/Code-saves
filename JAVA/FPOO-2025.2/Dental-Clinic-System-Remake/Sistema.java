package SistemaClinicaOdontologicaPackage;

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
			consulta = consulta.remarcar(consulta, sistema, agenda);
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
