package br.com.projetointegrado.service;

import br.com.projetointegrado.DAO.GrupoDAO;
import br.com.projetointegrado.model.Grupo;

public class GrupoService {

	GrupoDAO dao;
	
	public GrupoService() {
		dao = new GrupoDAO();
	}
	
	public void criar(Grupo to) {
		dao.criarGrupo(to);
	}
	public void atualizar(Grupo to) {
		dao.atualizarGrupo(to);
	}
	public void excluir(Grupo to) {
		dao.excluirGrupo(to);
	}
	public Grupo carregar(int id) {
		Grupo to = dao.carregarGrupo(id);
		return to;
	}

}
