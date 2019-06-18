package Core;

public class Ship {
	private int size;
	private char direction;
	
	public Ship(){}
	
	public Ship(int s, char d){
		this.setSize(s);
		this.setDirection(d);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}
}
