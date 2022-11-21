import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int menu(Scanner teclado) {
        System.out.println("\nMenu: ");
        System.out.println("1: Cadastrar produto ");
        System.out.println("2: Pesquisar produto ");
        System.out.println("3: Listar produto ");
        System.out.println("4: Excluir produto ");
        System.out.println("0: Sair ");
        System.out.print("\nDigite uma opção: ");
        int op = teclado.nextInt();
        return op;
    }

    public static void cadastrarProduto(Scanner teclado, ArrayList<Produto> produtos) {
        String nome;
        int qtd;
        float valor;
        teclado.nextLine();
        System.out.print("Produto " + (produtos.size() + 1));
        System.out.print("\nDigite o nome do produto: ");
        nome = teclado.nextLine();
        System.out.print("Digite a quantidade: ");
        qtd = teclado.nextInt();
        System.out.print("Digite o valor unitário: ");
        valor = teclado.nextFloat();
        produtos.add(new Produto(nome, qtd, valor));
    }

    public static void listarProdutos(ArrayList<Produto> produtos) {
        for (Produto produto : produtos) {
            System.out.println("\nProduto: " + produto.getNome());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.printf("Valor: R$%.2f \n", produto.getValor());
        }
    }

    public static void buscarProduto(Scanner teclado, ArrayList<Produto> produtos) {
        int achou = 0;
        teclado.nextLine();
        System.out.println("Digite o nome do produto a ser procurado:");
        String nome = teclado.nextLine();
        for (Produto produto : produtos) {
            if (produto.getNome().compareTo(nome) == 0) {
                achou = 1;
                System.out.println("\nProduto: " + produto.getNome());
                System.out.println("Quantidade: " + produto.getQuantidade());
                System.out.printf("Valor: R$%.2f \n", produto.getValor());
            }
        }
        if (achou == 0) {
            System.out.println("Produto não cadastrado.");
        }
    }

    public static void excluirProduto(Scanner teclado, ArrayList<Produto> produtos) {
        int achou = 0;
        teclado.nextLine();
        System.out.print("Digite o nome do produto a ser removido:");
        String nome = teclado.nextLine();
        for (Produto produto : produtos) {
            if (produto.getNome().compareTo(nome) == 0) {
                achou = 1;
                produtos.remove(produto);
                System.out.println("Removido com sucesso!");
            }
        }
        if (achou == 0) {
            System.out.println("Produto não cadastrado.");
        }
    }

    public static void main(String[] args) {
        int op = 1;
        Scanner teclado = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        while (op != 0) {
            op = menu(teclado);
            switch (op) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    if (produtos.size() < 10) {
                        cadastrarProduto(teclado, produtos);
                    } else {
                        System.out.println("Opção inválida, já existem 10 produtos cadastrados");
                    }
                    break;
                case 2:
                    buscarProduto(teclado, produtos);
                    break;
                case 3:
                    listarProdutos(produtos);
                    break;
                case 4:
                    excluirProduto(teclado, produtos);
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente");
                    break;
            }

        }

        teclado.close();
    }

}
