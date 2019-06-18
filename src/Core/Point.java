package Core;

public class Point {
	private int x;
	private int y;
	//For set ship in this point
	private Ship ship;
	/*
	 * 	 D = Destroy;
	 * 	 X = Error;
	 * ' ' = Null; 
	*/
	private char status;
	
	public Point() {}
	
	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setStatus(' ');
	}
	
	public Point getPointRandom(Ship ship, int width, int height) {
		this.setShip(ship);
		if (ship.getDirection() == 'h') 
			return new Point((int)(Math.random() * (width - this.ship.getSize()) + 1),(int)(Math.random() * height));
		else 
			return new Point((int)(Math.random() * width), (int)(Math.random() * (height - this.ship.getSize()) + 1));
	}
	
	public Point getPointRandom(int width, int height) {
		return new Point((int)(Math.random() * width),(int)(Math.random() * height));
	}
	
	public void incrementX() {
		this.x++;
	}
	
	public void incrementY() {
		this.y++;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	public boolean equals(Point p) {
		return (this.getX() == p.getX()) && (this.getY() == p.getY()) && (this.getStatus() == p.getStatus()); 
	}
	
	public boolean equalsCoordenate(Point p) {
		return (this.getX() == p.getX()) && (this.getY() == p.getY()); 
	}
	
	public boolean equalsCoordenate(int x, int y) {
		return (this.getX() == x) && (this.getY() == y); 
	}
	
	public boolean equalsAndFree(Point p) {
		return (this.getX() == p.getX()) && (this.getY() == p.getY()) && (this.getStatus() == ' '); 
	}
	
	public boolean equalsAndBusy(Point p) {
		return (this.getX() == p.getX()) && (this.getY() == p.getY()) && (this.getStatus() != ' '); 
	}
	
	public String getCoordinate() {
		return "(" + this.getX() + "," + this.getY() + ")";
	}
}
