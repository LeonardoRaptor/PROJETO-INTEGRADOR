package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

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
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

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
	private Funcionario funSelecionado;
	private Cliente cliSelecionado;

	private Livro l2 = new Livro();
	private Livro liVenda = new Livro();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// JanelaPrincipal frame = new JanelaPrincipal();
					JanelaVenda frame = new JanelaVenda();
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
		setBounds(100, 100, 1163, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JanelaVenda estajanela = this;

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setBounds(10, 507, 189, 38);
		contentPane.add(btnVoltar);

		JButton btnRealizarVenda = new JButton("Realizar venda");
		btnRealizarVenda.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Date data = new Date();

				v.setData(String.valueOf(data));
				v.setFunId(funSelecionado.getId());
				v.setCliId(cliSelecionado.getIdCli());

				bdv.cadastro(v);
			}
		});
		btnRealizarVenda.setBounds(953, 507, 173, 38);
		contentPane.add(btnRealizarVenda);

		textNomeFun = new JTextField();
		textNomeFun.setFont(new Font("Amiri", Font.PLAIN, 20));
		textNomeFun.setBounds(621, 95, 505, 32);
		contentPane.add(textNomeFun);
		textNomeFun.setEditable(false);
		textNomeFun.setColumns(10);

		textNomeCli = new JTextField();
		textNomeCli.setFont(new Font("Amiri", Font.PLAIN, 20));
		textNomeCli.setBounds(621, 138, 505, 32);
		contentPane.add(textNomeCli);
		textNomeCli.setEditable(false);
		textNomeCli.setColumns(10);

		textNomeLi = new JTextField();
		textNomeLi.setFont(new Font("Amiri", Font.PLAIN, 20));
		textNomeLi.setBounds(621, 181, 505, 33);
		contentPane.add(textNomeLi);
		textNomeLi.setEditable(false);
		textNomeLi.setColumns(10);

		JButton btnRemoverVenda = new JButton("Remover");
		btnRemoverVenda.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnRemoverVenda.setBounds(296, 308, 128, 41);
		contentPane.add(btnRemoverVenda);

		JButton btnAdicionarVenda = new JButton("Adicionar");
		btnAdicionarVenda.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnAdicionarVenda.setBounds(110, 308, 134, 41);
		contentPane.add(btnAdicionarVenda);

		txtQtdLivro = new JTextField();
		txtQtdLivro.setBounds(256, 256, 168, 32);
		contentPane.add(txtQtdLivro);
		txtQtdLivro.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setBounds(110, 249, 135, 43);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Amiri", Font.PLAIN, 24));

		txtIdFunc = new JTextField();
		txtIdFunc.setFont(new Font("Amiri", Font.PLAIN, 20));
		txtIdFunc.setBounds(451, 95, 141, 32);
		contentPane.add(txtIdFunc);
		txtIdFunc.setEditable(false);
		txtIdFunc.setColumns(10);

		txtIdCli = new JTextField();
		txtIdCli.setFont(new Font("Amiri", Font.PLAIN, 20));
		txtIdCli.setBounds(451, 138, 141, 32);
		contentPane.add(txtIdCli);
		txtIdCli.setEditable(false);
		txtIdCli.setColumns(10);

		txtIdLivro = new JTextField();
		txtIdLivro.setFont(new Font("Amiri", Font.PLAIN, 20));
		txtIdLivro.setBounds(451, 181, 141, 33);
		contentPane.add(txtIdLivro);
		txtIdLivro.setEditable(false);
		txtIdLivro.setColumns(10);

		JButton btnNewButton_1_1 = new JButton("Selecionar");
		btnNewButton_1_1.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(209, 95, 211, 32);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnNewButton_1.setBounds(209, 138, 211, 32);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnNewButton.setBounds(209, 180, 211, 32);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1_1 = new JLabel("Funcionário:");
		lblNewLabel_1_1.setBounds(64, 96, 135, 27);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Amiri", Font.PLAIN, 24));

		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setBounds(110, 141, 89, 23);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Amiri", Font.PLAIN, 24));

		JLabel lblNewLabel = new JLabel("Livro:");
		lblNewLabel.setBounds(124, 186, 65, 19);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Amiri", Font.PLAIN, 24));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(511, 229, 610, 230);
		contentPane.add(scrollPane);

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

		JLabel lblSumario = new JLabel("Sumário:");
		lblSumario.setBounds(405, 225, 96, 32);
		contentPane.add(lblSumario);
		lblSumario.setFont(new Font("Amiri", Font.PLAIN, 24));

		textField = new JTextField();
		textField.setFont(new Font("Amiri", Font.PLAIN, 22));
		textField.setBounds(953, 466, 133, 32);
		contentPane.add(textField);
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setForeground(Color.WHITE);
		lblValorTotal.setBounds(834, 470, 147, 21);
		contentPane.add(lblValorTotal);
		lblValorTotal.setFont(new Font("Amiri", Font.PLAIN, 24));

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Amiri", Font.PLAIN, 20));
		comboBox.setBounds(685, 507, 248, 31);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Cartão de Crédito", "Cartão de Débito", "Dinheiro (Papel)", "" }));

		JLabel lblNewLabel_2_1_1 = new JLabel("Forma de Pagamento:");
		lblNewLabel_2_1_1.setBounds(464, 515, 211, 21);
		contentPane.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setFont(new Font("Amiri", Font.PLAIN, 24));

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\venda.png"));
		lblNewLabel_3.setBounds(0, 0, 1156, 567);
		contentPane.add(lblNewLabel_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarLivro sl = new SelecionarLivro(estajanela);
				sl.setVisible(true);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCliente sc = new SelecionarCliente(estajanela);
				sc.setVisible(true);
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarFuncionario sf = new SelecionarFuncionario(estajanela);
				sf.setVisible(true);
			}
		});
		btnAdicionarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String qtdLivroStr = txtQtdLivro.getText();

				// boolean realiza;

				for (int i = 0; i < livros.size(); i++) {
					Livro l3 = livros.get(i);
					if (l3.getIdLi() == livroSelecionado.getIdLi()) {
						// realiza = false;
						qtdSelecionadaLivro = l3.getQtde();
						break;
					} else {
						qtdSelecionadaLivro = 0;
					}
				}

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

						// qtdSelecionadaLivro = 0;

						int qtdEstoque = livroSelecionado.getQtde();
						if (qtdEstoque >= qtdDesejada) {
							if (qtdSelecionadaLivro == 0) {
								// if(liVenda.getIdLi()!=)
								int validaQtd = qtdEstoque - qtdDesejada - qtdSelecionadaLivro;

								if ((validaQtd >= 0) /* && (realiza = true) */) {
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
		btnRemoverVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				livros.remove(l2);
				qtdSelecionadaLivro = 0;
				atualizarJTable();
				atualizarValorTotal();
			}
		});

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
		this.cliSelecionado = s;
		txtIdCli.setText(String.valueOf(s.getIdCli()));
		textNomeCli.setText(s.getNomeCli());

	}

	public void setFun(Funcionario s) {
		this.funSelecionado = s;
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
