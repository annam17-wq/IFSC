import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jradio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jradio frame = new Jradio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Jradio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);

	
		contentPane.setLayout(new MigLayout("insets 10", "[right][grow][grow][grow]", "[][][][][][][]"));

		JLabel lblNewLabel = new JLabel("Cadastro de Cliente - Academia TREINO FIT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel, "cell 0 0 4 1,align center");

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		contentPane.add(lblNewLabel_1, "cell 0 1");

		textField = new JTextField();
		contentPane.add(textField, "cell 1 1 3 1,growx");

		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		contentPane.add(lblNewLabel_2, "cell 0 2");

		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 2 3 1,growx");

		JLabel lblNewLabel_3 = new JLabel("Tipo de Plano:");
		contentPane.add(lblNewLabel_3, "cell 0 3");

		JRadioButton rdbBasico = new JRadioButton("Básico");
		buttonGroup.add(rdbBasico);
		contentPane.add(rdbBasico, "cell 1 3");

		JRadioButton rdbIntermediario = new JRadioButton("Intermediário");
		buttonGroup.add(rdbIntermediario);
		contentPane.add(rdbIntermediario, "cell 2 3");

		JRadioButton rdbPremium = new JRadioButton("Premium");
		buttonGroup.add(rdbPremium);
		contentPane.add(rdbPremium, "cell 3 3");

		JLabel lblNewLabel_4 = new JLabel("Duração:");
		contentPane.add(lblNewLabel_4, "cell 0 4");

		JRadioButton rdbMensal = new JRadioButton("Mensal");
		buttonGroup_1.add(rdbMensal);
		contentPane.add(rdbMensal, "cell 1 4");

		JRadioButton rdbSemestral = new JRadioButton("Semestral");
		buttonGroup_1.add(rdbSemestral);
		contentPane.add(rdbSemestral, "cell 2 4");

		JRadioButton rdbAnual = new JRadioButton("Anual");
		buttonGroup_1.add(rdbAnual);
		contentPane.add(rdbAnual, "cell 3 4");

		JLabel lblNewLabel_5 = new JLabel("Frequência semanal:");
		contentPane.add(lblNewLabel_5, "cell 0 5");

		JRadioButton rdb2x = new JRadioButton("2x por semana");
		buttonGroup_2.add(rdb2x);
		contentPane.add(rdb2x, "cell 1 5");

		JRadioButton rdb3X = new JRadioButton("3x por semana");
		buttonGroup_2.add(rdb3X);
		contentPane.add(rdb3X, "cell 2 5");

		JRadioButton rdb5x = new JRadioButton("5x por semana");
		buttonGroup_2.add(rdb5x);
		contentPane.add(rdb5x, "cell 3 5");

		JLabel lblvalorfinal = new JLabel("Valor final:");
		contentPane.add(lblvalorfinal, "cell 2 6 2 1,align left");

		JButton btnNewButton = new JButton("Calcular");
		contentPane.add(btnNewButton, "cell 1 6,align center");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String plano = "";
				String frequencia = "";
				int duracao = 0;

				if (rdbBasico.isSelected()) plano = "B";
				else if (rdbIntermediario.isSelected()) plano = "I";
				else if (rdbPremium.isSelected()) plano = "P";

				if (rdbMensal.isSelected()) frequencia = "M";
				else if (rdbSemestral.isSelected()) frequencia = "S";
				else if (rdbAnual.isSelected()) frequencia = "A";

				if (rdb2x.isSelected()) duracao = 2;
				else if (rdb3X.isSelected()) duracao = 3;
				else if (rdb5x.isSelected()) duracao = 5;

				Academia a = new Academia();
				double resultado = a.calcular(plano, duracao, frequencia);

				lblvalorfinal.setText("Valor final: R$ " + resultado);
			}
		});
	}
}
