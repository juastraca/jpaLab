package jpaLab;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;

public class JpaLab {

	public static void main(String[] args) throws ClassNotFoundException, Exception {
		System.out.println("running");
		Class.forName("com.mysql.jdbc.Driver");
		// connect way #1
		String url1 = "jdbc:mysql://localhost:3306/jpalab";
		String user = "root";
		String password = "!root";

		Connection conn1 = DriverManager.getConnection(url1, user, password);
		if (conn1 != null) {
			System.out.println("Connected to the database test1");
		}

		// Persistence.createEntityManagerFactory("jpaLabPU");

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
