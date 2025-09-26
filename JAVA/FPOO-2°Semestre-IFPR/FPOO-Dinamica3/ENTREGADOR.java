public class ENTREGADOR {
	
	//atributos do entregador
	private String cpf;
	private String nome;
	
	//atributos para fazer entregas
	private String rua;
	private String bairro;
	private String cidade;
	private String cep;
	
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
	
	public String setcep() {
		return this.cep = cep;
	}
}
