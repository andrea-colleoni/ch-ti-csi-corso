package ch.ti.csi.corso.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.ti.csi.corso.es1.app.Client;
import ch.ti.csi.corso.es1.app.Config;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Config.class})
@ActiveProfiles(profiles={"prod"})
public class EsercizioTest {
	
	@Autowired
	Client c;

	@Test
	public void testGo() {
		c.go();
		assertTrue(true);
	}

}
