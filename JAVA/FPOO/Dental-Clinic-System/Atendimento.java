package SistemaClinicaOdontologicaPackage;

public interface Atendimento {
	
	public abstract Consulta marcar(Consulta consulta, Sistema sistema);
	public abstract void remarcar();
	public abstract Consulta cancelar(Consulta consulta, Sistema sistema, Consulta consultaLista[]);
}
