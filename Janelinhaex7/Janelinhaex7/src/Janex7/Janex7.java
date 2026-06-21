package Janex7;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Janex7 extends JFrame {

    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtNota1;
    private JTextField txtNota2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Janex7 frame = new Janex7();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Janex7() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

       
        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 40, 80, 20);
        contentPane.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(113, 40, 150, 20);
        contentPane.add(txtNome);

    
        JLabel lblNota1 = new JLabel("Nota 1:");
        lblNota1.setBounds(50, 71, 80, 20);
        contentPane.add(lblNota1);

        txtNota1 = new JTextField();
        txtNota1.setBounds(113, 71, 150, 20);
        contentPane.add(txtNota1);

        
        JLabel lblNota2 = new JLabel("Nota 2:");
        lblNota2.setBounds(50, 102, 80, 20);
        contentPane.add(lblNota2);

        txtNota2 = new JTextField();
        txtNota2.setBounds(113, 102, 150, 20);
        contentPane.add(txtNota2);

        
        JLabel lblResultado = new JLabel("");
        lblResultado.setBounds(50, 230, 300, 20);
        contentPane.add(lblResultado);

      
        JButton btnCalcular = new JButton("Calcular Média");
        btnCalcular.setBounds(113, 173, 150, 25);
        contentPane.add(btnCalcular);

        
        btnCalcular.addActionListener(e -> {
           
            if (txtNome.getText().isEmpty() || txtNota1.getText().isEmpty() || txtNota2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }

            try {
                String nome = txtNome.getText();
                double n1 = Double.parseDouble(txtNota1.getText());
                double n2 = Double.parseDouble(txtNota2.getText());

                double media = (n1 + n2) / 2;

                String situacao;
                if (media >= 7) {
                    situacao = "Aprovado";
                } else {
                    situacao = "Reprovado";
                }

                lblResultado.setText(
                        nome + " | Média: " + String.format("%.2f", media) + " | Situação: " + situacao
                );

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Digite apenas números nas notas!");
            }
        });
    }
}