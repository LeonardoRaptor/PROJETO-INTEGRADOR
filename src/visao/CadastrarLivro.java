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
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLivro frame = new CadastrarLivro();
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
		setBounds(100, 100, 794, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 121, 75, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(0, 33, 75, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gênero:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(0, 69, 75, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Autor:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(29, 94, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Preço:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(29, 153, 46, 14);
		contentPane.add(lblNewLabel_5);

		textNomeL = new JTextField();
		textNomeL.setBounds(95, 30, 248, 20);
		contentPane.add(textNomeL);
		textNomeL.setColumns(10);

		JComboBox<Genero> boxGenero = new JComboBox<Genero>();
		boxGenero.setModel(new DefaultComboBoxModel(new String[] { "Terror", "Ação", "Romance", "Drama", "Fantasia",
				"Poesia", "Conto", "Mangá", "Aventura" }));
		boxGenero.setBounds(95, 61, 248, 22);

		// List<Genero> listaGeneros =
		// for
		boxGenero.addItem(new Genero());
		contentPane.add(boxGenero);

		textQntdL = new JTextField();
		textQntdL.setBounds(95, 118, 248, 20);
		contentPane.add(textQntdL);
		textQntdL.setColumns(10);

		textAutorL = new JTextField();
		textAutorL.setBounds(95, 87, 248, 20);
		contentPane.add(textAutorL);
		textAutorL.setColumns(10);

		textPrecoL = new JTextField();
		textPrecoL.setBounds(95, 150, 248, 20);
		contentPane.add(textPrecoL);
		textPrecoL.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(176, 238, 101, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		contentPane.add(btnCancelar);

		JButton btnCadastrar = new JButton("Cadastrar");
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
		btnCadastrar.setBounds(20, 238, 102, 23);
		contentPane.add(btnCadastrar);

		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(353, 48, 415, 220);
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
					
				}
				
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Gênero", "Autor", "Quantidade", "Preço", "Fornecedor" }));
		scrollPane.setViewportView(table);

		atualizarJTable();

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(10, 185, 89, 14);
		contentPane.add(lblFornecedor);

		textFornecedorL = new JTextField();
		textFornecedorL.setEditable(false);
		textFornecedorL.setBounds(231, 182, 112, 20);
		contentPane.add(textFornecedorL);
		textFornecedorL.setColumns(10);

		JButton btnRemover = new JButton("Excluir");
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
		btnRemover.setBounds(20, 272, 102, 23);
		contentPane.add(btnRemover);

		JButton btnAlterar = new JButton("Alterar");
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
		btnAlterar.setBounds(176, 272, 101, 23);
		contentPane.add(btnAlterar);
		
		JButton btnSelecionar = new JButton("Selecionar");
		CadastrarLivro estajanelaf =this;
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					SelecionarFornecedor slf = new SelecionarFornecedor(estajanelaf);
					slf.setVisible(true);
			}
		});
		btnSelecionar.setBounds(90, 181, 89, 23);
		contentPane.add(btnSelecionar);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(189, 185, 89, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(188, 213, 89, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(231, 213, 112, 20);
		contentPane.add(txtNome);
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
		//boxGenero.setSelectedItem((String)l.getGenero());
		textAutorL.setText(l.getAutor());
		textQntdL.setText(String.valueOf(l.getQtde()));
		textPrecoL.setText(l.getPreco());
		textFornecedorL.setText(String.valueOf(l.getFornecedor()));
	}

	public void setFornecedor(Fornecedor sc) {
		textFornecedorL.setText(String.valueOf(sc.getIdFor()));
		txtNome.setText(String.valueOf(sc.getNomeFor()));
		
	}
}
