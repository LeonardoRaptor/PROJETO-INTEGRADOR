package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.BDCliente;
import modelo.Genero;
import modelo.Cliente;
import java.awt.Color;

public class SelecionarCliente extends JFrame {

	private JPanel contentPane;
	private BDCliente bdcli = new BDCliente();
	private Cliente l = new Cliente();
	private int idClienteSelecionado;
	private ArrayList<Cliente> cadastroCliente;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	public SelecionarCliente(JanelaVenda jv) {

		setTitle("Selecionar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 276);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(679, 205, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 11, 758, 183);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				idClienteSelecionado = (int) table.getValueAt(row, 0);

				l = cadastroCliente.get(row);

				Cliente s = bdcli.getClientePorId(idClienteSelecionado);
				
				jv.setCliente(s);
				
				setVisible(false);

			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Gênero", "Autor", "Quantidade", "Preço", "Fornecedor" }));
		scrollPane.setViewportView(table);

		atualizarJTable();
	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Email", "Telefone", "CPF"});

		BDCliente bdl = new BDCliente();
		cadastroCliente = bdl.listarTodos();
		for (Cliente l : cadastroCliente) {
			modelo.addRow(new Object[] { l.getIdCli(), l.getNomeCli(), l.getEmailCli(), l.getTelefone(), l.getCpfCli() });	
		}

		table.setModel(modelo);

	}
}