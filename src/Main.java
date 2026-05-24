import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

        try {
            // conexão com banco
            Connection conn = DriverManager.getConnection("jdbc:sqlite:produtos.db");

            Statement stmt = conn.createStatement();

            // criar tabela
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS produtos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nome TEXT
                )
            """);

            // inserir dado de teste
            stmt.execute("INSERT INTO produtos (nome) VALUES ('Teclado')");

            // 🔥 AQUI COMEÇA O LOOP (depois do SELECT)
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("nome"));
            }
            // 🔥 AQUI TERMINA O LOOP

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}