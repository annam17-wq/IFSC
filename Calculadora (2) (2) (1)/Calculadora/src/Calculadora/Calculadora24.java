package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora24 extends JFrame {

    public Calculadora24() {
        setTitle("Calculadora de Investimentos");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JMenuBar menuBar = new JMenuBar();

        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre");
        
        itemSobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FormSobre();
            }
        });


        menuAjuda.add(itemSobre);
        menuBar.add(menuAjuda);

        setJMenuBar(menuBar);
       

        setLayout(new GridLayout(5, 2));

      
        JLabel lblMeses = new JLabel("Meses:");
        JTextField txtMeses = new JTextField(10);

        JLabel lblJuros = new JLabel("Juros (%):");
        JTextField txtJuros = new JTextField(10);

        JLabel lblDeposito = new JLabel("Depósito Mensal:");
        JTextField txtDeposito = new JTextField(10);

        JLabel lblTotal = new JLabel("Total:");
        JTextField txtTotal = new JTextField(10);
        txtTotal.setEditable(false);

        JButton btnCalcular = new JButton("Calcular");

   
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int meses = Integer.parseInt(txtMeses.getText());
                    double juros = Double.parseDouble(txtJuros.getText());
                    double deposito = Double.parseDouble(txtDeposito.getText());

                    Investimento inv = new Investimento(meses, juros, deposito);
                    double total = inv.calculaTotal();

                    txtTotal.setText(String.format("%.2f", total));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro nos dados!");
                }
            }
        });

      
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(lblMeses);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(txtMeses);

        JPanel p3 = new JPanel(new FlowLayout());
        p3.add(lblJuros);

        JPanel p4 = new JPanel(new FlowLayout());
        p4.add(txtJuros);

        JPanel p5 = new JPanel(new FlowLayout());
        p5.add(lblDeposito);

        JPanel p6 = new JPanel(new FlowLayout());
        p6.add(txtDeposito);

        JPanel p7 = new JPanel(new FlowLayout());
        p7.add(lblTotal);

        JPanel p8 = new JPanel(new FlowLayout());
        p8.add(txtTotal);

        JPanel p9 = new JPanel(new FlowLayout());
        p9.add(new JLabel());

        JPanel p10 = new JPanel(new FlowLayout());
        p10.add(btnCalcular);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        add(p6);
        add(p7);
        add(p8);
        add(p9);
        add(p10);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculadora24();
    }
}
