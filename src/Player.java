
public abstract class Player {
	
	private String name;
	private Roshambo roshambo;
	private int losses;
	private int wins;

	
	public Player(String name, Roshambo roshambo) {
		super();
		this.name = name;
		this.roshambo = roshambo;
	}

	public Player(String name) {
		super();
		this.name = name;
	}

	public Player() {
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Roshambo getRoshambo() {
		return roshambo;
	}

	public void setRoshambo(Roshambo roshambo) {
		this.roshambo = roshambo;
	}
	
	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}
	
	

}

    