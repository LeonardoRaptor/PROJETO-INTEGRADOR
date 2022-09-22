package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class JanelaAdmin extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAdmin frame = new JanelaAdmin();
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
	public JanelaAdmin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 414, -197);
		scrollPane.setViewportView(table);
		
		table = new JTable();
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
				"ID", "Nome", "CPF", "E-mail", "Senha"
			}
		));
		table.setBounds(0, 0, 414, 184);
		scrollPane.add(table);
		
		contentPane.add(scrollPane);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(10, 227, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(109, 227, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(208, 227, 98, 23);
		contentPane.add(btnPesquisar);
		
		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.setBounds(316, 227, 108, 23);
		contentPane.add(btnNewButton);
		
	}
}
