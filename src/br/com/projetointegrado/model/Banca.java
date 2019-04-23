package br.com.projetointegrado.model;

import java.util.ArrayList;
import java.util.Calendar;

public class Banca {
	private Grupo grupo;
	private int banca_id;
	private Calendar data;
	private String sala;
	private ArrayList<ProfessorBanca> professores;

	public Banca(Grupo grupo, int banca_id, Calendar data, String sala) {
		super();
		this.banca_id = banca_id;
		this.data = data;
		this.sala = sala;
		this.grupo = grupo;
		
	}

	public int getBanca_id() {
		return banca_id;
	}

	public void setBanca_id(int banca_id) {
		this.banca_id = banca_id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public ArrayList<ProfessorBanca> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<ProfessorBanca> professores) {
		this.professores = professores;
	}

}
