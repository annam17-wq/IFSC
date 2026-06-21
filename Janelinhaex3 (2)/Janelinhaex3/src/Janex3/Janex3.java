package Janex3;


import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Janex3 extends JFrame {

    private JPanel contentPane;
    private JTextField txtBase;
    private JTextField txtAltura;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Janex3 frame = new Janex3();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Janex3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Campo base
        JLabel lblBase = new JLabel("Base:");
        lblBase.setBounds(50, 50, 80, 20);
        contentPane.add(lblBase);

        txtBase = new JTextField();
        txtBase.setBounds(120, 50, 100, 20);
        contentPane.add(txtBase);

        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setBounds(50, 90, 80, 20);
        contentPane.add(lblAltura);

        txtAltura = new JTextField();
        txtAltura.setBounds(120, 90, 100, 20);
        contentPane.add(txtAltura);

 
        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(50, 180, 300, 20);
        contentPane.add(lblResultado);


        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(120, 130, 100, 25);
        contentPane.add(btnCalcular);

      
        btnCalcular.addActionListener(e -> {
            try {
                double base = Double.parseDouble(txtBase.getText());
                double altura = Double.parseDouble(txtAltura.getText());

              
                Retangulo r = new Retangulo(base, altura);

                double perimetro = r.calcularPerimetro();
                double area = r.calcularArea();

                lblResultado.setText("Perímetro: " + perimetro + " | Área: " + area);

            } catch (Exception ex) {
                lblResultado.setText("Digite valores válidos!");
            }
        });
    }
}
