package jpaLab;

import javax.persistence.EntityManager;

public class JpaLab {

	public static void main(String[] args) throws ClassNotFoundException, Exception {


		Address address = new Address();
		address.setLinea1("l1");
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		em.persist(address);
		em.getTransaction().commit();

		em.close();
		PersistenceManager.INSTANCE.close();

	}

}
