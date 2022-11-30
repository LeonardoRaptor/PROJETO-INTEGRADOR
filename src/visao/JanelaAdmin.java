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

import controle.BDFunc;
import modelo.Funcionario;
import javax.swing.ImageIcon;

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
	private ArrayList<Funcionario> lista;

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
		setBounds(100, 100, 1068, 558);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 10, 10);
		contentPane.add(panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(455, 140, 575, 306);
		contentPane.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				idFuncionarioSelecionado = (int) table.getValueAt(row, 0);

				f = lista.get(row);

				// pessoaSelecionada = Funcionario.get(row);
				// textNome.setText(pessoaSelecionada.getNome());
				// txtCPF.setText(pessoaSelecionada.getCpf());

				Funcionario sus = bdfu.getFuncionarioPorId(idFuncionarioSelecionado);
				if (sus != null) {
					recuperarValorT();
				}

			}
		});
		scrollPane.setViewportView(table);
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Email", "Telefone", "CPF" }));
		scrollPane.add(table);
		scrollPane.setViewportView(table);

		atualizarJTable();

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Amiri", Font.BOLD, 24));
		lblNome.setBounds(75, 138, 76, 25);
		contentPane.add(lblNome);

		textNome = new JTextField();
		textNome.setBounds(194, 138, 185, 32);
		contentPane.add(textNome);
		textNome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Amiri", Font.BOLD, 24));
		lblTelefone.setBounds(75, 264, 98, 27);
		contentPane.add(lblTelefone);

		textTelefone = new JTextField();
		textTelefone.setBounds(194, 265, 185, 32);
		contentPane.add(textTelefone);
		textTelefone.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setBackground(new Color(0, 0, 0));
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
		btnCadastrar.setBounds(0, 476, 118, 32);
		contentPane.add(btnCadastrar);

		JButton btnRemover = new JButton("Excluir");
		btnRemover.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRemover.setForeground(new Color(255, 255, 255));
		btnRemover.setBackground(new Color(0, 0, 0));
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso = bdfu.removeAq(idFuncionarioSelecionado);
				if (sucesso == false) {
					JOptionPane.showMessageDialog(null, "Funcionario excluido!");
					atualizarJTable();
					limparCampos();
				}

			}
		});
		btnRemover.setBounds(128, 476, 120, 32);
		contentPane.add(btnRemover);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setBackground(new Color(0, 0, 0));
		btnAlterar.addActionListener(new ActionListener() {
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

					bdfu.alterarFuncionario(f);

				} else {
					JOptionPane.showMessageDialog(btnAlterar, "Erro ao alterar");
				}

				atualizarJTable();
				limparCampos();

			}
		});
		btnAlterar.setBounds(254, 476, 114, 32);
		contentPane.add(btnAlterar);

		JButton btnFechar = new JButton("Voltar");
		btnFechar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnFechar.setBackground(new Color(189, 183, 107));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				JanelaPrincipal jap = new JanelaPrincipal();
				jap.setVisible(true);
			}
		});
		btnFechar.setBounds(916, 476, 114, 32);
		contentPane.add(btnFechar);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Amiri", Font.BOLD, 24));
		lblEmail.setBounds(75, 203, 87, 24);
		contentPane.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setBounds(194, 203, 185, 32);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText("");
				textEmail.setText("");
				textTelefone.setText("");
				textCPF.setText("");
				textSenha.setText("");

			}
		});
		btnNewButton_1.setBounds(378, 476, 114, 32);
		contentPane.add(btnNewButton_1);

		textCPF = new JTextField();
		textCPF.setBounds(194, 329, 185, 32);
		contentPane.add(textCPF);
		textCPF.setColumns(10);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Amiri", Font.BOLD, 24));
		lblCPF.setBounds(75, 331, 87, 21);
		contentPane.add(lblCPF);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Amiri", Font.BOLD, 24));
		lblSenha.setBounds(75, 391, 87, 25);
		contentPane.add(lblSenha);

		textSenha = new JTextField();
		textSenha.setBounds(194, 391, 185, 32);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\CadastroFuncionario.png"));
		lblNewLabel.setBounds(0, 0, 1052, 519);
		contentPane.add(lblNewLabel);
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
		lista = bd.listarTodos();
		for (Funcionario f : lista) {
			modelo.addRow(
					new Object[] { f.getId(), f.getNomeFunc(), f.getEmailFunc(), f.getTelefone(), f.getCpfFunc() });
		}

		table.setModel(modelo);

	}

	protected void recuperarValorT() {
		textNome.setText(f.getNomeFunc());
		textCPF.setText(f.getCpfFunc());
		textEmail.setText(f.getEmailFunc());
		textTelefone.setText(f.getTelefone());
		textSenha.setText(f.getSenhaFunc());
	}
}
