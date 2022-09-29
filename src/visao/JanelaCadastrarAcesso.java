package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JanelaCadastrarAcesso extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCadastrarAcesso frame = new JanelaCadastrarAcesso();
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
	public JanelaCadastrarAcesso() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Senha:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(146, 79, 78, 102);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(221, 122, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int senha = Integer. parseInt(textField.getText());
				if(senha==123) {
					JanelaAdmin j1 = new JanelaAdmin();
					j1.setVisible(true);
					setVisible(false);
				}else if (senha!=123){
					SenhaIncorreta j2 = new SenhaIncorreta();
					j2.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnOk.setBounds(117, 192, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setBounds(234, 192, 89, 23);
		contentPane.add(btnCancelar);
	}
}
