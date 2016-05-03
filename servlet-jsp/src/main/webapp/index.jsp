<html>
<body>
<h2>Hello World!</h2>
<!-- Scriptlet -->
<%
//out.print("Aqui e Java! <br><br><br><br><br>");
int i = 2;
//out.print("I ao quadrado e: " + (i * i));

out.println("<script>");
out.println("alert(\"Aqui é Java ou Java Script?\");");
out.println("alert(\"I ao quadrado e: " + (i * i) + "\");");
out.println("</script>");
%>
</body>
</html>
