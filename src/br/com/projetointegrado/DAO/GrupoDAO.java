package br.com.projetointegrado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.projetointegrado.conexao.ConnectionFactory;
import br.com.projetointegrado.model.Grupo;
import br.com.projetointegrado.model.Professor;



public class GrupoDAO {

	public void criarGrupo(Grupo to) {
		String sqlInsert = "INSERT INTO grupo(orientador_id, numero, nome) VALUES (?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setObject(1, to.getOrientador());
			stm.setInt(2, to.getNumero());  
			stm.setString(3, to.getGrupo_nome());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					to.setGrupo_id(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void atualizarGrupo(Grupo to) {
		String sqlUpdate = "UPDATE grupo SET orientador_id=?, numero=?, nome=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setObject(1, to.getOrientador());
			stm.setInt(2, to.getNumero());  
			stm.setString(3, to.getGrupo_nome());
			stm.setInt(4, to.getGrupo_id());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void excluirGrupo(int id) {
		String sqlDelete = "DELETE FROM grupo WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Grupo carregarGrupo2(int id) {
		Grupo to = new Grupo();
		String sqlSelect = "SELECT orientador_id, numero, nome, p.* FROM grupo g"
				+ "inner join professor p on g.orientador_id = p.id WHERE grupo.id =?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getGrupo_id());
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					Professor prof = new Professor();
					
					to.setOrientador(prof);
					to.setNumero(rs.getInt("numero"));
					to.setGrupo_nome(rs.getString("nome"));
					to.setGrupo_id(-1);
					to.setOrientador(null);
					to.setNumero(-1);
					to.setGrupo_nome(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
    }
	public Grupo carregarGrupo(int id) {
		Grupo to = new Grupo();
		to.setGrupo_id(id);
		String sqlSelect = "SELECT * FROM grupo WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getGrupo_id());
			try (ResultSet rs = stm.executeQuery();) {
				//while(rs.next()) {
					//Professor prof = new Professor();
					//to.setOrientador(prof);
				//}
				if (rs.next()) {
					to.setNumero(rs.getInt("numero"));
					to.setGrupo_nome(rs.getString("nome"));
				} else {
					to.setGrupo_id(-1);
					to.setNumero(-1);
					to.setGrupo_nome(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
    }
	public ArrayList<Grupo> findAll() {
		ArrayList<Grupo> lista = new ArrayList<Grupo>();
		String sqlSelect = "SELECT * FROM grupo";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Grupo to = new Grupo();
					to.setGrupo_nome(rs.getString("nome"));
					to.setNumero(rs.getInt("numero"));
					to.setGrupo_id(rs.getInt("id"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	public ArrayList<Grupo> findAll(String chave) {
		ArrayList<Grupo> lista = new ArrayList<Grupo>();
		String sqlSelect = "SELECT * FROM grupo WHERE upper (nome) like ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Grupo to = new Grupo();
					to.setGrupo_nome(rs.getString("nome"));
					to.setNumero(rs.getInt("numero"));
					to.setGrupo_id(rs.getInt("id"));
					lista.add(to);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
}
