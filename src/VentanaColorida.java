import javax.swing.*;
import java.awt.*;

public class VentanaColorida extends JFrame {
    public VentanaColorida() {
        setTitle("Ventana Colorida");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); // Cambiar el diseño a FlowLayout
        getContentPane().setBackground(new Color(173, 216, 230)); // Azul claro
        setVisible(true);
    }
}
