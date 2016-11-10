package Gerenciador;

public class Colaboradores {
	private String nomeProjeto;
	private String nomeFuncionarios;
	private String competencias;	
	private Vetor<Colaboradores> vColaboradores = new Vetor<>();

	public Colaboradores(String projeto, String funcionarios, String competencias) {
		this.nomeProjeto = projeto;
		this.nomeFuncionarios = funcionarios;
		this.competencias = competencias;
	}

	public Colaboradores(int indexP, int indexC) {
		// construtor vazio
	}
	
	public void associaProjeto(int indexP, int indexC){
		
	}

	public void remove(int index) {
		vColaboradores.remove(index - 1);
	}// remove o colaborador no index digitado

	@Override
	public String toString() {
		return	"Projeto: " + nomeProjeto +
				" | Funcionario: " + nomeFuncionarios +
				" | Competencias: " + competencias;
	}
}