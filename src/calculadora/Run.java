package calculadora;

import java.io.StringReader;
import javax.swing.JOptionPane;

public class Run
{
	public void executar() throws Exception
	{
		String expr     = JOptionPane.showInputDialog("Entrada: ");
		Yylex scanner   = new Yylex(new StringReader(expr));
        	JMParser parser = new JMParser(scanner);
        	parser.parse();

        	Calculadora c = parser.getCalculadora();
        	JOptionPane.showMessageDialog(null, "Resultado: " + c.imprime());
	}

	public static void main(String[] args)
	{
		Run app = new Run();
		
		try{
			app.executar();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
