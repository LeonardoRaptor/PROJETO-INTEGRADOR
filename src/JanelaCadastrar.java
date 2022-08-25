import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCadastrar extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textCPF;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrar frame = new JanelaCadastrar();
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
	public JanelaCadastrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNome = new JTextField();
		textNome.setBounds(229, 84, 182, 27);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(229, 122, 182, 27);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setBounds(229, 161, 182, 27);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(229, 199, 182, 27);
		contentPane.add(textSenha);
		textSenha.setColumns(10);
		
		JLabel lblNomeCadastro = new JLabel("Nome:");
		lblNomeCadastro.setBounds(172, 104, 58, 17);
		contentPane.add(lblNomeCadastro);
		
		JLabel lblEmailCadastro = new JLabel("E-mail:");
		lblEmailCadastro.setBounds(172, 136, 46, 14);
		contentPane.add(lblEmailCadastro);
		
		JLabel lblCPFCadastro = new JLabel("CPF:");
		lblCPFCadastro.setBounds(180, 167, 46, 14);
		contentPane.add(lblCPFCadastro);
		
		JLabel lblSenhaCadastro = new JLabel("Senha:");
		lblSenhaCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenhaCadastro.setBounds(153, 203, 77, 14);
		contentPane.add(lblSenhaCadastro);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(37, 38, 482, 287);
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(450, 344, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(351, 344, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
