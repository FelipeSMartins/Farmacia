package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {

	public void salvar(Fornecedores f) throws SQLException {
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao)");
		sql.append("VALUES (?)");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando =  conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
		
	}
	
	public static void main(String[] args) {
		Fornecedores f1 = new Fornecedores();
		f1.setDescricao("Teste 1");
		
		Fornecedores f2 = new Fornecedores();
		f2.setDescricao("Teste 2");
		
		FornecedoresDAO dao = new FornecedoresDAO();
		try {
			dao.salvar(f1);
			dao.salvar(f2);
			System.out.println("Fornecedores salvos com sucesso!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}