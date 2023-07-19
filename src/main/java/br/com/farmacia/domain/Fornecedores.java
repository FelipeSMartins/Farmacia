package br.com.farmacia.domain;

public class Fornecedores {
	
	private Long idFornecedores;
	private String descricao;
	
	public Fornecedores() {
		
	}
		
	
	public Long getIdFornecedores() {
		return idFornecedores;
	}


	public void setIdFornecedores(Long idFornecedores) {
		this.idFornecedores = idFornecedores;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	@Override
	public String toString() {
		return "Fornecedores [idFornecedores=" + idFornecedores + ", descricao=" + descricao + "]";
	}
	
	

}
