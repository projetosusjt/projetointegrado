package br.com.projetointegrado.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Tema {
	private int tema_id;
	private Calendar dt_cadastro;
	private String titulo, introducao, requisitos;
	private ArrayList<Atividade> atividades;

	public Tema(int tema_id, Calendar dt_cadastro, String titulo, String introducao, String requisitos
				, ArrayList<Atividade> atividades) {
		super();
		this.tema_id = tema_id;
		this.dt_cadastro = dt_cadastro;
		this.titulo = titulo;
		this.introducao = introducao;
		this.requisitos = requisitos;
		this.atividades = atividades;
	}

	public int getTema_id() {
		return tema_id;
	}

	public void setTema_id(int tema_id) {
		this.tema_id = tema_id;
	}

	public Calendar getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Calendar dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public ArrayList<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(ArrayList<Atividade> atividades) {
		this.atividades = atividades;
	}

}
