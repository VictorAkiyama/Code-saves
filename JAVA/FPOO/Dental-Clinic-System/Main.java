package SistemaClinicaOdontologicaPackage;

public class Main {

	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		Consulta consulta = new Consulta();
		Consulta consultaInteracao = new Consulta();
		Acompanhamento acompanhamentoConsultaInteracaoAnteriorPasso1 = new Acompanhamento();
		Consulta consultaAcompanhamento = new Consulta();
		int horarioAcompanhamento;
		Consulta consultaInteracaoAnterior = new Consulta();
		Consulta consultaLista[] = new Consulta[10];
		Agenda agenda = new Agenda();
		
		//simulação de o usuário digitando para marcar consulta, opção válida
		consultaInteracao = sistema.interacaoConsulta(1, consulta, sistema, consultaLista, consultaInteracao, agenda);
		//horario de consulta colocado como ocupado na agenda
		sistema.chamaColocaHorarioConsultaAgenda(consultaInteracao, agenda);
		//nova consulta feita pelo usuario colocado em uma lista
		consultaInteracao = sistema.colocarNovaConsultaEmLista(consultaInteracao, consultaLista);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.chamaMostrarAgenda(agenda);
		
		/*	OUTRAS SIMULAÇÕES	*/
		//simulação de remarcar consulta
		consultaInteracao = sistema.interacaoConsulta(2, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.chamaColocaHorarioConsultaAgenda(consultaInteracao, agenda);
		//consulta remarcada colocado na lista
		consultaInteracao = sistema.colocarConsultaRemarcadaEmLista(consultaInteracao, consultaLista);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.chamaMostrarAgenda(agenda);
		
		//simulação de marcar acompanhamento
		consultaInteracao = sistema.interacaoConsulta(4, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.chamaColocaHorarioAcompanhamentoAgenda(consultaInteracao, agenda);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.chamaMostrarAgenda(agenda);
		
		//simulação de remarcar acompanhamento
			//parte para pegar acompanhamento de uma consulta para outra, assim o remover horario do acompanhamento na agenda possa ter a consultaInteracao
		acompanhamentoConsultaInteracaoAnteriorPasso1 = consultaInteracao.getacompanhamento();
		consultaAcompanhamento = acompanhamentoConsultaInteracaoAnteriorPasso1.getconsulta();
		horarioAcompanhamento = acompanhamentoConsultaInteracaoAnteriorPasso1.gethorario();
		consultaInteracaoAnterior.setacompanhamento(consultaAcompanhamento, horarioAcompanhamento);
		
		consultaInteracao = sistema.interacaoConsulta(5, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.chamaRemoverHorarioAcompanhamentoAgenda(consultaInteracaoAnterior, agenda);
		sistema.chamaColocaHorarioAcompanhamentoAgenda(consultaInteracao, agenda);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.chamaMostrarAgenda(agenda);
		
		//simulação de cancelar acompanhamento
			//parte para pegar acompanhamento de uma consulta para outra, assim o remover horario do acompanhamento na agenda possa ter a consultaInteracao
		acompanhamentoConsultaInteracaoAnteriorPasso1 = consultaInteracao.getacompanhamento();
		consultaAcompanhamento = acompanhamentoConsultaInteracaoAnteriorPasso1.getconsulta();
		horarioAcompanhamento = acompanhamentoConsultaInteracaoAnteriorPasso1.gethorario();
		consultaInteracaoAnterior.setacompanhamento(consultaAcompanhamento, horarioAcompanhamento);
		
		consultaInteracao = sistema.interacaoConsulta(6, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.chamaRemoverHorarioAcompanhamentoAgenda(consultaInteracaoAnterior, agenda);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.chamaMostrarAgenda(agenda);
		
		//simulação de cancelamento da consulta
		consultaInteracao = sistema.interacaoConsulta(3, consulta, sistema, consultaLista, consultaInteracao, agenda);
		sistema.chamaRemoverHorarioConsultaAgenda(consultaInteracao, agenda);
		sistema.mostrarListadeConsultas(consultaLista);
		sistema.chamaMostrarAgenda(agenda);
		
		//limpando agenda
		sistema.chamaLimpaAgenda(agenda);
		sistema.chamaMostrarAgenda(agenda);
	}
}
