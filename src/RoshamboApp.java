import java.util.Scanner;

/*
 *  Emanuel Pelean
 *  Roshambo
 */
public class RoshamboApp {

	public RoshamboApp() {
	}

	public static void main(String[] args) {
		boolean proceed = true;

		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Rock, Paper, Scissors!\n");
		CurrentPlayer player = new CurrentPlayer();
		player.setName(capsFirst(Validator.getString(scan, "Please enter your name: ")));
		TheJets jets = null;
		TheSharks sharks = null;
		Player opponent = null;

		String opponentUsername = Validator.getStringJS(scan,
				"\nWould you like to play against TheJets or TheSharks (j/s)?: ");
		if (opponentUsername.equalsIgnoreCase("j")) {
			jets = new TheJets();
			jets.setName("TheJets");
			jets.setRoshambo(Roshambo.ROCK);
			opponent = jets;
		} else {
			sharks = new TheSharks();
			sharks.setName("TheSharks");
			opponent = sharks;

		}

		while (proceed) {
			if (opponent == sharks) {
				calculateSharksChoice(sharks);
			}
			calculateUserChoice(scan, player);

			testPlayersChoices(player, sharks, opponent);

			String userChoice = Validator.getStringYN(scan, "Do you want to play again? (y/n): \n");
			if (userChoice.equalsIgnoreCase("n")) {
				proceed = false;
				System.out.println(
						player.getName() + " had " + player.getWins() + " wins and " + player.getLosses() + " losses.");
				System.out.println(opponent.getName() + " had " + opponent.getWins() + " wins and "
						+ opponent.getLosses() + " losses.");
				System.out.println("Thank you for playing Rock, Paper, Scissors!");
			}
			System.out.println();
		}
		scan.close();
	}

	/**
	 * @param scan
	 * @param player
	 */
	private static void calculateUserChoice(Scanner scan, CurrentPlayer playerMe) {
		switch (Validator.getStringRPS(scan, "Rock, paper, or scissor? (R/P/S): ")) {
		case "R":
		case "r":
			playerMe.setRoshambo(Roshambo.ROCK);
			break;
		case "P":
		case "p":
			playerMe.setRoshambo(Roshambo.PAPER);
			break;
		case "S":
		case "s":
			playerMe.setRoshambo(Roshambo.SCISSORS);
			break;
		default:
			// repeat method
			System.out.println();

		}
	}

	/**
	 * @param sharks
	 */
	private static void calculateSharksChoice(TheSharks sharks) {
		int sharksChoice = (int) (Math.random() * 3 + 1);
		switch (sharksChoice) {
		case 1:
			sharks.setRoshambo(Roshambo.ROCK);
			break;
		case 2:
			sharks.setRoshambo(Roshambo.PAPER);
			break;
		case 3:
			sharks.setRoshambo(Roshambo.SCISSORS);
			break;
		default:

		}
	}

	/**
	 * @param player
	 * @param sharks
	 * @param opponent
	 */
	private static void testPlayersChoices(CurrentPlayer player, TheSharks sharks, Player opponent) {
		if (player.getRoshambo() == Roshambo.ROCK && opponent.getRoshambo() == Roshambo.PAPER) {
			System.out.println(player.getName() + ": " + player.getRoshambo() + "\n" + opponent.getName() + ": "
					+ opponent.getRoshambo() + "\n" + opponent.getName() + " wins!");
			opponent.setWins(opponent.getWins() + 1);
			player.setLosses(player.getLosses() + 1);
		} else if (player.getRoshambo() == Roshambo.ROCK && opponent.getRoshambo() == Roshambo.ROCK) {
			System.out.println(player.getName() + ": " + player.getRoshambo() + "\n" + opponent.getName() + ": "
					+ opponent.getRoshambo() + "\n" + "Draw!");
		} else if (player.getRoshambo() == Roshambo.ROCK && opponent.getRoshambo() == Roshambo.SCISSORS) {
			System.out.println(player.getName() + ": " + player.getRoshambo() + "\n" + opponent.getName() + ": "
					+ opponent.getRoshambo() + "\n" + player.getName() + " wins!");
			player.setWins(opponent.getWins() + 1);
			opponent.setLosses(player.getLosses() + 1);
		} else if (player.getRoshambo() == Roshambo.SCISSORS && opponent.getRoshambo() == Roshambo.SCISSORS) {
			System.out.println(player.getName() + ": " + player.getRoshambo() + "\n" + opponent.getName() + ": "
					+ opponent.getRoshambo() + "\n" + "Draw!");
		} else if (player.getRoshambo() == Roshambo.SCISSORS && opponent.getRoshambo() == Roshambo.PAPER) {
			System.out.println(player.getName() + ": " + player.getRoshambo() + "\n" + opponent.getName() + ": "
					+ opponent.getRoshambo() + "\n" + player.getName() + " wins!");
			player.setWins(opponent.getWins() + 1);
			opponent.setLosses(player.getLosses() + 1);
		} else if (player.getRoshambo() == Roshambo.SCISSORS && opponent.getRoshambo() == Roshambo.ROCK) {
			System.out.println(player.getName() + ": " + player.getRoshambo() + "\n" + opponent.getName() + ": "
					+ opponent.getRoshambo() + "\n" + opponent.getName() + " wins!");
			opponent.setWins(opponent.getWins() + 1);
			player.setLosses(player.getLosses() + 1);
		} else if (player.getRoshambo() == Roshambo.PAPER && opponent.getRoshambo() == Roshambo.PAPER) {
			System.out.println(player.getName() + ": " + player.getRoshambo() + "\n" + opponent.getName() + ": "
					+ opponent.getRoshambo() + "\n" + "Draw!");
		} else if (player.getRoshambo() == Roshambo.PAPER && opponent.getRoshambo() == Roshambo.SCISSORS) {
			System.out.println(player.getName() + ": " + player.getRoshambo() + "\n" + opponent.getName() + ": "
					+ opponent.getRoshambo() + "\n" + opponent.getName() + " wins!");
			opponent.setWins(opponent.getWins() + 1);
			player.setLosses(player.getLosses() + 1);
		} else if (player.getRoshambo() == Roshambo.PAPER && opponent.getRoshambo() == Roshambo.ROCK) {
			System.out.println(player.getName() + ": " + player.getRoshambo() + "\n" + opponent.getName() + ": "
					+ opponent.getRoshambo() + "\n" + player.getName() + " wins!");
			player.setWins(opponent.getWins() + 1);
			opponent.setLosses(player.getLosses() + 1);
		} else {
			System.out.println("Error! Unable to decide winner!");
		}

	}

	public static String capsFirst(String str) {
		String[] words = str.split(" ");
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			ret.append(Character.toUpperCase(words[i].charAt(0)));
			ret.append(words[i].substring(1));
			if (i < words.length - 1) {
				ret.append(' ');
			}
		}
		return ret.toString();
	}

}
