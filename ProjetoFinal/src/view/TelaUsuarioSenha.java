package view;



import model.Atleta;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;



public class TelaUsuarioSenha extends JFrame {



private JPanel contentPane;
private JTextField txtUsuario;
private JPasswordField txtSenha;



public TelaUsuarioSenha() {
setTitle("Cadastro de Usuário");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 300);
setLocationRelativeTo(null);



contentPane = new JPanel();
contentPane.setBackground(SystemColor.inactiveCaption);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);



JLabel lblTitulo = new JLabel("Cadastro de Usuário");
lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
lblTitulo.setBounds(114, 22, 250, 30);
contentPane.add(lblTitulo);



JLabel lblUsuario = new JLabel("Usuário:");
lblUsuario.setBounds(47, 94, 80, 20);
contentPane.add(lblUsuario);



txtUsuario = new JTextField();
txtUsuario.setBounds(137, 92, 180, 25);
contentPane.add(txtUsuario);



JLabel lblSenha = new JLabel("Senha:");
lblSenha.setBounds(47, 130, 80, 20);
contentPane.add(lblSenha);



txtSenha = new JPasswordField();
txtSenha.setBounds(137, 128, 180, 25);
contentPane.add(txtSenha);



JButton btnFinalizar = new JButton("Finalizar Cadastro");
btnFinalizar.setBounds(125, 190, 180, 30);
contentPane.add(btnFinalizar);



btnFinalizar.addActionListener(e -> {
Atleta.usuario = txtUsuario.getText();
Atleta.senha = new String(txtSenha.getPassword());



if(Atleta.usuario.isEmpty() || Atleta.senha.isEmpty()) {
JOptionPane.showMessageDialog(null, "Preencha usuário e senha!");
return;

}



JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");



TelaLogin login = new TelaLogin();
login.setVisible(true);
dispose();

});

}

}