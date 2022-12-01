package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Fornecedor;
import modelo.Genero;
import modelo.Livro;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.BDLivro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import controle.BDFornecedor;
import javax.swing.ImageIcon;

public class CadastrarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeL;
	private JTextField textQntdL;
	private JTextField textAutorL;
	private BDLivro bdli = new BDLivro();
	private JTextField textPrecoL;
	private Livro l = new Livro();
	private int idProdutoSelecionado;
	private ArrayList<Livro> cadastroLibro;
	private JTable table;
	private JTextField textFornecedorL;
	private BDFornecedor bdf = new BDFornecedor();

	private JTextField textNome;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public CadastrarLivro() {

		setTitle("Cadastro de Livros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1127, 539);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		//cadastrarLivro.setExtendedState(JFrame. MAXIMIZED_BOTH);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(-1, 259, 134, 43);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(0, 112, 134, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gênero:");
		lblNewLabel_3.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(48, 173, 85, 21);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Autor:");
		lblNewLabel_4.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(59, 229, 75, 19);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Preço:");
		lblNewLabel_5.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(0, 313, 133, 30);
		contentPane.add(lblNewLabel_5);

		textNomeL = new JTextField();
		textNomeL.setBounds(140, 108, 226, 32);
		contentPane.add(textNomeL);
		textNomeL.setColumns(10);

		JComboBox<Genero> boxGenero = new JComboBox<Genero>();
		boxGenero.setFont(new Font("Amiri", Font.PLAIN, 20));
		boxGenero.setModel(new DefaultComboBoxModel(new String[] { "Terror", "Ação", "Romance", "Drama", "Fantasia",
				"Poesia", "Conto", "Mangá", "Aventura" }));
		boxGenero.setBounds(140, 158, 226, 43);

		// List<Genero> listaGeneros =
		// for
		boxGenero.addItem(new Genero());
		contentPane.add(boxGenero);

		textQntdL = new JTextField();
		textQntdL.setBounds(140, 263, 226, 30);
		contentPane.add(textQntdL);
		textQntdL.setColumns(10);

		textAutorL = new JTextField();
		textAutorL.setBounds(140, 218, 226, 30);
		contentPane.add(textAutorL);
		textAutorL.setColumns(10);

		textPrecoL = new JTextField();
		textPrecoL.setBounds(140, 316, 226, 30);
		contentPane.add(textPrecoL);
		textPrecoL.setColumns(10);

		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnCancelar.setBounds(964, 463, 134, 36);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu men = new Menu();
				men.setVisible(true);
				dispose();

			}
		});
		contentPane.add(btnCancelar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(Color.GRAY);
		btnCadastrar.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNomeL.getText();
				String genero = (String) boxGenero.getSelectedItem();
				String autor = textAutorL.getText();
				String qntd = textQntdL.getText();
				String preco = textPrecoL.getText();
				String fornecedor = textFornecedorL.getText();

				if (!nome.isEmpty() && !autor.isEmpty() && !qntd.isEmpty() && !preco.isEmpty()
						&& !fornecedor.isEmpty()) {

					l.setNomeLi(textNomeL.getText());
					l.setGenero((String) boxGenero.getSelectedItem());
					l.setAutor(textAutorL.getText());
					l.setQtde(Integer.parseInt(textQntdL.getText()));
					l.setPreco(textPrecoL.getText());
					l.setFornecedor(Integer.parseInt(textFornecedorL.getText()));

					BDLivro bdli = new BDLivro();
					int idCadastradoL = bdli.cadastroLi(l);
					l.setIdLi(idCadastradoL);

				} else {
					JOptionPane.showMessageDialog(btnCadastrar, "Um ou mais dos Campos não foi preenchidos");
				}

				atualizarJTable();
				limparCampos();

			}
		});
		btnCadastrar.setBounds(326, 463, 134, 36);
		contentPane.add(btnCadastrar);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(396, 129, 693, 317);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				idProdutoSelecionado = (int) table.getValueAt(row, 0);

				l = cadastroLibro.get(row);

				Livro sos = bdli.getLivroPorId(idProdutoSelecionado);
				if (sos != null) {
					recuperarValorTotal();
					returnFornecedor();

				}

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Gênero", "Autor", "Quantidade", "Preço", "Fornecedor" }));
		scrollPane.setViewportView(table);

		atualizarJTable();

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblFornecedor.setBounds(4, 367, 143, 22);
		contentPane.add(lblFornecedor);

		textFornecedorL = new JTextField();
		textFornecedorL.setEditable(false);
		textFornecedorL.setBounds(307, 366, 60, 30);
		contentPane.add(textFornecedorL);
		textFornecedorL.setColumns(10);

		JButton btnRemover = new JButton("Excluir");
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setBackground(Color.GRAY);
		btnRemover.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso = bdli.removeAqui(idProdutoSelecionado);
				if (sucesso == false) {
					JOptionPane.showMessageDialog(null, "Produto excluido!");
					atualizarJTable();
					limparCampos();
				}

			}
		});
		btnRemover.setBounds(25, 465, 122, 33);
		contentPane.add(btnRemover);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(Color.GRAY);
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNomeL.getText();
				String genero = (String) boxGenero.getSelectedItem();
				String autor = textAutorL.getText();
				String qntd = textQntdL.getText();
				String preco = textPrecoL.getText();
				String fornecedor = textFornecedorL.getText();

				if (!nome.isEmpty() && !autor.isEmpty() && !qntd.isEmpty() && !preco.isEmpty()
						&& !fornecedor.isEmpty()) {

					l.setNomeLi(textNomeL.getText());
					l.setGenero((String) boxGenero.getSelectedItem());
					l.setAutor(textAutorL.getText());
					l.setQtde(Integer.parseInt(textQntdL.getText()));
					l.setPreco(textPrecoL.getText());
					l.setFornecedor(Integer.parseInt(textFornecedorL.getText()));

					bdli.alterarLivro(l);

				} else {
					JOptionPane.showMessageDialog(btnAlterar, "Erro ao alterar");
				}

				atualizarJTable();
				limparCampos();

			}
		});
		btnAlterar.setBounds(166, 464, 134, 35);
		contentPane.add(btnAlterar);

		textNome = new JTextField();
		textNome.setEditable(false);
		textNome.setColumns(10);
		textNome.setBounds(214, 407, 153, 33);
		contentPane.add(textNome);

		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Amiri", Font.PLAIN, 20));
		CadastrarLivro estajanelaL = this;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarFornecedor sf = new SelecionarFornecedor(estajanelaL);
				sf.setVisible(true);
			}
		});
		btnNewButton.setBounds(140, 362, 122, 36);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_6 = new JLabel("ID:");
		lblNewLabel_6.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblNewLabel_6.setBounds(272, 362, 46, 37);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("Nome Fornecedor:");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6_1.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblNewLabel_6_1.setBounds(-2, 421, 206, 19);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\Telas redimencionadas\\CadLivre.png"));
		lblNewLabel.setBounds(-2, 0, 1118, 507);
		contentPane.add(lblNewLabel);
	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Gênero", "Autor", "Quantidade", "Preço", "Fornecedor" });

		BDLivro bdl = new BDLivro();
		cadastroLibro = bdl.listarTodos();
		for (Livro l : cadastroLibro) {
			modelo.addRow(new Object[] { l.getIdLi(), l.getNomeLi(), l.getGenero(), l.getAutor(), l.getQtde(),
					l.getPreco(), l.getFornecedor() });
		}

		table.setModel(modelo);

	}

	protected void limparCampos() {
		textNomeL.setText("");
		textAutorL.setText("");
		textPrecoL.setText("");
		textQntdL.setText("");
		textFornecedorL.setText("");
	}

	protected void recuperarValorTotal() {
		
		textNomeL.setText(l.getNomeLi());
		// boxGenero.setSelectedItem((String)l.getGenero());
		textAutorL.setText(l.getAutor());
		textQntdL.setText(String.valueOf(l.getQtde()));
		textPrecoL.setText(l.getPreco());
		textFornecedorL.setText(String.valueOf(l.getFornecedor()));
		//txtNome.setText();
	}

	public void setFornecedor(Fornecedor sc) {
		textFornecedorL.setText(String.valueOf(sc.getIdFor()));
		textNome.setText(String.valueOf(sc.getNomeFor()));

	}

	protected void returnFornecedor() {
		Fornecedor f = bdf.getFornecedorPorId(Integer.parseInt(textFornecedorL.getText()));
		textNome.setText(f.getNomeFor());
	}

}
