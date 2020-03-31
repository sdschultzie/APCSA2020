package Q3FinalLab;

public class Player {
	private String name;
	private String teamAbrv;
	private int gamesPlayed;
	private Points myPoints;
	
	public Player(String nameIn, String teamAbrvIn, int gamesPlayedIn) {
		setName(nameIn);
		setTeamAbrv(teamAbrvIn);
		setGamesPlayed(gamesPlayedIn);
		myPoints = new Points();
	}

	public String getName() {
		return name;
	}

	public String getTeamAbrv() {
		return teamAbrv;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTeamAbrv(String teamAbrv) {
		this.teamAbrv = teamAbrv;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	
	
}
