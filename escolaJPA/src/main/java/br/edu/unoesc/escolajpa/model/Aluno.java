package br.edu.unoesc.escolajpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50, nullable = false)
	private String nome;

	@ManyToOne
	private Curso curso;

	@ManyToMany // (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "alunos_diciplinas", joinColumns = @JoinColumn(name = "id_aluno"), inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
	private List<Disciplina> disciplinas_alunos;

	public Aluno() {

	}

	public Aluno( String nome) {
		this.nome = nome;
	}

	public Aluno(String nome, Curso curso) {
		this.nome = nome;
		curso.adicionarAluno(this);
	}

	public Aluno(String nome, Curso curso, List<Disciplina> disciplinas_alunos) {
		this.nome = nome;
		this.curso = curso;
		this.disciplinas_alunos = disciplinas_alunos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Disciplina> getDisciplinas_alunos() {
		return disciplinas_alunos;
	}

	public void setDiscilonas_alunos(List<Disciplina> disciplinas_alunos) {
		this.disciplinas_alunos = disciplinas_alunos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void adicionarDisciplina(Disciplina disciplina) {
		if (disciplina != null && !this.getDisciplinas().contains(disciplina)) {
			this.disciplinas_alunos.add(disciplina);
			if (!disciplina.getAlunos().contains(this)) {
				disciplina.getAlunos().add(this);
			}
		}
	}

	public List<Disciplina> getDisciplinas() {
		if (disciplinas_alunos == null) {
			disciplinas_alunos = new ArrayList<>();
		}
		return disciplinas_alunos;
	}


}