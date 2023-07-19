package br.com.farmacia.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.farmacia.dao.ProdutosDAO;
import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;


public class TestProdutoDAO {
	
	@Test
	
	public void salvar() throws SQLException {

		Produtos p1 = new Produtos();
		p1.setDescricao("Dorlfex");
		p1.setQuantidade(4L);
		p1.setPreco(7.00);

		Fornecedores f = new Fornecedores();

		f.setIdFornecedores(37L);
		p1.setFornecedores(f);

		ProdutosDAO pdao = new ProdutosDAO();
		pdao.salvar(p1);

	}
	
	@Test
	@Ignore
	public void listar() throws SQLException {
		
		ProdutosDAO dao = new ProdutosDAO();
		ArrayList<Produtos> lista = dao.listar();
		
		for (Produtos p : lista) {
			System.out.println(p.toString());
		}
	
		
	}
	
	@Test
	@Ignore
	public void excluir() throws SQLException {
		
		Produtos p = new Produtos();
		p.setIdProdutos(2L);
		
		ProdutosDAO dao = new ProdutosDAO();
		dao.excluir(p);
		
	}
	
	@Test
	@Ignore
	public void editar() throws SQLException{
			
		Produtos p = new Produtos();
		p.setIdProdutos(4L);
		p.setDescricao("Cataflan");
		p.setPreco(30.00);
		p.setQuantidade(20L);
		
		Fornecedores f = new Fornecedores();		
		f.setIdFornecedores(30L);
		p.setFornecedores(f);
		
		ProdutosDAO dao = new ProdutosDAO();
		dao.editar(p);
		
	
	}
}
