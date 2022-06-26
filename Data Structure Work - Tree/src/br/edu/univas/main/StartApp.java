package br.edu.univas.main;

import java.util.Scanner;
import br.edu.univas.vo.Peca;
import br.edu.univas.vo.Tree;

public class StartApp {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("ÁRVORE GENÉRICA - SKATE");
		Tree skate = new Tree();
		Float valorFinal = 0.0f;
		
		Peca meuSkate = new Peca();
		skate.inserir(meuSkate);
	
		System.out.println("1° PEÇA - SHAPE");
		Peca shape = criarPeca(valorFinal);
		skate.inserir(shape);
		
		System.out.println("2° PEÇA - LIXA");
		Peca lixa = criarPeca(valorFinal);
		skate.inserir(lixa);
		
		System.out.println("3° PEÇA - PARAFUSOS DE BASE");
		Peca parafusoBase = criarPeca(valorFinal);
		skate.inserir(parafusoBase);
		
		System.out.println("4° PEÇA - TRUCK");
		Peca truck = criarPeca(valorFinal);
		skate.inserir(truck);
		
		System.out.println("5° PEÇA - RODINHAS");
		Peca rodinhas = criarPeca(valorFinal);
		skate.inserir(rodinhas);
		
		System.out.println("6° PEÇA - ROLAMENTO");
		Peca rolamento = criarPeca(valorFinal);
		skate.inserir(rolamento);
		
		meuSkate.listaFilhos.add(shape);
		meuSkate.listaFilhos.add(truck);
		
		shape.listaFilhos.add(lixa);
		shape.listaFilhos.add(parafusoBase);
		
		truck.listaFilhos.add(rodinhas);
		truck.listaFilhos.add(rolamento);
		
		System.out.println("VALOR TOTAL: R$" + valorFinal );
		
		for(int i=0; i<shape.listaFilhos.size(); i++){
	        System.out.println("Partes do Truck:"+shape.listaFilhos.get(i));

	    }
	        for(int i=0; i<truck.listaFilhos.size(); i++){
	            System.out.println("Partes do Truck:"+truck.listaFilhos.get(i));
	    }
						
	}
	
	public static Peca criarPeca(Float valorFinal) {
		Peca pecaAtual = new Peca();
		System.out.println("DIGITE O NOME DO MODELO ESCOLHIDO:");
		pecaAtual.modelo = scanner.nextLine();
		
		System.out.println("DIGITE O VALOR UNITARIO: ");
		pecaAtual.valorUnitario = scanner.nextFloat();
		scanner.nextLine();
		
		System.out.println("DIGITE A QUANTIDADE: ");
		pecaAtual.quantidade = scanner.nextInt();
		scanner.nextLine();
		
		valorFinal += pecaAtual.valorUnitario;
		
		System.out.println("PEÇA ADICIONADO COM SUCESSO!");
		
		return pecaAtual;
	}
}
