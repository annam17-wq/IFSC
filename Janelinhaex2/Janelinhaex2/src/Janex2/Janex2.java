package Janex2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Janex2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janex2 frame = new Janex2();
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
	public Janex2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(116, 73, 181, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 104, 181, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(43, 75, 53, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sobrenome:");
		lblNewLabel_1.setBounds(43, 103, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(116, 200, 200, 20); 
		lblResultado.setVisible(false);
		contentPane.add(lblResultado);
		
		JButton btnNewButton = new JButton("Mostrar nome completo");
		btnNewButton.setBounds(116, 147, 181, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(e -> {
		    String nome = textField.getText();
		    String sobrenome = textField_1.getText();

		    lblResultado.setText(nome + " " + sobrenome);
		    lblResultado.setVisible(true); 
		});

	}
}
