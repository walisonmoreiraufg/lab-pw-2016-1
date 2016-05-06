package servletjsp;

public class Calculadora {
	public static int calcular(
			int oper1,
			String op,
			int oper2) {
		int resultado = 0;
		if (op.equals("+")) {
			resultado = oper1 + oper2;
		} else if (op.equals("-")) {
			resultado = oper1 - oper2;
		} else if (op.equals("*")) {
			resultado = oper1 * oper2;
		}
		return resultado;
	}
}
