package visao;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Adicionado extends JFrame{
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adicionado frame = new Adicionado();
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
	public Adicionado() {
		setTitle("Msg");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 107);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionado com sucesso");
		lblNewLabel.setBounds(10, 11, 235, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBackground(new Color(102, 205, 170));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 34, 184, 23);
		contentPane.add(btnNewButton);
	}

}
