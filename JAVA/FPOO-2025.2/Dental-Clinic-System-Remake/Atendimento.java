package SistemaClinicaOdontologicaPackage;

public interface Atendimento {
	
	public abstract Consulta marcar(Consulta consulta, Sistema sistema, int numero_id);
	public abstract Consulta remarcar(Consulta consulta, Sistema sistema, Agenda agenda);
	public abstract Consulta cancelar(Consulta consulta, Sistema sistema, Consulta consultaLista[]);
}
