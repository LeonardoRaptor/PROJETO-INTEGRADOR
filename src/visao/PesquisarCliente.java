package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PesquisarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeCli;
	private JTextField textCPFCli;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisarCliente frame = new PesquisarCliente();
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
	public PesquisarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 558, 46);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("PROCURAR CLIENTES");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(245, 255, 250));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		panel_1.setBounds(33, 61, 494, 296);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCPFCli = new JLabel("CPF:\r\n");
		lblCPFCli.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCPFCli.setBounds(30, 52, 44, 26);
		panel_1.add(lblCPFCli);
		
		JLabel lblNomeCli = new JLabel("Nome:");
		lblNomeCli.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNomeCli.setBounds(10, 11, 66, 26);
		panel_1.add(lblNomeCli);
		
		textNomeCli = new JTextField();
		textNomeCli.setBounds(96, 10, 219, 27);
		panel_1.add(textNomeCli);
		textNomeCli.setColumns(10);
		
		textCPFCli = new JTextField();
		textCPFCli.setColumns(10);
		textCPFCli.setBounds(96, 51, 219, 27);
		panel_1.add(textCPFCli);
		
		JButton btnBuscarCli = new JButton("BUSCAR");
		btnBuscarCli.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscarCli.setBounds(338, 53, 123, 37);
		panel_1.add(btnBuscarCli);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 98, 384, 187);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "NOME", "CPF", "EMAIL", "TELEFONE"
			}
		));
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(338, 6, 123, 37);
		panel_1.add(btnVoltar);
		
	}
}
