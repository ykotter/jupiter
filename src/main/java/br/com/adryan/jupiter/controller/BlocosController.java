package br.com.adryan.jupiter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adryan.jupiter.model.BlocosModel;

@RestController
@RequestMapping("/bc")
public class BlocosController {
	
	@GetMapping("/matriz-num")
	public Long[][] matrizNumero() {
		return new BlocosModel().criarMatrizLong();
	}
	
	@GetMapping("/matriz-letra")
	public char[][] matrizLetra() {
		return new BlocosModel().criarMatrizChar();
	}
}