package SistemaClinicaOdontologicaPackage;

public class Consulta {

	public Dentista dentista;
    public Paciente paciente;
    public int horario;
    public String detalhes;
    public Acompanhamento acompanhamentos;
    
    //construtor vazio
    public Consulta() {}
    
    //construtor 
    public Consulta(Dentista dentista, Paciente paciente, int horario, String detalhes, Acompanhamento acompanhamentos[]){
        this.dentista = dentista;
        this.paciente = paciente;
        this.horario = horario;
        this.detalhes = detalhes;
        this.acompanhamentos = acompanhamentos[0];
    }
    
    //métodos
    public Consulta marcar(Consulta consulta, Sistema sistema) {
    	System.out.println("\nDigite o nome do Doutor, paciente, horário e detalhes da consulta:  ");
    	//simulação do usuário digitando os dados
    	Dentista dentista = new Dentista("Luis", "M", "Mestrado", "Odontopediatria");
    	Paciente paciente = new Paciente("Ricardo", "M");
    	Acompanhamento acompanhamento[] = new Acompanhamento[10];
    	Consulta consultaSimulacao = sistema.CriarConsulta(dentista, paciente, 15, "Implante dentário", acompanhamento);
    	
    	if (consultaSimulacao.paciente != null && consultaSimulacao.dentista != null) {
    		System.out.println("\nConsulta marcada com Dr." + consultaSimulacao.dentista.nome + " para " + consultaSimulacao.paciente.nome + " para às " + consultaSimulacao.horario + ":00\nDetalhes: " + consultaSimulacao.detalhes + "\n");
    	}
    	else {
    		System.out.println("Erro de agendamento");
    	}
    	return consultaSimulacao;
    }
    
    public void remarcar() {}
    
    public Consulta cancelar(Consulta consulta, Sistema sistema, Consulta consultaLista[]) {
    	//interagir com a lista e remover a selecionada por usuário
    	System.out.println("\nQual das consultas deseja cancelar: ");
    	int i, j;
    	for (i = 0, j = 1; i < 10; i++, j++) {
    		if (consultaLista[i] != null) {
    			System.out.println("Opção" + j + ": " + "Consulta " + i + " - " + consultaLista[i].dentista.nome + ", " + consultaLista[i].paciente.nome + ", " + consultaLista[i].horario + ":00, " + consultaLista[i].detalhes);
    		}
    		else {
    			System.out.println("Opção" + j + ": " + "Consulta " + i + " - " + consultaLista[i]);
    		}
    	}
    	//simula a escolha do usuário de cancelar a primeira consulta
    	int opcao = 1;
    	if (opcao == 1) {
    		consultaLista[0] = null;
    		System.out.println("A consulta de opção: " + opcao + " foi cancelada.");
    	}
    	else if (opcao != 1){
    		consultaLista[opcao] = null;
    		System.out.println("A consulta de opção: " + opcao + " foi cancelada.");
    	}
    	return new Consulta();
    }
    
    public void acompanhamento(Consulta consultaLista[], int opcao2) {
    	Acompanhamento novoAcompanhamento = new Acompanhamento();
    	//simula o usuário marcando um retorno
    	Consulta consulta = consultaLista[opcao2]; 
    	novoAcompanhamento.marcar(consulta, 9);
    }
}
