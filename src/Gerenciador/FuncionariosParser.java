package Gerenciador;

import java.util.Scanner;

public class FuncionariosParser implements Parser<Funcionarios> {
	
	public Funcionarios parse(String dados) {
		
		Scanner arquivo = new Scanner(dados);		
		arquivo.useDelimiter(";");		
		
		String nome = arquivo.next();
		Double salario = Double.parseDouble(arquivo.next());
		int numCompetencias = arquivo.nextInt();
		
		Funcionarios funcionario = new Funcionarios(nome, salario, numCompetencias);
		
		for (int competencia = 0; competencia < numCompetencias; competencia++) {
			String nomeCompetencia = arquivo.next();
			funcionario.setCompetencia(competencia, nomeCompetencia);
		}
		
		arquivo.close();
		return funcionario;
	}
}