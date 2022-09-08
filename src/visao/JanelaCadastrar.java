package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
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
import javax.swing.ImageIcon;

public class JanelaCadastrar extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textCPF;
	private JTextField textSenha;
	private JTextField textId;
	
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

		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(229, 48, 182, 27);
		contentPane.add(textId);
		
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

		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(153, 43, 63, 26);
		contentPane.add(lblId);
		
		
	
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
				try {
					Connection conexao;
					Statement st;
					conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "aluno");
					System.out.println("Conectado � base de dados com sucesso.");
					st = conexao.createStatement();
					
					st.executeUpdate("Insert into funcionarios (idFuncionario, NomeFuncionario,EmailFunc,CPF, SenhaFunc) values ('" + Integer.parseInt(textId.getText()) + "','" + textNome.getText() + "', '" + textEmail.getText() + "', '" + textCPF.getText() + "', '" + textSenha.getText() + "')");
					
				} catch (SQLException a) {
					System.out.println(a.getMessage());
						System.out.println("Erro ao conectar � base de dados.");
				}
				
			}
		});
		btnNewButton_1.setBounds(344, 344, 96, 23);
		contentPane.add(btnNewButton_1);
		
	}
}
