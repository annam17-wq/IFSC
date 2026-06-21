package JComboBoxex1;

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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import JComboBoxex.TipoPlano;
import JComboBoxex.Duracao;
import JComboBoxex.FrequenciaSemanal;

public class JComboBoxex1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblvalorfinal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JComboBoxex1 frame = new JComboBoxex1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JComboBoxex1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);


		contentPane.setLayout(new MigLayout("insets 10", "[][][grow][][][]", "[][][][][][][][][]"));
		//contentPane.setLayout(new MigLayout("", "[1px]", "[1px][][]"));

		JLabel lblNewLabel = new JLabel("Cadastro de Cliente - Academia TREINO FIT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel, "cell 2 1 6 1");

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		contentPane.add(lblNewLabel_1, "cell 1 2,alignx right");

		textField = new JTextField();
		contentPane.add(textField, "cell 2 2 4 1,growx");
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		contentPane.add(lblNewLabel_2, "cell 1 3,alignx right");

		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 2 3 4 1,growx");
		textField_1.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Tipo de Plano:");
		contentPane.add(lblNewLabel_3, "cell 1 4,alignx right");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipoPlano.values()));
		contentPane.add(comboBox, "cell 2 4 4 1,growx");

		JLabel lblNewLabel_4 = new JLabel("Duração:");
		contentPane.add(lblNewLabel_4, "cell 1 5,alignx right");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(Duracao.values()));
		contentPane.add(comboBox_1, "cell 2 5 4 1,growx");

		JLabel lblNewLabel_5 = new JLabel(" Frequência semanal:");
		contentPane.add(lblNewLabel_5, "cell 1 6");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(FrequenciaSemanal.values()));
		contentPane.add(comboBox_2, "cell 2 6 4 1,growx");
				
						JButton btnNewButton = new JButton("Calcular");
						contentPane.add(btnNewButton, "flowx,cell 2 8,alignx left");
						
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								if(textField.getText().isEmpty() || textField_1.getText().isEmpty()) {
									lblvalorfinal.setText("Preencha nome e telefone");
									return;
								}

								TipoPlano plano = (TipoPlano) comboBox.getSelectedItem();
								Duracao duracao = (Duracao) comboBox_1.getSelectedItem();
								FrequenciaSemanal frequencia = (FrequenciaSemanal) comboBox_2.getSelectedItem();

								double valor = plano.valorT;

								valor = valor + (valor * frequencia.valorF);

								valor = valor - (valor * duracao.valorD);

								lblvalorfinal.setText("Valor final: R$ " + String.format("%.2f", valor));
							}
						});
		
						lblvalorfinal = new JLabel("Valor final:");
						contentPane.add(lblvalorfinal, "cell 2 8,alignx center");
	}
}

