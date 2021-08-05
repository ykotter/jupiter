package br.com.adryan.jupiter.model.saver;

import java.util.ArrayList;
import java.util.List;

import br.com.adryan.jupiter.model.CarrinhoModel;
import br.com.adryan.jupiter.model.PerfumeModel;

public class SalvaDados {
	
	private SalvaDados() {}
	
	public static List<PerfumeModel> perfumes = new ArrayList<>();
	public static CarrinhoModel carrinho = new CarrinhoModel();
	

}
