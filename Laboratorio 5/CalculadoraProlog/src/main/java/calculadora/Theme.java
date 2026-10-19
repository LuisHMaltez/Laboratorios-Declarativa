package calculadora;

import java.awt.Color;
import java.awt.Font;

public class Theme {
    // Colores base de la interfaz
    public static final Color BG = new Color(0x1E1F29);      // Fondo general
    public static final Color CARD = new Color(0x282A36);    // Fondo de los paneles
    public static final Color TEXT = new Color(0xF8F8F2);    // Texto claro
    public static final Color PRIMARY = new Color(0xBD93F9); // Color de los botones (morado)

    // Métodos para facilitar la asignación de fuentes
    public static Font sans(int style, int size) {
        return new Font("SansSerif", style, size);
    }
    
    public static Font mono(int style, int size) {
        return new Font("Monospaced", style, size);
    }
}