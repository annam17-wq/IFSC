package view;



import model.Atleta;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.Color;
import java.awt.SystemColor;



public class TelaAtleta {



private JFrame frame;
private JTextField txtCategoria;
private JTextField txtPeso;
private JTextField txtAltura;
private JTextField txtAssociacao;
private JTextField txtMatricula;
private JTextField txtPosicao;
private JTextField txtEquipe;
private JTextArea txtObs;



public TelaAtleta() {
initialize();
preencherDadosExistentes();

}



private void initialize() {
frame = new JFrame();
frame.getContentPane().setBackground(SystemColor.inactiveCaption);
frame.setTitle("Informações do Atleta");
frame.setBounds(100, 100, 650, 550);
frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
frame.getContentPane().setLayout(null);



JLabel lblCategoria = new JLabel("Categoria:");
lblCategoria.setBackground(Color.BLACK);
lblCategoria.setBounds(50, 80, 120, 25);
frame.getContentPane().add(lblCategoria);



txtCategoria = new JTextField();
txtCategoria.setBounds(220, 80, 250, 25);
frame.getContentPane().add(txtCategoria);



JLabel lblPeso = new JLabel("Peso (kg):");
lblPeso.setBackground(Color.WHITE);
lblPeso.setBounds(50, 120, 120, 25);
frame.getContentPane().add(lblPeso);



txtPeso = new JTextField();
txtPeso.setBounds(220, 120, 250, 25);
frame.getContentPane().add(txtPeso);



JLabel lblAltura = new JLabel("Altura (m):");
lblAltura.setBackground(Color.WHITE);
lblAltura.setBounds(50, 160, 120, 25);
frame.getContentPane().add(lblAltura);



txtAltura = new JTextField();
txtAltura.setBounds(220, 160, 250, 25);
frame.getContentPane().add(txtAltura);



JLabel lblAssociacao = new JLabel("Data Associação:");
lblAssociacao.setBackground(Color.WHITE);
lblAssociacao.setBounds(50, 200, 120, 25);
frame.getContentPane().add(lblAssociacao);



txtAssociacao = new JTextField();
txtAssociacao.setBounds(220, 200, 250, 25);
frame.getContentPane().add(txtAssociacao);



JLabel lblMatricula = new JLabel("Matrícula:");
lblMatricula.setBounds(50, 240, 120, 25);
frame.getContentPane().add(lblMatricula);



txtMatricula = new JTextField();
txtMatricula.setBounds(220, 240, 250, 25);
frame.getContentPane().add(txtMatricula);



JLabel lblPosicao = new JLabel("Posição/Função:");
lblPosicao.setBounds(50, 280, 120, 25);
frame.getContentPane().add(lblPosicao);



txtPosicao = new JTextField();
txtPosicao.setBounds(220, 280, 250, 25);
frame.getContentPane().add(txtPosicao);



JLabel lblEquipe = new JLabel("Equipe:");
lblEquipe.setBounds(50, 320, 120, 25);
frame.getContentPane().add(lblEquipe);



txtEquipe = new JTextField();
txtEquipe.setBounds(220, 320, 250, 25);
frame.getContentPane().add(txtEquipe);



JLabel lblObs = new JLabel("Observações:");
lblObs.setBounds(50, 360, 120, 25);
frame.getContentPane().add(lblObs);



txtObs = new JTextArea();
txtObs.setBounds(220, 360, 250, 60);
frame.getContentPane().add(txtObs);



JButton btnProximo = new JButton("Próximo");
btnProximo.setBounds(220, 450, 180, 40);
frame.getContentPane().add(btnProximo);

JLabel lblDadosDoAtleta = new JLabel("Dados do Atleta\r\n");
lblDadosDoAtleta.setFont(new Font("Arial", Font.BOLD, 22));
lblDadosDoAtleta.setBounds(161, 11, 250, 30);
frame.getContentPane().add(lblDadosDoAtleta);



btnProximo.addActionListener(new ActionListener() {
	
public void actionPerformed(ActionEvent e) {
	
 if (txtCategoria.getText().trim().isEmpty() ||
txtPeso.getText().trim().isEmpty() ||
txtAltura.getText().trim().isEmpty() ||
txtAssociacao.getText().trim().isEmpty() ||
txtMatricula.getText().trim().isEmpty() ||
txtPosicao.getText().trim().isEmpty() ||
txtEquipe.getText().trim().isEmpty()) {


JOptionPane.showMessageDialog(null, "Por favor, preencha as informações obrigatórias!", "Aviso", JOptionPane.WARNING_MESSAGE);
return;

}



if (!txtPeso.getText().trim().matches("^\\d+(\\.\\d+)?$")) {
JOptionPane.showMessageDialog(null, "Peso inválido! Use ponto para decimais.", "Erro", JOptionPane.ERROR_MESSAGE);
return;

}



if (!txtAltura.getText().trim().matches("^\\d+(\\.\\d+)?$")) {
JOptionPane.showMessageDialog(null, "Altura inválida! Use ponto para decimais.", "Erro", JOptionPane.ERROR_MESSAGE);
return;

}



if (!txtAssociacao.getText().trim().matches("^\\d{8}$")) {
JOptionPane.showMessageDialog(null, "A data de associação deve ter 8 números!", "Erro", JOptionPane.ERROR_MESSAGE);
return;

}



if (!txtMatricula.getText().trim().matches("^\\d+$")) {
JOptionPane.showMessageDialog(null, "A matrícula deve conter apenas números!", "Erro", JOptionPane.ERROR_MESSAGE);
return;

}



Atleta.categoria = txtCategoria.getText().trim();
Atleta.peso = Double.parseDouble(txtPeso.getText().trim());
Atleta.altura = Double.parseDouble(txtAltura.getText().trim());
Atleta.associacao = txtAssociacao.getText().trim();
Atleta.matricula = Long.parseLong(txtMatricula.getText().trim());
Atleta.posicao = txtPosicao.getText().trim();
Atleta.equipe = txtEquipe.getText().trim();
Atleta.observacoes = txtObs.getText().trim();



if (Atleta.isEdicao) {
Atleta.isEdicao = false;
JOptionPane.showMessageDialog(null, "Informações atualizadas com sucesso!");
TelaConta conta = new TelaConta();
conta.setVisible(true);
} else {
TelaUsuarioSenha tela = new TelaUsuarioSenha();
tela.setVisible(true);
}

frame.dispose();

}

});

}



private void preencherDadosExistentes() {

if (Atleta.categoria != null) txtCategoria.setText(Atleta.categoria);
if (Atleta.peso != 0.0) txtPeso.setText(String.valueOf(Atleta.peso));
if (Atleta.altura != 0.0) txtAltura.setText(String.valueOf(Atleta.altura));
if (Atleta.associacao != null) txtAssociacao.setText(Atleta.associacao);
if (Atleta.matricula != 0) txtMatricula.setText(String.valueOf(Atleta.matricula));
if (Atleta.posicao != null) txtPosicao.setText(Atleta.posicao);
if (Atleta.equipe != null) txtEquipe.setText(Atleta.equipe);
if (Atleta.observacoes != null) txtObs.setText(Atleta.observacoes);

}



public void mostrarTela() {
frame.setLocationRelativeTo(null);
frame.setVisible(true);

}

}