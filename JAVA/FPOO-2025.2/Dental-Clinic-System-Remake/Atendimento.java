package SistemaClinicaOdontologicaPackage;

public interface Atendimento {
	
	public abstract Consulta marcar(Consulta consulta, Sistema sistema, int numero_id, Agenda agenda);
	public abstract Consulta remarcar(Consulta consulta, Sistema sistema, Agenda agenda, int id_consulta_selecionada);
	public abstract void cancelar(Consulta consulta, Sistema sistema, Consulta consultaLista[], int id_consulta_selecionada);
}
