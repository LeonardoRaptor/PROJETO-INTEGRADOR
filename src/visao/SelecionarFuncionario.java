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

import controle.BDFunc;
import modelo.Genero;
import modelo.Funcionario;
import java.awt.Color;

public class SelecionarFuncionario extends JFrame {

	private JPanel contentPane;
	private BDFunc bdli = new BDFunc();
	private Funcionario l = new Funcionario();
	private int idProdutoSelecionado;
	private ArrayList<Funcionario> cadastroFunc;
	private JTable table;

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
	
	public SelecionarFuncionario(JanelaVenda jv) {

		setTitle("Selecionar Livro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 276);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnCancelar = new JButton("Voltar");
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
				idProdutoSelecionado = (int) table.getValueAt(row, 0);

				l = cadastroFunc.get(row);

				Funcionario s = bdli.getFuncionarioPorId(idProdutoSelecionado);
				
				jv.setFun(s);
				
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
				new String[] { "ID", "Nome", "Email", "Telefone", "CPF" });

		BDFunc bd = new BDFunc();
		cadastroFunc = bd.listarTodos();
		for (Funcionario f : cadastroFunc) {
			modelo.addRow(
					new Object[] { f.getId(), f.getNomeFunc(), f.getEmailFunc(), f.getTelefone(), f.getCpfFunc() });
		}

		table.setModel(modelo);

	}
}