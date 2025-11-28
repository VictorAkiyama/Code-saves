package SistemaClinicaOdontologicaPackage;

public class Pagamento {

	private double valor;
	private Consulta consulta;
	private String forma;
	
	//construtor
	public Pagamento() {}
	
	public Pagamento(double valor, Consulta consulta, String forma) {
		this.valor = valor;
		this.consulta = consulta;
		this.forma = forma;
	}
	
	//métodos
	public void pagamento() {
		if (consulta != null) {
			System.out.println("Pagamento de " + valor + "da consulta" + "via" + forma);
		}
		else {
			System.out.println("Erro de pagamento.");
		}
	}
	
	@Override
	public String toString() {
		return "Pagamento de valor: " + valor + " foi pago de forma: " + forma;
	}
}
