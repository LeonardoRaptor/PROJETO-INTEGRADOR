package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.BDFornecedor;
import modelo.Fornecedor;
import javax.swing.ImageIcon;

public class JanelaFornecedor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textNome;
	private JTextField textTelefone;

	private BDFornecedor bdfu = new BDFornecedor();
	private Fornecedor forn = new Fornecedor();
	private int idFornecedorSelecionado;
	private JTextField textEmail;
	private ArrayList<Fornecedor> listaFornecedor;

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

	public JanelaFornecedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1171, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(422, 131, 723, 355);
		contentPane.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				idFornecedorSelecionado = (int) table.getValueAt(row, 0);

				forn = listaFornecedor.get(row);

				Fornecedor sus = bdfu.getFornecedorPorId(idFornecedorSelecionado);
				if (sus != null) {
					recuperarValorT();
				}

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Email", "Telefone" }));
		scrollPane.add(table);
		scrollPane.setViewportView(table);

		atualizarJTable();

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Amiri", Font.PLAIN, 30));
		lblNome.setBounds(44, 219, 89, 29);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(143, 223, 241, 29);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Amiri", Font.PLAIN, 30));
		lblTelefone.setBounds(14, 338, 119, 24);
		contentPane.add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(142, 338, 242, 29);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				String email = textEmail.getText();
				String telefone = textTelefone.getText();

				if (!nome.isEmpty() && !email.isEmpty() && !telefone.isEmpty()) {

					forn.setNomeFor(textNome.getText());
					forn.setEmailFor(textEmail.getText());
					forn.setTelefoneFor(textTelefone.getText());

					BDFornecedor bdFornecedor = new BDFornecedor();
					int idCadastrado = bdFornecedor.cadastroFor(forn);
					forn.setIdFor(idCadastrado);

				} else {
					JOptionPane.showMessageDialog(btnCadastrar, "Um ou mais dos Campos não foi preenchidos");
				}

				atualizarJTable();
				limparCampos();

			}
		});
		btnCadastrar.setBounds(81, 420, 126, 29);
		contentPane.add(btnCadastrar);

		JButton btnRemover = new JButton("Excluir");
		btnRemover.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso = bdfu.removeAq(idFornecedorSelecionado);
				if (sucesso == false) {
					JOptionPane.showMessageDialog(null, "Fornecedor excluido!");
					atualizarJTable();
					limparCampos();
				}

			}
		});
		btnRemover.setBounds(81, 470, 126, 29);
		contentPane.add(btnRemover);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				String email = textEmail.getText();
				String telefone = textTelefone.getText();

				if (!nome.isEmpty() && !email.isEmpty() && !telefone.isEmpty()) {

					forn.setNomeFor(textNome.getText());
					forn.setEmailFor(textEmail.getText());
					forn.setTelefoneFor(textTelefone.getText());

					bdfu.alterarFornecedor(forn);

				} else {
					JOptionPane.showMessageDialog(btnAlterar, "Erro ao alterar");
				}

				atualizarJTable();
				limparCampos();

			}
		});
		btnAlterar.setBounds(258, 420, 126, 29);
		contentPane.add(btnAlterar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(1012, 497, 133, 30);
		contentPane.add(btnFechar);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Amiri", Font.PLAIN, 30));
		lblEmail.setBounds(35, 274, 119, 36);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(142, 282, 242, 29);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText("");
				textEmail.setText("");
				textTelefone.setText("");

			}
		});
		btnNewButton_1.setBounds(258, 472, 126, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\cadastrar_fornecedor.png"));
		lblNewLabel.setBounds(0, 0, 1226, 545);
		contentPane.add(lblNewLabel);
	}

	protected void limparCampos() {
		textNome.setText("");
		textEmail.setText("");
		textTelefone.setText("");

	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Email", "Telefone"});

		BDFornecedor bd = new BDFornecedor();
		listaFornecedor = bd.listarTodos();
		for (Fornecedor f : listaFornecedor) {
			modelo.addRow(new Object[] { f.getIdFor(), f.getNomeFor(), f.getEmailFor(), f.getTelefoneFor() });
		}

		table.setModel(modelo);

	}

	protected void recuperarValorT() {
		textNome.setText(forn.getNomeFor());
		textEmail.setText(forn.getEmailFor());
		textTelefone.setText(forn.getTelefoneFor());
	}
}
