import java.util.ArrayList;

public class ProdutoService {

    private ArrayList<Produto> produtos = new ArrayList<>();

    // Cadastrar
    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    // Listar
    public void listarProdutos() {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    // Editar
    public void editarProduto(int id, String novoNome, double novoPreco) {

        for (Produto p : produtos) {

            if (p.getId() == id) {
                p.setNome(novoNome);
                p.setPreco(novoPreco);

                System.out.println("Produto atualizado!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    // Excluir
    public void excluirProduto(int id) {

        for (Produto p : produtos) {

            if (p.getId() == id) {
                produtos.remove(p);

                System.out.println("Produto removido!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }
}