package Core.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Core.Computer;
import Core.Map;
import Core.Point;
import Core.exceptions.ExceptionComputerMiss;

public class ComputerTest {
	
	Map mh = new Map(10,10);
	Computer h = new Computer("Djheyson", mh, 3);
	Map mc = new Map(10,10);
	Computer c = new Computer("Enemy", mc, 3);
	
	@Test
	public void testAttack(){ 
		try {
			c.attack(h);	
		} catch (Exception e) {
			assertEquals(ExceptionComputerMiss.class, e.getClass());
		}
	}

	@Test
	public void testGetPointAttack() {
		assertEquals(Point.class, c.getPoint(10, 10).getClass());
	}
	
	@Test
	public void testCheckAttackRepeat() {
		Point p = new Point(0,0);
		Point p1 = new Point(1,0);
		List<Point> pa = c.getAttacks();
		pa.add(p);
		c.setAttacks(pa);
		assertTrue(c.checkAttackRepeat(p));
		assertFalse(c.checkAttackRepeat(p1));
	}
	
	

}
