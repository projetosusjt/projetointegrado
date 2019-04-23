package br.com.projetointegrado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetointegrado.conexao.ConnectionFactory;
import br.com.projetointegrado.model.Atividade;

public class AtividadeDAO {

	public int criar(Atividade to) {
		String sqlInsert = "INSERT INTO atividade(id, numero, descricao, formato_entrega, dt_inicio, dt_fim) VALUES (?, ?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getAtividade_id());
			stm.setInt(2, to.getNumero());
			stm.setString(3, to.getDescricao());
			stm.setString(4, to.getFormato());
			stm.setObject(5, to.getDt_inicio());
			stm.setObject(6, to.getDt_fim());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					to.setAtividade_id(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return to.getAtividade_id();
	}

	public void atualizar(Atividade to) {
		String sqlUpdate = "UPDATE atividade SET numero=?, descricao=?, formato_entrega=?, dt_inicio=?, dt_fim=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, to.getNumero());
			stm.setString(2, to.getDescricao());
			stm.setString(3, to.getFormato());
			stm.setObject(4, to.getDt_inicio());
			stm.setObject(5, to.getDt_fim());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM atividade WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Atividade carregar(int id) {
		Atividade to = new Atividade();
		to.setAtividade_id(id);
		String sqlSelect = "SELECT numero, descricao, formato_entrega, dt_inicio, dt_fim FROM atividade WHERE atividade.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getAtividade_id());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNumero(rs.getInt("numero"));
					to.setDescricao(rs.getString("descricao"));
					to.setFormato(rs.getString("formato_entrega"));
					//to.setDt_inicio(rs.getObject("dt_inicio"));
					//to.setDt_fim(rs.getObject("dt_fim"));
				} else {
					to.setAtividade_id(-1);
					to.setNumero(1);
					to.setDescricao(null);
					to.setFormato(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

}
