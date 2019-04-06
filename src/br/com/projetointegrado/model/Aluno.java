package br.com.projetointegrado.model;

public class Aluno extends Usuario {
	private String ra;
	private int aluno_id;
	private Grupo grupo;
	private Turma turma;

	public Aluno(int id, String nome, String email, String senha, String ra, int aluno_id, Grupo grupo, Turma turma) {
		super(id, nome, email, senha);
		this.ra = ra;
		this.aluno_id = aluno_id;
		this.grupo = grupo;
		this.turma = turma;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public int getAluno_id() {
		return aluno_id;
	}

	public void setAluno_id(int aluno_id) {
		this.aluno_id = aluno_id;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
