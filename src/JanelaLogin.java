import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaLogin frame = new JanelaLogin();
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
	public JanelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textLogin = new JTextField();
		textLogin.setBounds(170, 122, 133, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(114, 116, 46, 29);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(110, 156, 63, 14);
		contentPane.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setBounds(170, 153, 133, 20);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLogar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogar.setBackground(new Color(30, 144, 255));
		btnLogar.setBounds(236, 263, 89, 23);
		contentPane.add(btnLogar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBackground(new Color(30, 144, 255));
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(335, 263, 89, 23);
		contentPane.add(btnVoltar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(54, 52, 320, 200);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 139));
		panel_1.setBounds(0, 0, 434, 41);
		contentPane.add(panel_1);
	}
}
