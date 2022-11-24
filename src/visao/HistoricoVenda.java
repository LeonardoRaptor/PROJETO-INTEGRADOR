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
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

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
	public HistoricoVenda() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1132, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 147, 1021, 300);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Funcionário", "ID Cliente", "Valor", "Quantidade", "Data", "Forma Pagamento" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(951, 481, 113, 40);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso = bdv.removeAq(idVenda);
				if (sucesso == false) {
					JOptionPane.showMessageDialog(null, "Funcionario excluido!");
					atualizarJTable();
				}
			}
		});
		btnNewButton_1.setBounds(808, 481, 113, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\historico de vendas.png"));
		lblNewLabel.setBounds(0, 0, 1116, 545);
		contentPane.add(lblNewLabel);
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
