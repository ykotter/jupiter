package br.com.adryan.jupiter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.adryan.jupiter.saver.SalvaDados;
import br.com.adryan.jupiter.model.CarrinhoModel;
import br.com.adryan.jupiter.model.PerfumeModel;

@RestController
@RequestMapping("/c")
public class CarrinhoController {
	
	@GetMapping("/add")
	public CarrinhoModel addCarrinho(@RequestParam(value = "id") Long id,
								     @RequestParam(value = "qtd") Integer qtd)
	{	
		CarrinhoModel c = SalvaDados.carrinho;
		PerfumeModel perfume = null;
		for (PerfumeModel p : SalvaDados.perfumes) {
			if (id.equals(p.getId())) {
				perfume = p;
			}
		}
		c.addPerfume(perfume, qtd);
		return c;
	}
	
	@GetMapping("/finalizar")
	public CarrinhoModel finalizar() {
		CarrinhoModel c = SalvaDados.carrinho;
		c.finalizar();
		SalvaDados.carrinho = new CarrinhoModel();
		return c;
	}
	
	@GetMapping("/listar")
	public CarrinhoModel listar() {
		return SalvaDados.carrinho;
	}
}
