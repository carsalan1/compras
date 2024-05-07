import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            double limiteTarjeta = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el límite de la tarjeta:"));
            new AplicacionCompras(limiteTarjeta);
        });
    }
}
