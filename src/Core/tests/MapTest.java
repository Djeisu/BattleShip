package Core.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Core.Computer;
import Core.Map;
import Core.Point;
import Core.exceptions.ExceptionMiss;

public class MapTest {
	
	Map mh = new Map(10,10);
	Computer h = new Computer("Djheyson", mh, 3);
	Map mc = new Map(10,10);
	Computer c = new Computer("Enemy", mc, 3);	

}
