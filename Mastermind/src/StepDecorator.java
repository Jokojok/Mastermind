
public class StepDecorator implements Step {
	private String entry;
	private int guessed, misplaced, turn, maxTurn;

	public StepDecorator(String entry, int guessed, int misplaced, int turn, int maxTurn) {
		super();
		this.entry = entry;
		this.guessed = guessed;
		this.misplaced = misplaced;
		this.turn = turn;
		this.maxTurn = maxTurn;
	}

	@Override
	public String afficher() {
		return "|" + entry + "| " + guessed + " | " + misplaced + " | " + turn + "/" + maxTurn + " |";
	}

}
