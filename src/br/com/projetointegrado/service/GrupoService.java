package br.com.projetointegrado.service;

import java.util.ArrayList;

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
	public void excluir(int id) {
		dao.excluirGrupo(id);
	}
	public Grupo carregar(int id) {
		
		return dao.carregarGrupo(id);
	}
	public ArrayList<Grupo> findAll() {
		ArrayList<Grupo> to = dao.findAll();
		return to;
	}
	public ArrayList<Grupo> findAll(String chave) {
		
		return dao.findAll(chave);
	}
}
