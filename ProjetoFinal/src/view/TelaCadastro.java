package view;

import model.Atleta;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class TelaCadastro {

    private JFrame frame;
    private JTextField txtNome;
    private JTextField txtNascimento;
    private JTextField txtEndereco; // Campo utilizado para o CPF no seu código original
    private JTextField txtTelefone;
    private JTextField txtModalidade;
    private JTextField textField; // Campo utilizado para o Sexo

    public TelaCadastro() {
        initialize();
        preencherDadosExistentes();
    }

    public void mostrarTela() {
        if (frame != null) {
            frame.setVisible(true);
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(SystemColor.inactiveCaption);
        frame.setTitle("Cadastro de Atleta");
        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ajustado para não fechar o app inteiro
        frame.getContentPane().setLayout(null);

        JLabel lblTitulo = new JLabel("Dados iniciais");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setBounds(180, 20, 250, 30);
        frame.getContentPane().add(lblTitulo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 80, 100, 25);
        frame.getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(180, 80, 350, 25);
        frame.getContentPane().add(txtNome);
        txtNome.setColumns(10);

        JLabel lblNascimento = new JLabel("Data de Nascimento:");
        lblNascimento.setBounds(50, 130, 130, 25);
        frame.getContentPane().add(lblNascimento);

        txtNascimento = new JTextField();
        txtNascimento.setBounds(180, 130, 350, 25);
        frame.getContentPane().add(txtNascimento);
        txtNascimento.setColumns(10);

        JLabel lblCpf = new JLabel("CPF (apenas números):");
        lblCpf.setBounds(50, 180, 130, 25);
        frame.getContentPane().add(lblCpf);

        txtEndereco = new JTextField(); // Usado para CPF conforme o original
        txtEndereco.setBounds(180, 180, 350, 25);
        frame.getContentPane().add(txtEndereco);
        txtEndereco.setColumns(10);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(50, 230, 100, 25);
        frame.getContentPane().add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(180, 230, 350, 25);
        frame.getContentPane().add(txtTelefone);
        txtTelefone.setColumns(10);

        JLabel lblModalidade = new JLabel("Modalidade:");
        lblModalidade.setBounds(50, 280, 100, 25);
        frame.getContentPane().add(lblModalidade);

        txtModalidade = new JTextField();
        txtModalidade.setBounds(180, 280, 350, 25);
        frame.getContentPane().add(txtModalidade);
        txtModalidade.setColumns(10);

        JLabel lblSexo = new JLabel("Sexo (M/F):");
        lblSexo.setBounds(50, 330, 100, 25);
        frame.getContentPane().add(lblSexo);

        textField = new JTextField(); // Usado para Sexo conforme o original
        textField.setBounds(180, 330, 350, 25);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnAvancar = new JButton("Avançar");
        btnAvancar.setBounds(430, 400, 100, 30);
        frame.getContentPane().add(btnAvancar);

        btnAvancar.addActionListener(e -> {
            if (txtNome.getText().trim().isEmpty() || txtNascimento.getText().trim().isEmpty() || 
                txtEndereco.getText().trim().isEmpty() || txtTelefone.getText().trim().isEmpty() || 
                txtModalidade.getText().trim().isEmpty() || textField.getText().trim().isEmpty()) {
                
                JOptionPane.showMessageDialog(frame, "Todos os campos devem ser preenchidos!", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!txtEndereco.getText().trim().matches("^\\d{11}$")) {
                JOptionPane.showMessageDialog(frame, "O CPF deve conter exatamente 11 números!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!txtTelefone.getText().trim().matches("^\\d{10,11}$")) {
                JOptionPane.showMessageDialog(frame, "O telefone deve conter entre 10 e 11 números com DDD!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!textField.getText().trim().matches("^[MfMF]$")) {
                JOptionPane.showMessageDialog(frame, "No campo Sexo, digite apenas M ou F!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Salva os dados validados no Model
            Atleta.nome = txtNome.getText().trim();
            Atleta.dataNascimento = txtNascimento.getText().trim();
            Atleta.cpf = Long.parseLong(txtEndereco.getText().trim());
            Atleta.telefone = Long.parseLong(txtTelefone.getText().trim());
            Atleta.modalidade = txtModalidade.getText().trim();
            Atleta.sexo = textField.getText().trim().toUpperCase();

            // Avança para a tela de Endereço
            TelaEndereco telaEndereco = new TelaEndereco();
            telaEndereco.mostrarTela();
            frame.dispose();
        });
    }

    private void preencherDadosExistentes() {
        if (Atleta.nome != null) txtNome.setText(Atleta.nome);
        if (Atleta.dataNascimento != null) txtNascimento.setText(Atleta.dataNascimento);
        if (Atleta.cpf != 0) txtEndereco.setText(String.format("%011d", Atleta.cpf));
        if (Atleta.telefone != 0) txtTelefone.setText(String.valueOf(Atleta.telefone));
        if (Atleta.modalidade != null) txtModalidade.setText(Atleta.modalidade);
        if (Atleta.sexo != null) textField.setText(Atleta.sexo);
    }
}