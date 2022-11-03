package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class JanelaPrincipal extends JFrame {

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
	public JanelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()=='a') {
					JanelaAdmin ja = new JanelaAdmin();
					ja.setVisible(true);
				}
			}
		
			public void keyPressed(KeyEvent e) {
			}
		});
		
		btnLogin.setBounds(281, 189, 160, 63);
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaLogin j2 = new JanelaLogin();
				j2.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		btnLogin.setBackground(new Color(0, 204, 255));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 23));
		contentPane.add(btnLogin);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(507, 189, 160, 63);
		btnCadastrar.setBackground(new Color(0, 204, 255));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JanelaAdmin ja = new JanelaAdmin();
				ja.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 23));
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\PROJETO-INTEGRADOR\\Interfaces\\1.png"));
		lblNewLabel.setBounds(0, 0, 891, 462);
		contentPane.add(lblNewLabel);
	}

}
