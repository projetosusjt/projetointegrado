package br.com.projetointegrado.model;

import java.util.Calendar;

public class Entrega {
	private Atividade atividade;
	private Grupo grupo;
	private int entrega_id;
	private Calendar dt_entrega;
	private Avaliacao avaliacao;

	public Entrega(Atividade atividade, Grupo grupo, int entrega_id, Calendar dt_entrega) {
		super();
		this.atividade = atividade;
		this.grupo = grupo;
		this.entrega_id = entrega_id;
		this.dt_entrega = dt_entrega;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public int getEntrega_id() {
		return entrega_id;
	}

	public void setEntrega_id(int entrega_id) {
		this.entrega_id = entrega_id;
	}

	public Calendar getDt_entrega() {
		return dt_entrega;
	}

	public void setDt_entrega(Calendar dt_entrega) {
		this.dt_entrega = dt_entrega;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}



}
