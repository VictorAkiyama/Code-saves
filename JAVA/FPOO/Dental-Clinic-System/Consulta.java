package SistemaClinicaOdontologicaPackage;

public class Consulta implements Atendimento{

	public int id_consulta;
	public Dentista dentista;
    public Paciente paciente;
    public int horario;
    public String detalhes;
    public Acompanhamento acompanhamento;
    private Pagamento pagamento;
    
    //construtor vazio
    public Consulta() {}
    
    //construtor 
    public Consulta(int id_consulta, Dentista dentista, Paciente paciente, int horario, String detalhes, Acompanhamento acompanhamento, Pagamento pagamento){
    	this.id_consulta = id_consulta;
        this.dentista = dentista;
        this.paciente = paciente;
        this.horario = horario;
        this.detalhes = detalhes;
        this.acompanhamento = acompanhamento;
        this.pagamento = pagamento;
    }
    
    //métodos
    public Consulta marcar(Consulta consulta, Sistema sistema) {
    	System.out.println("\nDigite o nome do Doutor, paciente, horário, detalhes e forma de pagamento da consulta:  ");
    	//simulação do usuário digitando os dados
    	Dentista dentista = new Dentista("Luis", "M", "Mestrado", "Odontopediatria");
    	Paciente paciente = new Paciente("Ricardo", "M");
    	Pagamento pagamento = new Pagamento(150.00, consulta, "Pix");
    	Acompanhamento acompanhamento = new Acompanhamento();
    	Consulta consultaSimulacao = sistema.CriarConsulta(2355, dentista, paciente, 15, "Implante dentário", acompanhamento, pagamento);
    	//mostra de foi marcado com sucesso ou não
    	if (consultaSimulacao.paciente != null && consultaSimulacao.dentista != null) {
    		System.out.println("\nConsulta " + consultaSimulacao.id_consulta + ", marcada com Dr." + consultaSimulacao.dentista.nome + " para " + consultaSimulacao.paciente.nome + " para às " + consultaSimulacao.horario + ":00\nDetalhes: " + consultaSimulacao.detalhes + ", " + consultaSimulacao.pagamento + "\n");
    	}
    	else {
    		System.out.println("Erro de agendamento");
    	}
    	return consultaSimulacao;
    }
    
    public Consulta remarcar(Consulta consulta, Sistema sistema, Consulta consultaInteracao, Agenda agenda) {
    	//remove da agenda o horario da consulta antiga
    	sistema.chamaRemoverHorarioConsultaAgenda(consultaInteracao, agenda);
    	
    	System.out.println("\nDigite o nome do Doutor, paciente, horário, detalhes e forma de pagamento da consulta:  ");
    	//simulação do usuário digitando os dados
    	Dentista dentista = new Dentista("Luis", "M", "Mestrado", "Odontopediatria");
    	Paciente paciente = new Paciente("Ricardo", "M");
    	Pagamento pagamento = new Pagamento(150.00, consulta, "Pix");
    	Acompanhamento acompanhamento = new Acompanhamento();
    	//remarcado para as 18 horas
    	Consulta consultaSimulacao = sistema.CriarConsulta(2355, dentista, paciente, 18, "Implante dentário", acompanhamento, pagamento);
    	//mostra de foi marcado com sucesso ou não
    	if (consultaSimulacao.paciente != null && consultaSimulacao.dentista != null) {
    		System.out.println("\nConsulta " + consultaSimulacao.id_consulta + ", foi remarcada com Dr." + consultaSimulacao.dentista.nome + " para " + consultaSimulacao.paciente.nome + " para às " + consultaSimulacao.horario + ":00\nDetalhes: " + consultaSimulacao.detalhes + ", " + consultaSimulacao.pagamento + "\n");
    	}
    	else {
    		System.out.println("Erro de agendamento");
    	}
    	return consultaSimulacao;
    }
    
    public Consulta cancelar(Consulta consulta, Sistema sistema, Consulta consultaLista[]) {
    	//interagir com a lista e remover a selecionada por usuário
    	System.out.println("\nQual das consultas deseja cancelar: ");
    	int i, j;
    	for (i = 0, j = 1; i < 10; i++, j++) {
    		if (consultaLista[i] != null) {
    			System.out.println("Opção" + j + ": " + "Consulta " + i + " - " + consultaLista[i].id_consulta + ", "+ consultaLista[i].dentista.nome + ", " + consultaLista[i].paciente.nome + ", " + consultaLista[i].horario + ":00, " + consultaLista[i].detalhes + ", " + consultaLista[i].acompanhamento + ", " + consultaLista[i].pagamento + ";");
    		}
    		else {
    			System.out.println("Opção" + j + ": " + "Consulta " + i + " - " + consultaLista[i]);
    		}
    	}
    	//classe que preserva horario
    	Consulta consultaOpcaoHorario = new Consulta();
    	//simula a escolha do usuário de cancelar a primeira consulta
    	int opcao = 1;
    	if (opcao == 1) {
    		//preservando em uma nova classe, para que seja possível remover da agenda utilizando como referencia o horario da classe
    		consultaOpcaoHorario.horario = consultaLista[0].horario;
    		//apagando
    		consultaLista[0] = null;
    		System.out.println("A consulta de opção: " + opcao + " foi cancelada.");
    	}
    	else if (opcao != 1){
    		//preservando em uma nova classe, para que seja possível remover da agenda utilizando como referencia o horario da classe
    		consultaOpcaoHorario.horario = consultaLista[opcao].horario;
    		//apagando
    		consultaLista[opcao] = null;
    		System.out.println("A consulta de opção: " + opcao + " foi cancelada.");
    	}
    	return consultaOpcaoHorario;
    }
    
    public Consulta marcarAcompanhamento(Consulta consultaLista[], int opcao2) {
    	Acompanhamento novoAcompanhamento = new Acompanhamento();
    	//simula o usuário marcando um retorno
    	Consulta consulta = consultaLista[opcao2];
    	consulta.acompanhamento = novoAcompanhamento.marcar(consulta, 9);
    	return consulta;
    }
    
    public Consulta remarcarAcompanhamento(Consulta consultaLista[], int opcao2) {
    	Acompanhamento novoAcompanhamento = new Acompanhamento();
    	//simula o usuário remarcando um retorno
    	Consulta consulta = consultaLista[opcao2];
    	consulta.acompanhamento = novoAcompanhamento.remarcar(consulta, 13);;
    	return consulta;
    }
    
    public Consulta cancelarAcompanhamento(Consulta consultaLista[], int opcao2) {
    	Acompanhamento novoAcompanhamento = new Acompanhamento();
    	//simula o usuário remarcando um retorno
    	Consulta consulta = consultaLista[opcao2];
    	consulta.acompanhamento = novoAcompanhamento.cancelar(consulta);;
    	return consulta;
    }
    
    //gets e sets
    public Pagamento getpagamento() {
    	return pagamento;
    }
    
    public void setpagamento(double valor, Consulta consulta, String forma) {
    	this.pagamento = new Pagamento(valor, consulta, forma);
    }
}
