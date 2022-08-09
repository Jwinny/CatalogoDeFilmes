package br.com.winny.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogodefilmes");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}