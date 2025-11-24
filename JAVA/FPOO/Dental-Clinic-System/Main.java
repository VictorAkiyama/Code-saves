package SistemaClinicaOdontologicaPackage;

public class Main {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Consulta consulta = new Consulta();
		Consulta consultaInteracao = new Consulta();
		Consulta consultaLista[] = new Consulta[10];
		Agenda agenda = new Agenda();
		
		//simulação de o usuário digitando para marcar consulta, opção válida
		consultaInteracao = sistema.interacaoConsulta(1, consulta, sistema, consultaLista, consultaInteracao, agenda);
		//horario de consulta colocado como ocupado na agenda
		sistema.colocaHorarioConsultaAgenda(consultaInteracao, agenda);
		//nova consulta feita pelo usuario colocado em uma lista
		consultaInteracao = sistema.colocarNovaConsultaEmLista(consultaInteracao, consultaLista);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.mostrarAgenda(agenda);
		
		/*	OUTRAS SIMULAÇÕES	*/
		//simulação de remarcar consulta
		consultaInteracao = sistema.interacaoConsulta(2, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.colocaHorarioConsultaAgenda(consultaInteracao, agenda);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.mostrarAgenda(agenda);
		
		//simulação de marcar acompanhamento
		consultaInteracao = sistema.interacaoConsulta(4, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.colocaHorarioAcompanhamentoAgenda(consultaInteracao, agenda);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.mostrarAgenda(agenda);
		
		//simulação de remarcar acompanhamento
		consultaInteracao = sistema.interacaoConsulta(5, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.removerHorarioAcompanhamentoAgenda(consultaInteracao, agenda);
		sistema.colocaHorarioAcompanhamentoAgenda(consultaInteracao, agenda);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.mostrarAgenda(agenda);
		
		//simulação de cancelar acompanhamento
		consultaInteracao = sistema.interacaoConsulta(6, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.removerHorarioAcompanhamentoAgenda(consultaInteracao, agenda);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.mostrarAgenda(agenda);
		
		//simulação de cancelamento da consulta
		consultaInteracao = sistema.interacaoConsulta(3, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.removerHorarioConsultaAgenda(consultaInteracao, agenda);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.mostrarAgenda(agenda);
		
		//limpando agenda
		sistema.LimpaAgenda(agenda);
		sistema.mostrarAgenda(agenda);
	}
}
