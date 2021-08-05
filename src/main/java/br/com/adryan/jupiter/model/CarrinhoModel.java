package br.com.adryan.jupiter.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoModel {
	
	private static long count = 0;
	
	private Long id;
	private List<ItemCarrinhoModel> itens;
	private EnumStatusCarrinho status;

	public CarrinhoModel() {
		this.id = ++count;
		this.itens = new ArrayList<>();
		this.status = EnumStatusCarrinho.ANDAMENTO;
	}
	
	public void addPerfume(PerfumeModel p, Integer qtd) {
		if (EnumStatusCarrinho.FINALIZADO.equals(this.status)) {
			throw new RuntimeException("Carrinho finalizado");
		}
		this.itens.add(new ItemCarrinhoModel(p, qtd));
	}
	
	public void finalizar() {
		this.status = EnumStatusCarrinho.FINALIZADO;
	}

	public Long getId() {
		return id;
	}

	public List<ItemCarrinhoModel> getItens() {
		return itens;
	}

	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for (ItemCarrinhoModel i : itens) {
			soma = soma.add(i.getValorTotal());
		}
		return soma;
	}

	public EnumStatusCarrinho getStatus() {
		return status;
	}
}