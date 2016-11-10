package Gerenciador;
import java.util.Scanner;

public class CompetenciasParser implements Parser<Competencias> {
	public Competencias parse(String dados) {
		Scanner arquivo = new Scanner(dados);		
		String nome = arquivo.nextLine();
		
		Competencias competencia = new Competencias(nome);
		
		arquivo.close();		
		return competencia;
	}
} 