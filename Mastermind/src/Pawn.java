import java.util.Random;

public enum Pawn {
	Rouge("R"), Jaune("J"), Bleu("B"), Orange("O"), Vert("V"), Noir("N");

	private String name;

	Pawn(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public static Pawn randomPawn() {
		Random random = new Random();
		Pawn[] pawnTab = Pawn.values();
		Pawn rand = pawnTab[random.nextInt(pawnTab.length)];
		return rand;
	}
}
