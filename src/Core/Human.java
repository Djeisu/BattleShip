package Core;

import java.util.List;
import java.util.Scanner;

import Core.exceptions.ExceptionHumanMiss;

public class Human extends PlayerAbstract{
	public Human() {}
	
	public Human(String name) {
		super(name);
	}
	
	public Human(String name, Map h_map) {
		super(name,h_map);
		this.defineShipsInMap();
	}
	
	public Human(String name, Map h_map, int h_qtd) {
		super(name,h_map,h_qtd);
		this.defineShipsInMap();
	}
	
	public void attack(PlayerAbstract player) throws ExceptionHumanMiss{
		Point p = this.getPoint(player.getP_map().getWidth(), player.getP_map().getHeight());
		try {
			player.attackPoint(p);
		} catch (Exception e) {
			throw new ExceptionHumanMiss(p);
		}
	}
	
	public Point getPoint(int width, int height) {
		Scanner in = new Scanner(System.in);
		int option = -1;
		Point p = new Point(-1,-1);
		do {
			try {
				if(p.getX() < 0) {
					System.out.print("Informe um valor para X:");
					option = in.nextInt();
					if(option >= 0 && option <= width)
						p.setX(option);
					else
						System.out.println("Valor inválido");
				}
				else if (p.getX() >= 0 && p.getY() < 0) {
					System.out.print("Informe um valor para Y:");
					option = in.nextInt();
					if(option >= 0 && option <= height)
						p.setY(option);
					else
						System.out.println("Valor inválido");
				}
			}catch (Exception e){
				System.out.println(e);
			}
		} while(p.getY() < 0);
		
		System.out.println("");
		System.out.println(p.getCoordinate());
		return p;
	}
	
	public void defineShipsInMap() {
		this.setShipsInMap(this.getP_ships());
	}
	
	public void setShipsInMap(List<Ship> m_ships) {
		for (Ship ship : m_ships) {
			this.getP_map().draw(this);
			System.out.println("\nPosicione seu navio no mapa");
			this.setShipInMap(ship);
		}
	}
	
	public void setShipInMap(Ship ship) {
		boolean f = false;
		while (!f) {
			Point new_p = new Point();
			new_p = this.getPoint(this.getP_map().getWidth(), this.getP_map().getHeight());
			if(this.checkPreviewPosition(new_p, ship)) {
				for (int i = 0; i < ship.getSize(); i++) {
					this.setPositionShipInMap(new_p);
					if(ship.getDirection() == 'h')
						new_p.incrementX();
					else
						new_p.incrementY();
				}
				f = true;			
			}else {
				System.out.println("Valor inválido, escolha outro por favor");
			}
		}
	}
	
	public boolean checkPreviewPosition(Point init, Ship ship) {
		Point p = new Point(init.getX(),init.getY());
		for (int i = 0; i < ship.getSize(); i++) {
			if (!verifyPointFree(p))
				return false;
			if(ship.getDirection() == 'h')	p.incrementX();
			else p.incrementY();
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
