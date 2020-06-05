package Tanks;

public class Score implements Comparable<Score>{
	private String name;
	private int numTanks;
	private long seconds;
	
	public Score(int t, long s) {
		setNumTanks(t);
		setSeconds(s);
	}
	
	public Score(String n, int t, long s) {
		setName(n);
		setNumTanks(t);
		setSeconds(s);
	}

	
	// Getters & Setters ----------------------------
	public String getName() {
		return name;
	}
	
	public int getNumTanks() {
		return numTanks;
	}

	public long getSeconds() {
		return seconds;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setNumTanks(int numTanks) {
		this.numTanks = numTanks;
	}

	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}
	//---------------------------------------------

	
	@Override
	public int compareTo(Score other) {
		if (numTanks == other.getNumTanks()) {
			if (seconds == other.getSeconds())
				return 0;
			else if (seconds < other.getSeconds())
				return -1;
			else 
				return 1;
		}
		else if (numTanks > other.getNumTanks())
			return -1;
		else 
			return 1;
	}
	
	
	public String toString(){
		return "Name: " + name + "\tTanks Destroyed: " + numTanks + "\tTime: " + seconds;
	}
	 
	
}
