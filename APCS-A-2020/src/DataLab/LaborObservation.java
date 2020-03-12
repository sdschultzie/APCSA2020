package DataLab;

public class LaborObservation {
	private int year;
	private String month;
	private double rate16_19;
	private double rate20_24;
	private double rate25_34;
	private double rate35_44;
	private double rate45_54;
	private double rate55_64;
	private double rate65;

	public LaborObservation (int yr, String mnth, double r1, double r2, double r3, double r4, double r5, double r6, double r7) {
		this.year = yr;
		this.month = mnth;
		this.rate16_19 = r1;
		this.rate20_24 = r2;
		this.rate25_34 = r3;
		this.rate35_44 = r4;
		this.rate45_54 = r5;
		this.rate55_64 = r6;
		this.rate65 = r7;
	}

	public int getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}

	public double getRate16_19() {
		return rate16_19;
	}

	public double getRate20_24() {
		return rate20_24;
	}

	public double getRate25_34() {
		return rate25_34;
	}

	public double getRate35_44() {
		return rate35_44;
	}

	public double getRate45_54() {
		return rate45_54;
	}

	public double getRate55_64() {
		return rate55_64;
	}

	public double getRate65() {
		return rate65;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setRate16_19(double rate16_19) {
		this.rate16_19 = rate16_19;
	}

	public void setRate20_24(double rate20_24) {
		this.rate20_24 = rate20_24;
	}

	public void setRate25_34(double rate25_34) {
		this.rate25_34 = rate25_34;
	}

	public void setRate35_44(double rate35_44) {
		this.rate35_44 = rate35_44;
	}

	public void setRate45_54(double rate45_54) {
		this.rate45_54 = rate45_54;
	}

	public void setRate55_64(double rate55_64) {
		this.rate55_64 = rate55_64;
	}

	public void setRate65(double rate65) {
		this.rate65 = rate65;
	}
	
	public String toString () {
		return "California Labor Force Participation Rate: " + month + " " + year + "\n" +
				"16-19: " + getRate16_19() + "\n" +
				"20-24: " + getRate20_24() + "\n" +
				"25-34: " + getRate25_34() + "\n" +
				"35-44: " + getRate35_44() + "\n" +
				"45-54: " + getRate45_54() + "\n" +
				"55-64: " + getRate55_64() + "\n" +
				"65+: " + getRate65();
	}
}
