<!DOCTYPE html>
<%@page import="servletjsp.Calculadora"%>
<html>

  <head>
    <title>Calculadora</title>
  </head>

  <body>
  	<h1>Calculadora</h1>
  	<form>
		Operador 1: <input name="operador1">
		<br>
		Operação: <input name="operacao">
		<br>
		Operador 2: <input name="operador2">
		<br>
		<button>Calcular</button>
<%!
public String valor(
		HttpServletRequest req,
		String param,
		String padrao) {

	String result = req.getParameter(param);
	if (result == null) {
		result = padrao;
	}
	return result;
}
public int toInt(
		HttpServletRequest req,
		String param,
		String padrao) {
	return Integer.parseInt(valor(req, param, padrao));
}
%>

<%
int oper1 = toInt(request, "operador1", "0");
String op = valor(request, "operacao", "");
int oper2 = toInt(request, "operador2", "0");

int resultado = Calculadora.calcular(oper1, op, oper2);
%>
  	</form>
<b>Resultado: <%out.print(resultado);%></b>
  </body>

</html>