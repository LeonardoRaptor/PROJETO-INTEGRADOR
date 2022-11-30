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
		setBounds(100, 100, 1118, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		textLogin = new JTextField();
		textLogin.setBounds(479, 191, 346, 42);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(478, 303, 347, 42);
		contentPane.add(passwordField);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblLogin.setBounds(342, 191, 76, 37);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Amiri", Font.PLAIN, 26));
		lblSenha.setBounds(342, 309, 76, 25);
		contentPane.add(lblSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setForeground(Color.WHITE);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textLogin.getText();
				String senha = passwordField.getText();
				if (!login.isEmpty() && !senha.isEmpty()) {
					BDFunc bdf = new BDFunc();
					Funcionario funcionario = bdf.logarConta(login, senha);
					if (funcionario != null) {
						if (funcionario.getNomeFunc().equals(login) && funcionario.getSenhaFunc().equals(senha)) {
							setVisible(false);
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
		btnLogar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogar.setBackground(Color.GRAY);
		btnLogar.setBounds(779, 447, 125, 35);
		contentPane.add(btnLogar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JanelaPrincipal jap = new JanelaPrincipal();
				jap.setVisible(true);
			}
		});
		btnVoltar.setBackground(Color.GRAY);
		btnVoltar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVoltar.setBounds(929, 447, 133, 35);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\loginnn.png"));
		lblNewLabel.setBounds(0, 0, 1102, 510);
		contentPane.add(lblNewLabel);
	}
}
