package visao;

import java.awt.EventQueue;
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

import controle.BDFunc;
import modelo.Funcionario;

public class JanelaAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textNome;
	private JTextField textTelefone;

	private BDFunc bdfu = new BDFunc();
	private Funcionario f = new Funcionario();
	private int idFuncionarioSelecionado;
	private JTextField textEmail;
	private JTextField textCPF;
	private JTextField textSenha;

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

	public JanelaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(284, 38, 387, 169);

		scrollPane.setBounds(284, 38, 387, 134);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				idFuncionarioSelecionado = (int) table.getValueAt(row, 0);

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Email", "Telefone", "CPF" }));
		table.setBounds(0, 0, 414, 184);
		scrollPane.add(table);
		scrollPane.setViewportView(table);

		atualizarJTable();

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(13, 31, 46, 14);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(69, 28, 142, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(13, 92, 58, 14);
		contentPane.add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(69, 89, 142, 20);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textNome.getText();
				String email = textEmail.getText();
				String telefone = textTelefone.getText();
				String cpf = textCPF.getText();
				String senha = textSenha.getText();

				if (!nome.isEmpty() && !senha.isEmpty() && !cpf.isEmpty() && !email.isEmpty() && !telefone.isEmpty()) {

					f.setNomeFunc(textNome.getText());
					f.setEmailFunc(textEmail.getText());
					f.setTelefone(textTelefone.getText());
					f.setCpfFunc(textCPF.getText());
					f.setSenhaFunc(textSenha.getText());

					BDFunc bdfu = new BDFunc();
					int idCadastrado = bdfu.cadastro(f);
					f.setId(idCadastrado);

				} else {
					JOptionPane.showMessageDialog(btnCadastrar, "Um ou mais dos Campos não foi preenchidos");
				}

				atualizarJTable();
				limparCampos();

			}
		});
		btnCadastrar.setBounds(11, 230, 102, 23);
		contentPane.add(btnCadastrar);

		JButton btnRemover = new JButton("Excluir");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso = bdfu.removeAq(idFuncionarioSelecionado);
				if (sucesso==false) {
					JOptionPane.showMessageDialog(null, "Funcionario excluido!");
					atualizarJTable();
					limparCampos();
				}
				
			}
		});
		btnRemover.setBounds(123, 230, 93, 23);
		contentPane.add(btnRemover);

		// JanelaAdmin estaJanela = this;

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// int posicaoFuncionario = 1;
				// JanelaAlterar janela = new JanelaAlterar(estaJanela, funcionarioSelecionado,
				// posicaoFuncionario);
				// janela.setVisible(true);

			}
		});
		btnAlterar.setBounds(226, 230, 99, 23);
		contentPane.add(btnAlterar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFechar.setBounds(545, 230, 99, 23);
		contentPane.add(btnFechar);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(13, 63, 45, 13);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(69, 59, 142, 19);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText("");
				textEmail.setText("");
				textTelefone.setText("");
				textCPF.setText("");
				textSenha.setText("");

			}
		});
		btnNewButton_1.setBounds(335, 231, 99, 21);
		contentPane.add(btnNewButton_1);

		textCPF = new JTextField();
		textCPF.setBounds(69, 120, 142, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(13, 123, 46, 14);
		contentPane.add(lblCPF);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(13, 158, 46, 14);
		contentPane.add(lblSenha);

		textSenha = new JTextField();
		textSenha.setBounds(69, 152, 142, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
	}

	protected void limparCampos() {
		textNome.setText("");
		textEmail.setText("");
		textTelefone.setText("");
		textCPF.setText("");
		textSenha.setText("");
	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Email", "Telefone", "CPF" });

		BDFunc bd = new BDFunc();
		ArrayList<Funcionario> lista = bd.listarTodos();
		for (Funcionario f : lista) {
			modelo.addRow(
					new Object[] { f.getId(), f.getNomeFunc(), f.getEmailFunc(), f.getTelefone(), f.getCpfFunc() });
		}

		table.setModel(modelo);

	}
}
