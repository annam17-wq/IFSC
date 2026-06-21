package Janex4;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Janex4 extends JFrame {

    private JPanel contentPane;
    private JTextField txtPreco;
    private JTextField txtValor;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Janex4 frame = new Janex4();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Janex4() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblPreco = new JLabel("Preço por litro:");
        lblPreco.setBounds(50, 50, 120, 20);
        contentPane.add(lblPreco);

        
        txtPreco = new JTextField();
        txtPreco.setBounds(140, 50, 100, 20);
        contentPane.add(txtPreco);

      
        JLabel lblValor = new JLabel("Valor a pagar:");
        lblValor.setBounds(50, 90, 120, 20);
        contentPane.add(lblValor);

      
        txtValor = new JTextField();
        txtValor.setBounds(140, 90, 100, 20);
        contentPane.add(txtValor);

        
        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(50, 180, 300, 20);
        contentPane.add(lblResultado);

        
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 193, 120, 25);
        contentPane.add(btnCalcular);

       
        btnCalcular.addActionListener(e -> {
            try {
                double preco = Double.parseDouble(txtPreco.getText());
                double valor = Double.parseDouble(txtValor.getText());

                double litros = valor / preco;

                lblResultado.setText("Litros: " + litros);
            } catch (Exception ex) {
                lblResultado.setText("Digite valores válidos!");
            }
        });
    }
}
