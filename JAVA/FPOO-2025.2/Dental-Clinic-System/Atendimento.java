package SistemaClinicaOdontologicaPackage;

public interface Atendimento {
	
	public abstract Consulta marcar(Consulta consulta, Sistema sistema);
	public abstract Consulta remarcar(Consulta consulta, Sistema sistema, Consulta consultaInteracao, Agenda agenda);
	public abstract Consulta cancelar(Consulta consulta, Sistema sistema, Consulta consultaLista[]);
}
