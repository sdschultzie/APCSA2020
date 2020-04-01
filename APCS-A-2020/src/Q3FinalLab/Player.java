package Q3FinalLab;

public class Player implements Comparable<Player> {
	private String name;
	private String teamName;
	private String position;
	private Stats myStats;
	private double myFantasyPoints;
	
	public Player(String nmIn, String teamIn, String posIn) {
		setName(nmIn);
		setTeamName(teamIn);
		setPosition(posIn);
		myStats = new Stats();
	}

	public String getName() {
		return name;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getPosition() {
		return position;
	}
	
	public Stats getMyStats() {
		return myStats;
	}
	
	public double getMyFantasyPoints() {
		return myStats.getTotalFantasyPoints();
	}

	public void setName(String nmIn) {
		String nonLetters = "*+'\\";
		for (int i=0; i<nmIn.length(); i++) {
			if (nonLetters.contains(nmIn.substring(i,i+1))) {
				this.name = nmIn.substring(0,i);
				break;
			}
		}
	}

	public void setTeamName(String teamIn) {
		this.teamName = teamIn;
	}

	public void setPosition(String posIn) {
		this.position = posIn;
	}
	
	public void setStats(Stats s) {
		this.myStats = s;
	}
	
	public int compareTo(Player other) {
		if (getMyFantasyPoints() > other.getMyFantasyPoints()) 
			return -1;
		else if (getMyFantasyPoints() < other.getMyFantasyPoints())
			return 1;
		else 
			return 0;
	}
	
	public String toString() {
		String output = "";
		output += "Name: " + name + "\t" + "Team: " + teamName + "\t" + "Position: " + position + "\n";
		output += myStats;
		return output;
	}
	
	
}
