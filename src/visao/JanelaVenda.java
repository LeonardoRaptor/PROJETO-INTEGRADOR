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

public class JanelaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField textCodLivro;
	private JTextField textCPFCli;
	private JTextField textQuant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaVenda frame = new JanelaVenda();
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
	public JanelaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 376);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 128));
		panel.setBounds(-13, 0, 538, 47);
		contentPane.add(panel);
		
		JLabel lblVenda = new JLabel("VENDA");
		panel.add(lblVenda);
		lblVenda.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblVenda.setForeground(new Color(245, 255, 250));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 224, 208));
		panel_1.setBounds(31, 71, 460, 246);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código do Livro:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(39, 16, 194, 19);
		panel_1.add(lblNewLabel);
		
		textCodLivro = new JTextField();
		textCodLivro.setBounds(186, 11, 240, 24);
		panel_1.add(textCodLivro);
		textCodLivro.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CPF Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(39, 51, 121, 14);
		panel_1.add(lblNewLabel_1);
		
		textCPFCli = new JTextField();
		textCPFCli.setBounds(186, 48, 240, 24);
		panel_1.add(textCPFCli);
		textCPFCli.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(39, 81, 96, 21);
		panel_1.add(lblNewLabel_2);
		
		textQuant = new JTextField();
		textQuant.setBounds(144, 82, 73, 22);
		panel_1.add(textQuant);
		textQuant.setColumns(10);
		
		JButton btnAdicionarVenda = new JButton("Adicionar");
		btnAdicionarVenda.setBounds(227, 82, 89, 23);
		panel_1.add(btnAdicionarVenda);
		
		JButton btnRemoverVenda = new JButton("Remover");
		btnRemoverVenda.setBounds(337, 83, 89, 23);
		panel_1.add(btnRemoverVenda);
	}
}
