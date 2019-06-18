package Core.exceptions;

import Core.Point;

public class ExceptionComputerMiss extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionComputerMiss() {
		super("Computador errou");
	}
	
	public ExceptionComputerMiss(Point p) {
		super("Computador atirou em " + p.getCoordinate() + " e errou");
	}
}
