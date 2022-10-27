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
					CadastrarCliente frame = new CadastrarCliente();
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
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 14, 58, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 39, 58, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 64, 58, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("CPF:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(10, 89, 58, 14);
		contentPane.add(lblNewLabel_4);

		textField_1 = new JTextField();
		textField_1.setBounds(78, 11, 346, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(78, 36, 346, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(78, 61, 346, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(78, 86, 346, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(335, 307, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Cadastrar");
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
		btnNewButton_1.setBounds(10, 307, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnAlterar = new JButton("Alterar");
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
		btnAlterar.setBounds(113, 307, 99, 23);
		contentPane.add(btnAlterar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 114, 404, 182);
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
		btnRemover.setBounds(232, 307, 93, 23);
		contentPane.add(btnRemover);
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
