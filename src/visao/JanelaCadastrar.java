package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.BDFunc;
import modelo.Funcionario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 417);
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
		lblNomeCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeCadastro.setBounds(153, 85, 63, 26);
		contentPane.add(lblNomeCadastro);
		
		JLabel lblEmailCadastro = new JLabel("E-mail:");
		lblEmailCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmailCadastro.setBounds(153, 126, 105, 23);
		contentPane.add(lblEmailCadastro);
		
		JLabel lblCPFCadastro = new JLabel("CPF:");
		lblCPFCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCPFCadastro.setBounds(153, 165, 78, 23);
		contentPane.add(lblCPFCadastro);
		
		JLabel lblSenhaCadastro = new JLabel("Senha:");
		lblSenhaCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenhaCadastro.setBounds(153, 203, 77, 23);
		contentPane.add(lblSenhaCadastro);
		
		
	
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
				String nome = textNome.getText();
				String cpf = textCPF.getText();
				String email = textEmail.getText();
				String senha = textSenha.getText();
				if (!nome.isEmpty() && !senha.isEmpty() && !cpf.isEmpty() && !email.isEmpty()) {
					Funcionario f = new Funcionario();
					f.setNomeFunc(textNome.getText());
					f.setCpfFunc(textCPF.getText());
					f.setEmailFunc(textEmail.getText());
					f.setSenhaFunc(textSenha.getText());
					BDFunc bdfu= new BDFunc();
					bdfu.cadastro();
				} else {
					// erro
					JOptionPane.showMessageDialog(btnNewButton_1, "Erro login ou senha não confirmados" );
				}
				BDFunc bdfu= new BDFunc();
				bdfu.cadastro();
			}
		});
		btnNewButton_1.setBounds(344, 344, 96, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
