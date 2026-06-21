package Calculadora;

import javax.swing.*;
import java.awt.*;

public class Calculadora2 extends JFrame {

    public Calculadora2() {
        setTitle("Calculadora de Investimentos");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(5, 2));


        JLabel lblMeses = new JLabel("Meses:");
        JTextField txtMeses = new JTextField();

        JLabel lblJuros = new JLabel("Juros (%):");
        JTextField txtJuros = new JTextField();

        JLabel lblDeposito = new JLabel("Depósito Mensal:");
        JTextField txtDeposito = new JTextField();

        JLabel lblTotal = new JLabel("Total:");
        JTextField txtTotal = new JTextField();
        txtTotal.setEditable(false);

        JButton btnCalcular = new JButton("Calcular");


        add(lblMeses);
        add(txtMeses);

        add(lblJuros);
        add(txtJuros);

        add(lblDeposito);
        add(txtDeposito);

        add(lblTotal);
        add(txtTotal);

        add(new JLabel());
        add(btnCalcular);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculadora2();
    }
}
