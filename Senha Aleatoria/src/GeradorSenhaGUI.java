import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GeradorSenhaGUI extends JFrame{
	private GeradorSenha geradorSenha;
	
	public GeradorSenhaGUI() {
		
		// criando o jframe e adicionando titulo
		super("Gerador de Senha");
		
		// definindo tamanho do frame
		setSize(540,570);
		
		// evitando que o tamanho possa ser alterado
		setResizable(false);
		setLayout(null);
		
		//terminar o programa quando o frame for fechado
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//centralizar o frame na tela
		setLocationRelativeTo(null);
		
		// iniciar o gerador de senha
		geradorSenha = new GeradorSenha();
		
		addGuiComponents();
		
	}
	private void addGuiComponents() {
		//criando titulo
		JLabel tituloLabel = new JLabel ("Gerador de Senha");
		
		// definindo fonte
		tituloLabel.setFont(new Font("Dialog", Font.BOLD, 32));
		
		//centralizar o texto no frame 
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		// definindo x, y e largura e altura
		tituloLabel.setBounds(0, 10, 540, 39);
		
		// adicionando  ao frame
		add(tituloLabel);
		
		// criando output
		JTextArea senhaOutput = new JTextArea();
		
		//evitar de alterar o output
		senhaOutput.setEditable(false);
		senhaOutput.setFont(new Font("Dialog", Font.BOLD, 32));
		
		//adicionando scroll
		JScrollPane senhaOutputPane = new JScrollPane(senhaOutput);
		senhaOutputPane.setBounds(25, 97, 479, 70);
		
		//criando um borda ao redor do texto
		senhaOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(senhaOutputPane);
		
		//criando tamanujo da senha
		JLabel senhaTamanhoLabel = new JLabel("Tamanho da Senha: ");
		senhaTamanhoLabel.setFont(new Font("Dialog", Font.PLAIN, 29));
		senhaTamanhoLabel.setBounds(25, 215, 272, 39);
		add(senhaTamanhoLabel);
		
		//criando input do tamanho da senha
		JTextArea senhaTamanhoInputArea = new JTextArea(); 
		senhaTamanhoInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
		senhaTamanhoInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		senhaTamanhoInputArea.setBounds(310, 215, 192, 39);
		add(senhaTamanhoInputArea);
		
		//criando botao de alternar
		//alternar para letras e caixa alta
		JToggleButton caixaaltaToggle = new JToggleButton("Caixa Alta");
		caixaaltaToggle.setBounds(25, 302, 225, 56);
		caixaaltaToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		add(caixaaltaToggle);
		
		//alternar para letras e caixa baixa
		JToggleButton caixabaixaToggle = new JToggleButton("Caixa Baixa");
		caixabaixaToggle.setBounds(282, 302, 225, 56);
		caixabaixaToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		add(caixabaixaToggle);
		
		// alternar para numeros
		JToggleButton numerosToggle = new JToggleButton("Números");
		numerosToggle.setBounds(25, 373, 225, 56);
		numerosToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		add(numerosToggle);
		
		//alternar para simbolos
		JToggleButton simbolosToggle = new JToggleButton("Símbolos");
		simbolosToggle.setBounds(282, 373, 225, 56);
		simbolosToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		add(simbolosToggle);
		
		// criando botao gerar
		JButton btnGerar = new JButton ("Gerar");
		btnGerar.setFont(new Font("Dialog", Font.PLAIN, 32));
		btnGerar.setBounds(155, 477, 222, 41);
		btnGerar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				// validacao: gera a senha apenas quando o length > 0, e um dos botoes de alternar estiverem pressionados 
				if(senhaTamanhoInputArea.getText().length() <=0) return ; 
				boolean qualquerToggleSelected = caixabaixaToggle.isSelected() ||
						caixaaltaToggle.isSelected() ||
						numerosToggle.isSelected() ||
						simbolosToggle.isSelected();
			// gerar senha
			// converte o texto para um valor 
			int senhaTamanho = Integer.parseInt(senhaTamanhoInputArea.getText());
			if(qualquerToggleSelected) {
				String senhaGerada = geradorSenha.gerarSenha(senhaTamanho,
						caixaaltaToggle.isSelected(),
						caixabaixaToggle.isSelected(),
						numerosToggle.isSelected(),
						simbolosToggle.isSelected());
				
				// mostra senha gerada
				senhaOutput.setText(senhaGerada);
			}
				
			}
		});
		add(btnGerar);
	}
}


















