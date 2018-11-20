import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Launcher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean inGame = true;
		
		Game game = new Game(10);	// number of turn before losing
		System.out.println("Nouvelle partie de Mastermind !\n");
		while (inGame) {
			game.show();
			
			System.out.println("Devinez les 4 pions : ");
			String entry="";
			try {
				entry = sc.next(Pattern.compile("(R|J|B|O|V|N){4}"));
				inGame = game.jouer(entry);
			} catch(InputMismatchException e) {
				System.out.println("Veuillez réessayer en respectant le regex (R|J|B|O|V|N){4}.\n\n");
			} finally {
				sc.nextLine();
			}
			
		}
		if(game.win) {
			System.out.println("Bravo, vous avez gagné en : "+game.turn+" tours.");
		}
		else {
			game.show();
			System.out.println("Partie finie, vous n'avez plus de coups.");
		}

		sc.close();
	}
}
