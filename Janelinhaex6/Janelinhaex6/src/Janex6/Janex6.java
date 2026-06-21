package Janex6;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Janex6 extends JFrame {

    private JPanel contentPane;
    private JTextField txtNum1;
    private JTextField txtNum2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Janex6 frame = new Janex6();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Janex6() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

     
        JLabel lblNum1 = new JLabel("Número 1:");
        lblNum1.setBounds(50, 50, 80, 20);
        contentPane.add(lblNum1);

        txtNum1 = new JTextField();
        txtNum1.setBounds(140, 50, 100, 20);
        contentPane.add(txtNum1);

       
        JLabel lblNum2 = new JLabel("Número 2:");
        lblNum2.setBounds(50, 90, 80, 20);
        contentPane.add(lblNum2);

        txtNum2 = new JTextField();
        txtNum2.setBounds(140, 90, 100, 20);
        contentPane.add(txtNum2);

        
        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(50, 200, 300, 20);
        contentPane.add(lblResultado);

     
        JButton btnSomar = new JButton("Somar");
        btnSomar.setBounds(50, 145, 100, 25);
        contentPane.add(btnSomar);

        JButton btnSubtrair = new JButton("Subtrair");
        btnSubtrair.setBounds(231, 145, 100, 25);
        contentPane.add(btnSubtrair);

        JButton btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(50, 195, 100, 25);
        contentPane.add(btnMultiplicar);

        JButton btnDividir = new JButton("Dividir");
        btnDividir.setBounds(231, 195, 100, 25);
        contentPane.add(btnDividir);

      
        java.util.function.Supplier<double[]> getValores = () -> {
            if (txtNum1.getText().isEmpty() || txtNum2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos.");
                return null;
            }

            try {
                double n1 = Double.parseDouble(txtNum1.getText());
                double n2 = Double.parseDouble(txtNum2.getText());
                return new double[]{n1, n2};
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Digite apenas números.");
                return null;
            }
        };

    
        btnSomar.addActionListener(e -> {
            double[] v = getValores.get();
            if (v != null) {
                lblResultado.setText("Resultado: " + (v[0] + v[1]));
            }
        });

       
        btnSubtrair.addActionListener(e -> {
            double[] v = getValores.get();
            if (v != null) {
                lblResultado.setText("Resultado: " + (v[0] - v[1]));
            }
        });

     
        btnMultiplicar.addActionListener(e -> {
            double[] v = getValores.get();
            if (v != null) {
                lblResultado.setText("Resultado: " + (v[0] * v[1]));
            }
        });

     
        btnDividir.addActionListener(e -> {
            double[] v = getValores.get();
            if (v != null) {
                if (v[1] == 0) {
                    JOptionPane.showMessageDialog(null, "Não é possível dividir por zero.");
                } else {
                    lblResultado.setText("Resultado: " + (v[0] / v[1]));
                }
            }
        });
    }
}
