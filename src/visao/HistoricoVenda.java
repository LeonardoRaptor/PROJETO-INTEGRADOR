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
import modelo.Cliente;
import modelo.Venda;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		setBounds(100, 100, 1116, 545);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 163, 988, 272);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Funcionário", "ID Cliente", "Valor", "Quantidade", "Data", "Forma Pagamento" }));
		scrollPane.setViewportView(table);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Amiri", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu men = new Menu();
				men.setVisible(true);
				dispose();
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				idVenda = (int) table.getValueAt(row, 0);
				
				verCompra ver = new verCompra(idVenda);
				
				ver.setVisible(true);

			}
		});
		btnNewButton.setBounds(949, 461, 116, 45);
		contentPane.add(btnNewButton);

		atualizarJTable();

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(
				new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\Telas redimencionadas\\Tela Venda.png"));
		lblNewLabel.setBounds(0, 0, 1100, 552);
		contentPane.add(lblNewLabel);
	}

	protected void atualizarJTable() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Quantidade", "Valor", "Funcionário", "ID Cliente", "Data", "FormaPagamento" });

		vendaPro = bdv.listarTodos();
		for (Venda v : vendaPro) {
			modelo.addRow(new Object[] { v.getIdVenda(), v.getQtdeVenda(), v.getValor(), v.getFunId(), v.getCliId(),
					v.getData(), v.getFormaPagamento() });
		}

		table.setModel(modelo);

	}
	
}
