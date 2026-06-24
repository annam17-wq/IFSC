package view;



import model.Atleta;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;



public class TelaEndereco {



private JFrame frame;
private JTextField txtPais;
private JTextField txtEstado;
private JTextField txtCidade;
private JTextField txtBairro;
private JTextField txtRua;
private JTextField txtNumero;
private JTextField txtCEP;



public TelaEndereco() {
initialize();
preencherDadosExistentes();

}



private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(SystemColor.inactiveCaption);
frame.setTitle("Endereço do Atleta");
frame.setBounds(100, 100, 600, 550);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.getContentPane().setLayout(null);



JLabel lblTitulo = new JLabel("Dados de Endereço");
lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
lblTitulo.setBounds(180, 20, 250, 30);
frame.getContentPane().add(lblTitulo);



JLabel lblPais = new JLabel("País:");
lblPais.setBounds(50, 80, 100, 25);
frame.getContentPane().add(lblPais);



txtPais = new JTextField();
txtPais.setBounds(180, 80, 351, 25);
frame.getContentPane().add(txtPais);



JLabel lblEstado = new JLabel("Estado:");
lblEstado.setBounds(50, 120, 100, 25);
frame.getContentPane().add(lblEstado);



txtEstado = new JTextField();
txtEstado.setBounds(180, 120, 351, 25);
frame.getContentPane().add(txtEstado);



JLabel lblCidade = new JLabel("Cidade:");
lblCidade.setBounds(50, 160, 100, 25);
frame.getContentPane().add(lblCidade);



txtCidade = new JTextField();
txtCidade.setBounds(180, 160, 351, 25);
frame.getContentPane().add(txtCidade);



JLabel lblBairro = new JLabel("Bairro:");
lblBairro.setBounds(50, 200, 100, 25);
frame.getContentPane().add(lblBairro);



txtBairro = new JTextField();
txtBairro.setBounds(180, 200, 351, 25);
frame.getContentPane().add(txtBairro);



JLabel lblRua = new JLabel("Rua:");
lblRua.setBounds(50, 240, 100, 25);
frame.getContentPane().add(lblRua);



txtRua = new JTextField();
txtRua.setBounds(180, 240, 351, 25);
frame.getContentPane().add(txtRua);



JLabel lblNumero = new JLabel("Número:");
lblNumero.setBounds(50, 280, 100, 25);
frame.getContentPane().add(lblNumero);



txtNumero = new JTextField();
txtNumero.setBounds(180, 280, 351, 25);
frame.getContentPane().add(txtNumero);



JLabel lblCEP = new JLabel("CEP:");
lblCEP.setBounds(50, 320, 100, 25);
frame.getContentPane().add(lblCEP);



txtCEP = new JTextField();
txtCEP.setBounds(180, 320, 351, 25);
frame.getContentPane().add(txtCEP);



JButton btnProximo = new JButton("Próximo");
btnProximo.setBounds(220, 400, 120, 40);
frame.getContentPane().add(btnProximo);



btnProximo.addActionListener(e -> {

if (txtPais.getText().trim().isEmpty() ||
txtEstado.getText().trim().isEmpty() ||
txtCidade.getText().trim().isEmpty() ||
txtBairro.getText().trim().isEmpty() ||
txtRua.getText().trim().isEmpty() ||
txtNumero.getText().trim().isEmpty() ||
txtCEP.getText().trim().isEmpty()) {


JOptionPane.showMessageDialog(frame, "Todos os campos são obrigatórios!", "Aviso", JOptionPane.WARNING_MESSAGE);
return;

}



if (!txtNumero.getText().trim().matches("^\\d+$")) {
JOptionPane.showMessageDialog(frame, "O número deve conter apenas algarismos!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
return;

}



if (!txtCEP.getText().trim().matches("^\\d{8}$")) {
JOptionPane.showMessageDialog(frame, "O CEP deve conter exatamente 8 números!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
return;

}



Atleta.pais = txtPais.getText().trim();
Atleta.estado = txtEstado.getText().trim();
Atleta.cidade = txtCidade.getText().trim();
Atleta.bairro = txtBairro.getText().trim();
Atleta.rua = txtRua.getText().trim();
Atleta.numero = Integer.parseInt(txtNumero.getText().trim());
Atleta.cep = Long.parseLong(txtCEP.getText().trim());



TelaAtleta telaAtleta = new TelaAtleta();
telaAtleta.mostrarTela();
frame.dispose();
});

}



private void preencherDadosExistentes() {
if (Atleta.pais != null) txtPais.setText(Atleta.pais);
if (Atleta.estado != null) txtEstado.setText(Atleta.estado);
if (Atleta.cidade != null) txtCidade.setText(Atleta.cidade);
if (Atleta.bairro != null) txtBairro.setText(Atleta.bairro);
if (Atleta.rua != null) txtRua.setText(Atleta.rua);
if (Atleta.numero != 0) txtNumero.setText(String.valueOf(Atleta.numero));
if (Atleta.cep != 0) txtCEP.setText(String.format("%08d", Atleta.cep));

}



public void mostrarTela() {
frame.setLocationRelativeTo(null);
frame.setVisible(true);

}

} 

