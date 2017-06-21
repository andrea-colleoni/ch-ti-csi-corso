package ch.ti.csi.corso.jpa;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Servizio {
	
	@PersistenceContext(unitName="corsi")
	EntityManager em;
	
	void go() {
		Studente s = new Studente();
		s.setNome("Xxxxxx");
		s.setCognome("Yyyyyyy");
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
