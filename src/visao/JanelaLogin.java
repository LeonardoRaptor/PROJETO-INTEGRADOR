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
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 858, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		textLogin = new JTextField();
		textLogin.setBounds(330, 231, 346, 42);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(329, 318, 347, 42);
		contentPane.add(passwordField);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(207, 230, 62, 37);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSenha.setBounds(207, 323, 76, 25);
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
		btnLogar.setBackground(Color.GRAY);
		btnLogar.setBounds(527, 527, 125, 35);
		contentPane.add(btnLogar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVoltar.setBackground(Color.GRAY);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(677, 527, 133, 35);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\login.png"));
		lblNewLabel.setBounds(0, 0, 851, 587);
		contentPane.add(lblNewLabel);
	}
}
