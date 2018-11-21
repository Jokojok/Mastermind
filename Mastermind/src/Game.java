import java.util.HashMap;

public class Game {
	private final static int PAWN_TO_GUESS = 4;

	private HashMap<Integer, Step> game = new HashMap<Integer, Step>();
	public int turn;
	private int maxTurn;

	public boolean win;

	private String toGuess;

	public Game(int maxTurn) {
		turn = 1;
		this.maxTurn = maxTurn;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < PAWN_TO_GUESS; i++) {
			sb.append(Pawn.randomPawn().toString());
		}
		toGuess = sb.toString();
	}

	public boolean jouer(String entry) {
		int guessed = hasGuessed(entry);
		int misplaced = hasMisplaced(entry, guessed);

		game.put(turn, new StepDecorator(entry, guessed, misplaced, turn, maxTurn));
		
		if (guessed == PAWN_TO_GUESS || turn == maxTurn) {
			// guessed well => win || no more steps => lost
			win = guessed == PAWN_TO_GUESS ? true : false;
			return false; // game finished
		}
		turn++;
		return true; // step lost
	}

	private int hasGuessed(String entry) {
		int response = 0;
		for (int i = 0; i < entry.length(); i++) {
			if (entry.charAt(i) == toGuess.charAt(i))
				response++;
		}
		return response;
	}

	private int hasMisplaced(String entry, int guessed) {
		int response = 0;
		for (char c : toGuess.toCharArray()) {
			if (entry.contains(Character.toString(c)))
				response++;
		}
		return response - guessed;
	}

	public void show() {
		System.out.println("|-------------------|");
		game.forEach((k, v) -> System.out.println(v.afficher()));
		if(game.size() != maxTurn) {
			System.out.println("|....| . | . | " + turn + "/" + maxTurn + " | ");
		}
		System.out.println("|-------------------|");
	}
}
