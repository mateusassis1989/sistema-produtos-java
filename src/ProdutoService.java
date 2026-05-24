import java.sql.*;
import java.util.Scanner;

public class ProdutoService {

    private Connection conn;
    private Statement stmt;

    public ProdutoService(Connection conn, Statement stmt) {
        this.conn = conn;
        this.stmt = stmt;
    }

    public void criarTabela() throws SQLException {
        stmt.execute("""
            CREATE TABLE IF NOT EXISTS produtos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT
            )
        """);
    }

    public void cadastrar(Scanner scanner) throws SQLException {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        stmt.execute("INSERT INTO produtos (nome) VALUES ('" + nome + "')");
        System.out.println("Produto cadastrado!");
    }

    public void listar() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");

        System.out.println("\n--- LISTA DE PRODUTOS ---");

        while (rs.next()) {
            Produto p = new Produto(
                    rs.getInt("id"),
                    rs.getString("nome")
            );
            System.out.println(p);
        }

        rs.close();
    }

    public void editar(Scanner scanner) throws SQLException {
        System.out.print("ID do produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        stmt.execute("UPDATE produtos SET nome = '" + nome + "' WHERE id = " + id);
        System.out.println("Produto atualizado!");
    }

    public void excluir(Scanner scanner) throws SQLException {
        System.out.print("ID do produto: ");
        int id = scanner.nextInt();

        stmt.execute("DELETE FROM produtos WHERE id = " + id);
        System.out.println("Produto excluído!");
    }
}