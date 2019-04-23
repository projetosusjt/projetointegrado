package br.com.projetointegrado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projetointegrado.conexao.ConnectionFactory;
import br.com.projetointegrado.model.Professor;

public class ProfessorDAO {

	public int criar(Professor to) {
		String sqlInsert = "INSERT INTO professor(professor_id, administrador, matricula) VALUES (?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getEmail());
			stm.setString(3, to.getSenha());
			stm.setInt(4, to.getProfessor_id());
			stm.setObject(5, to.getAdministrador());
			stm.setString(6, to.getMatricula());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return to.getId();
	}

	public void atualizar(Professor to) {
		String sqlUpdate = "UPDATE professor SET professor_id=?, administrador=?, matricula=? WHERE id=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, to.getProfessor_id());
			stm.setObject(2, to.getAdministrador());
			stm.setString(3, to.getMatricula());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM professor WHERE id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Professor carregar(int id) {
		Professor to = new Professor(id, null, null, null);
		to.setId(id);
		String sqlSelect = "SELECT professor_id, administrador, matricula FROM professor WHERE professor.id = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setProfessor_id(rs.getInt("professor_id"));
					to.setEmail(rs.getString("administrador"));
					to.setMatricula(rs.getString("matricula"));
				} else {
					to.setId(-1);
					to.setProfessor_id(1);
					to.setEmail(null);
					to.setMatricula(null);
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
