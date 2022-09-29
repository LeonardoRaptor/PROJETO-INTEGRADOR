package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.BDFunc;
import modelo.Funcionario;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class JanelaAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textNome;
	private JTextField textTelefone;
	private ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	private Funcionario funcionarioSelecionado;
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
				int posicaoFuncionario = table.getSelectedRow();
				funcionarioSelecionado = listaFuncionarios.get(posicaoFuncionario);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome","Email", "Telefone", "CPF"
			}
		));
		table.setBounds(0, 0, 414, 184);
		scrollPane.add(table);
		scrollPane.setViewportView(table);
		
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
				String cpf = textCPF.getText();
				String email = textEmail.getText();
				String senha = textSenha.getText();
				String telefone = textTelefone.getText();
				Funcionario f = new Funcionario();
				if (!nome.isEmpty() && !senha.isEmpty() && !cpf.isEmpty() && !email.isEmpty() && !telefone.isEmpty()) {
					
					f.setNomeFunc(textNome.getText());
					f.setEmailFunc(textEmail.getText());
					f.setTelefone(textTelefone.getText());
					f.setCpfFunc(textCPF.getText());
					f.setSenhaFunc(textSenha.getText());
					BDFunc bdfu= new BDFunc();
					bdfu.cadastro();
				} else {
					// erro
					JOptionPane.showMessageDialog(btnCadastrar, "Um ou mais dos Campos não foi preenchidos" );
				}
				BDFunc bdfu= new BDFunc();
				bdfu.cadastro();
				listaFuncionarios.add(f);
				atualizarJTable();
				limparCampos();
				
				
			}
		});
		btnCadastrar.setBounds(11, 230, 87, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnRemover = new JButton("Excluir");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(funcionarioSelecionado != null) {
					int posicao = listaFuncionarios.indexOf(funcionarioSelecionado);
					listaFuncionarios.remove(posicao);
					atualizarJTable();
					limparCampos();
				}
				
			}
		});
		btnRemover.setBounds(108, 230, 93, 23);
		contentPane.add(btnRemover);
		JanelaAdmin estaJanela = this;
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				int posicao = listaFuncionarios.indexOf(funcionarioSelecionado);
				funcionarioSelecionado = listaFuncionarios.get(posicao);
				
				JanelaAlterar janela = new JanelaAlterar(estaJanela, funcionarioSelecionado, posicao);
				janela.setVisible(true);
				
				
				
				
				
			}
		});
		btnAlterar.setBounds(211, 230, 99, 23);
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
		btnNewButton_1.setBounds(320, 231, 99, 21);
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
		DefaultTableModel modelo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Nome", "Email", "Telefone", "CPF"
			}
		);
		
		for(int i=0; i< listaFuncionarios.size(); i++) {
			Funcionario f = listaFuncionarios.get(i);
			modelo.addRow(new Object[] { f.getNomeFunc(),f.getEmailFunc(),f.getTelefone(),f.getCpfFunc() });
		}
		
		table.setModel(modelo);
		
		
	}

	public void alterarFuncionario(int posicao, Funcionario funcionarioSelecionado) {
		listaFuncionarios.set(posicao, funcionarioSelecionado);
		atualizarJTable();
		limparCampos();
		// TODO Auto-generated method stub
		
	}
}

