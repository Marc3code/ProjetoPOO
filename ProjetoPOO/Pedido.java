class Pedido {
    public enum TipoPedido { ENTREGA, RETIRADA, CONSUMO_LOCAL }

    private TipoPedido tipo;
    private int numeroPedido;
    private Carrinho carrinho;

    public Pedido(TipoPedido tipo, int numeroPedido) {
        this.tipo = tipo;
        this.numeroPedido = numeroPedido;
        this.carrinho = new Carrinho();
    }

    public void adicionarItem(Item item) {
        this.carrinho.adicionarItem(item);
    }

    public TipoPedido getTipo() {
        return tipo;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }
}