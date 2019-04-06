package br.com.projetointegrado.model;

import java.util.Calendar;

public class Atividade {
	private int atividade_id, numero;
	private String descricao, formato;
	private Calendar dt_inicio, dt_fim;
	private Tema tema;

	public Atividade(int atividade_id, int numero, String descricao, String formato, Calendar dt_inicio,
			Calendar dt_fim, Tema tema) {
		super();
		this.atividade_id = atividade_id;
		this.numero = numero;
		this.descricao = descricao;
		this.formato = formato;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		this.tema = tema;
	}

	public int getAtividade_id() {
		return atividade_id;
	}

	public void setAtividade_id(int atividade_id) {
		this.atividade_id = atividade_id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Calendar getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Calendar dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public Calendar getDt_fim() {
		return dt_fim;
	}

	public void setDt_fim(Calendar dt_fim) {
		this.dt_fim = dt_fim;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}



}
