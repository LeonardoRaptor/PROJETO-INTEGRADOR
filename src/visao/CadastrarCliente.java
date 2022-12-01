package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.BDCliente;
import controle.BDFunc;
import modelo.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;

	private BDCliente bdcl = new BDCliente();

	private JTable tabelaClientes;

	private Cliente c = new Cliente();
	private int idClienteSelecionado;
	private ArrayList<Cliente> listaClientes;

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
	public CadastrarCliente() {
		setTitle("Cadastrar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 577);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(233, 150, 122));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Amiri", Font.PLAIN, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(151, 174, 85, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setFont(new Font("Amiri", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(117, 247, 119, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBackground(new Color(240, 240, 240));
		lblNewLabel_3.setFont(new Font("Amiri", Font.PLAIN, 30));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(117, 308, 119, 23);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("CPF:");
		lblNewLabel_4.setFont(new Font("Amiri", Font.PLAIN, 30));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(151, 383, 85, 25);
		contentPane.add(lblNewLabel_4);

		textField_1 = new JTextField();
		textField_1.setBounds(251, 169, 231, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(251, 242, 231, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(251, 309, 231, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(251, 385, 231, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu men = new Menu();
				men.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(948, 476, 111, 37);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_1.getText();
				String email = textField_3.getText();
				String telefone = textField_2.getText();
				String cpf = textField_4.getText();

				if (!nome.isEmpty() && !cpf.isEmpty() && !email.isEmpty() && !telefone.isEmpty()) {

					c.setNomeCli(textField_1.getText());
					c.setEmailCli(textField_3.getText());
					c.setTelefone(textField_2.getText());
					c.setCpfCli(textField_4.getText());

					BDCliente bdcli = new BDCliente();
					int idCadastrado = bdcli.cadastroCli(c);
					c.setIdCli(idCadastrado);

				} else {
					JOptionPane.showMessageDialog(btnNewButton_1, "Um ou mais dos Campos não foi preenchidos");
				}

				atualizarJTable();
				limparCampos();
			}
		});
		btnNewButton_1.setBounds(26, 477, 132, 36);
		contentPane.add(btnNewButton_1);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnAlterar.setForeground(new Color(255, 255, 255));
		btnAlterar.setBackground(Color.GRAY);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_1.getText();
				String email = textField_3.getText();
				String telefone = textField_2.getText();
				String cpf = textField_4.getText();

				if (!nome.isEmpty() && !cpf.isEmpty() && !email.isEmpty() && !telefone.isEmpty()) {

					c.setNomeCli(textField_1.getText());
					c.setEmailCli(textField_3.getText());
					c.setTelefone(textField_2.getText());
					c.setCpfCli(textField_4.getText());

					bdcl.alterarCliente(c);

				} else {
					JOptionPane.showMessageDialog(btnAlterar, "Erro ao alterar");
				}

				atualizarJTable();
				limparCampos();

			}
		});
		btnAlterar.setBounds(211, 476, 132, 37);
		contentPane.add(btnAlterar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(550, 174, 524, 239);
		contentPane.add(scrollPane);

		tabelaClientes = new JTable();
		tabelaClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = tabelaClientes.getSelectedRow();
				idClienteSelecionado = (int) tabelaClientes.getValueAt(row, 0);

				c = listaClientes.get(row);

				Cliente sus = bdcl.getClientePorId(idClienteSelecionado);
				if (sus != null) {
					recuperarValorT();
				}

			}
		});
		scrollPane.setViewportView(tabelaClientes);
		tabelaClientes.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome", "Email", "Telefone", "CPF" }));
		scrollPane.add(tabelaClientes);
		scrollPane.setViewportView(tabelaClientes);

		atualizarJTable();
		
		JButton btnRemover = new JButton("Excluir");
		btnRemover.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnRemover.setForeground(new Color(255, 255, 255));
		btnRemover.setBackground(Color.GRAY);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso = bdcl.removeAq(idClienteSelecionado);
				if (sucesso == false) {
					JOptionPane.showMessageDialog(null, "Cliente excluido!");
					atualizarJTable();
					limparCampos();
				}

			}
		});
		btnRemover.setBounds(390, 476, 132, 37);
		contentPane.add(btnRemover);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\cadastrar_cliente.png"));
		lblNewLabel.setBounds(0, 0, 1084, 538);
		contentPane.add(lblNewLabel);
	}

	protected void atualizarJTable() {

		DefaultTableModel modelo1 = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Email", "Telefone", "CPF" });

		BDCliente bd = new BDCliente();
		listaClientes = bd.listarTodos();
		for (Cliente c : listaClientes) {
			modelo1.addRow(
					new Object[] { c.getIdCli(), c.getNomeCli(), c.getEmailCli(), c.getTelefone(), c.getCpfCli() });
		}

		tabelaClientes.setModel(modelo1);

	}

	protected void recuperarValorT() {
		textField_1.setText(c.getNomeCli());
		textField_3.setText(c.getCpfCli());
		textField_2.setText(c.getEmailCli());
		textField_4.setText(c.getTelefone());
	}

	protected void limparCampos() {
		textField_1.setText("");
		textField_3.setText("");
		textField_2.setText("");
		textField_4.setText("");
	}
}
