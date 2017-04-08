package com.demirel.utils;

import org.junit.Ignore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Ignore
public class TestBaseRepository {
	private EntityManagerFactory emf;
	protected EntityManager em;
	protected DBCommandTransactionalExecutor dbCommandExecutor;

	protected void initializeTestDB() {
		emf = Persistence.createEntityManagerFactory("ds");
		em = emf.createEntityManager();

		dbCommandExecutor = new DBCommandTransactionalExecutor(em);
	}

	protected void closeEntityManager() {
		em.close();
		emf.close();
	}

}