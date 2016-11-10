package Gerenciador;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class Gerenciador {

	public static void main(String[] args) {
		try {
			(new Gerenciador()).run();
		} catch (FileNotFoundException e) {
			System.err.println("Nao encontrou arquivo.");
			System.err.println(e.getMessage());
		}
	}

	private Vetor<Funcionarios> vFuncionarios = new Vetor<>();
	private Vetor<Projetos> vProjetos = new Vetor<>();	
	private Vetor<Competencias> vCompetencias = new Vetor<>();
	private Vetor<Colaboradores> vColaboradores = new Vetor<>();	

	private void run() throws FileNotFoundException {
		// inicia a leitura pra memória de cada classe e arquivos
		verificaFuncionarios();
		verificaColaboradores();
		verificaCompetencias();
		verificaProjetos();		

		// menu genérico
		System.out.println("GERENCIADOR DE PROJETOS");
		Menu menu1 = new Menu();
		Menu menu2 = new Menu();
		Menu menu3 = new Menu();
		Menu menu4 = new Menu();

		Opcao consultar = new Opcao("Consultar");
		Opcao cadastrar = new Opcao("Cadastrar");
		Opcao pendencia = new Opcao("Pendências");
		Opcao excluir = new Opcao("Excluir");

		Opcao verFuncionarios = new Opcao("Ver Funcionarios");
		Opcao verProjetos = new Opcao("Ver Projetos");
		Opcao verCompetencias = new Opcao("Ver Competencias");
		Opcao verColaboradores = new Opcao("Ver Colaboradores");		

		Opcao cadFuncionario = new Opcao("Cadastrar Funcionarios");
		Opcao cadCompetencia = new Opcao("Cadastrar Competencias");
		Opcao cadProjeto = new Opcao("Cadastrar Projetos");
		Opcao cadColaboradores = new Opcao("Associar Colaboradores");

		Opcao excluirFuncionario = new Opcao("Excluir Funcionarios");
		Opcao excluirCompetencia = new Opcao("Excluir Competencias");
		Opcao excluirProjeto = new Opcao("Excluir Projetos");
		Opcao excluirColaborador = new Opcao("Excluir Colaboradores");

		Opcao sair = new Opcao("Sair");
		Opcao voltar = new Opcao("Voltar");

		menu1.addOption(consultar);
		menu1.addOption(cadastrar);
		menu1.addOption(excluir);
		menu1.addOption(pendencia);
		menu1.addOption(sair);		
	
		menu2.addOption(verFuncionarios);
		menu2.addOption(verProjetos);
		menu2.addOption(verCompetencias);
		menu2.addOption(verColaboradores);
		menu2.addOption(voltar);

		menu3.addOption(cadFuncionario);		
		menu3.addOption(cadProjeto);
		menu3.addOption(cadCompetencia);
		menu3.addOption(cadColaboradores);
		menu3.addOption(voltar);

		menu4.addOption(excluirFuncionario);
		menu4.addOption(excluirProjeto);
		menu4.addOption(excluirCompetencia);
		menu4.addOption(excluirColaborador);
		menu4.addOption(voltar);

		do {// menus encadeados de opções
			menu1.show();// menu1 principal
			switch (menu1.getOption()) {

			case 1:
				menu2.show();// menu2 de consulta
				switch (menu2.getOption()) {

				case 1:
					vFuncionarios.listaVetor();					
					break;
				case 2:
					vProjetos.listaVetor();
					break;
				case 3:
					vCompetencias.listaVetor();
					break;
				case 4:
					vColaboradores.listaVetor();
					break;
				default:
					break;
				}// fim menu2
				break;
			case 2: // menu1
				menu3.show();// menu3 cadastro
				switch (menu3.getOption()) {

				case 1:
					addFuncionario();
					break;
				case 2:
					addProjeto();
					break;
				case 3:
					addCompetencia();
					break;
				case 4:
					assColaboradores();
					break;					
				default:
					break;
				}// fim menu3
				break;
			case 3: // menu1
				menu4.show();// menu4 de exclusao
				switch (menu4.getOption()) {

				case 1:
					vFuncionarios.remove(Integer.parseInt(digita("Digite o indice do funcionario:")));
					break;
				case 2:
					vProjetos.remove(Integer.parseInt(digita("Digite o indice do projeto:")));
					break;
				case 3:
					vCompetencias.remove(Integer.parseInt(digita("Digite o indice da competencia:")));					
					break;
				case 4:
					vColaboradores.remove(Integer.parseInt(digita("Digite o indice do colaborador:")));
					break;
				default:
					break;
				}// fim menu4
				break;
			case 4: // menu1
				System.out.println("Em construção...");
				break;
			default: // menu1
				System.exit(-1);
			}// fim menu1
		} while (true);
	}
	
	private void assColaboradores() {
		System.out.println("Em construção...");
	}

	public void verificaFuncionarios() throws FileNotFoundException {
		Parser<Funcionarios> parser = new FuncionariosParser();
		CSVReader<Funcionarios> leitor = new CSVReader<>("funcionarios.csv", parser);
		leitor.skipLine();
		while (leitor.hasNext()) {
			Funcionarios funcionario = leitor.readObject();
			vFuncionarios.append(funcionario);
		}
		leitor.close();
	}// fim verifica funcionarios

	public void verificaProjetos() throws FileNotFoundException {
		Parser<Projetos> parser = new ProjetosParser();
		CSVReader<Projetos> leitor = new CSVReader<>("projetos.csv", parser);
		leitor.skipLine();
		while (leitor.hasNext()) {
			Projetos projeto = leitor.readObject();
			vProjetos.append(projeto);			
		}
		leitor.close();
	}// fim verifica projetos	

	public void verificaCompetencias() throws FileNotFoundException {		
		Parser<Competencias> parser = new CompetenciasParser();
		CSVReader<Competencias> leitor = new CSVReader<>("competencias.csv", parser);
		leitor.skipLine();
		while (leitor.hasNext()) {
			Competencias competencia = leitor.readObject();
			vCompetencias.append(competencia);			
		}
		leitor.close();
	}// fim verifica competencias

	public void verificaColaboradores() throws FileNotFoundException {		
		Parser<Colaboradores> parser = new ColaboradoresParser();
		CSVReader<Colaboradores> leitor = new CSVReader<>("colaboradores.csv", parser);
		leitor.skipLine();
		while (leitor.hasNext()) {
			Colaboradores colaborador = leitor.readObject();
			vColaboradores.append(colaborador);
		}
		leitor.close();
	}// fim verifica colaboradores

	private void addFuncionario() {
		try {
			Funcionarios Func = new Funcionarios(digita("Informe o nome do funcionario: "),
					Double.parseDouble(digita("Informe o salario do funcionario: ")),
					Integer.parseInt(digita("Informe a quantidade de competencias")));
			Func.addCompetencias();
			vFuncionarios.append(Func);
		} catch (Exception e) {
			System.out.println("\nERRO! Verifique os valores digitados!!\n");
		}
	}// fim addFuncionario
	
	public void addCompetencia() {
		Competencias Comp = new Competencias(digita("Informe a competencia: "));		
		vCompetencias.append(Comp);
	}// fim addCompetencia

	@SuppressWarnings("unused")
	private void addProjeto() {
		LocalDate inicio;
		LocalDate fim;
		try {
			Projetos novoProjeto = new Projetos(digita("Digite o nome do Projeto: "),
					LocalDate.parse((digita("Digite a data de inicio no formato AAAA-MM-DD"))),
					LocalDate.parse((digita("Digite a data final no formato AAAA-MM-DD"))),
					Integer.parseInt(digita("Informe o numero de competencias")));
			novoProjeto.addCompetencias();
			vProjetos.append(novoProjeto);// esta tratando como outro vetor!!!
		} catch (Exception err) {
			System.out.println("Data inválida");
		}
/*		for (int i = 0; i < vProjetos.size(); i++) {
			System.out.println("[" + (i + 1) + "]" + vProjetos.get(i));
		} // print só pra verificação 
*/		
	}// fim addProjeto

	@SuppressWarnings("resource")
	public String digita(String texto) {
		Scanner ler = new Scanner(System.in);
		System.out.println(texto);
		final String text = ler.nextLine(); 
		return text;
	}// fecha digita
}// fecha a classe