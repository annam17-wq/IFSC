package view;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class pf {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                pf window = new pf();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public pf() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(SystemColor.inactiveCaption);
        frame.setTitle("Sistema de Atletas");
        frame.setBounds(100, 100, 500, 320); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Possui cadastro?");
        lblTitulo.setBackground(Color.WHITE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setBounds(140, 50, 220, 30);
        frame.getContentPane().add(lblTitulo);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(120, 120, 100, 35);
        frame.getContentPane().add(btnEntrar);
        
        btnEntrar.addActionListener(e -> {
            TelaLogin tela = new TelaLogin();
            tela.setVisible(true);
        });

        JButton btnCadastrar = new JButton("Cadastre-se");
        btnCadastrar.setBounds(260, 120, 120, 35);
        frame.getContentPane().add(btnCadastrar);

       
        JButton btnVerCadastros = new JButton("Ver Cadastros");
        btnVerCadastros.setBounds(150, 180, 180, 35);
        frame.getContentPane().add(btnVerCadastros);

        btnVerCadastros.addActionListener(e -> {
            TelaListaAtletas telaLista = new TelaListaAtletas();
            telaLista.setVisible(true);
        });

        btnCadastrar.addActionListener(e -> {
            TelaCadastro tela = new TelaCadastro();
            tela.mostrarTela();
        });
    }
}