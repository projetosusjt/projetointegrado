package br.com.projetointegrado.service;

import br.com.projetointegrado.DAO.AtividadeDAO;
import br.com.projetointegrado.model.Atividade;

public class AtividadeService {
	
	AtividadeDAO dao;

	public AtividadeService() {
		dao = new AtividadeDAO();
	}
	
	public void criar(Atividade to) {
		dao.criar(to);
	}
	public void atualizar(Atividade to) {
		dao.atualizar(to);
	}
	public void excluir(Atividade to) {
		dao.excluir(1);
	}
	public Atividade carregar(int id) {
		Atividade to = dao.carregar(id);
		return to;
	}

}
