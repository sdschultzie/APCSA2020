package Q3FinalLab;

public class Player {
	private String name;
	private String teamAbrv;
	private String position;
	private Stats myStats;
	
	public Player(String nmIn, String teamIn, String posIn) {
		setName(nmIn);
		setTeamAbrv(teamIn);
		setPosition(posIn);
		myStats = new Stats();
	}

	public String getName() {
		return name;
	}

	public String getTeamAbrv() {
		return teamAbrv;
	}

	public String getPosition() {
		return position;
	}

	public void setName(String nmIn) {
		String nonLetters = "*+/";
		for (int i=0; i<nmIn.length(); i++) {
			if (nonLetters.contains(nmIn.substring(i,i+1))) {
				this.name = nmIn.substring(0,i);
				break;
			}
		}
	}

	public void setTeamAbrv(String teamIn) {
		this.teamAbrv = teamIn;
	}

	public void setPosition(String posIn) {
		this.position = posIn;
	}
	
	public void setStats(Stats s) {
		this.myStats = s;
	}
	
	public String toString() {
		String output = "";
		output += "Name: " + name + "\t" + "Team: " + teamAbrv + "\t" + "Position: " + position + "\n";
		output += myStats;
		return output;
	}
	
	
}
