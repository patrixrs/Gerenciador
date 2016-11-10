package Gerenciador;

import java.io.UnsupportedEncodingException;

public class Vetor<T> {

	@SuppressWarnings("unchecked")
	private T[] dados = (T[]) new Object[2];
	private int numElementos = 0;

	public void append(T valor) {
		aumentaEspaco();
		dados[numElementos] = valor;
		numElementos++;
	}// fim append

	public void aumentaEspaco() {
		if (numElementos >= dados.length) {
			@SuppressWarnings("unchecked")
			T[] novo = (T[]) new Object[dados.length * 2];
			for (int i = 0; i < dados.length; i++) {
				novo[i] = dados[i];
			}
			dados = novo;
		}
	}// fim aumentaEspaço

	public T get(int index) {
		validaIndex(index);
		return dados[index];
	}// fim get

	public void listaVetor() {
		for (int i = 0; i < dados.length; i++) {
			if (dados[i] != null) {
				String texto = "[" + (i) + "]" + dados[i];
				try {
					System.out.println(new String(texto.getBytes(), "UTF-8"));// escreve os acentos do arquivo csv
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
	}// fim listaVetor

	public int size() {
		return numElementos;
	}// fim size

	public void insert(int index, T valor) {
		validaIndex(index);
		aumentaEspaco();
		for (int i = numElementos; i > index; i--) {
			dados[i] = dados[i - 1];
		}
		dados[index] = valor;
		numElementos++;
	}// fim insert

	private void validaIndex(int index) {
		if (index < 0 || index >= dados.length) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}// fim validaIndex

	public void remove(int index) {
		validaIndex(index);
		for (int i = index; i < numElementos; i++) {
			if (dados[i + 1] == null) {
				dados[i] = null;
			} else {
				dados[i] = dados[i + 1];
			}
		}
		numElementos--;
	}// fim remove
}// fim da classe