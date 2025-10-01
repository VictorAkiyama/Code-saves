private class Pedido {
    private int idPedido;
    private int idProduto;
    private String cpfCliente;
    private boolean temBebida;
    
    //Construtor cheio
    public Pedido(int idPedido, int idProduto, String cpfCliente, boolean temBebida) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.cpfCliente = cpfCliente;
        this.temBebida = temBebida;
    }
    
    //Gets e Sets
    public int getidPedido() {
        return this.idPedido;
    }
    public void setidPedido() {
        this.idPedido = idPedido;
    }
    
    public int getidProduto() {
        return this.idProduto;
    }
    public void setidProduto() {
        this.idProduto = idProduto;
    }
    
    public int getcpfCliente() {
        return this.cpfCliente;
    }
    public void setcpfCliente() {
        this.cpfCliente = cpfCliente;
    }
    
    public int gettemBebida() {
        return this.temBebida;
    }
    public void settemBebida() {
        this.temBebida = temBebida;
    }
}
