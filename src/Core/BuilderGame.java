package Core;

import java.util.Scanner;

public class BuilderGame {
	private PlayerAbstract player1;
	private PlayerAbstract player2;
	private Scanner in;
	
	public BuilderGame() {
		this.initialize();
	}
	
	public BuilderGame(PlayerAbstract p1, PlayerAbstract p2) {
		this.player1 = p1;
		this.player2 = p2;
		this.initialize();
	}
	
	private void initialize() {
		this.in = new Scanner(System.in);
	}
	
	public void run() {
		this.print_maps();
		this.print_menu();
		this.print_finish();
	}
	
	public void print_finish() {
		if (player1.finishGame())
			System.out.println("Muito bem, "+ player2.getP_name() +", Parabéns, você venceu!!!");
		if (player2.finishGame())
			System.out.println("Muito bem, "+ player1.getP_name() +", Parabéns, você venceu!!!");
	}
	
	public void print_menu() {
		int option = -1;
		System.out.println("Bem Vindo!");
		do {
			System.out.println("1: Atacar");
			System.out.println("0: Sair");
			System.out.print("Digite uma ação: ");
			
			try {
				option = in.nextInt();
			}catch (Exception e){
				System.out.println(e);
			}
			
			switch (option) {
			case 0:
				System.out.println("\n\n Valeu, meu fi, volte sempre \n");
				continue;
			case 1: //Draw Map
				try {
					player1.attack(player2);
					System.out.println(player1.getP_name() + " ACERTOU!!");
				}catch(Exception e) {
					System.out.println(e);
				}
				
				try {
					if(!player2.finishGame()) {
						player2.attack(player1);
						System.out.println(player2.getP_name() + " ACERTOU!!");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				
				System.out.println("");
				this.print_maps();
				continue;
			default:
				System.out.println("\n\n Nao tem esse valor nao \n");
				continue;
			}
		} while (option != 0 && (!player1.finishGame() && !player2.finishGame()));
	}
	
	public void print_maps() {
		System.out.println("-----------------------------------------------------------");
		//Draw map player
		System.out.println(player2.getP_name());
		player2.getP_map().draw(player2);
		System.out.println("");
		
		System.out.println(player1.getP_name());
		player1.getP_map().draw(player1);
				
		System.out.println(" ");
		//Draw map other player in game
		player2.getP_map().drawGame(player2);
		
		System.out.println("-----------------------------------------------------------");
	}
	
	public PlayerAbstract getPlayer1() {
		return player1;
	}

	public void setPlayer1(PlayerAbstract player1) {
		this.player1 = player1;
	}

	public PlayerAbstract getPlayer2() {
		return player2;
	}

	public void setPlayer2(PlayerAbstract player2) {
		this.player2 = player2;
	}

	public Scanner getIn() {
		return in;
	}

	public void setIn(Scanner in) {
		this.in = in;
	}
}
