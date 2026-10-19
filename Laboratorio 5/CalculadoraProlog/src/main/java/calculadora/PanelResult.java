package calculadora;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class PanelResult extends JPanel {
    // Etiquetas para mostrar el estado ("Éxito" o "Error") y el resultado matemático
    private final JLabel lblTitulo = new JLabel("Esperando expresión...");
    private final JLabel lblResultado = new JLabel("");

    public PanelResult() {
        // Configuramos el diseño, fondo y márgenes usando nuestro Theme
        setLayout(new BorderLayout(10, 10));
        setBackground(Theme.CARD); 
        setBorder(new EmptyBorder(20, 20, 20, 20)); 

        // Estilos para el título
        lblTitulo.setFont(Theme.sans(Font.BOLD, 14));
        lblTitulo.setForeground(Theme.TEXT);

        // Estilos para el resultado matemático (usamos fuente Monospace para que parezca código)
        lblResultado.setFont(Theme.mono(Font.PLAIN, 24));
        lblResultado.setForeground(Theme.PRIMARY); 

        // Agregamos los textos al panel
        add(lblTitulo, BorderLayout.NORTH);
        add(lblResultado, BorderLayout.CENTER);
    }

    // Este método lo usaremos después para cambiar el texto de las etiquetas
    public void mostrar(String resultado, String estado, Color colorEstado) {
        lblTitulo.setText(estado);
        lblTitulo.setForeground(colorEstado);
        lblResultado.setText(resultado);
    }
}