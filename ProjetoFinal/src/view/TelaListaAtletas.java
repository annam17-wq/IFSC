package view;

import model.Atleta;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TelaListaAtletas extends JFrame {

    public TelaListaAtletas() {
        setTitle("Atletas Cadastrados");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBackground(SystemColor.inactiveCaption);
        painel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("Selecione um atleta para ver a conta:", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        painel.add(lblTitulo, BorderLayout.NORTH);


        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        
        if (Atleta.nome != null && !Atleta.nome.isEmpty()) {
            modeloLista.addElement(Atleta.nome);
        } else {
            modeloLista.addElement("Nenhum atleta cadastrado no momento.");
        }

        JList<String> listaAtletas = new JList<>(modeloLista);
        listaAtletas.setFont(new Font("Tahoma", Font.PLAIN, 14));
        listaAtletas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(listaAtletas);
        painel.add(scrollPane, BorderLayout.CENTER);

        JButton btnAcessar = new JButton("Acessar Conta");
        painel.add(btnAcessar, BorderLayout.SOUTH);

       
        btnAcessar.addActionListener(e -> acessarContaSelecionada(listaAtletas));
        
        listaAtletas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) { 
                    acessarContaSelecionada(listaAtletas);
                }
            }
        });

        getContentPane().add(painel);
    }

    private void acessarContaSelecionada(JList<String> lista) {
        String selecionado = lista.getSelectedValue();
        
        if (selecionado == null || selecionado.equals("Nenhum atleta cadastrado no momento.")) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um atleta válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

     
        TelaConta conta = new TelaConta();
        conta.setVisible(true);
        dispose();
    }
}