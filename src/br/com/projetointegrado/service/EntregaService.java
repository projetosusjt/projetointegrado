package br.com.projetointegrado.service;

import br.com.projetointegrado.DAO.EntregaDAO;
import br.com.projetointegrado.model.Entrega;

public class EntregaService {
	
	EntregaDAO dao;

	public EntregaService() {
		dao = new EntregaDAO();
	}
	
	public void criar(Entrega to) {
		dao.criar(to);
	}
	public void atualizar(Entrega to) {
		dao.atualizar(to);
	}
	public void excluir(Entrega to) {
		dao.excluir(1);
	}
	public Entrega carregar(int id) {
		Entrega to = dao.carregar(id);
		return to;
	}

}
