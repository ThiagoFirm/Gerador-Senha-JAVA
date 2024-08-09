import java.util.Random;

public class GeradorSenha {
	public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSUTVWXYZ";
	public static final String NUMBERS = "0123456789";
	public static final String SPECIAL_SYMBOLS = "!@#$%&*()<>,.'?/-_{}";
	
	// a classe random nos permite gerar um numero aleatorio  no qual sera usado par escolher aleatoriamente os caracteres
	private final Random random;
	
	//construtor
	public GeradorSenha() {
		random = new Random();
	}
	
	// lenght - tamanho da senha, escolhida pelo ususario
	public String gerarSenha(int length, boolean incluiCaixaalta, boolean incluiCaixabaixa, boolean incluiNumeros, boolean incluiSimbolos) {
		
		// esse é um string builder, usado para melhor manipulacao de strings
		StringBuilder  senhaBuilder = new StringBuilder();
		
		// armazena caracteres validos
		String caracValido = "";
		if (incluiCaixaalta) caracValido += UPPERCASE_CHARACTERS;
		if (incluiCaixabaixa) caracValido += LOWERCASE_CHARACTERS;
		if (incluiNumeros) caracValido += NUMBERS;
		if (incluiCaixaalta) caracValido += SPECIAL_SYMBOLS;
		
		// controi senha
		for(int i = 0; i < length; i++) {
			
			// gerar um indice aleatorio
			int randomIndice = random.nextInt(caracValido.length());
			
			// pegar o char baseado no indice 
			char randomChar = caracValido.charAt(randomIndice);
			
			// armazenando o char no  senhaBuilder
			senhaBuilder.append(randomChar);
		}
		
		return senhaBuilder.toString();
	}
	
}








