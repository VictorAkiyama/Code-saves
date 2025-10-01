private class EnderecoPedido {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    
    //Construtor cheio
    public EnderecoPedido(String rua, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    //Métodos
    public void entrega(EnderecoPedido endereco) {
        this.endereco = endereco;
    }
    
    //Gets e Sets
    public String getrua() {
        return this.rua;
    }
    public void setrua() {
        this.rua = rua;
    }
    
    public String getbairro() {
        return this.bairro;
    }
    public void setbairro() {
        this.bairro = bairro;
    }
    
    public String getcidade() {
        return this.cidade;
    }
    public void setcidade() {
        this.cidade = cidade;
    }
    
    public String getestado() {
        return this.estado;
    }
    public void setestado() {
        this.estado = estado;
    }
    
    public String getcep() {
        return this.cep;
    }
    public void setcep() {
        this.cep = cep;
    }
}
