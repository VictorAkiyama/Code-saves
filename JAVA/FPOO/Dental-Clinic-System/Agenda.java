package SistemaClinicaOdontologicaPackage;

public class Agenda {

	public boolean hora8 = false;
	public boolean hora9 = false;
	public boolean hora10 = false;
	public boolean hora11 = false;
	public boolean hora12 = false;
	public boolean hora13 = false;
	public boolean hora14 = false;
	public boolean hora15 = false;
	public boolean hora16 = false;
	public boolean hora17 = false;
	public boolean hora18 = false;
	
	//construtor
	public Agenda() {}
	
	public Agenda(boolean hora8, boolean hora9, boolean hora10, boolean hora11, boolean hora12, boolean hora13, boolean hora14, boolean hora15, boolean hora16, boolean hora17, boolean hora18) {
		this.hora8 = hora8;
		this.hora9 = hora9;
		this.hora10 = hora10;
		this.hora11 = hora11;
		this.hora12 = hora12;
		this.hora13 = hora13;
		this.hora14 = hora14;
		this.hora15 = hora15;
		this.hora16 = hora16;
		this.hora17 = hora17;
		this.hora18 = hora18;
	}
	
	//métodos
	public void colocaHorarioConsultaAgenda(Consulta consultaInteracao) {
		switch(consultaInteracao.horario) {
			case 8:
				this.hora8 = true;
				break;
			case 9:
				this.hora9 = true;
				break;
			case 10:
				this.hora10 = true;
				break;
			case 11:
				this.hora11 = true;
				break;
			case 12:
				this.hora12 = true;
				break;
			case 13:
				this.hora13 = true;
				break;
			case 14:
				this.hora14 = true;
				break;
			case 15:
				this.hora15 = true;
				break;
			case 16:
				this.hora16 = true;
				break;
			case 17:
				this.hora17 = true;
				break;
			case 18:
				this.hora18 = true;
				break;
			default:
				System.out.println("\nO horário de consulta não é equivalente aos disponíveis na agenda.");
		}
	}
	
	public void removerHorarioConsultaAgenda(Consulta consultaInteracao) {
		switch(consultaInteracao.horario) {
			case 8:
				this.hora8 = false;
				break;
			case 9:
				this.hora9 = false;
				break;
			case 10:
				this.hora10 = false;
				break;
			case 11:
				this.hora11 = false;
				break;
			case 12:
				this.hora12 = false;
				break;
			case 13:
				this.hora13 = false;
				break;
			case 14:
				this.hora14 = false;
				break;
			case 15:
				this.hora15 = false;
				break;
			case 16:
				this.hora16 = false;
				break;
			case 17:
				this.hora17 = false;
				break;
			case 18:
				this.hora18 = false;
				break;
			default:
				System.out.println("\nO horário de consulta não é equivalente aos ocupados na agenda.");
		}
	}
	
	public void colocaHorarioAcompanhamentoAgenda(Consulta consultaInteracao) {
		switch(consultaInteracao.acompanhamento.horario) {
			case 8:
				this.hora8 = true;
				break;
			case 9:
				this.hora9 = true;
				break;
			case 10:
				this.hora10 = true;
				break;
			case 11:
				this.hora11 = true;
				break;
			case 12:
				this.hora12 = true;
				break;
			case 13:
				this.hora13 = true;
				break;
			case 14:
				this.hora14 = true;
				break;
			case 15:
				this.hora15 = true;
				break;
			case 16:
				this.hora16 = true;
				break;
			case 17:
				this.hora17 = true;
				break;
			case 18:
				this.hora18 = true;
				break;
			default:
				System.out.println("\nO horário do acompanhamento não é equivalente aos disponíveis na agenda.");
		}
	}
	
	public void removerHorarioAcompanhamentoAgenda(Consulta consultaInteracaoAnterior) {
		switch(consultaInteracaoAnterior.acompanhamento.horario) {
			case 8:
				this.hora8 = false;
				break;
			case 9:
				this.hora9 = false;
				break;
			case 10:
				this.hora10 = false;
				break;
			case 11:
				this.hora11 = false;
				break;
			case 12:
				this.hora12 = false;
				break;
			case 13:
				this.hora13 = false;
				break;
			case 14:
				this.hora14 = false;
				break;
			case 15:
				this.hora15 = false;
				break;
			case 16:
				this.hora16 = false;
				break;
			case 17:
				this.hora17 = false;
				break;
			case 18:
				this.hora18 = false;
				break;
			default:
				System.out.println("\nO horário do acompanhamento não é equivalente aos ocupados na agenda.");
		}
	}
	
	public void mostrarAgenda() {
		System.out.println("\nAgenda:");
		if(this.hora8 == false) {
			System.out.println("8 horas: Disponível");
		} else {
			System.out.println("8 horas: Ocupado");
		}
		if(this.hora9 == false) {
			System.out.println("9 horas: Disponível");
		} else {
			System.out.println("9 horas: Ocupado");
		}
		if(this.hora10 == false) {
			System.out.println("10 horas: Disponível");
		} else {
			System.out.println("10 horas: Ocupado");
		}
		if(this.hora11 == false) {
			System.out.println("11 horas: Disponível");
		} else {
			System.out.println("11 horas: Ocupado");
		}
		if(this.hora12 == false) {
			System.out.println("12 horas: Disponível");
		} else {
			System.out.println("12 horas: Ocupado");
		}
		if(this.hora13 == false) {
			System.out.println("13 horas: Disponível");
		} else {
			System.out.println("13 horas: Ocupado");
		}
		if(this.hora14 == false) {
			System.out.println("14 horas: Disponível");
		} else {
			System.out.println("14 horas: Ocupado");
		}
		if(this.hora15 == false) {
			System.out.println("15 horas: Disponível");
		} else {
			System.out.println("15 horas: Ocupado");
		}
		if(this.hora16 == false) {
			System.out.println("16 horas: Disponível");
		} else {
			System.out.println("16 horas: Ocupado");
		}
		if(this.hora17 == false) {
			System.out.println("17 horas: Disponível");
		} else {
			System.out.println("17 horas: Ocupado");
		}
		if(this.hora18 == false) {
			System.out.println("18 horas: Disponível");
		} else {
			System.out.println("18 horas: Ocupado");
		}
	}
	
	public void LimpaAgenda() {
		this.hora8 = false;
		this.hora9 = false;
		this.hora10 = false;
		this.hora11 = false;
		this.hora12 = false;
		this.hora13 = false;
		this.hora14 = false;
		this.hora15 = false;
		this.hora16 = false;
		this.hora17 = false;
		this.hora18 = false;
		System.out.println("\nA agenda foi limpa.");
	}
}
