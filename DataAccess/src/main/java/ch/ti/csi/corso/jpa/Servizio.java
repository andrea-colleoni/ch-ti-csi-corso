package ch.ti.csi.corso.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Servizio {
	
	@PersistenceContext(unitName="corsi")
	EntityManager em;
	
	@Transactional(propagation=Propagation.NEVER)
	void go() {
		Studente s = new Studente();
		s.setNome("Andrea");
		s.setCognome("Colleoni");
		s.setDataNascita(new Date());
		s.setMatricola((int)( Math.random() * 1000));
		try {
			//em.getTransaction().begin();
			em.persist(s);
			//em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
