import java.util.ArrayList;
import java.util.List;

class Carrinho {
    private List<Item> itens;

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public List<Item> getItens() {
        return itens;
    }

    public void calcularPrecoTotal(){}
}
