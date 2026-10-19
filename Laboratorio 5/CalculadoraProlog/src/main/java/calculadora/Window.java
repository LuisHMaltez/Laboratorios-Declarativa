package calculadora;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private Connection prologConnection;
    private JTextField txtExpresion;
    private PanelResult panelResultado;

    public Window() {
        // 1. Iniciamos la conexión con Prolog
        prologConnection = new Connection();

        // 2. Configuramos la ventana
        setTitle("Cálculo Simbólico en Prolog");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Theme.BG);
        setLayout(new BorderLayout(20, 20));

        // --- PANEL SUPERIOR (Título y Campo de Texto) ---
        JPanel pnlArriba = new JPanel(new BorderLayout(10, 10));
        pnlArriba.setOpaque(false); 
        pnlArriba.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        JLabel lblEncabezado = new JLabel("Calculadora de Derivadas e Integrales");
        lblEncabezado.setFont(Theme.sans(Font.BOLD, 22));
        lblEncabezado.setForeground(Theme.TEXT);

        txtExpresion = new JTextField();
        txtExpresion.setFont(Theme.mono(Font.PLAIN, 18));
        txtExpresion.setBackground(Theme.CARD);
        txtExpresion.setForeground(Theme.TEXT);
        txtExpresion.setCaretColor(Theme.TEXT);
        txtExpresion.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Theme.PRIMARY),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        pnlArriba.add(lblEncabezado, BorderLayout.NORTH);
        pnlArriba.add(txtExpresion, BorderLayout.CENTER);

        // --- PANEL CENTRAL (Botones y Tarjeta de Resultado) ---
        JPanel pnlCentro = new JPanel(new BorderLayout(20, 20));
        pnlCentro.setOpaque(false);
        pnlCentro.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));

        // Fila para los botones
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        pnlBotones.setOpaque(false);

        JButton btnDerivar = crearBoton("Derivar");
        JButton btnIntegrar = crearBoton("Integrar");
        // NUEVO BOTÓN
        JButton btnSimplificar = crearBoton("Simplificar"); 

        pnlBotones.add(btnDerivar);
        pnlBotones.add(btnIntegrar);
        pnlBotones.add(btnSimplificar); // Lo agregamos a la ventana

        panelResultado = new PanelResult();

        pnlCentro.add(pnlBotones, BorderLayout.NORTH);
        pnlCentro.add(panelResultado, BorderLayout.CENTER);

        add(pnlArriba, BorderLayout.NORTH);
        add(pnlCentro, BorderLayout.CENTER);

        // --- ACCIONES DE LOS BOTONES ---
        btnDerivar.addActionListener(e -> resolver("d"));
        btnIntegrar.addActionListener(e -> resolver("s"));
        // NUEVA ACCIÓN: Le decimos que llame a la regla "simp" de Prolog
        btnSimplificar.addActionListener(e -> resolver("simp")); 
    }

    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(Theme.sans(Font.BOLD, 16));
        btn.setBackground(Theme.PRIMARY);
        btn.setForeground(Theme.BG);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return btn;
    }

    private void resolver(String operador) {
        String expresion = txtExpresion.getText().trim();
        
        if (expresion.isEmpty()) {
            panelResultado.mostrar("Escribe una expresión", "Advertencia", Color.YELLOW);
            return;
        }

        String resultado = prologConnection.consultar(operador, expresion);

        if (resultado.startsWith("Error")) {
            panelResultado.mostrar(resultado, "Error", Color.RED);
        } else {
            panelResultado.mostrar(resultado, "Solución:", Color.GREEN);
        }
    }
}