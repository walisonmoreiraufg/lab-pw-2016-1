package servletjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/calculadora.php") // ;)
public class CalculadoraServlet extends 
	HttpServlet {


	@Override
	protected void service(
			HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		ServletOutputStream out = resp.getOutputStream();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Calculadora</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Calculadora</h1>");
		out.print("<b>2 + 2 = " + (2 + 2) + "</b>");
		out.print("</body>");
		out.print("</html>");
	}
	
}
