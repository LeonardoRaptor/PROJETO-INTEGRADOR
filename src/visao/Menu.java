package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 861, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 857, 55);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("MENU");
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));

		JButton btnEstoque = new JButton("ESTOQUE");
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque es = new Estoque();
				es.setVisible(true);
			}
		});
		btnEstoque.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEstoque.setBounds(113, 112, 171, 79);
		contentPane.add(btnEstoque);

		JButton btnHistoricoVenda = new JButton("<html>HISTÓRICO<br /><center>DE VENDAS</center></html>");
		btnHistoricoVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHistoricoVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoVenda hv = new HistoricoVenda();
				hv.setVisible(true);
			}
		});
		btnHistoricoVenda.setBounds(564, 112, 171, 79);
		contentPane.add(btnHistoricoVenda);

		JButton btnCadastrarFornecedor = new JButton("<html>CADASTRAR<br /><center>FORNECEDOR</center></html>\r\n");
		btnCadastrarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaFornecedor cadfor = new JanelaFornecedor();
				cadfor.setVisible(true);
			}
		});
		btnCadastrarFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrarFornecedor.setBounds(342, 112, 171, 79);
		contentPane.add(btnCadastrarFornecedor);

		JButton btnCadastrarClientes = new JButton("<html>CADASTRAR<br /><center>CLIENTES</center></html> \r\n");
		btnCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente cadcli = new CadastrarCliente();
				cadcli.setVisible(true);
			}
		});
		btnCadastrarClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrarClientes.setBounds(113, 225, 171, 79);
		contentPane.add(btnCadastrarClientes);

		JButton btnRegistrarLivro = new JButton("<html>REGISTRAR<br /><center>LIVRO</center></html>");
		btnRegistrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarLivro cadliv = new CadastrarLivro();
				cadliv.setVisible(true);
			}
		});
		btnRegistrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarLivro.setBounds(342, 225, 171, 79);
		contentPane.add(btnRegistrarLivro);

		JButton btnRegistrarVenda = new JButton("<html>REGISTRAR<br /><center>VENDAS</center></html>");
		btnRegistrarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaVenda venda = new JanelaVenda();
				venda.setVisible(true);
			}
		});
		btnRegistrarVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarVenda.setBounds(564, 225, 171, 79);
		contentPane.add(btnRegistrarVenda);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		panel_1.setBounds(45, 81, 744, 319);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnVoltarMenu = new JButton("Voltar");
		btnVoltarMenu.setBounds(620, 268, 114, 40);
		panel_1.add(btnVoltarMenu);
		btnVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltarMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}
}
