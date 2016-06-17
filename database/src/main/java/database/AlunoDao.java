package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO = Data Access Object.
 */
public class AlunoDao {

	private static final String URL = "jdbc:derby:db;create=true";

	public static void inclui(int matricula, String nome) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "insert into aluno (matricula, nome) values (?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, matricula);
		pstmt.setString(2, nome);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static void alterar(int matricula, String nome) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "update aluno set nome = ? where matricula = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nome);
		pstmt.setInt(2, matricula);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static void excluir(int matricula) throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "delete from aluno where matricula = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, matricula);
		pstmt.executeUpdate();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
	}

	public static List<Aluno> listar() throws SQLException {
		// Abrir uma conexão com o banco de dados.
		Connection conn = DriverManager.getConnection(URL);
		// Executar instrução SQL.
		String sql = "select matricula, nome from aluno";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// Represneta o resultado da execução.
		ResultSet rs = pstmt.executeQuery();
		
		List<Aluno> alunos = new ArrayList<>();
		while (rs.next()) {
			int matricula = rs.getInt("matricula");
			String nome = rs.getString("nome");
			Aluno aluno = new Aluno(matricula, nome);
			alunos.add(aluno);
		}
	
		// Fechar resultado.
		rs.close();
		// Fechar sentença.
		pstmt.close();
		// Fechar conexão.
		conn.close();
		
		return alunos;
	}
}
