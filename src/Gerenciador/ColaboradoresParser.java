package Gerenciador;
import java.util.Scanner;

public class ColaboradoresParser implements Parser<Colaboradores> {

	public Colaboradores parse(String dados) {
		Scanner arquivo = new Scanner(dados);
		arquivo.useDelimiter(";");
		String nomeProjeto = arquivo.next();
	
		String nomeFuncionarios = arquivo.next();	
		String competencias = arquivo.next();				
		Colaboradores colaborador = new Colaboradores(nomeProjeto, nomeFuncionarios, competencias);
		
		arquivo.close();
		return colaborador;
		
		
	}

}
