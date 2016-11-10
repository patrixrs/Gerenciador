package Gerenciador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CSVReader<T> {
	private Scanner arquivo;
	private Parser<T> parser;	
	public CSVReader(String filename, Parser<T> parser)
			throws FileNotFoundException
	{
		this.arquivo = new Scanner( new BufferedReader(	new FileReader(filename)));
		this.parser = parser;		
	}
	
	public CSVReader(){
		//construtor sem parametros		
	}

	public boolean hasNext() {//verifica o proximo campo pelo delimitador
		return arquivo.hasNext();
	}
	
	public void skipLine() {//pula a linha
		arquivo.nextLine();
	}

	public T readObject() {
		return parser.parse(arquivo.nextLine());
	}
	
	public void close() {
		arquivo.close();
	}	
}//fim da classe reader