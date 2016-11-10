package Gerenciador;

import java.util.Scanner;

public class Funcionarios {
	private String nome;
	private double salario;
	private int numCompetencias, index;
	private String[] competencias;
	Scanner ler = new Scanner(System.in);

	public Funcionarios(String nome, Double salario, int numCompetencias) {
		this.nome = nome;
		this.salario = salario;
		this.numCompetencias = numCompetencias;
		this.competencias = new String[numCompetencias];
	}

	public Funcionarios() {
		// construtor vazio
	}

	void setNome(String nome) {
		this.nome = nome;
	}// fim setNome

	public void setCompetencia(int competencia, String nomeCompetencia) {
		if (competencia < 0 || competencia >= competencias.length) {
			throw new ArrayIndexOutOfBoundsException(competencia);
		}
		competencias[competencia] = nomeCompetencia;
	}// fim setCompetencias

	public void addCompetencias() {
		 while (index < competencias.length) {
			System.out.println("Informe o nome da competencia: " + (index + 1));
			if (index < competencias.length) {
				competencias[index] = ler.next();
				index++;
			}
		}
	}// fim addCompetencias

	public String verificaCompetencias() {
		String comp = "";
		for (int i = 0; i < numCompetencias; i++) {
			if (i < numCompetencias - 1) {
				comp = comp + competencias[i] + ", ";
			} else {
				comp = comp + competencias[i] + ". ";
			}
		}
		return comp;
	}// fim addCompetencias

	public String toString() {
		String valor = "";
		String result = "Nome: " + nome +
						"\n | Salario: " + salario +
						"\n | Nro competencias: " + numCompetencias +
						"\n | Competencias: ";
		for (int i = 0; i < numCompetencias; i++) {
			valor = valor + competencias[i] + ", ";
		}
		return result + valor + "\n";
	}
}