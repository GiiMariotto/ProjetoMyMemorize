package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String URL =
        "jdbc:mysql://localhost:3306/meu_memorize?useSSL=false&serverTimezone=UTC";

    private static final String USUARIO = "root";
    private static final String SENHA = "M@2532#1579";

    public static Connection abrirConexao() throws SQLException {
        try {
            //carregamento do driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver do MySQL não encontrado", e);
        }

        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
