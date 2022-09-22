package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Funcionario;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
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
	private JTextField txtNome;
	private JTextField txtTelefone;
	private ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	private Funcionario funcionarioSelecionado;
	private JTextField txtId;
	private JTextField txtEndereco;
	private JTextField txtEmail;

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
		scrollPane.setBounds(10, 210, 414, -197);
		
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
					//nome,cpf
				"C�digo", "Nome","Telefone"
			}
		));
		table.setBounds(0, 0, 414, 184);
		scrollPane.add(table);
		scrollPane.setViewportView(table);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 79, 46, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(69, 77, 142, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(11, 45, 45, 13);
		contentPane.add(lblId);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 192, 58, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(69, 190, 142, 20);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JButton btnAdicionar = new JButton("Salvar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String telefone = txtTelefone.getText();
				String email = txtEmail.getText();
				Funcionario f = new Funcionario();
				f.setNomeFunc(nome);
				f.setTelefone(telefone);
				f.setEmailFunc(email);
				listaFuncionarios.add(f);
				atualizarJTable();
				limparCampos();
				
				
			}
		});
		btnAdicionar.setBounds(11, 230, 87, 23);
		contentPane.add(btnAdicionar);
		
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
		
		
		txtId = new JTextField();
		txtId.setBounds(69, 42, 142, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setBounds(10, 119, 58, 13);
		contentPane.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(69, 116, 142, 19);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 156, 45, 13);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(69, 153, 142, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					txtNome.setText("");
					txtId.setText("");
					txtTelefone.setText("");
					txtEndereco.setText("");
					txtEmail.setText("");
			}
		});
		btnNewButton_1.setBounds(320, 231, 99, 21);
		contentPane.add(btnNewButton_1);
		
		JComboBox SexoBox = new JComboBox();
		SexoBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		SexoBox.setToolTipText("");
		SexoBox.setBounds(284, 189, 142, 21);
		contentPane.add(SexoBox);
	}

	protected void limparCampos() {
		txtNome.setText("");
		txtId.setText("");
		txtTelefone.setText("");
		txtEndereco.setText("");
		txtEmail.setText("");
		
		
	}

	protected void atualizarJTable() {
		DefaultTableModel modelo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C�digo","Nome", "Telefone"
			}
		);
		
		for(int i=0; i< listaFuncionarios.size(); i++) {
			Funcionario f = listaFuncionarios.get(i);
			modelo.addRow(new Object[] { f.getNomeFunc(),f.getEmailFunc() });
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

