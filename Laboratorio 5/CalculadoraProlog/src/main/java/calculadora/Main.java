package calculadora;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Window ventana = new Window();
            ventana.setVisible(true);
        });
    }
}