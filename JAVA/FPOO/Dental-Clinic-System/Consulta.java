package SistemaClinicaOdontologicaPackage;

public class Consulta {

	public String dentista;
    public String paciente;
    public int horario;
    
    //construtor vazio
    public Consulta() {}
    
    //construtor 
    public Consulta(String dentista, String paciente, int horario){
        this.dentista = dentista;
        this.paciente = paciente;
        this.horario = horario;
    }
    
    //métodos
    public Consulta marcar(Consulta consulta, Sistema sistema) {
    	System.out.println("Digite o nome do Doutor, paciente e horário:  ");
    	//simulação do usuário digitando os dados
    	Consulta consultaSimulacao = sistema.CriarConsulta("Luis", "Ricardo", 15);
    	if (consultaSimulacao.paciente != null && consultaSimulacao.dentista != null) {
    		System.out.println("\nConsulta marcada com Dr." + consultaSimulacao.dentista + " para " + consultaSimulacao.paciente + " para as " + consultaSimulacao.horario + "\n");
    	}
    	else {
    		System.out.println("Erro de agendamento");
    	}
    	return consultaSimulacao;
    }
    public Consulta cancelar(Consulta consulta, Sistema sistema) {
    	//FAZER
    	//interagir com a lista e remover a selecionada por usuário
    	System.out.println("Qual das consultas deseja cancelar: ");
    	return new Consulta();
    }
}
