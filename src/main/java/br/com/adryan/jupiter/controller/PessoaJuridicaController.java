package br.com.adryan.jupiter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.adryan.jupiter.model.PessoaJuridicaModel;

@RestController
@RequestMapping("/pj")
public class PessoaJuridicaController {
	
	@GetMapping("/valida-cnpj")
	public Boolean validaCnpj(@RequestParam(value = "cnpj") String cnpj) {
		return new PessoaJuridicaModel(cnpj).validarDocumento();
	}
	
	@GetMapping("/gerar-cnpj")
	public PessoaJuridicaModel gerarcnpj(@RequestParam(value = "cnpj") String cnpj) {
		return new PessoaJuridicaModel(cnpj);
	}
}
