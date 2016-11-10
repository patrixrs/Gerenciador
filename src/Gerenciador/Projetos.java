package Gerenciador;

import java.time.LocalDate;
import java.util.Scanner;

public class Projetos {
	private String nome, situacao;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private LocalDate hoje = LocalDate.now();
	private int numCompetencias, index;
	private String[] competencias;
	Scanner ler = new Scanner(System.in);

	public Projetos(String nome, LocalDate inicio, LocalDate fim, int numCompetencias) {
		this.nome = nome;
		this.dataInicio = inicio;
		this.dataFim = fim;
		this.numCompetencias = numCompetencias;
		this.competencias = new String[this.numCompetencias];
	}

	void setNome(String nome) {
		this.nome = nome;
	}// fim setNome

	public void setCompetencia(int competencia, String nomeCompetencia) {
		if (competencia < 0 || competencia >= competencias.length) {
			throw new ArrayIndexOutOfBoundsException(competencia);
		}
		competencias[competencia] = nomeCompetencia;
	}// fim setCompetencia
	
	public void addCompetencias() {
		 while (index < competencias.length) {
			System.out.println("Informe o nome da competencia: " + (index + 1));
			if (index < competencias.length) {
				competencias[index] = ler.nextLine();
				index++;
			}
		}
	}// fim addCompetencias
	
	public String situacaoProjeto() {
		if (dataInicio.isEqual(hoje) || dataInicio.isBefore(hoje) && dataFim.isAfter(hoje)) {
			situacao = "Projeto Ativo";
		} else {
			situacao = "Projeto Inativo";
		} // if-else
		return situacao;
	}// fecha situacaoProjeto
	
	public String checkAtivo() {
		String valor = "";
		String result = "Nome: " + nome +
						"\n | " + situacaoProjeto();		
		return result + valor + "\n";
	}// fim checkAtivo
	
	@Override
	public String toString() {
		String valor = "";
		String result = "Nome: " + nome +
						"\n | " + situacaoProjeto() +
						"\n | Inicio:" + dataInicio +
						"\n | Fim: " + dataFim +
						"\n | Nro Competencias: "	+ numCompetencias +
						"\n | Competencias: ";
		for (int i = 0; i < numCompetencias; i++) {
			valor = valor + competencias[i] + ", ";
		}
		return result + valor + "\n";
	}
}// fim da classe