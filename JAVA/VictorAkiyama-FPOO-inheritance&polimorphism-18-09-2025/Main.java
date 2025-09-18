class Cliente {
  
  private String nome;
  private String endereco;
  private String telefone;
  
  //constructor
  public void Cliente(String n, String e, String t) {
    this.n = n;
    this.e = e;
    this.t = t;
  }
  
  //gets e sets
  public getNome() {
    return nome;
  }
  public getEndereco() {
    return endereco;
  }
  public void setEndereco(String e) {
  	this.endereco = e;
  }
  public getTelefone() {
  	return telefone;
  }
  public void setTelefone(String t) {
    this.telefone = t;
  }
}


// subclass of class "Cliente"
class PessoFisica extends Cliente{

  private String cpf;
  
  //constructor
  public void PessoaFisica(String n, String e, String t, String c) {
    super.Cliente(); //inherits the attributes from parent
    this.cpf = c;
  }
}
