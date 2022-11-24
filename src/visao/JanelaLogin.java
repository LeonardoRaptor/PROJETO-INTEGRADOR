package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.BDFunc;
import modelo.Funcionario;

public class JanelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField passwordField;

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
	public JanelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		textLogin = new JTextField();
		textLogin.setBounds(170, 122, 133, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(170, 153, 133, 20);
		contentPane.add(passwordField);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(114, 116, 46, 29);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(110, 156, 63, 14);
		contentPane.add(lblSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textLogin.getText();
				String senha = passwordField.getText();
				if (!login.isEmpty() && !senha.isEmpty()) {
					BDFunc bdf = new BDFunc();
					Funcionario funcionario = bdf.logarConta(login, senha);
					if (funcionario != null) {
						if (funcionario.getNomeFunc().equals(login) && funcionario.getSenhaFunc().equals(senha)) {
							JanelaLogin jl = new JanelaLogin();
							jl.setVisible(false);
							Menu m = new Menu();
							m.setVisible(true);
						}
					} else {
						JOptionPane.showMessageDialog(btnLogar, "Usuário e/ou senha incorretos");
					}
				} else {
					JOptionPane.showMessageDialog(btnLogar, "Usuário inexistente");
				}
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
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(54, 52, 320, 200);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 139));
		panel_1.setBounds(0, 0, 434, 47);
		contentPane.add(panel_1);

		JLabel lblNewLabel = new JLabel("LOGIN\r\n\r\n");
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(245, 255, 250));
	}
}
