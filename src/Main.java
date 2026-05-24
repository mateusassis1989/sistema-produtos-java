import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:produtos.db");
             Statement stmt = conn.createStatement();
             Scanner scanner = new Scanner(System.in)) {

            // cria tabela
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS produtos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT
                )
            """);

            int opcao;

            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1 - Cadastrar produto");
                System.out.println("2 - Listar produtos");
                System.out.println("3 - Editar produto");
                System.out.println("4 - Excluir produto");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    // ---------------- CADASTRAR ----------------
                    case 1:
                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();

                        stmt.execute("INSERT INTO produtos (nome) VALUES ('" + nome + "')");
                        System.out.println("Produto cadastrado!");
                        break;

                    // ---------------- LISTAR ----------------
                    case 2:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");

                        System.out.println("\n--- LISTA DE PRODUTOS ---");
                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("id") + " - " + rs.getString("nome")
                            );
                        }
                        rs.close();
                        break;

                    // ---------------- EDITAR ----------------
                    case 3:
                        System.out.print("ID do produto: ");
                        int idEdit = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();

                        stmt.execute("UPDATE produtos SET nome = '" + novoNome + "' WHERE id = " + idEdit);
                        System.out.println("Produto atualizado!");
                        break;

                    // ---------------- EXCLUIR ----------------
                    case 4:
                        System.out.print("ID do produto: ");
                        int idDel = scanner.nextInt();

                        stmt.execute("DELETE FROM produtos WHERE id = " + idDel);
                        System.out.println("Produto excluído!");
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } while (opcao != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}