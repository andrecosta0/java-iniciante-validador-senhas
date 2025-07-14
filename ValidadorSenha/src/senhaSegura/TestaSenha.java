package senhaSegura;

public class TestaSenha {
	
	public static void main(String[] args) {
		
		boolean executando = true;
		
		while (executando) {
			
			System.out.println("\nBem vindo ao testador de senhas\n"
					+ "\nDigite qual serviço deseja acessar\n"
					+ "(1) - Criar nova senha\n"
					+ "(2) - Checar sua criada\n"
					+ "(3) - Encerrar o programa\n");
			
			String opcao = Funcionalidades.entrada.nextLine();
			
			switch (opcao) {
				case "1":
					Funcionalidades.fazerSenhaNova();
					break;
				case "2": 
					Funcionalidades.mostrarSenha();
					break;
				case "3":
					executando = false;
					System.out.println("\nPrograma encerrado.");
					break;
				default : 
					System.out.println("\nOpção inválida por favor tente novamente...\n");
			}
			
		}
	}
}