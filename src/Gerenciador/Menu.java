package Gerenciador;

import com.senac.SimpleJava.Console;

public class Menu {
	Opcao[] opcoes = new Opcao[6];
	int numOpcoes = 0;

	public void addOption(Opcao opcao) {
		opcoes[numOpcoes] = opcao;
		numOpcoes++;
	}// fim addOption
	
	public void removeOption(Opcao opcao) {
		if(numOpcoes >= 0 )
		opcoes[numOpcoes] = opcao;
		numOpcoes--;
	}// fim removeOption

	// cabecalho do menu principal
	public void show() {
		Console.print("\nMenu:\n");
		for (int i = 0; i < numOpcoes; i++) {
			Console.println("[", i + 1, "] ", opcoes[i].getTexto());
		}
		Console.println("ESCOLHA UMA OPÇÃO: ");
	}// fim show

	public int getOption() {
		int opcao = Console.readInt();
		return opcao;
	}	
}// fim da classe