package calculadora;

import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import java.io.InputStream;

public class Connection {
    private Prolog engine;

    public Connection() {
        try {
            engine = new Prolog();
            
            // Forma profesional: Java busca el archivo dentro de sus propios recursos compilados
            InputStream is = getClass().getResourceAsStream("/calculo.pl");
            
            if (is == null) {
                System.out.println("Error: No se encontró calculo.pl en la carpeta resources.");
                return;
            }
            
            Theory theory = new Theory(is);
            engine.setTheory(theory);
            System.out.println("¡Conexión con Prolog exitosa y reglas cargadas!");
        } catch (Exception e) {
            System.out.println("Error al cargar Prolog: " + e.getMessage());
        }
    }

    public String consultar(String operador, String expresion) {
        try {
            String consulta = operador + "(x, " + expresion + ", R).";
            SolveInfo info = engine.solve(consulta);
            
            if (info.isSuccess()) {
                String resultadoCrudo = info.getVarValue("R").toString();
                return formatear(resultadoCrudo);
            } else {
                return "Error: No se pudo resolver la expresión.";
            }
        } catch (Exception e) {
            return "Error de sintaxis en Prolog.";
        }
    }

    private String formatear(String s) {
        s = s.replace("'", "").replace(" ", "");
        boolean cambiando = true;
        while (cambiando) {
            String anterior = s;
            s = s.replaceAll("([\\*\\^\\/\\+\\-])\\(([^,\\(\\)]+),([^,\\(\\)]+)\\)", "$2$1$3");
            cambiando = !anterior.equals(s);
        }
        return s;
    }
}