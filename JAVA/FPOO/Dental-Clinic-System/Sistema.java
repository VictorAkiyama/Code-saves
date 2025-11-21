package SistemaClinicaOdontologicaPackage;

public class Sistema {
	
	//construtor
	public Sistema() {}
	
	//métodos
	public static Consulta CriarConsulta(String dentista, String paciente, int horario) {
        Consulta novaConsulta = new Consulta(dentista, paciente, horario);
        return novaConsulta;
    }
	public static Consulta CriarConsulta() {
		Consulta novaConsulta = new Consulta();
		return novaConsulta;
	}
	
	public Consulta interacaoConsulta(int opcao, Consulta consulta, Sistema sistema) {
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
			/*
			else if (opcao == 2) {
				consulta.remarcar();
			}
			else if (opcao == 3) {
				consulta.cancelar();
			}
			else if (opcao == 4) {
				consulta.acompanhamento();
			}*/
			else {
				System.out.println(opcao + " Não é uma opção válida, tente novamente");
				return new Consulta();
			}
		}
		return new Consulta();
	}
	
	public void colocarNovaConsultaEmLista(Consulta consultaInteracao, Consulta consultaLista[]) {
		int i;
		for (i = 0; i < 10; i++) {
			if (consultaLista[i] == null) {
				consultaLista[i]= consultaInteracao;
				return;
			}
		}
	}
}
