package br.edu.unoesc.escolajpa.app;

import java.util.List;

import br.edu.unoesc.escolajpa.model.Aluno;
import br.edu.unoesc.escolajpa.model.Curso;
import br.edu.unoesc.escolajpa.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class App1 {

	private static EntityManager em;

	private void adiciona() {
		Curso c1 = new Curso("Pedagogia");

		Aluno a1 = new Aluno("Luiza pill", c1);

		em.getTransaction().begin();

		em.persist(c1);
		em.persist(a1);

		em.getTransaction().commit();
	}

	public static void main(String[] args) {

		App1 app1 = new App1();
		em = JPAUtil.getEntityManager();
		// Adicionar cursos e alunos
		app1.adiciona();

		// Mostrando todos os Alunos e seus Cursos
		String jpql1 = "SELECT a FROM Aluno a JOIN Curso c on a.curso = c.id";
		List<Aluno> aluno1 = em.createQuery(jpql1, Aluno.class).getResultList();

		System.out.println("Alunos e seus cursos");
		System.out.println("Alunos\t\tCursos");

		for (Aluno a : aluno1) {
			System.out.println(a.getNome() + "\t\t" + a.getCurso().getNome());
		}

		em.close();
		JPAUtil.closeEntityManagerFactory();
	}
}
