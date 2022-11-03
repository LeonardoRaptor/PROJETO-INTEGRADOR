package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.BDLivro;
import controle.BDVenda;
import modelo.Livro;
import modelo.Venda;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JanelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField textCodLivro;
	private JTextField textCPFCli;
	private JTextField textQuant;
	private JTextField textField;
	private JTable table;
	private BDVenda bdv = new BDVenda();
	private Venda v = new Venda();
	private ArrayList<Venda> vendaPro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaVenda frame = new JanelaVenda();
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
	public JanelaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(-13, 0, 670, 47);
		contentPane.add(panel);

		JLabel lblVenda = new JLabel("VENDA");
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblVenda.setForeground(new Color(245, 255, 250));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		panel_1.setBounds(32, 57, 586, 371);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Código do Livro:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(49, 12, 119, 19);
		panel_1.add(lblNewLabel);

		textCodLivro = new JTextField();
		textCodLivro.setBounds(186, 11, 390, 24);
		panel_1.add(textCodLivro);
		textCodLivro.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CPF Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(78, 51, 121, 14);
		panel_1.add(lblNewLabel_1);

		textCPFCli = new JTextField();
		textCPFCli.setBounds(186, 48, 390, 24);
		panel_1.add(textCPFCli);
		textCPFCli.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(78, 82, 96, 21);
		panel_1.add(lblNewLabel_2);

		textQuant = new JTextField();
		textQuant.setBounds(186, 83, 172, 22);
		panel_1.add(textQuant);
		textQuant.setColumns(10);

		JButton btnAdicionarVenda = new JButton("Adicionar");
		btnAdicionarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnAdicionarVenda.setBounds(368, 83, 89, 23);
		panel_1.add(btnAdicionarVenda);

		JButton btnRemoverVenda = new JButton("Remover");
		btnRemoverVenda.setBounds(487, 83, 89, 23);
		panel_1.add(btnRemoverVenda);

		JLabel lblSumario = new JLabel("Sumário:");
		lblSumario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumario.setBounds(103, 151, 65, 21);
		panel_1.add(lblSumario);

		JLabel lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorTotal.setBounds(88, 338, 96, 21);
		panel_1.add(lblValorTotal);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(186, 340, 390, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(186, 149, 390, 178);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "QTD", "C\u00F3digo", "Pre\u00E7o" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2_1_1 = new JLabel("Forma de Pagamento:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 117, 158, 21);
		panel_1.add(lblNewLabel_2_1_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Cartão de Crédito", "Cartão de Débito", "Dinheiro (Papel)", "" }));
		comboBox.setBounds(186, 116, 390, 22);
		panel_1.add(comboBox);

		JButton btnVoltar = new JButton("Cancelar Venda");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 449, 133, 23);
		contentPane.add(btnVoltar);

		JButton btnRealizarVenda = new JButton("Realizar venda");
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bdv.cadastro(v);
			}
		});
		btnRealizarVenda.setBounds(524, 449, 123, 23);
		contentPane.add(btnRealizarVenda);

	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "QTD", "Código", "Preço" });

		vendaPro = bdv.listarTodos();
		for (Venda v : vendaPro) {
			modelo.addRow(new Object[] { v.getIdVenda(), v.getQtdeVenda(), v.getProduto(), v.getFunId(), v.getValor(),
					v.getCliId(), v.getData(), v.getFormaPagamento() });
		}

		table.setModel(modelo);

	}
}
