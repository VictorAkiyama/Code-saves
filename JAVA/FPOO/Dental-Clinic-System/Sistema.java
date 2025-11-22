package SistemaClinicaOdontologicaPackage;

public class Sistema {
	
	//construtor
	public Sistema() {}
	
	//métodos
	public Consulta CriarConsulta(Dentista dentista, Paciente paciente, int horario, String detalhes, Acompanhamento acompanhamentos[]) {
        Consulta novaConsulta = new Consulta(dentista, paciente, horario, detalhes, acompanhamentos);
        return novaConsulta;
    }
	public Consulta CriarConsulta() {
		Consulta novaConsulta = new Consulta();
		return novaConsulta;
	}
	
	public Consulta interacaoConsulta(int opcao, Consulta consulta, Sistema sistema, Consulta consultaLista[]) {
		//opções da tela principal
		System.out.println("================================================");
		System.out.println("           Opção 1: Marcar Consulta             ");
		System.out.println("           Opção 2: Remarcar Consulta           ");
		System.out.println("           Opção 3: Cancelar Consulta           ");
		System.out.println("           Opção 4: Marcar acompanhamento       ");
		System.out.println("================================================");
		if (consulta != null) {
			if (opcao == 1) {
				System.out.println("Opção para marcar selecionada");
				return consulta.marcar(consulta, sistema);
			}
			else if (opcao == 2) {
				consulta.remarcar();
			}
			else if (opcao == 3) {
				consulta.cancelar(consulta, sistema, consultaLista);
			}
			else if (opcao == 4) {
				System.out.println("Opção para marcar acompanhamento selecionada\nQual das consultas deseja marcar um acompanhamento:");
				sistema.mostrarListadeConsultas(consultaLista);
				//simula o usuário selecionando uma das consultas
				consulta.acompanhamento(consultaLista, 0);
			}
			else {
				System.out.println(opcao + " Não é uma opção válida, tente novamente");
				return new Consulta();
			}
		}
		return new Consulta();
	}
	
	public Consulta colocarNovaConsultaEmLista(Consulta consultaInteracao, Consulta consultaLista[]) {
		int i;
		for (i = 0; i < 10; i++) {
			if (consultaLista[i] == null) {
				consultaLista[i] = consultaInteracao;
				//sai do loop
				return new Consulta();
			}
		}
		//limpa consultaInteracao
		return new Consulta();
	}
	
	public void mostrarListadeConsultas(Consulta consultaLista[]) {
		int i;
		System.out.println("\nLista de consultas:");
		for (i = 0; i < 10; i++) {
			if (consultaLista[i] == null) {
				System.out.println(i + " Nenhuma consulta marcada aqui.");
			}
			else {
				System.out.println(i + " " + consultaLista[i].dentista.nome + ", " + consultaLista[i].paciente.nome + ", " + consultaLista[i].horario + ":00, " + consultaLista[i].detalhes + ";");
			}
		}
	}
}
