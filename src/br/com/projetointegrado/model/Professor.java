package br.com.projetointegrado.model;

import java.util.ArrayList;

public class Professor extends Usuario{
	private int professor_id, administrador;
	private String matricula;
	private Banca banca;
	private ArrayList<Grupo> grupos;
	
	public Professor(int id, String nome, String email, String senha) {
		super(id, nome, email, senha);
	}

	public Professor(int id, String nome, String email, String senha, int professor_id, int administrador, String matricula) {
		super(id, nome, email, senha);
		this.professor_id = professor_id;
		this.administrador = administrador;
		this.matricula = matricula;
	}

	public Professor(int id, String nome, String email, String senha, int professor_id, int administrador,
			String matricula, Banca banca) {
		super(id, nome, email, senha);
		this.professor_id = professor_id;
		this.administrador = administrador;
		this.matricula = matricula;
		this.banca = banca;
	}

	public Professor(int id, String nome, String email, String senha, int professor_id, int administrador,
			String matricula, ArrayList<Grupo> grupos) {
		super(id, nome, email, senha);
		this.professor_id = professor_id;
		this.administrador = administrador;
		this.matricula = matricula;
		this.grupos = grupos;
	}

	public int getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
	}

	public int getAdministrador() {
		return administrador;
	}

	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Banca getBanca() {
		return banca;
	}

	public void setBanca(Banca banca) {
		this.banca = banca;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}

}
