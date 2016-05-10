package servletjsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/calculadora.php")
public class CalculadoraServlet extends 
	HttpServlet {


	@Override
	protected void service(
			HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		resp.getOutputStream().print("<html><head><title>Calculadora</title></head><body><h1>Calculadora</h1><b>2 + 2 = " + (2 + 2) + "</b></body></html>");
		
	}
	
}
