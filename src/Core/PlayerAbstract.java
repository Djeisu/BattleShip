package Core;

import java.util.ArrayList;
import java.util.List;

import Core.exceptions.ExceptionMiss;

public abstract class PlayerAbstract {
	private String p_name;
	private Map p_map;
	private int p_qtdShips;
	private List<Ship> p_ships;
	private List<Point> positionsShips;
	
	public PlayerAbstract() {}
	
	public PlayerAbstract(String name) {
		this.setP_name(name);
	}
	
	public PlayerAbstract(String name, Map m) {
		this.setP_name(name);
		this.setP_map(m);
		this.setP_qtdShips(2);
		this.initialize();
	}
	
	public PlayerAbstract(String name, Map m, int qtd) {
		this.setP_name(name);
		this.setP_map(m);
		this.setP_qtdShips(qtd);
		this.initialize();
	}
	
	//Initialize ships in position map
	private void initialize() {
		this.setP_ships(this.setShips());
		
		this.positionsShips = new ArrayList<Point>();
		for (int y = 0; y < this.getP_map().getHeight(); y++)
			for (int x = 0; x < this.getP_map().getWidth(); x++)
				this.positionsShips.add(new Point(x,y));
	}
	
	//Generate size for ships and direction
	public ArrayList<Ship> setShips() {
		ArrayList<Ship> s = new ArrayList<Ship>();
		for (int i = 0; i < this.getP_qtdShips(); i++) {
			char d = 'h';
			if (i%2==0)	d = 'v';
			Ship sh = new Ship(i+2,d);
			s.add(sh);
		}
		return s;
	}
	
	public boolean finishGame() {
		for (Point point : this.getPositionsShips()) 
			if(point.getStatus() == 'N')
				return false;
		
		return true;
	}
	
	public void attackPoint(Point p) throws ExceptionMiss{
		for (Point point : this.getPositionsShips())
			if(p.getX() == point.getX() && p.getY() == point.getY() && point.getStatus() == 'N') {
				point.setStatus('D');
				return;
			}
		throw new ExceptionMiss();
	}
	
	public boolean verifyPoint(Point p) {
		for (Point point : this.getPositionsShips()) 
			if(p.equals(point) && point.getStatus() != ' ')
				return true;
		return false;
	}
	
	public boolean verifyPointFree(Point p) {
		for (Point point : this.getPositionsShips()) 
			if(p.equals(point) && point.getStatus() == ' ')
				return true;
		return false;
	}
	
	//Define how to attack, get param player and attack
	public abstract void attack(PlayerAbstract player) throws Exception;
	
	public abstract Point getPoint(int width, int height);
	
	public abstract void defineShipsInMap();
	
	public abstract void setShipsInMap(List<Ship> m_ships);
	
	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Map getP_map() {
		return p_map;
	}

	public void setP_map(Map p_map) {
		this.p_map = p_map;
	}

	public List<Ship> getP_ships() {
		return p_ships;
	}

	public void setP_ships(List<Ship> p_ships) {
		this.p_ships = p_ships;
	}

	public int getP_qtdShips() {
		return p_qtdShips;
	}

	public void setP_qtdShips(int p_qtdShips) {
		this.p_qtdShips = p_qtdShips;
	}
	
	public List<Point> getPositionsShips() {
		return positionsShips;
	}

	public void setPositionsShips(List<Point> positionsShips) {
		this.positionsShips = positionsShips;
	}
}
