import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CadastrarLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textNome;
	private JTextField textQntd;
	private JTextField textAutor;
	private JTextField textPreco;
	
	//variaveis 
	public String nome, autor, genero;
	public int quantidade, id, preco;
	public ArrayList<Cadastro> cadastro = new ArrayList<Cadastro>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLivro frame = new CadastrarLivro();
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
	public CadastrarLivro() {
		
		Cadastro x =new Cadastro();
		setTitle("Cadastro de Livros");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 11, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 86, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(10, 36, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gênero:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(10, 61, 75, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Autor:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(39, 111, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Preço:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(39, 136, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textID = new JTextField();
		textID.setBounds(95, 8, 329, 20);
		contentPane.add(textID);
		textID.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(95, 33, 329, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JComboBox boxGenero = new JComboBox();
		boxGenero.setBounds(95, 57, 329, 22);
		contentPane.add(boxGenero);
		
		textQntd = new JTextField();
		textQntd.setBounds(95, 83, 329, 20);
		contentPane.add(textQntd);
		textQntd.setColumns(10);
		
		textAutor = new JTextField();
		textAutor.setBounds(95, 108, 329, 20);
		contentPane.add(textAutor);
		textAutor.setColumns(10);
		
		textPreco = new JTextField();
		textPreco.setBounds(95, 133, 329, 20);
		contentPane.add(textPreco);
		textPreco.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 227, 89, 23);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar"); //começa aqui o botão de cadastro
		btnCadastrar.setBounds(236, 227, 89, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ids=textID.getText();
				String quantidades =textQntd.getText();
				if((ids!=null)&&(nome!=null)&&(autor!=null)&&(genero!=null)&&(quantidades!=null)) {
                    
					//colocando tudo q vai ser cadastrado, todas as variáveis.. eu acho?
					id = Integer.parseInt(ids); 
					
					nome=textNome.getText();
					
					autor=textAutor.getText();
										
					quantidade = Integer.parseInt(quantidades);
					
					x.setId(id);
					x.setNome(nome);
					x.setAutor(autor);
					x.setGenero(genero); //enquanto não tiver banco de dados integrado, o botao nao vai rodar pq precisa integrar 
					x.setQuantidade(quantidade);
					x.setPreco(preco);
					
					Adicionado frame1 = new Adicionado();
					frame1.setVisible(true);
					btnCadastrar.setEnabled(false);
				}
			}	
		});
		contentPane.add(btnCadastrar);
	}
}
