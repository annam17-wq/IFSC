package view;



import model.Atleta;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;
import java.awt.SystemColor;



public class TelaLogin extends JFrame {



private JTextField txtUsuario;
private JPasswordField txtSenha;



public TelaLogin() {
getContentPane().setBackground(SystemColor.inactiveCaption);
setTitle("Login");
setSize(400,250);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
getContentPane().setLayout(null);



JLabel lblTitulo = new JLabel("Entrar");
lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
lblTitulo.setBounds(160,20,100,30);
getContentPane().add(lblTitulo);



JLabel lblUsuario = new JLabel("Usuário:");
lblUsuario.setBounds(50,80,80,20);
getContentPane().add(lblUsuario);



txtUsuario = new JTextField();
txtUsuario.setBounds(140,80,180,25);
getContentPane().add(txtUsuario);



JLabel lblSenha = new JLabel("Senha:");
lblSenha.setBounds(50,120,80,20);
getContentPane().add(lblSenha);



txtSenha = new JPasswordField();
txtSenha.setBounds(140,120,180,25);
getContentPane().add(txtSenha);



JButton btnEntrar = new JButton("Entrar");
btnEntrar.setBounds(140,170,120,30);
getContentPane().add(btnEntrar);



btnEntrar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String usuario = txtUsuario.getText();
String senha = new String(txtSenha.getPassword());



if(usuario.equals(Atleta.usuario) && senha.equals(Atleta.senha)) {
JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");


TelaConta conta = new TelaConta();
conta.setVisible(true);
dispose();
} else {

JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");

}

}

});

}

}

