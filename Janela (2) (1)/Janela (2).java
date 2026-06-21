import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Janela() {
		setBackground(Color.GREEN);
		setForeground(new Color(0, 255, 64));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 64));
		contentPane.setForeground(new Color(0, 255, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtNomecaixa = new JLabel("Nome:");
		txtNomecaixa.setBounds(102, 93, 46, 14);
		contentPane.add(txtNomecaixa);
		
		txtNome = new JTextField();
		txtNome.setText("Anna");
		txtNome.setBounds(136, 90, 86, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(102, 121, 46, 14);
		contentPane.add(lblCpf);
		
		textField = new JTextField();
		textField.setText("Anna");
		textField.setColumns(10);
		textField.setBounds(136, 118, 86, 20);
		contentPane.add(textField);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(88, 149, 46, 14);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setText("Anna");
		textField_1.setColumns(10);
		textField_1.setBounds(136, 146, 86, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    setVisible(false);
			}
		});
		btnNewButton.setBounds(133, 200, 109, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Mostrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				JOptionPane.showMessageDialog(null,"Olá "+ nome);
			}
		});
		btnNewButton_1.setBounds(263, 197, 86, 36);
		contentPane.add(btnNewButton_1);

	}
}
