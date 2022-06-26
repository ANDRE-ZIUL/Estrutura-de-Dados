package br.edu.univas.vo;

import java.util.ArrayList;

public class Peca {
	
	public String modelo;
	public Float valorUnitario;
	public int quantidade;
	public ArrayList<Peca> listaFilhos = new ArrayList<Peca>();
}
