package br.com.farmacia.dao;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConexaoFactory;

public class FornecedoresDAO {

	public void salvar(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();

	}

	public void excluir(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores WHERE idfornecedores = (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getIdFornecedores());
		comando.executeUpdate();

	}

	public void editar(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao = (?) ");
		sql.append("WHERE idfornecedores = (?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(2, f.getIdFornecedores());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();

	}

	public Fornecedores buscaPorCodigo(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idfornecedores, descricao ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE idfornecedores = (?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getIdFornecedores());
		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;

		if (resultado.next()) {

			retorno = new Fornecedores();
			retorno.setIdFornecedores(resultado.getLong("idfornecedores"));
			retorno.setDescricao(resultado.getString("descricao"));

		} else {

			System.out.println("Não existe resultado a retornar");

		}

		return retorno;

	}

	public static void main(String[] args) {

		Fornecedores f1 = new Fornecedores();
		f1.setIdFornecedores(2);

		FornecedoresDAO dao = new FornecedoresDAO();

		try {

			dao.buscaPorCodigo(f1);
			System.out.println("Resultado " + f1.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
