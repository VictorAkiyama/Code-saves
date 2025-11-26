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
	
	public Consulta interacaoConsulta(int opcao, Consulta consulta, Sistema sistema, Consulta consultaLista[], Consulta consultaInteracao, Agenda agenda) {
		//opções da tela principal
		System.out.println("================================================");
		System.out.println("           Opção 1: Marcar Consulta             ");
		System.out.println("           Opção 2: Remarcar Consulta           ");
		System.out.println("           Opção 3: Cancelar Consulta           ");
		System.out.println("           Opção 4: Marcar acompanhamento       ");
		System.out.println("           Opção 5: Remarcar acompanhamento     ");
		System.out.println("           Opção 6: Cancelar acompanhamento     ");
		System.out.println("================================================");
		if (consulta != null) {
			if (opcao == 1) {
				System.out.println("Opção para marcar consulta selecionada");
				consulta = consulta.marcar(consulta, sistema);
			}
			else if (opcao == 2) {
				System.out.println("Opção para remarcar consulta selecionada");
				consulta = consulta.remarcar(consulta, sistema, consultaInteracao, agenda);
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
				return new Consulta();
			}
		}
		return consulta;
	}
	
	public Consulta colocarNovaConsultaEmLista(Consulta consultaInteracao, Consulta consultaLista[]) {
		int i;
		for (i = 0; i < 10; i++) {
			if (consultaLista[i] == null) {
				consultaLista[i] = consultaInteracao;
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
	
	public void chamaColocaHorarioConsultaAgenda(Consulta consultaInteracao, Agenda agenda) {
		agenda.colocaHorarioConsultaAgenda(consultaInteracao);
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
