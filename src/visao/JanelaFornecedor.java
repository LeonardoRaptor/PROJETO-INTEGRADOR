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
		setBounds(100, 100, 718, 280);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 10, 10);
		contentPane.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 67, 387, 134);
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
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(13, 72, 58, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(81, 71, 167, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefone.setBounds(13, 120, 70, 14);
		contentPane.add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(81, 119, 167, 20);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
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
		btnCadastrar.setBounds(13, 150, 102, 23);
		contentPane.add(btnCadastrar);

		JButton btnRemover = new JButton("Excluir");
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
		btnRemover.setBounds(13, 184, 102, 23);
		contentPane.add(btnRemover);

		JButton btnAlterar = new JButton("Alterar");
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
		btnAlterar.setBounds(149, 150, 99, 23);
		contentPane.add(btnAlterar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(572, 212, 99, 23);
		contentPane.add(btnFechar);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(13, 97, 58, 13);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(81, 95, 167, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText("");
				textEmail.setText("");
				textTelefone.setText("");

			}
		});
		btnNewButton_1.setBounds(149, 184, 99, 21);
		contentPane.add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 702, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblJanelaCadastrar = new JLabel("CADASTRAR FORNECEDOR");
		lblJanelaCadastrar.setBounds(141, 5, 420, 37);
		panel.add(lblJanelaCadastrar);
		lblJanelaCadastrar.setForeground(new Color(245, 255, 250));
		lblJanelaCadastrar.setFont(new Font("Tahoma", Font.BOLD, 30));
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
