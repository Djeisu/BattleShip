package Core;

import java.util.List;

public class Map {
	private int width;
	private int height;
	
	public Map() {}
	
	public Map(int w, int h) {
		this.width = w;
		this.height = h;
	}
	
	public Point verifyPoint(int x, int y, List<Point> l) {
		for (Point point : l) 
			if(point.equalsCoordenate(x, y))
				return point;
		return null;
	}
	
	public void draw(PlayerAbstract player) {
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int h = 0; h < this.height; h++) {
			System.out.print(h+"|");
			for (int w = 0; w < this.width; w++) {
				Point p = this.verifyPoint(w, h, player.getPositionsShips());
				if(p.getStatus() != ' ')
					System.out.print( p.getStatus() +"|");
				else
					System.out.print(" |");
			}
			System.out.println("");
		}
	}
	
	public void drawGame(PlayerAbstract player) {
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for (int h = 0; h < this.height; h++) {
			System.out.print(h+"|");
			for (int w = 0; w < this.width; w++) {
				Point p = this.verifyPoint(w, h, player.getPositionsShips());
				if(p.getStatus() == 'D')
					System.out.print( p.getStatus() +"|");
				else
					System.out.print(" |");
			}
			System.out.println("");
		}
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
