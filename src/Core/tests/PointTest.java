package Core.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Core.Point;
import Core.Ship;

public class PointTest {

	@Test
	public void testGetPointRandom() {
		Point p = new Point(0,0);
		Point ptemp = new Point(0,0);
		p = p.getPointRandom(new Ship(), 10, 10);
		assertFalse(p.equals(ptemp));
	}

	@Test
	public void testIncrementX() {
		Point p = new Point(0,0);
		p.incrementX();
		assertEquals(p.getX(), 1);
	}

	@Test
	public void testIncrementY() {
		Point p = new Point(0,0);
		p.incrementY();
		assertEquals(p.getY(), 1);
	}
	
	@Test
	public void testEquals() {
		Point p = new Point(0,0);
		Point ptemp = new Point(0,0);
		
		assertTrue(p.equals(ptemp));
		
		ptemp.setX(5);
		
		assertFalse(p.equals(ptemp));
	}
	
	@Test
	public void testEqualsCoordenate() {
		Point p = new Point(0,0);
		Point ptemp = new Point(0,0);
		
		ptemp.setStatus('N');
		
		assertTrue(p.equalsCoordenate(ptemp));
		
		ptemp.setX(5);
		
		assertFalse(p.equalsCoordenate(ptemp));
	}

}
