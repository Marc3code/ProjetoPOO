import java.util.ArrayList;
import java.util.List;

class Restaurante {
    private List<Pedido> pedidos;

    public Restaurante() {
        this.pedidos = new ArrayList<>();
    }

    public void fazerPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}