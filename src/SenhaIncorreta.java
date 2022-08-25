import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SenhaIncorreta extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SenhaIncorreta frame = new SenhaIncorreta();
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
	public SenhaIncorreta() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblSenhaIncorretasoliciteAo = new JLabel("Senha incorreta!");
		lblSenhaIncorretasoliciteAo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSenhaIncorretasoliciteAo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSenhaIncorretasoliciteAo);
		
		JLabel lblSoliciteAoAdministrador = new JLabel("Solicite ao administrador que insira a senha!");
		lblSoliciteAoAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblSoliciteAoAdministrador);
		
		JButton btnOk = new JButton("     OK     ");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		contentPane.add(btnOk);
	}
}
