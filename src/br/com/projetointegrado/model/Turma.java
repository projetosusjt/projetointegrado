package br.com.projetointegrado.model;

import java.util.ArrayList;

public class Turma {
	private int turma_id, semestre, ano;
	private String sigla;
	private Tema tema;
	private ArrayList<Aluno> alunos;
	private ArrayList<Grupo> grupos;

	public Turma(int turma_id, int semestre, int ano, String sigla, Tema tema, ArrayList<Aluno> alunos) {
		super();
		this.turma_id = turma_id;
		this.semestre = semestre;
		this.ano = ano;
		this.sigla = sigla;
		this.tema = tema;
		this.alunos = alunos;
	}

	public Turma(int turma_id, int semestre, int ano, String sigla, Tema tema, ArrayList<Aluno> alunos,
			ArrayList<Grupo> grupos) {
		super();
		this.turma_id = turma_id;
		this.semestre = semestre;
		this.ano = ano;
		this.sigla = sigla;
		this.tema = tema;
		this.alunos = alunos;
		this.grupos = grupos;
	}

	public int getTurma_id() {
		return turma_id;
	}

	public void setTurma_id(int turma_id) {
		this.turma_id = turma_id;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

}
