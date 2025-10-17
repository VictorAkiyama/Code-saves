public class Sistema {
    
    //construtor
    public Sistema() {}
    
    //métodos
    public static Consulta CriarConsulta(String dentista, String paciente) {
        Consulta novaConsulta = new Consulta(dentista, paciente);
        return novaConsulta;
    }
}
