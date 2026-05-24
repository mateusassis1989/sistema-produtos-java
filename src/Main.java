import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:produtos.db");
             Statement stmt = conn.createStatement();
             Scanner scanner = new Scanner(System.in)) {

            ProdutoService service = new ProdutoService(conn, stmt);
            service.criarTabela();

            int opcao;

            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1 - Cadastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Editar");
                System.out.println("4 - Excluir");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> service.cadastrar(scanner);
                    case 2 -> service.listar();
                    case 3 -> service.editar(scanner);
                    case 4 -> service.excluir(scanner);
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }

            } while (opcao != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}