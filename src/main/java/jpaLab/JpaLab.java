package jpaLab;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class JpaLab {

	public static void main(String[] args) throws Exception {

		// Una persona tiene varias direcciones

		// añadimos persona y direccion
		Address address = new Address();
		address.setLinea1("l1");
		Persona p = new Persona();
		p.setNombre("manolito");
		address.setPersona(p);
		p.getDirecciones().add(address);
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		p = em.merge(p);
		em.getTransaction().commit();

		// le añadimos una segunda direccion
		Address ad2 = new Address();
		ad2.setLinea2("l2");
		ad2.setPersona(p);
		em.getTransaction().begin();
		p.getDirecciones().add(ad2);
		p = em.merge(p);
		em.getTransaction().commit();

		// eliminamos la primera dirección
		p.getDirecciones().remove(0);
		em.getTransaction().begin();
		p = em.merge(p);
		em.getTransaction().commit();

		// sustituimos la lista de direcciones que tenía por otra totalmente
		// distinta
		List<Address> dirs = new ArrayList<Address>();
		Address d = new Address();
		d.setLinea1("renew");
		d.setPersona(p);
		dirs.add(d);

		// nótese que no damos el cambiazo a la lista,
		// vaciamos la que ya tiene y la rellenamos con lo que nos de la gana
		p.getDirecciones().clear();
		p.getDirecciones().addAll(dirs);
		em.getTransaction().begin();
		em.getTransaction().commit();
		p = em.merge(p);
		em.close();
		PersistenceManager.INSTANCE.close();

	}

}
