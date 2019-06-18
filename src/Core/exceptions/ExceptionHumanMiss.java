package Core.exceptions;

import Core.Point;

public class ExceptionHumanMiss extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionHumanMiss() {
		super("Humano Errou");
	}
	
	public ExceptionHumanMiss(Point p) {
		super("Humano atirou em " + p.getCoordinate() + " e errou");
	}
}
