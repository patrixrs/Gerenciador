package Gerenciador;

import java.time.LocalDate;
import java.util.Scanner;

public class ProjetosParser implements Parser<Projetos> {
	
	public Projetos parse(String dados) {
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		
		String nome = arquivo.next();
		LocalDate dataInicio = LocalDate.parse(arquivo.next());
		LocalDate dataFim = LocalDate.parse(arquivo.next());
		int numCompetencias = arquivo.nextInt();
		
		Projetos projeto = new Projetos(nome, dataInicio, dataFim, numCompetencias);
		
		for (int competencia = 0; competencia < numCompetencias; competencia++) {
			String nomeCompetencia = arquivo.next();
			projeto.setCompetencia(competencia, nomeCompetencia);
		}				
		arquivo.close();
		return projeto;
	}
}