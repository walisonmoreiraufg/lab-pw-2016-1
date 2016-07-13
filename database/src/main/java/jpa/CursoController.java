package jpa;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/curso")
public class CursoController extends HttpServlet {

	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String msg;
			String op = valor(req, "operacao", "");
      String codigo = valor(req, "codigo", "0");
			String nome = valor(req, "nome", "");
			if (op.equals("incluir")) {
				CursoDao.inclui(codigo, nome);
				msg = "Inclusão realizada com sucesso.";
			} else if (op.equals("alterar")) {
				CursoDao.alterar(codigo, nome);
				msg = "Alteração realizada com sucesso.";
			} else if (op.equals("excluir")) {
				CursoDao.excluir(codigo);
				resp.sendRedirect("curso");
				msg = "Exclusão realizada com sucesso.";
			} else if (op.equals("")) {
				msg = "";
			} else {
				throw new IllegalArgumentException("Operação \"" + op + "\" não suportada.");
			}
			
			req.setAttribute("msg", msg);

			List<Curso> cursos = CursoDao.listar();
			req.setAttribute("cursos", cursos);
			
			req.getRequestDispatcher("CursoView.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}
