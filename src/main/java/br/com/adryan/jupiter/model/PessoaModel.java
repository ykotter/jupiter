package br.com.adryan.jupiter.model;

public abstract class PessoaModel {
	
	private String documento;
	
	public PessoaModel(String documento) {
		this.documento = documento;
	}

	public abstract Boolean validarDocumento();
	public abstract String gerarDocumento();
	public abstract String getDocumentoFormatado();
	
	public String getDocumento() {
		return documento;
	}
}
