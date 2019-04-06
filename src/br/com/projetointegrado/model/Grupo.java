package br.com.projetointegrado.model;

import java.util.ArrayList;

public class Grupo {
	private Professor orientador;
	private Turma turma;
	private int grupo_id, numero;
	private String grupo_nome;
	private ArrayList<Aluno> alunos;
	private ArrayList<Entrega> entregas;

	public Grupo() {
	}

	public Grupo(Professor orientador, Turma turma, int grupo_id, int numero, String grupo_nome,
			ArrayList<Aluno> alunos) {
		this.orientador = orientador;
		this.turma = turma;
		this.grupo_id = grupo_id;
		this.numero = numero;
		this.grupo_nome = grupo_nome;
		this.alunos = alunos;
	}

	public Grupo(Turma turma, int grupo_id, int numero, String grupo_nome, ArrayList<Aluno> alunos) {
		this.turma = turma;
		this.grupo_id = grupo_id;
		this.numero = numero;
		this.grupo_nome = grupo_nome;
		this.alunos = alunos;
	}


	public Grupo(Professor orientador, Turma turma, int grupo_id, int numero, String grupo_nome,
			ArrayList<Aluno> alunos, ArrayList<Entrega> entregas) {
		super();
		this.orientador = orientador;
		this.turma = turma;
		this.grupo_id = grupo_id;
		this.numero = numero;
		this.grupo_nome = grupo_nome;
		this.alunos = alunos;
		this.entregas = entregas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public ArrayList<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(ArrayList<Entrega> entregas) {
		this.entregas = entregas;
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getGrupo_id() {
		return grupo_id;
	}

	public void setGrupo_id(int grupo_id) {
		this.grupo_id = grupo_id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getGrupo_nome() {
		return grupo_nome;
	}

	public void setGrupo_nome(String grupo_nome) {
		this.grupo_nome = grupo_nome;
	}

	public Professor getOrientador() {
		return orientador;
	}

	public void setOrientador(Professor orientador) {
		this.orientador = orientador;
	}

}
