package br.edu.univas.vo;

import java.util.Comparator;

public class Tree {

	private No raiz;
	
	public void inserir(Peca peca) {
		if(raiz == null) {
			raiz = criarNo(peca);
		} else {
			inserirNoInterno(raiz, peca);
		}
	}
	
	private void inserirNoInterno(No raizDaSubArvore, Peca novaPeca) {
		if(novaPeca.modelo.equals(raizDaSubArvore.peca.modelo)) {
			return;
		}
		if(novaPeca.valorUnitario < raizDaSubArvore.peca.valorUnitario) {
			if(raizDaSubArvore.esquerda == null) {
				raizDaSubArvore.esquerda = criarNo(novaPeca);
			} else {
				inserirNoInterno(raizDaSubArvore.esquerda, novaPeca);
			}
		} else {
			if(raizDaSubArvore.direita == null) {
				raizDaSubArvore.direita = criarNo(novaPeca);
			} else {
				inserirNoInterno(raizDaSubArvore.direita, novaPeca);
			}
		}
	}
	
	public No criarNo(Peca novaPeca) {
		No novoNo = new No();
		novoNo.peca = novaPeca;
		return novoNo;
	}
	
	public Peca buscar(Peca pecaBuscada, Comparator<Peca> comparador) {
		return buscarPeca(raiz, pecaBuscada, comparador);
	}
	
	private Peca buscarPeca(No raizDaSubArvore, Peca pecaBuscada, Comparator<Peca> comparador) {
		if(raizDaSubArvore == null) {
			return null;
		}
		
		int result = comparador.compare(pecaBuscada, raizDaSubArvore.peca);
		
		if(result == 0) {
			return raizDaSubArvore.peca;
		} else if(result < 0) {
			return buscarPeca(raizDaSubArvore.esquerda, pecaBuscada, comparador);
		} else {
			return buscarPeca(raizDaSubArvore.direita, pecaBuscada, comparador);
		}
	}
}

