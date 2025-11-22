package SistemaClinicaOdontologicaPackage;

public class Main {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Consulta consulta = new Consulta();
		Consulta consultaLista[] = new Consulta[10];
		
		//simulação de o usuário digitando para marcar consulta, opção válida
		Consulta consultaInteracao = sistema.interacaoConsulta(1, consulta, sistema, consultaLista);
		
		//nova consulta feita pelo usuario colocado em uma lista
		consultaInteracao = sistema.colocarNovaConsultaEmLista(consultaInteracao, consultaLista);
		
		//mostra lista de consultas
		sistema.mostrarListadeConsultas(consultaLista);
		
		/*	TESTES	*/
		
		//simulação de cancelamento da consulta
		//consultaInteracao = sistema.interacaoConsulta(3, consulta, sistema, consultaLista);
		
		//mostra lista de consultas
		//sistema.mostrarListadeConsultas(consultaLista);
		
		//simulação de criar acompanhamento
		consultaInteracao = sistema.interacaoConsulta(4, consulta, sistema, consultaLista);
		
	}
}
