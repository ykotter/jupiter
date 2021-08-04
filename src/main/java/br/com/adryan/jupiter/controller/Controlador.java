package br.com.adryan.jupiter.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.adryan.jupiter.model.PessoaFisicaModel;
import br.com.adryan.jupiter.model.PessoaJuridicaModel;

@RestController
public class Controlador {

	@GetMapping("/valida-cpf")
	public Boolean validaCpf(@RequestParam(value = "cpf") String cpf) {
		return new PessoaFisicaModel(cpf).validarDocumento();
	}
	
	@GetMapping("/gerar-cpf")
	public PessoaFisicaModel gerarCpf(@RequestParam(value = "cpf") String cpf) {
		return new PessoaFisicaModel(cpf);
	}
	
	@GetMapping("/valida-cnpj")
	public Boolean validaCnpj(@RequestParam(value = "cnpj") String cnpj) {
		return new PessoaJuridicaModel(cnpj).validarDocumento();
	}
	
	@GetMapping("/gerar-cnpj")
	public PessoaJuridicaModel gerarcnpj(@RequestParam(value = "cnpj") String cnpj) {
		return new PessoaJuridicaModel(cnpj);
	}
}
