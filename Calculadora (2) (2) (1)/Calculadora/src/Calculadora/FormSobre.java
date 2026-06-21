package Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormSobre extends JFrame {

    public FormSobre() {
        setTitle("Sobre");
        setSize(320, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(5, 1));

        
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p1.add(new JLabel("CalcInvest - Calculadora de Investimentos"));

      
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p2.add(new JLabel("Versão: 1.0"));

       
        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p3.add(new JLabel("Autor: Andrei de Souza Inácio"));

       
        JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p4.add(new JLabel("Contato: andrei.inacio@ifsc.edu.br"));

        
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(e -> dispose());

        JPanel p5 = new JPanel();
        p5.add(btnOk);

        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
