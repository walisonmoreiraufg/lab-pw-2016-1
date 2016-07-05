<!DOCTYPE html>
<html>

<head>
<title>Transferência</title>
</head>

<body>
  <h1>
    <a href="aluno">Transferência</a>
  </h1>
  <a href="logout">Logout</a>
  <br>
  <br>
  <form>
    <table>
      <tr>
        <td>Origem</td>
        <td><input name="origem"></td>
      </tr>
      <tr>
        <td>Destino:</td>
        <td><input name="destino"></td>
      </tr>
      <tr>
        <td>Valor:</td>
        <td><input name="valor"></td>
      </tr>
    </table>
    <button name="operacao" value="transferir">Transferir</button>
  </form>
  <b>${msg}</b>
</body>

</html>