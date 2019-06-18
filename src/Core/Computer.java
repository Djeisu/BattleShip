package Core;

import java.util.ArrayList;
import java.util.List;

import Core.exceptions.ExceptionComputerMiss;

public class Computer extends PlayerAbstract{
	private List<Point> attacks;
	
	public Computer() {}
	
	public Computer(String name) {
		super(name);
	}
	
	public Computer(String name, Map h_map) {
		super(name,h_map);
		this.defineShipsInMap();
		this.attacks = new ArrayList<Point>();
	}
	
	public Computer(String name, Map h_map, int h_qtd) {
		super(name,h_map,h_qtd);
		this.defineShipsInMap();
		this.attacks = new ArrayList<Point>();
	}
	
	public void attack(PlayerAbstract player) throws ExceptionComputerMiss{
		Point p = this.getPoint(player.getP_map().getWidth(), player.getP_map().getHeight());
		
		while (checkAttackRepeat(p)) 
			p = this.getPoint(player.getP_map().getWidth(), player.getP_map().getHeight());
		
		try {
			this.attacks.add(p);
			player.attackPoint(p);
		} catch (Exception e) {
			throw new ExceptionComputerMiss(p);
		}
	}
	
	public boolean checkAttackRepeat(Point p) {
		for (Point point : attacks)
			if (point.equals(p))
				return true;
		return false;
	}
	
	public List<Point> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<Point> attacks) {
		this.attacks = attacks;
	}

	public Point getPoint(int width, int height){
		return new Point().getPointRandom(width,height);
	}
	
	public void defineShipsInMap() {
		this.setShipsInMap(this.getP_ships());
	}
	
	public void setShipsInMap(List<Ship> m_ships) {
		for (Ship ship : m_ships)
			this.setShipInMap(ship);
	}
	
	public boolean setShipInMap(Ship ship) {
		Point init = new Point().getPointRandom(ship, this.getP_map().getWidth(), this.getP_map().getHeight());
		
		for (int i = 0; i < ship.getSize(); i++) 
			if (verifyPoint(init)) 
				return this.setShipInMap(ship);
			else {
				init.setShip(ship);
				if (ship.getDirection() == 'h') {
					this.setPositionShipInMap(init);
					init.incrementX();
				}
				else {
					this.setPositionShipInMap(init);
					init.incrementY();
				}
			}
		
		return true;
	}
	
	private void setPositionShipInMap(Point p) {
		for (Point point : this.getPositionsShips()) 
			if(p.getX() == point.getX() && p.getY() == point.getY() && point.getStatus() == ' ') {
				point.setShip(p.getShip());
				point.setStatus('N');
			}
	}
}
