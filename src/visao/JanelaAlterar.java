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
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JanelaAdmin janelaAdmin = null;
	private JTextField txtId;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	public JanelaAlterar(JanelaAdmin janelaPrincipal, Funcionario funcionarioSelecionado, int posicao) {
		setSize(548, 303);
		getContentPane().setLayout(null);
		this.janelaAdmin = janelaPrincipal;
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(23, 65, 66, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setBounds(23, 180, 66, 14);
		getContentPane().add(lblNewLabel_1);
		JLabel lblId2 = new JLabel("Id:");
		lblId2.setBounds(24, 29, 45, 13);
		getContentPane().add(lblId2);
		
		JLabel lblEndereco2 = new JLabel("Endereco:");
		lblEndereco2.setBounds(23, 105, 75, 13);
		getContentPane().add(lblEndereco2);
		
		
		JLabel lblEmail2 = new JLabel("Email:");
		lblEmail2.setBounds(24, 144, 45, 13);
		getContentPane().add(lblEmail2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(99, 141, 202, 19);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setText(funcionarioSelecionado.getEmailFunc());
		
		txtNome = new JTextField();
		txtNome.setBounds(99, 63, 202, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(funcionarioSelecionado.getNomeFunc());
		
		txtTelefone = new JTextField();
		txtTelefone.setBounds(99, 178, 202, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);
		txtTelefone.setText(funcionarioSelecionado.getTelefone());
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionarioSelecionado.setNomeFunc(txtNome.getText());
				funcionarioSelecionado.setTelefone(txtTelefone.getText());
				funcionarioSelecionado.setEmailFunc(txtEmail.getText());
				BDFunc.alterarFuncionario(posicao, funcionarioSelecionado);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 237, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnNewButton_1.setBounds(112, 237, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		
	}
}
