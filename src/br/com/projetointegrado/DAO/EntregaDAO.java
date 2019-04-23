package br.com.projetointegrado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetointegrado.conexao.ConnectionFactory;
import br.com.projetointegrado.model.Entrega;

public class EntregaDAO {

	public int criar(Entrega to) {
		String sqlInsert = "INSERT INTO entrega (id) VALUES (?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getEntrega_id());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					to.setEntrega_id(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return to.getEntrega_id();
	}

	public void atualizar(Entrega to) {
		String sqlUpdate = "UPDATE entrega SET grupo_id=?, atividade_id=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setObject(1, to.getGrupo());
			stm.setObject(2, to.getAtividade());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM entrega WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Entrega carregar(int id) {
		Entrega to = new Entrega();
		to.setEntrega_id(id);
		String sqlSelect = "SELECT numero, descricao, formato_entrega, dt_inicio, dt_fim FROM atividade WHERE atividade.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getEntrega_id());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					//to.setNumero(rs.getInt("numero"));
					//to.setDescricao(rs.getString("descricao"));
					//to.setFormato(rs.getString("formato_entrega"));
					//to.setDt_inicio(rs.getObject("dt_inicio"));
					//to.setDt_fim(rs.getObject("dt_fim"));
				} else {
					//to.setAtividade_id(-1);
					//to.setNumero(1);
					//to.setDescricao(null);
					//to.setFormato(null);
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
