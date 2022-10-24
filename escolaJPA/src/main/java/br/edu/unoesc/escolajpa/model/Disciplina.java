package br.edu.unoesc.escolajpa.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "disiplinas")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 50, nullable = false)
	private String nome;

	@ManyToMany(mappedBy = "disciplinas_alunos")
	private List<Aluno> alunos;

	public Disciplina() {

	}

	public Disciplina(String nome) {
		this.nome = nome;
	}

	public Disciplina(Integer id, String nome, List<Aluno> alunos) {
		this.id = id;
		this.nome = nome;
		this.alunos = alunos;
	}
	
	public Disciplina(String nome, List<Aluno> alunos) {
		this.nome = nome;
		this.alunos = alunos;
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

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void adicionarAluno(Aluno aluno) {
		if (aluno != null && !this.getAlunos().contains(aluno)) {
			this.alunos.add(aluno);

			if (!aluno.getDisciplinas().contains(this)) {
				aluno.getDisciplinas().add(this);
			}
		}
	}

	public List<Aluno> getAlunos() {
		if (this.alunos == null) {
			this.alunos = new ArrayList<>();
		}
		return alunos;
	}
	
	
}
