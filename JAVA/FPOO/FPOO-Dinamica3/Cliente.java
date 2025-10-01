public class Cliente {
    private String cpfCliente;
    private EnderecoPedido endereco;
    private String nome;
    
    //Construtor cheio
    public Cliente(String cpfCliente, EnderecoPedido endereco, String nome) {
        this.cpfCliente = cpfCliente;
        this.endereco = endereco;
        this.nome = nome;
    }
    
    //Métodos
    public void realizarPedido(Pedido pedido) {
        Pedido pedido_cliente = new Pedido();
    }
    
    //Gets e Sets
    public String getcpfCliente() {
        return this.cpfCliente;
    }
    public void setcpfCliente() {
        this.cpfCliente = cpfCliente;
    }
    
    public EnderecoPedido getendereco() {
        return this.endereco;
    }
    public void setendereco() {
        this.endereco = endereco;
    }
    
    public String getnome() {
        return this.nome;
    }
    public void setnome() {
        this.nome = nome;
    }
}
