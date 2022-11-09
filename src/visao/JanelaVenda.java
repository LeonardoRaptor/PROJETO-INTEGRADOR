package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.BDVenda;
import modelo.Livro;
import modelo.Venda;

public class JanelaVenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3138548207155785040L;
	private JPanel contentPane;
	private JTextField textQuant;
	private JTextField textField;
	private JTable table;
	private BDVenda bdv = new BDVenda();
	private Venda v = new Venda();
	private ArrayList<Livro> livros;
	private int quantidade;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		livros = new ArrayList<>();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 579);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 657, 47);
		contentPane.add(panel);

		JLabel lblVenda = new JLabel("VENDA");
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblVenda.setForeground(new Color(245, 255, 250));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		panel_1.setBounds(32, 57, 586, 438);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Livro:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 12, 65, 19);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 42, 65, 14);
		panel_1.add(lblNewLabel_1);

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
				// int idLivro = Integer.parseInt(textCodLivro.getText());
				quantidade = Integer.parseInt(textQuant.getText());

				Livro l = new Livro();
				l.setQtde(quantidade);

				livros.add(l);

				atualizarJTable();

			}
		});
		btnAdicionarVenda.setBounds(368, 83, 89, 23);
		panel_1.add(btnAdicionarVenda);

		JButton btnRemoverVenda = new JButton("Remover");
		btnRemoverVenda.setBounds(487, 83, 89, 23);
		panel_1.add(btnRemoverVenda);

		JLabel lblSumario = new JLabel("Sumário:");
		lblSumario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumario.setBounds(103, 116, 65, 21);
		panel_1.add(lblSumario);

		JLabel lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorTotal.setBounds(396, 298, 96, 21);
		panel_1.add(lblValorTotal);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(487, 300, 89, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(186, 114, 390, 178);
		panel_1.add(scrollPane);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "QTD", "C\u00F3digo", "Pre\u00E7o" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2_1_1 = new JLabel("Forma de Pagamento:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(10, 336, 158, 21);
		panel_1.add(lblNewLabel_2_1_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Cartão de Crédito", "Cartão de Débito", "Dinheiro (Papel)", "" }));
		comboBox.setBounds(186, 335, 390, 22);
		panel_1.add(comboBox);

		JButton btnNewButton = new JButton("Selecionar");
		JanelaVenda estajanela =this;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarLivro sl = new SelecionarLivro(estajanela);
				Livro l = new Livro();
				// l
				sl.setVisible(true);
			}
		});
		btnNewButton.setBounds(78, 12, 89, 23);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setBounds(78, 40, 89, 23);
		panel_1.add(btnNewButton_1);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(177, 13, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(177, 41, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Funcionário:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(285, 14, 96, 14);
		panel_1.add(lblNewLabel_1_1);

		JButton btnNewButton_1_1 = new JButton("Selecionar");
		btnNewButton_1_1.setBounds(391, 12, 89, 23);
		panel_1.add(btnNewButton_1_1);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(490, 13, 86, 20);
		panel_1.add(textField_3);

		JButton btnVoltar = new JButton("Cancelar Venda");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBounds(10, 506, 133, 23);
		contentPane.add(btnVoltar);

		JButton btnRealizarVenda = new JButton("Realizar venda");
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bdv.cadastro(v);
			}
		});
		btnRealizarVenda.setBounds(524, 506, 123, 23);
		contentPane.add(btnRealizarVenda);

	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "QTD", "Código", "Preço" });

		// BDLivro bdl = new BDLivro();
		// livros = bdl.listarTodos();
		// for (Livro v : livros) {
		// modelo.addRow(new Object[] { v.getNomeLi(), quantidade, v.getIdLi(),
		// Integer.parseInt(v.getPreco())*quantidade
		// });
		// }

		table.setModel(modelo);

	}

	public void setLivro(Livro s) {
		textField_1.setText(String.valueOf(s.getIdLi()));
		
	}
}
