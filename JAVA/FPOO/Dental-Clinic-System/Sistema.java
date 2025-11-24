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
	
	public void mostrarListadeConsultas(Consulta consultaLista[]) {
		int i;
		System.out.println("\nLista de consultas:");
		for (i = 0; i < 10; i++) {
			if (consultaLista[i] == null) {
				System.out.println(i + " Nenhuma consulta marcada aqui.");
			}
			else {
				System.out.println(i + " " + consultaLista[i].id_consulta + ", " + consultaLista[i].dentista.nome + ", " + consultaLista[i].paciente.nome + ", " + consultaLista[i].horario + ":00, " + consultaLista[i].detalhes + ", " + consultaLista[i].acompanhamento + ", " + consultaLista[i].getpagamento() + ";");
			}
		}
	}
	
	public void colocaHorarioConsultaAgenda(Consulta consultaInteracao, Agenda agenda) {
		switch(consultaInteracao.horario) {
			case 8:
				agenda.hora8 = true;
				break;
			case 9:
				agenda.hora9 = true;
				break;
			case 10:
				agenda.hora10 = true;
				break;
			case 11:
				agenda.hora11 = true;
				break;
			case 12:
				agenda.hora12 = true;
				break;
			case 13:
				agenda.hora13 = true;
				break;
			case 14:
				agenda.hora14 = true;
				break;
			case 15:
				agenda.hora15 = true;
				break;
			case 16:
				agenda.hora16 = true;
				break;
			case 17:
				agenda.hora17 = true;
				break;
			case 18:
				agenda.hora18 = true;
				break;
			default:
				System.out.println("\nO horário de consulta não é equivalente aos disponíveis na agenda.");
		}
	}
	
	public void removerHorarioConsultaAgenda(Consulta consultaInteracao, Agenda agenda) {
		switch(consultaInteracao.horario) {
			case 8:
				agenda.hora8 = false;
				break;
			case 9:
				agenda.hora9 = false;
				break;
			case 10:
				agenda.hora10 = false;
				break;
			case 11:
				agenda.hora11 = false;
				break;
			case 12:
				agenda.hora12 = false;
				break;
			case 13:
				agenda.hora13 = false;
				break;
			case 14:
				agenda.hora14 = false;
				break;
			case 15:
				agenda.hora15 = false;
				break;
			case 16:
				agenda.hora16 = false;
				break;
			case 17:
				agenda.hora17 = false;
				break;
			case 18:
				agenda.hora18 = false;
				break;
			default:
				System.out.println("\nO horário de consulta não é equivalente aos ocupados na agenda.");
		}
	}
	
	public void colocaHorarioAcompanhamentoAgenda(Consulta consultaInteracao, Agenda agenda) {
		switch(consultaInteracao.acompanhamento.horario) {
			case 8:
				agenda.hora8 = true;
				break;
			case 9:
				agenda.hora9 = true;
				break;
			case 10:
				agenda.hora10 = true;
				break;
			case 11:
				agenda.hora11 = true;
				break;
			case 12:
				agenda.hora12 = true;
				break;
			case 13:
				agenda.hora13 = true;
				break;
			case 14:
				agenda.hora14 = true;
				break;
			case 15:
				agenda.hora15 = true;
				break;
			case 16:
				agenda.hora16 = true;
				break;
			case 17:
				agenda.hora17 = true;
				break;
			case 18:
				agenda.hora18 = true;
				break;
			default:
				System.out.println("\nO horário do acompanhamento não é equivalente aos disponíveis na agenda.");
		}
	}
	
	public void removerHorarioAcompanhamentoAgenda(Consulta consultaInteracao, Agenda agenda) {
		switch(consultaInteracao.acompanhamento.horario) {
			case 8:
				agenda.hora8 = false;
				break;
			case 9:
				agenda.hora9 = false;
				break;
			case 10:
				agenda.hora10 = false;
				break;
			case 11:
				agenda.hora11 = false;
				break;
			case 12:
				agenda.hora12 = false;
				break;
			case 13:
				agenda.hora13 = false;
				break;
			case 14:
				agenda.hora14 = false;
				break;
			case 15:
				agenda.hora15 = false;
				break;
			case 16:
				agenda.hora16 = false;
				break;
			case 17:
				agenda.hora17 = false;
				break;
			case 18:
				agenda.hora18 = false;
				break;
			default:
				System.out.println("\nO horário do acompanhamento não é equivalente aos ocupados na agenda.");
		}
	}
	
	public void mostrarAgenda(Agenda agenda) {
		System.out.println("\nAgenda:");
		if(agenda.hora8 == false) {
			System.out.println("8 horas: Disponível");
		} else {
			System.out.println("8 horas: Ocupado");
		}
		if(agenda.hora9 == false) {
			System.out.println("9 horas: Disponível");
		} else {
			System.out.println("9 horas: Ocupado");
		}
		if(agenda.hora10 == false) {
			System.out.println("10 horas: Disponível");
		} else {
			System.out.println("10 horas: Ocupado");
		}
		if(agenda.hora11 == false) {
			System.out.println("11 horas: Disponível");
		} else {
			System.out.println("11 horas: Ocupado");
		}
		if(agenda.hora12 == false) {
			System.out.println("12 horas: Disponível");
		} else {
			System.out.println("12 horas: Ocupado");
		}
		if(agenda.hora13 == false) {
			System.out.println("13 horas: Disponível");
		} else {
			System.out.println("13 horas: Ocupado");
		}
		if(agenda.hora14 == false) {
			System.out.println("14 horas: Disponível");
		} else {
			System.out.println("14 horas: Ocupado");
		}
		if(agenda.hora15 == false) {
			System.out.println("15 horas: Disponível");
		} else {
			System.out.println("15 horas: Ocupado");
		}
		if(agenda.hora16 == false) {
			System.out.println("16 horas: Disponível");
		} else {
			System.out.println("16 horas: Ocupado");
		}
		if(agenda.hora17 == false) {
			System.out.println("17 horas: Disponível");
		} else {
			System.out.println("17 horas: Ocupado");
		}
		if(agenda.hora18 == false) {
			System.out.println("18 horas: Disponível");
		} else {
			System.out.println("18 horas: Ocupado");
		}
	}
	
	public void LimpaAgenda(Agenda agenda) {
		agenda.hora8 = false;
		agenda.hora9 = false;
		agenda.hora10 = false;
		agenda.hora11 = false;
		agenda.hora12 = false;
		agenda.hora13 = false;
		agenda.hora14 = false;
		agenda.hora15 = false;
		agenda.hora16 = false;
		agenda.hora17 = false;
		agenda.hora18 = false;
		System.out.println("\nA agenda foi limpa.");
	}
}
