package visao;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.BDFunc;
import modelo.Funcionario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaAlterar extends JDialog {
	private JTextField textNome;
	private JTextField textTelefone;
	private JanelaAdmin janelaAdmin = null;
	private JTextField txtEndereco;
	private JTextField textEmail;
	private JTextField textCPF;
	private JTextField textSenha;
	public JanelaAlterar(JanelaAdmin janelaPrincipal, Funcionario funcionarioSelecionado, int posicao) {
		setSize(548, 303);
		getContentPane().setLayout(null);
		this.janelaAdmin = janelaPrincipal;
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(23, 47, 66, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setBounds(23, 108, 66, 14);
		getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblEmail2 = new JLabel("Email:");
		lblEmail2.setBounds(23, 79, 45, 13);
		getContentPane().add(lblEmail2);
		
		textEmail = new JTextField();
		textEmail.setBounds(99, 75, 202, 19);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		textEmail.setText(funcionarioSelecionado.getEmailFunc());
		
		textNome = new JTextField();
		textNome.setBounds(99, 44, 202, 20);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		textNome.setText(funcionarioSelecionado.getNomeFunc());
		
		textTelefone = new JTextField();
		textTelefone.setBounds(99, 105, 202, 20);
		getContentPane().add(textTelefone);
		textTelefone.setColumns(10);
		textTelefone.setText(funcionarioSelecionado.getTelefone());
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionarioSelecionado.setNomeFunc(textNome.getText());
				funcionarioSelecionado.setTelefone(textTelefone.getText());
				funcionarioSelecionado.setEmailFunc(textEmail.getText());
				BDFunc.alterarFuncionario(posicao, funcionarioSelecionado);
				dispose();
			}
		});
		btnNewButton.setBounds(334, 230, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(433, 230, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(23, 139, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textCPF = new JTextField();
		textCPF.setBounds(99, 136, 202, 20);
		getContentPane().add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setBounds(23, 172, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		textSenha = new JTextField();
		textSenha.setBounds(99, 169, 86, 20);
		getContentPane().add(textSenha);
		textSenha.setColumns(10);
		
		
	}
}
