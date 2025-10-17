public class Main
{
	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		//Consulta consulta = new Consulta("", "");
		Consulta consulta = sistema.CriarConsulta("Dr.José", "Felipe");
		System.out.println("Dentista: "+ consulta.dentista + "; Paciente: " + consulta.paciente + ".");
	}
}
