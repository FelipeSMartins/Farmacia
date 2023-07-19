package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.domain.Produtos;
import br.com.farmacia.factory.ConexaoFactory;

public class ProdutosDAO {
	
	public void salvar(Produtos p) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produtos ");
		sql.append("(descricao, quantidade, preco, idfornecedores) ");
		sql.append("VALUES (?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescricao());
		comando.setLong(2, p.getQuantidade());
		comando.setDouble(3, p.getPreco());
		comando.setLong(4, p.getFornecedores().getIdFornecedores());
		comando.executeUpdate();
		
	}
	
	public ArrayList<Produtos> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p.idprodutos, p.descricao, p.quantidade, p.preco, f.idFornecedores, f.descricao ");
		sql.append("FROM produtos p ");
		sql.append("INNER JOIN fornecedores f ON p.idfornecedores = f.idfornecedores");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Produtos> lista = new ArrayList<Produtos>();

		while (resultado.next()) {
						
			Fornecedores f = new Fornecedores();
			f.setIdFornecedores(resultado.getLong("f.idfornecedores"));
			f.setDescricao(resultado.getString("f.descricao"));	
			
			Produtos p = new Produtos();			
			p.setIdProdutos(resultado.getLong("p.idprodutos"));
			p.setDescricao(resultado.getString("p.descricao"));
			p.setQuantidade(resultado.getLong("p.quantidade"));
			p.setPreco(resultado.getDouble("p.preco"));		
			p.setFornecedores(f);

			lista.add(p);

		}

		return lista;

	}
	
	public void excluir(Produtos p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM produtos WHERE idprodutos = (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, p.getIdProdutos());
		comando.executeUpdate();

	}
	
	public void editar(Produtos p) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE produtos ");
		sql.append("SET descricao = ?, preco = ?, quantidade = ?, idfornecedores = ? ");
		sql.append("WHERE idprodutos = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, p.getDescricao());
		comando.setDouble(2, p.getPreco());
		comando.setLong(3, p.getQuantidade());
		comando.setLong(4, p.getFornecedores().getIdFornecedores());
		comando.setLong(5, p.getIdProdutos());
		comando.executeUpdate();

	}

}
