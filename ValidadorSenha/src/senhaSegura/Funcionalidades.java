package senhaSegura;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class Funcionalidades {

	static Scanner entrada = new Scanner(System.in);
		
	private static String senha = "ABcd123!";

	public static String getSenha() {
		return senha;
	}
 
	public static void setSenha(String senha) {
		Funcionalidades.senha = senha;
	}
 
	private static final Map<Predicate<String>, String> validacoes = new LinkedHashMap<>();
	
	static {
		validacoes.put(s -> s.length() >= 8, "Senha deve ter no mínimo 8 caracteres.");
		validacoes.put(s -> s.chars().anyMatch(Character::isUpperCase), "Senha deve conter pelo menos uma letra maiúscula.");
		validacoes.put(s -> s.chars().anyMatch(Character::isLowerCase), "Senha deve conter pelo menos uma letra minúscula.");
		validacoes.put(s -> s.chars().anyMatch(Character::isDigit), "Senha deve conter pelo menos um número.");
		validacoes.put(s -> s.chars().anyMatch(c -> !Character.isLetterOrDigit(c)), "Senha deve conter pelo menos um caractere especial.");
	}
	
	public static void fazerSenhaNova() {
		boolean executar = true;
		while(executar) {
			System.out.println("\nDigite a sua nova senha: ");
			String novaSenha = entrada.nextLine();
			
			List<String> erros = new ArrayList<String>();
			
			for(Map.Entry<Predicate<String>, String> entrada : validacoes.entrySet()) {
				if (!entrada.getKey().test(novaSenha)) {
					erros.add(entrada.getValue());
				}
			}
			
			if (erros.isEmpty()) {
				setSenha(novaSenha);
	            System.out.println("\nNova senha salva com sucesso!");
	            executar = false;
			} else {
				System.out.println("\nSenha inválida!");
	            erros.forEach(System.out::println);
			}
		}
	}
	
	public static void mostrarSenha() {
		System.out.println("\nA sua senha atual é: " + getSenha()); 
	}
	
}
