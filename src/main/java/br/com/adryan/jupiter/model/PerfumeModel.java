package br.com.adryan.jupiter.model;

import java.math.BigDecimal;

public class PerfumeModel {
	
	private static long count = 0;
	
	private Long id;
	private String nome;
	private String tipo;
	private BigDecimal valor;
	
	public PerfumeModel(String nome, String tipo, BigDecimal valor) {
		this.id = ++count;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public void alterar(String nome, String tipo, BigDecimal valor) {
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public void remover() {
		
	}
	public static long getCount() {
		return count;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}
	
	
}
