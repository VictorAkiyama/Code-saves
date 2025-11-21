package SistemaClinicaOdontologicaPackage;

public class Main {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Consulta consulta = new Consulta();
		Consulta consultaLista[] = new Consulta[10];
		
		//simulação de o usuário digitando para marcar consulta, opção válida
		Consulta consultaInteracao = sistema.interacaoConsulta(1, consulta, sistema);
		
		//nova consulta feita pelo usuario colocado em uma lista
		sistema.colocarNovaConsultaEmLista(consultaInteracao, consultaLista);
		
		//temp para ver se foi marcado na lista
		System.out.println(consultaLista[0].dentista + " " + consultaLista[0].paciente + " " + consultaLista[0].horario);
	}
}
