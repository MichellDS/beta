package br.edu.unoesc.escolajpa.app;

import java.util.List;

import br.edu.unoesc.escolajpa.dao.AlunoDAO;
import br.edu.unoesc.escolajpa.dao.CursoDAO;
import br.edu.unoesc.escolajpa.dao.DisciplinaDAO;
import br.edu.unoesc.escolajpa.model.Aluno;
import br.edu.unoesc.escolajpa.model.Curso;
import br.edu.unoesc.escolajpa.model.Disciplina;

public class App3 {

	public static void main(String[] args) {

		CursoDAO cursoDAO = new CursoDAO();
		AlunoDAO alunoDAO = new AlunoDAO();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

		// Cursos
		Curso curso1 = new Curso("Pedagogia");
		Curso curso2 = new Curso("Ciencias da Computação");

		cursoDAO.salvar(curso1).salvar(curso2);

		// Alunos
		Aluno aluno1 = new Aluno("Luiza pill", curso1);
		Aluno aluno2 = new Aluno("Zira Mclan", curso1);
		Aluno aluno3 = new Aluno("Erick Bonfin", curso2);

		alunoDAO.salvar(aluno1).salvar(aluno2).salvar(aluno3);

		// Disciplinas
		Disciplina disciplina1 = new Disciplina("Calculo");
		Disciplina disciplina2 = new Disciplina("Orientação Infantil");

		aluno1.adicionarDisciplina(disciplina2);
		aluno2.adicionarDisciplina(disciplina2);

		disciplina1.adicionarAluno(aluno3);

		disciplinaDAO.salvar(disciplina1).salvar(disciplina2);

		List<Aluno> alunos = alunoDAO.obterTodos();
		System.out.println("Alunos\tDisciplinas");
		for (Aluno a : alunos) {
			System.out.println(a.getNome());
			for (Disciplina d : a.getDisciplinas()) {
				System.out.println("\t" + d.getNome());
			}
		}

		List<Disciplina> disciplinas = disciplinaDAO.obterTodos();
		System.out.println("Disciplinas\tAlunos");
		for (Disciplina d : disciplinas) {
			System.out.println(d.getNome());
			for (Aluno a : d.getAlunos()) {
				System.out.println("\t" + a.getNome());
			}
		}

		cursoDAO.fechar();
		alunoDAO.fechar();
		disciplinaDAO.fechar();

	}
}
