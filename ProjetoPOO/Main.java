import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante();

        while (true) {
            System.out.println("Bem-vindo ao Restaurante!");
            System.out.println("Selecione o tipo de pedido:");
            System.out.println("1. Entrega");
            System.out.println("2. Retirada");
            System.out.println("3. Consumo no Local");
            System.out.println("4. Visualizar todos os pedidos");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            if (opcao == 5) {
                break;
            }

            Pedido.TipoPedido tipoPedido;
            if (opcao == 1) {
                tipoPedido = Pedido.TipoPedido.ENTREGA;
            } else if (opcao == 2) {
                tipoPedido = Pedido.TipoPedido.RETIRADA;
            } else if (opcao == 3) {
                tipoPedido = Pedido.TipoPedido.CONSUMO_LOCAL;
            } else if (opcao == 4) {
                // Visualizar todos os pedidos
                for (Pedido pedido : restaurante.getPedidos()) {
                    System.out.println("Tipo: " + pedido.getTipo() +
                                       ", Número: " + pedido.getNumeroPedido());
                    System.out.println("Itens:");
                    for (Item item : pedido.getCarrinho().getItens()) {
                        System.out.println("- " + item.getNome() +
                                           ", Preço: R$" + item.getPreco() +
                                           ", Quantidade: " + item.getQuantidade());
                    }
                    System.out.println();
                }
                continue;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            Pedido pedido = new Pedido(tipoPedido, restaurante.getPedidos().size() + 1);
            while (true) {
                System.out.println("Digite o nome do item (ou 'fim' para finalizar o pedido):");
                String nomeItem = scanner.nextLine();

                if (nomeItem.equalsIgnoreCase("fim")) {
                    break;
                }

                System.out.println("Digite o preço do item:");
                double precoItem = scanner.nextDouble();
                scanner.nextLine();  // Consumir a quebra de linha

                System.out.println("Digite a quantidade do item:");
                int quantidadeItem = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                Item item = new Item(nomeItem, precoItem, quantidadeItem);
                pedido.adicionarItem(item);
            }

            restaurante.fazerPedido(pedido);
            System.out.println("Pedido realizado com sucesso!");
        }

        System.out.println("Obrigado por utilizar nosso sistema. Até mais!");
        scanner.close();
    }
}

