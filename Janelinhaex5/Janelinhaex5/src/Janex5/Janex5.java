package Janex5;


import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Janex5 extends JFrame {

    private JPanel contentPane;
    private JTextField txtPeso;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Janex5 frame = new Janex5();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Janex5() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 0, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        JLabel lblPeso = new JLabel("Peso (kg):");
        lblPeso.setBounds(49, 99, 100, 20);
        contentPane.add(lblPeso);

     
        txtPeso = new JTextField();
        txtPeso.setBounds(106, 99, 100, 20);
        contentPane.add(txtPeso);


     
        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(49, 212, 300, 20);
        contentPane.add(lblResultado);

    
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(106, 161, 120, 25);
        contentPane.add(btnCalcular);
        
        JLabel lblNewLabel = new JLabel("Preço fixo do kg; 9,90");
        lblNewLabel.setBounds(49, 61, 198, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Fomelândia");
        lblNewLabel_1.setBounds(148, 11, 100, 20);
        contentPane.add(lblNewLabel_1);

       
        btnCalcular.addActionListener(e -> {
            try {
                double peso = Double.parseDouble(txtPeso.getText());
                double valorKg = 9.95; 

                double total = peso * valorKg;

                lblResultado.setText("Total a pagar: R$ " + String.format("%.2f", total));
            } catch (Exception ex) {
                lblResultado.setText("Digite valores válidos!");
            }
        });

    }
}
