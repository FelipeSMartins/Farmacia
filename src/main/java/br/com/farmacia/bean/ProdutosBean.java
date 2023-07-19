package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.dao.FornecedoresDAO;
import br.com.farmacia.dao.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBProdutos")
@ViewScoped
public class ProdutosBean {
	
	private Produtos produtos;
	
	private ArrayList<Produtos> itens;
	
	private ArrayList<Produtos> itensFiltrados;
	
	private ArrayList<Fornecedores> comboFornecedores;
	
	public ArrayList<Fornecedores> getComboFornecedores() {
		return comboFornecedores;
	}
	
	public void setComboFornecedores(ArrayList<Fornecedores> comboFornecedores) {
		this.comboFornecedores = comboFornecedores;
	}

	public Produtos getProdutos() {
		return produtos;
	}

	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Produtos> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Produtos> itens) {
		this.itens = itens;
	}

	public ArrayList<Produtos> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Produtos> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	@PostConstruct
	public void prepararPesquisa() {

		try {

			ProdutosDAO pdao = new ProdutosDAO();
			itens = pdao.listar();
			

		} catch (SQLException e) {
			JSFUtil.adicionarMsgErro("ex.getMessage()");
			e.printStackTrace();
		}

	}
	
	public void prepararNovo() {

		
		try {
			
			produtos = new Produtos();
			FornecedoresDAO fdao = new FornecedoresDAO();
			comboFornecedores = fdao.listar();
			
		} catch (SQLException e) {
			JSFUtil.adicionarMsgErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public void novo() {

		try {

			ProdutosDAO pdao = new ProdutosDAO();
			pdao.salvar(produtos);

			itens = pdao.listar();
			
			JSFUtil.adicionarMsgSucesso("Salvo com sucesso");

		} catch (SQLException e) {
			JSFUtil.adicionarMsgErro("ex.getMessage()");
			e.printStackTrace();
		}

	}
	
	public void excluir() {

		try {

			ProdutosDAO pdao = new ProdutosDAO();
			pdao.excluir(produtos);

			itens = pdao.listar();

			JSFUtil.adicionarMsgSucesso("Excluído com sucesso");

		} catch (SQLException e) {
			JSFUtil.adicionarMsgErro("Erro ao excluir o Fornecedor");
			e.printStackTrace();
		}

	}
	
	public void editar() {

		try {

			ProdutosDAO pdao = new ProdutosDAO();
			pdao.editar(produtos);

			itens = pdao.listar();

			JSFUtil.adicionarMsgSucesso("Edição com sucesso");

		} catch (SQLException e) {
			JSFUtil.adicionarMsgErro("Erro ao editar o Fornecedor");
			e.printStackTrace();
		}

	}
	
	

}
