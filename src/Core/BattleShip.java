package Core;

public class BattleShip {
	public static void main(String[] args) {
		Map m_player = new Map(10,10);
		Human h = new Human("Djheyson", m_player, 3);
		
		Map m_computer = new Map(10,10);
		Computer c = new Computer("Enemy", m_computer, 3);
		
		BuilderGame builder = new BuilderGame(h,c);
		builder.run();
	}
}
