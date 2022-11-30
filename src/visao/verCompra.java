package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.BDCliente;
import controle.BDFunc;
import controle.BDLivro;
import controle.BDVenda;
import controle.ProdutoHasVenda;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Livro;
import modelo.ProVenda;
import modelo.Venda;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class verCompra extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<ProVenda> vendaPro;
	private ProdutoHasVenda bdpv = new ProdutoHasVenda();
	private int idDaquelaVenda;
	private BDVenda bdv = new BDVenda();
	private BDCliente bdc = new BDCliente();
	private BDFunc bdf = new BDFunc();
	private BDLivro bdl = new BDLivro();
	// private int idDaVenda;

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
	 * @param idVenda 
	 */
	public verCompra(int idVenda) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1077, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 148, 867, 262);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID Livro", "Nome Livro", "Quantidade", "Nome Funcionário", "Nome Cliente" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(887, 433, 164, 33);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel
				.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\detalhe venda.png"));
		lblNewLabel.setBounds(0, 0, 1061, 487);
		contentPane.add(lblNewLabel);
		
		idDaquelaVenda=idVenda;
		
		atualizarJTable();
	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID Livro", "Nome Livro", "Quantidade", "Nome Funcionário", "Nome Cliente" });

		vendaPro = bdpv.listarPorIDVenda(idDaquelaVenda);
		for (ProVenda pv : vendaPro) {
			Venda v = bdv.getVendaPorId(idDaquelaVenda);
			int idCli = v.getCliId();
			int idFunc = v.getFunId();
			Cliente c = bdc.getClientePorId(idCli);
			Funcionario f = bdf.getFuncionarioPorId(idFunc);
			Livro l = bdl.getLivroPorId(pv.getIdProduto());
			modelo.addRow(
					new Object[] { pv.getIdProduto(), l.getNomeLi(), pv.getQuantiVenda(), f.getNomeFunc(), c.getNomeCli() });
		}

		table.setModel(modelo);

	}
}
