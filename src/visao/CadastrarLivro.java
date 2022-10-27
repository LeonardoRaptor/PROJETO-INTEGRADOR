package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Funcionario;
import modelo.Genero;
import modelo.Livro;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.BDFunc;
import controle.BDLivro;

public class CadastrarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textQntd;
	private JTextField textAutor;
	private JTextField textPreco;
	private Livro l = new Livro();
	private ArrayList<Livro> cadastro;
	private JTable table;

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

		Livro x = new Livro();
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
		lblNewLabel_1.setBounds(0, 197, 75, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(0, 89, 75, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Gênero:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(0, 140, 75, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Autor:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(29, 172, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Preço:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(27, 232, 46, 14);
		contentPane.add(lblNewLabel_5);

		textNome = new JTextField();
		textNome.setBounds(95, 86, 192, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JComboBox<Genero> boxGenero = new JComboBox<Genero>();
		boxGenero.setModel(new DefaultComboBoxModel(new String[] {"Terror", "Ação", "Romance", "Drama", "Fantasia", "Poesia", "Conto", "Mangá", "Aventura"}));
		boxGenero.setBounds(95, 136, 192, 22);
		
		// List<Genero> listaGeneros = 
		// for
		boxGenero.addItem(new Genero());
		contentPane.add(boxGenero);

		textQntd = new JTextField();
		textQntd.setBounds(95, 194, 192, 20);
		contentPane.add(textQntd);
		textQntd.setColumns(10);

		textAutor = new JTextField();
		textAutor.setBounds(95, 169, 192, 20);
		contentPane.add(textAutor);
		textAutor.setColumns(10);

		textPreco = new JTextField();
		textPreco.setBounds(95, 229, 192, 20);
		contentPane.add(textPreco);
		textPreco.setColumns(10);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(194, 260, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		contentPane.add(btnCancelar);

		JButton btnCadastrar = new JButton("Cadastrar"); // começa aqui o botão de cadastro
		btnCadastrar.setBounds(76, 260, 89, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String quantidades = textQntd.getText();
				String nome = textNome.getText();
				String autor = textAutor.getText();
				String preco = textPreco.getText();
				String genero = boxGenero.getName();
				if ((nome != null) && (autor != null) && (quantidades != null)) {

					// colocando tudo q vai ser cadastrado, todas as variáveis.. eu acho?

					nome = textNome.getText();

					autor = textAutor.getText();

					Integer quantidade = Integer.parseInt(quantidades);

					x.setNomeLi(nome);
					x.setAutor(autor);
					x.setGenero(genero); // enquanto não tiver banco de dados integrado, o botao nao vai rodar pq
					x.setQuantidade(quantidade);
					x.setPreco(preco);

					Adicionado frame1 = new Adicionado();
					frame1.setVisible(true);
					btnCadastrar.setEnabled(false);
				}
			}
		});
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 89, 415, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Gênero", "Autor", "Quantidade", "Preço"
			}
		));
		scrollPane.setViewportView(table);
		
	}


protected void atualizarJTable() {

	DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
			new String[] { "ID", "Nome", "Email", "Telefone", "CPF" });

	BDLivro bdl = new BDLivro();
	cadastro = bdl.listarTodos();
	for (Livro l : cadastro) {
		modelo.addRow(
				new Object[] { l.getIdLi(), l.getNomeLi(), l.getGenero(), l.getAutor(), l.getQtde(), l.getPreco() });
	}

	table.setModel(modelo);

}
}

