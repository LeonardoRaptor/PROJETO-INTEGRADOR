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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 857, 40);
		contentPane.add(panel);
		
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
			}
		});
		btnHistoricoVenda.setBounds(564, 112, 171, 79);
		contentPane.add(btnHistoricoVenda);
		
		JButton btnPesquisarClientes = new JButton("<html>PESQUISAR<br /><center>CLIENTES</center></html>\r\n");
		btnPesquisarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisarCliente pesCli = new PesquisarCliente();
				pesCli.setVisible(true);
			}
		});
		btnPesquisarClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPesquisarClientes.setBounds(342, 112, 171, 79);
		contentPane.add(btnPesquisarClientes);
		
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
		btnRegistrarVenda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegistrarVenda.setBounds(564, 225, 171, 79);
		contentPane.add(btnRegistrarVenda);
		
		JButton btnVoltarMenu = new JButton("Voltar");
		btnVoltarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltarMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltarMenu.setBounds(746, 384, 89, 40);
		contentPane.add(btnVoltarMenu);
	}
}
