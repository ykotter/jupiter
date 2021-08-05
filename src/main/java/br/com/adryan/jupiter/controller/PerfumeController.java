package br.com.adryan.jupiter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import br.com.adryan.jupiter.model.PerfumeModel;
import br.com.adryan.jupiter.model.saver.SalvaDados;

@RestController
@RequestMapping("/pm")
public class PerfumeController {

	@GetMapping("/add")
	public PerfumeModel addPerfume(@RequestParam(value = "nome") String nome, 
								   @RequestParam(value = "tipo") String tipo,
								   @RequestParam(value = "valor") BigDecimal valor)
	{
		
		PerfumeModel p = new PerfumeModel(nome, tipo, valor);
		SalvaDados.perfumes.add(p);
		return p;
	}
	
	@GetMapping("/alterar")
	public PerfumeModel alteraPerfume(@RequestParam(value = "id") Long id,
			                          @RequestParam(value = "nome") String nome, 
								      @RequestParam(value = "tipo") String tipo,
								      @RequestParam(value = "valor") BigDecimal valor)
	{
		for (PerfumeModel p : SalvaDados.perfumes) {
			if (id.equals(p.getId())) {
				p.alterar(nome, tipo, valor);
				return p;
			}
		}
		return null;
	}
	
	@GetMapping("/remover")
	public PerfumeModel removerPerfume(@RequestParam(value = "id") Long id) {
		PerfumeModel perfume = null;
		for (PerfumeModel p : SalvaDados.perfumes) {
			if (id.equals(p.getId())) {
			perfume = p;
			break;
			}
		}
	
		if (Objects.nonNull(perfume)) {
			SalvaDados.perfumes.remove(perfume);
			return perfume;
		}
	return null;
	}
	
	@GetMapping("/listar")
	public List<PerfumeModel> Listar() {
		return SalvaDados.perfumes;
	}
}