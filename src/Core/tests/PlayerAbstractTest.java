package Core.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Core.Computer;
import Core.Map;
import Core.Point;
import Core.exceptions.ExceptionMiss;

public class PlayerAbstractTest {
	
	Map mh = new Map(10,10);
	Computer h = new Computer("Djheyson", mh, 3);
	Map mc = new Map(10,10);
	Computer c = new Computer("Enemy", mc, 3);

	@Test
	public void testFinishGame() {
		try {
			for (int h = 0; h < this.c.getP_map().getHeight(); h++) 
				for (int w = 0; w < this.c.getP_map().getWidth(); w++) 
					this.c.attackPoint(new Point(w,h));
			
			assertTrue(c.finishGame());
		}catch (Exception e) {}
	}
	
	@Test
	public void testAttack() {
		try {
			for (int h = 0; h < this.c.getP_map().getHeight(); h++) 
				for (int w = 0; w < this.c.getP_map().getWidth(); w++) 
					this.c.attackPoint(new Point(w,h));
		} catch (Exception e) {
	        assertEquals( ExceptionMiss.class, e.getClass());
		}
	}
	
	@Test
	public void testGetPositionsShips() {
		assertTrue(h.getPositionsShips().size() != 0);
	}

}
