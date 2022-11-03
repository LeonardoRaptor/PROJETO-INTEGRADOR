package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.BDVenda;
import modelo.Venda;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoricoVenda extends JFrame {

	private JPanel contentPane;

	private int idVenda;
	private BDVenda bdv = new BDVenda();
	private Venda v = new Venda();
	private ArrayList<Venda> vendaPro;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoricoVenda frame = new HistoricoVenda();
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
	public HistoricoVenda() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 774, 178);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Funcionário", "ID Cliente", "Valor", "Quantidade", "Data", "Forma Pagamento" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(695, 227, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso = bdv.removeAq(idVenda);
				if (sucesso == false) {
					JOptionPane.showMessageDialog(null, "Funcionario excluido!");
					atualizarJTable();
				}
			}
		});
		btnNewButton_1.setBounds(596, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Funcionário", "ID Cliente", "Valor", "Quantidade", "Forma Pagamento", "Data" });

		vendaPro = bdv.listarTodos();
		for (Venda v : vendaPro) {
			modelo.addRow(new Object[] { v.getIdVenda(), v.getQtdeVenda(), v.getFunId(), v.getValor(), v.getCliId(),
					v.getData(), v.getFormaPagamento() });
		}

		table.setModel(modelo);

	}
}
