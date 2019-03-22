package model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.junit.Test;

public class GameTest {
	public void setupScenary1() {

	}
	
	@Test
	public void caseA() throws ClassNotFoundException, IOException {
		setupScenary1();
		Game g = new Game();
		assertNotNull("Fail creating a new Game", g);
	}

	@Test
	public void caseB1() throws ClassNotFoundException, IOException {
		setupScenary1();
		Score[] scores = new Score[3];
		Score scoreUser = new Score(11, "Juan", 0);
		scores[0] = scoreUser;
		assertNotNull("No se pudo crear un arreglo de Score correctamente", scores);
	}

	@Test
	public void caseB2() throws ClassNotFoundException, IOException {
		setupScenary1();
		Score[] scores = new Score[3];
		Score scoreUser = new Score(20, "Ronald", 2);
		scores[0] = scoreUser;
		assertNotNull("No se pudo crear un arreglo de Score correctamente", scores);
	}

	@Test
	public void caseC1() throws ClassNotFoundException, IOException {
		setupScenary1();
		Score[] scores = new Score[3];
		Score scoreUser = new Score(13, "Carlos", 0);
		scores[0] = scoreUser;
		assertTrue("No se agregó la informacion del usuario correctamente", scores[0].getScore() == 13
				&& scores[0].getLevel() == 0 && scores[0].getName().equalsIgnoreCase("Carlos"));
	}

	@Test
	public void caseC2() throws ClassNotFoundException, IOException {
		setupScenary1();
		Score[] scores = new Score[3];
		Score scoreUser = new Score(-13, "Carlos", 0);
		scores[0] = scoreUser;
		assertTrue("No se agregó la informacion del usuario correctamente", scores[0].getScore() == -13
				&& scores[0].getLevel() == 0 && scores[0].getName().equalsIgnoreCase("Carlos"));
	}

}