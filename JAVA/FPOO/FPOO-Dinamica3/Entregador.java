public class Entregador {
	
	//atributos do entregador
	private String idTrabalhador;
	private String nome;
	
	//atributos para fazer entregas
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;

	//Construtor cheio
	public Entregador(String idTrabalhador, String nome, String rua, String bairro, String cidade, String estado, String cep) {
		this.idTrabalhador = idTrabalhador;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	//Gets
	public String getrua() {
		return this.rua;
	}
	public String getbairro() {
		return this.bairro;
	}
	public String getcidade() {
		return this.cidade;
	}
	public String getestado() {
		return this.estado;
	}
	public String getcep() {
		return this.cep;
	}
	
	//Sets
	public String setrua() {
		return this.rua = rua;
	}
	public String setbairro() {
		return this.bairro = bairro;
	}
	public String setcidade() {
		return this.cidade = cidade;
	}
	public String setestado() {
		return this.estado = estado;
	}
	public String setcep() {
		return this.cep = cep;
	}
}
