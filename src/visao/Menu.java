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
import javax.swing.ImageIcon;

public class Menu extends JFrame {

	private JPanel contentPane;

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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1131, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnEstoque = new JButton("ESTOQUE");
		btnEstoque.setBackground(Color.GRAY);
		btnEstoque.setForeground(new Color(255, 255, 255));
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque es = new Estoque();
				es.setVisible(true);
			}
		});
		btnEstoque.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEstoque.setBounds(218, 176, 177, 79);
		contentPane.add(btnEstoque);

		JButton btnHistoricoVenda = new JButton("<html>HISTÓRICO<br /><center>DE VENDAS</center></html>");
		btnHistoricoVenda.setForeground(new Color(255, 255, 255));
		btnHistoricoVenda.setBackground(Color.GRAY);
		btnHistoricoVenda.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHistoricoVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HistoricoVenda hv = new HistoricoVenda();
				hv.setVisible(true);
			}
		});
		btnHistoricoVenda.setBounds(750, 176, 183, 79);
		contentPane.add(btnHistoricoVenda);

		JButton btnCadastrarFornecedor = new JButton("<html>CADASTRAR<br /><center>FORNECEDOR</center></html>\r\n");
		btnCadastrarFornecedor.setForeground(new Color(255, 255, 255));
		btnCadastrarFornecedor.setBackground(Color.GRAY);
		btnCadastrarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaFornecedor cadfor = new JanelaFornecedor();
				cadfor.setVisible(true);
			}
		});
		btnCadastrarFornecedor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCadastrarFornecedor.setBounds(484, 308, 177, 84);
		contentPane.add(btnCadastrarFornecedor);

		JButton btnCadastrarClientes = new JButton("<html>CADASTRAR<br /><center>CLIENTES</center></html> \r\n");
		btnCadastrarClientes.setForeground(new Color(255, 255, 255));
		btnCadastrarClientes.setBackground(Color.GRAY);
		btnCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarCliente cadcli = new CadastrarCliente();
				cadcli.setVisible(true);
			}
		});
		btnCadastrarClientes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCadastrarClientes.setBounds(218, 308, 177, 84);
		contentPane.add(btnCadastrarClientes);

		JButton btnRegistrarLivro = new JButton("<html>REGISTRAR<br /><center>LIVRO</center></html>");
		btnRegistrarLivro.setForeground(new Color(255, 255, 255));
		btnRegistrarLivro.setBackground(Color.GRAY);
		btnRegistrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarLivro cadliv = new CadastrarLivro();
				cadliv.setVisible(true);
			}
		});
		btnRegistrarLivro.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRegistrarLivro.setBounds(484, 176, 177, 79);
		contentPane.add(btnRegistrarLivro);

		JButton btnRegistrarVenda = new JButton("<html>REGISTRAR<br /><center>VENDAS</center></html>");
		btnRegistrarVenda.setForeground(new Color(255, 255, 255));
		btnRegistrarVenda.setBackground(Color.GRAY);
		btnRegistrarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaVenda venda = new JanelaVenda();
				venda.setVisible(true);
			}
		});
		btnRegistrarVenda.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRegistrarVenda.setBounds(750, 308, 183, 84);
		contentPane.add(btnRegistrarVenda);
		
				JButton btnVoltarMenu = new JButton("Voltar");
				btnVoltarMenu.setBackground(Color.GRAY);
				btnVoltarMenu.setBounds(965, 477, 128, 45);
				contentPane.add(btnVoltarMenu);
				btnVoltarMenu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnVoltarMenu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				
				JLabel lblNewLabel = new JLabel("    ");
				lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\menu.png"));
				lblNewLabel.setBounds(0, 0, 1115, 548);
				contentPane.add(lblNewLabel);
	}
}
