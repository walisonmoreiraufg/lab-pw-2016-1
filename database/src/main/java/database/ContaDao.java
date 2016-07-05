package database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DAO = Data Access Object.
 */
public class ContaDao {

  private static final String URL = "jdbc:derby:db;create=true";

  public static void transferir(int numContaOrigem, int numContaDestino, double valor) throws SQLException, IOException {
    // Abrir uma conexão com o banco de dados.
    Connection conn = DriverManager.getConnection(URL);
    //É o mesmo que "vou trabalhar com transação".
    conn.setAutoCommit(false);
    try {
      //Subtrair o valor do saldo da conta origem.
      debitar(conn, numContaOrigem, valor);
      //Registrar o débito num arquivo (conta, valor e data).
      registrarDebito(numContaOrigem, valor);
      //Adicionar o valor no saldo da conta destivo.
      creditar(conn, numContaDestino, valor);
      
      //Se der tudo certo.
      conn.commit();
    } catch(Throwable e) {
      conn.rollback();
      throw e;
    } finally {
      // Fechar conexão.
      conn.close();
    }
  }

  private static void debitar(Connection conn, int numContaOrigem, double valor) throws SQLException {
    // Executar instrução SQL.
    String sql = "update conta set saldo = saldo - ? where numero = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setDouble(1, valor);
    pstmt.setInt(2, numContaOrigem);
    pstmt.executeUpdate();
    // Fechar sentença.
    pstmt.close();
  }

  private static void registrarDebito(int numContaOrigem, double valor) throws IOException {
    Files.write(
        Paths.get("debitos.txt"),
        (numContaOrigem + ", " + valor + ", " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "\n").getBytes(),
        StandardOpenOption.APPEND);
  }

  private static void creditar(Connection conn, int numContaDestino, double valor) throws SQLException {
    // Executar instrução SQL.
    String sql = "update conta set saldo = saldo + ? where numero = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setDouble(1, valor);
    pstmt.setInt(2, numContaDestino);
    pstmt.executeUpdate();
    // Fechar sentença.
    pstmt.close();
  }
}
