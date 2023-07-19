package br.com.farmacia.domain;

public class Produtos {
	
	private Long idProdutos;
	private String descricao;
	private Long quantidade;
	private Double preco;	
	private Fornecedores fornecedores = new Fornecedores();
	
	public Produtos() {
		
	}

	public Long getIdProdutos() {
		return idProdutos;
	}

	public void setIdProdutos(Long idProdutos) {
		this.idProdutos = idProdutos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}

	@Override
	public String toString() {
		return "Produtos [idProdutos=" + idProdutos + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", preco=" + preco + ", fornecedores=" + fornecedores + "]";
	}
	
	
	
	
	

}
