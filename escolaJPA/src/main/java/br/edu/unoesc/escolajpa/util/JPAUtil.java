package br.edu.unoesc.escolajpa.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("escolapersistencia");

	private JPAUtil() {
	}

	public static EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

	public static void closeEntityManagerFactory() {
		EMF.close();
	}

}