import java.util.ArrayList;

public class ProdutoService {

    ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(Produto produto) {

        produtos.add(produto);

        System.out.println("Produto cadastrado!");
    }

    public void listarProdutos() {

        if (produtos.isEmpty()) {

            System.out.println("Nenhum produto cadastrado.");

        } else {

            for (Produto produto : produtos) {

                System.out.println(produto);
            }
        }
    }

    public void editarProduto(int id, String novoNome, double novoPreco) {

        for (Produto produto : produtos) {

            if (produto.getId() == id) {

                produto.setNome(novoNome);
                produto.setPreco(novoPreco);

                System.out.println("Produto atualizado!");

                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    public void excluirProduto(int id) {

        for (Produto produto : produtos) {

            if (produto.getId() == id) {

                produtos.remove(produto);

                System.out.println("Produto removido!");

                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}