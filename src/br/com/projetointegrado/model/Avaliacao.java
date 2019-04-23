package br.com.projetointegrado.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Avaliacao {
	private int avaliacao_id;
	private double nota;
	private String comentarios;
	private Calendar dt_avaliacao;
	private Grupo grupo;
	private Aluno aluno;
	private ArrayList<Entrega> entregas;

	public Avaliacao(int avaliacao_id, double nota, String comentarios, Calendar dt_avaliacao,
			ArrayList<Entrega> entregas) {
		super();
		this.avaliacao_id = avaliacao_id;
		this.nota = nota;
		this.comentarios = comentarios;
		this.dt_avaliacao = dt_avaliacao;
		this.entregas = entregas;
	}

	public Avaliacao(int avaliacao_id, double nota, String comentarios, Calendar dt_avaliacao, Grupo grupo, Aluno aluno,
			ArrayList<Entrega> entregas) {
		super();
		this.avaliacao_id = avaliacao_id;
		this.nota = nota;
		this.comentarios = comentarios;
		this.dt_avaliacao = dt_avaliacao;
		this.grupo = grupo;
		this.aluno = aluno;
		this.entregas = entregas;
	}

	public int getAvaliacao_id() {
		return avaliacao_id;
	}

	public void setAvaliacao_id(int avaliacao_id) {
		this.avaliacao_id = avaliacao_id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Calendar getDt_avaliacao() {
		return dt_avaliacao;
	}

	public void setDt_avaliacao(Calendar dt_avaliacao) {
		this.dt_avaliacao = dt_avaliacao;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public ArrayList<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(ArrayList<Entrega> entregas) {
		this.entregas = entregas;
	}



}
