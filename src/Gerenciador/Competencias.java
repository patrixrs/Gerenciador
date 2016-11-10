package Gerenciador;

import java.util.Scanner;

public class Competencias {
	private String nome;

	public Competencias(String nomeCompetencia) {
		this.nome = nomeCompetencia;
	}
	
	@SuppressWarnings("resource")
	public String digita(String texto) {
		Scanner ler = new Scanner(System.in);
		System.out.println(texto);
		final String text = ler.nextLine(); 
		return text;
	}// fim digita

	@Override
	public String toString() {
		return "Competencia: " + nome;
	}	
}// fim da classe