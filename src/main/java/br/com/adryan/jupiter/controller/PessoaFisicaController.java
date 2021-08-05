package br.com.adryan.jupiter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.adryan.jupiter.model.PessoaFisicaModel;

@RestController
@RequestMapping("/pf")
public class PessoaFisicaController {

	@GetMapping("/valida-cpf")
	public Boolean validaCpf(@RequestParam(value = "cpf") String cpf) {
		return new PessoaFisicaModel(cpf).validarDocumento();
	}
	
	@GetMapping("/gerar-cpf")
	public PessoaFisicaModel gerarCpf(@RequestParam(value = "cpf") String cpf) {
		return new PessoaFisicaModel(cpf);
	}
}
