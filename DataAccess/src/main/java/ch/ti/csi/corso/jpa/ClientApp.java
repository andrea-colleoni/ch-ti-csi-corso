package ch.ti.csi.corso.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsi");
		EntityManager em = emf.createEntityManager();
		
		Studente s = new Studente();
		s.setNome("Mario");
		s.setCognome("Rossi");
		s.setDataNascita(new Date());
		s.setMatricola((int)Math.random() * 1000);
		
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();

		em.close();
	}

}
