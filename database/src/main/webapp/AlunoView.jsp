<!DOCTYPE html>
<%@page import="database.Aluno"%>
<%@page import="java.util.List"%>
<html>

<head>
<title>Aluno</title>
</head>

<body>
  <h1>
    <a href="aluno">Aluno</a>
  </h1>
  <a href="logout">Logout</a>
  <br>
  <br>
  <form>
    <table>
      <tr>
        <td>Matrícula</td>
        <td><input name="matricula"></td>
      </tr>
      <tr>
        <td>Nome:</td>
        <td><input name="nome"></td>
      </tr>
    </table>
    <button name="operacao" value="incluir">Incluir</button>
    <button name="operacao" value="excluir">Excluir</button>
    <button name="operacao" value="alterar">Alterar</button>
  </form>
  <b>${msg}</b>
  <hr>
  Usuário: ${usuario}
  <hr>
  <table>
    <tr>
      <th>Matrícula</th>
      <th>Nome</th>
      <th>Ações</th>
    </tr>
    <%
      //Obtém a lista de alunos criada pelo controlador.
  	List<Aluno> alunos =
      (List<Aluno>) request.getAttribute("alunos");

    if (alunos != null && !alunos.isEmpty()) {
      for (Aluno a : alunos) {
    %>
    <tr>
      <td><%=a.getMatricula()%></td>
      <td><%=a.getNome()%></td>
      <td><a href="aluno?operacao=excluir&matricula=<%=a.getMatricula()%>">Excluir</a></td>
    </tr>
    <%
      }
    }
    %>
  </table>
</body>

</html>