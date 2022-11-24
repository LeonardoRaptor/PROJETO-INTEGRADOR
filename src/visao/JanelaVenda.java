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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.BDLivro;
import controle.BDVenda;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Livro;
import modelo.Venda;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JanelaVenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3138548207155785040L;
	private JPanel contentPane;
	private JTextField txtQtdLivro;
	private JTextField textField;
	private JTable table;
	private BDVenda bdv = new BDVenda();
	private Venda v = new Venda();
	private ArrayList<Livro> livros;

	private JTextField txtIdLivro;
	private JTextField txtIdCli;
	private JTextField txtIdFunc;
	private JTextField textNomeLi;
	private JTextField textNomeCli;
	private JTextField textNomeFun;

	private int qtdSelecionadaLivro;
	private Livro livroSelecionado;

	private Livro l2 = new Livro();
	private Livro liVenda = new Livro();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JanelaVenda() {
		livros = new ArrayList<>();

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 725, 47);
		contentPane.add(panel);

		JLabel lblVenda = new JLabel("VENDA");
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblVenda.setForeground(new Color(245, 255, 250));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		panel_1.setBounds(33, 58, 682, 392);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Livro:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 67, 65, 19);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 42, 65, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(174, 106, 96, 21);
		panel_1.add(lblNewLabel_2);

		txtQtdLivro = new JTextField();
		txtQtdLivro.setBounds(282, 107, 172, 22);
		panel_1.add(txtQtdLivro);
		txtQtdLivro.setColumns(10);

		JButton btnAdicionarVenda = new JButton("Adicionar");
		btnAdicionarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String qtdLivroStr = txtQtdLivro.getText();

				Livro obj = new Livro();

				int index = livros.indexOf(livroSelecionado);

				boolean realiza;
				if ((index >= 0)) {

					// obj = livros.get(index);
					// Livro obj2;
					// for (int i = 0; i < livros.size(); i++) {
					// obj2 = livros.get(i);
					// if (liVenda.getIdLi() == obj2.getIdLi()) {
					realiza = false;
					// break;
					// } else {
					// realiza = true;
					// }
					// }
				} else {
					realiza = true;
					// qtdSelecionadaLivro = 0;
				}

				// if (obj != livroSelecionado) {
				// qtdSelecionadaLivro = 0;

				// }

				if (qtdLivroStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nenhuma quantidade inserida!");
				} else {
					if (txtIdLivro.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Livro não selecionado!");
					} else {

						liVenda.setAutor(livroSelecionado.getAutor());
						liVenda.setFornecedor(livroSelecionado.getFornecedor());
						liVenda.setGenero(livroSelecionado.getGenero());
						liVenda.setIdLi(livroSelecionado.getIdLi());
						liVenda.setNomeLi(livroSelecionado.getNomeLi());
						liVenda.setPreco(livroSelecionado.getPreco());

						int qtdDesejada = Integer.valueOf(qtdLivroStr);
						liVenda.setQtde(qtdDesejada);

						int qtdEstoque = livroSelecionado.getQtde();
						if (qtdEstoque >= qtdDesejada) {
							if (qtdSelecionadaLivro == 0) {
								int validaQtd = qtdEstoque - qtdDesejada - qtdSelecionadaLivro;

								if ((validaQtd >= 0) && (realiza = true)) {
									livros.add(liVenda);
									qtdSelecionadaLivro = qtdDesejada;

									atualizarJTable();
								}
							} else {
								JOptionPane.showMessageDialog(null,
										"Para adicionar mais do mesmo produto, remova primeiro");
							}

						} else {
							JOptionPane.showMessageDialog(null, "Livro fora de estoque ou quantia acima do estoque!");
						}
					}
				}
				atualizarValorTotal();
			}
		});
		btnAdicionarVenda.setBounds(464, 107, 89, 23);
		panel_1.add(btnAdicionarVenda);

		JButton btnRemoverVenda = new JButton("Remover");
		btnRemoverVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livros.remove(l2);
				qtdSelecionadaLivro = 0;
				atualizarJTable();
				atualizarValorTotal();
			}
		});
		btnRemoverVenda.setBounds(583, 107, 89, 23);
		panel_1.add(btnRemoverVenda);

		JLabel lblSumario = new JLabel("Sumário:");
		lblSumario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSumario.setBounds(199, 140, 65, 21);
		panel_1.add(lblSumario);

		JLabel lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorTotal.setBounds(492, 322, 96, 21);
		panel_1.add(lblValorTotal);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(583, 324, 89, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(282, 138, 390, 178);
		panel_1.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				l2 = livros.get(row);

				recuperarValorT();

			}
		});
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "QTD", "Pre\u00E7o" }));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2_1_1 = new JLabel("Forma de Pagamento:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(106, 360, 158, 21);
		panel_1.add(lblNewLabel_2_1_1);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Cartão de Crédito", "Cartão de Débito", "Dinheiro (Papel)", "" }));
		comboBox.setBounds(282, 359, 390, 22);
		panel_1.add(comboBox);

		JButton btnNewButton = new JButton("Selecionar");
		JanelaVenda estajanela = this;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarLivro sl = new SelecionarLivro(estajanela);
				sl.setVisible(true);
			}
		});
		btnNewButton.setBounds(116, 67, 185, 23);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCliente sc = new SelecionarCliente(estajanela);
				sc.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(116, 40, 185, 23);
		panel_1.add(btnNewButton_1);

		txtIdLivro = new JTextField();
		txtIdLivro.setEditable(false);
		txtIdLivro.setBounds(311, 67, 86, 20);
		panel_1.add(txtIdLivro);
		txtIdLivro.setColumns(10);

		txtIdCli = new JTextField();
		txtIdCli.setEditable(false);
		txtIdCli.setBounds(311, 40, 86, 20);
		panel_1.add(txtIdCli);
		txtIdCli.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Funcionário:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 13, 96, 14);
		panel_1.add(lblNewLabel_1_1);

		JButton btnNewButton_1_1 = new JButton("Selecionar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarFuncionario sf = new SelecionarFuncionario(estajanela);
				sf.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(116, 11, 185, 23);
		panel_1.add(btnNewButton_1_1);

		txtIdFunc = new JTextField();
		txtIdFunc.setEditable(false);
		txtIdFunc.setColumns(10);
		txtIdFunc.setBounds(311, 11, 86, 20);
		panel_1.add(txtIdFunc);

		textNomeLi = new JTextField();
		textNomeLi.setEditable(false);
		textNomeLi.setBounds(407, 67, 265, 20);
		panel_1.add(textNomeLi);
		textNomeLi.setColumns(10);

		textNomeCli = new JTextField();
		textNomeCli.setEditable(false);
		textNomeCli.setBounds(407, 40, 265, 20);
		panel_1.add(textNomeCli);
		textNomeCli.setColumns(10);

		textNomeFun = new JTextField();
		textNomeFun.setEditable(false);
		textNomeFun.setBounds(407, 11, 265, 20);
		panel_1.add(textNomeFun);
		textNomeFun.setColumns(10);

		JButton btnVoltar = new JButton("Cancelar Venda");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 460, 133, 23);
		contentPane.add(btnVoltar);

		JButton btnRealizarVenda = new JButton("Realizar venda");
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bdv.cadastro(v);
			}
		});
		btnRealizarVenda.setBounds(592, 460, 123, 23);
		contentPane.add(btnRealizarVenda);

	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "Código", "Nome", "QTD", "Preço" });

		// BDLivro bdl = new BDLivro();
		// livros = bdl.listarTodos();
		for (Livro livro : livros) {

			modelo.addRow(new Object[] { livro.getIdLi(), livro.getNomeLi(), String.valueOf(livro.getQtde()),
					String.valueOf(livro.getPreco()) });
		}

		table.setModel(modelo);

	}

	public void setLivro(Livro livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
		txtIdLivro.setText(String.valueOf(this.livroSelecionado.getIdLi()));
		textNomeLi.setText(this.livroSelecionado.getNomeLi());

	}

	public void setCliente(Cliente s) {
		txtIdCli.setText(String.valueOf(s.getIdCli()));
		textNomeCli.setText(s.getNomeCli());

	}

	public void setFun(Funcionario s) {
		txtIdFunc.setText(String.valueOf(s.getId()));
		textNomeFun.setText(s.getNomeFunc());

	}

	protected void recuperarValorT() {
		livroSelecionado = l2;
		textNomeLi.setText(l2.getNomeLi());
		txtIdLivro.setText(String.valueOf(l2.getIdLi()));
	}

	protected void atualizarValorTotal() {
		double valor = 0;
		for (int i = 0; i < livros.size(); i++) {
			Livro l3 = livros.get(i);
			valor += Double.parseDouble(l3.getPreco()) * l3.getQtde();
		}
		textField.setText(String.valueOf(valor));
	}
}
