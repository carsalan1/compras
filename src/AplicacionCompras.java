import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AplicacionCompras extends JFrame implements ActionListener {
    private JLabel limiteLabel, descripcionLabel, valorLabel, resultadoLabel;
    private JTextField descripcionTextField, valorTextField;
    private JButton comprarButton, finalizarButton;
    private JTextArea resultadoTextArea;
    private double limiteTarjeta;
    private double saldo;
    private ArrayList<Compra> compras;

    public AplicacionCompras(double limiteTarjeta) {
        this.limiteTarjeta = limiteTarjeta;
        this.saldo = limiteTarjeta;
        this.compras = new ArrayList<>();

        setTitle("Aplicación de Compras");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel(new GridLayout(3, 2));
        limiteLabel = new JLabel("Límite de la tarjeta:");
        panelSuperior.add(limiteLabel);
        panelSuperior.add(new JLabel("$" + formatCurrency(limiteTarjeta)));
        descripcionLabel = new JLabel("Descripción de la compra:");
        panelSuperior.add(descripcionLabel);
        descripcionTextField = new JTextField();
        panelSuperior.add(descripcionTextField);
        valorLabel = new JLabel("Valor de la compra:");
        panelSuperior.add(valorLabel);
        valorTextField = new JTextField();
        panelSuperior.add(valorTextField);

        JPanel panelInferior = new JPanel(new FlowLayout());
        comprarButton = new JButton("Comprar");
        comprarButton.addActionListener(this);
        panelInferior.add(comprarButton);
        finalizarButton = new JButton("Finalizar");
        finalizarButton.addActionListener(this);
        panelInferior.add(finalizarButton);

        resultadoTextArea = new JTextArea(10, 30);
        resultadoTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoTextArea);

        add(panelSuperior, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == comprarButton) {
            String descripcion = descripcionTextField.getText();
            double valorCompra;
            try {
                valorCompra = Double.parseDouble(valorTextField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor válido para la compra.");
                return;
            }

            if (valorCompra <= 0) {
                JOptionPane.showMessageDialog(this, "El valor de la compra debe ser mayor que cero.");
                return;
            }

            if (saldo >= valorCompra) {
                saldo -= valorCompra;
                compras.add(new Compra(descripcion, valorCompra));
                actualizarResultado();
            } else {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente.");
            }

            descripcionTextField.setText("");
            valorTextField.setText("");
        } else if (e.getSource() == finalizarButton) {
            mostrarResumen();
        }
    }

    private void actualizarResultado() {
        resultadoTextArea.setText("Compras realizadas:\n");
        for (Compra compra : compras) {
            resultadoTextArea.append(compra.toString() + "\n");
        }
        resultadoTextArea.append("\nSaldo restante: $" + formatCurrency(saldo));
    }

    private void mostrarResumen() {
        Collections.sort(compras, Comparator.comparingDouble(Compra::getCantidad));
        StringBuilder resumen = new StringBuilder("Resumen de compras realizadas:\n");
        for (Compra compra : compras) {
            resumen.append(compra.toString()).append("\n");
        }
        resumen.append("\nSaldo final: ").append(formatCurrency(saldo));
        JOptionPane.showMessageDialog(this, resumen.toString(), "Resumen de Compras", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private String formatCurrency(double amount) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(amount);
    }
}

class Compra {
    private String descripcion;
    private double cantidad;

    public Compra(String descripcion, double cantidad) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return descripcion + " - $" + cantidad;
    }
}
