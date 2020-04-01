package Q3FinalLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import core.data.*;

public class Stats {
	private int gamesPlayed;
	private int passYds;
	private int passTD;
	private int interceptions;
	private int rushYds;
	private int rushTD;
	private int rec;
	private int recYds;
	private int recTD;
	private int	fumblesLost;
	private int twoPC;
	private double totalFantasyPoints;
	
	public Stats() {
		setGamesPlayed(0);
		setPassYds(0);
		setPassTD(0);
		setInterceptions(0);
		setRushYds(0);
		setRushTD(0);
		setRec(0);
		setRecYds(0);
		setRecTD(0);
		setFumblesLost(0);
		setTwoPC(0);
		calcFantasyPoints();
	}
	
	public Stats(int gpIn, int py, int ptd, int i, int ruy, int rutd, int re, int reyd, int retd, int fl, int tpc) {
		setGamesPlayed(gpIn);
		setPassYds(py);
		setPassTD(ptd);
		setInterceptions(i);
		setRushYds(ruy);
		setRushTD(rutd);
		setRec(re);
		setRecYds(reyd);
		setRecTD(retd);
		setFumblesLost(fl);
		setTwoPC(tpc);
		calcFantasyPoints();
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getPassYds() {
		return passYds;
	}

	public int getPassTD() {
		return passTD;
	}

	public int getInterceptions() {
		return interceptions;
	}

	public int getRushYds() {
		return rushYds;
	}

	public int getRushTD() {
		return rushTD;
	}

	public int getRec() {
		return rec;
	}

	public int getRecYds() {
		return recYds;
	}

	public int getRecTD() {
		return recTD;
	}

	public int getFumblesLost() {
		return fumblesLost;
	}

	public int getTwoPC() {
		return twoPC;
	}
	
	public double getTotalFantasyPoints() {
		return totalFantasyPoints;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public void setPassYds(int passYds) {
		this.passYds = passYds;
	}

	public void setPassTD(int passTD) {
		this.passTD = passTD;
	}

	public void setInterceptions(int interceptions) {
		this.interceptions = interceptions;
	}

	public void setRushYds(int rushYds) {
		this.rushYds = rushYds;
	}

	public void setRushTD(int rushTD) {
		this.rushTD = rushTD;
	}

	public void setRec(int rec) {
		this.rec = rec;
	}

	public void setRecYds(int recYds) {
		this.recYds = recYds;
	}

	public void setRecTD(int recTDs) {
		this.recTD = recTDs;
	}

	public void setFumblesLost(int fumblesLost) {
		this.fumblesLost = fumblesLost;
	}

	public void setTwoPC(int twoPC) {
		this.twoPC = twoPC;
	}
	
	public void calcFantasyPoints() {
		this.totalFantasyPoints = 
				(4*passTD) + (6*rushTD) + (6*recTD)
				+(0.04*passYds) + (0.1*rushYds) + (0.1*recYds) + (rec) + (2*twoPC) 
				-(interceptions) - (2*fumblesLost);
	}
	
	public String toString() {
		calcFantasyPoints();
		return 
				"Games Played: " + gamesPlayed + "\n" +
				"Pass Yds: " + passYds + "\n" +
				"Pass TD: " + passTD + "\n" +
				"Interceptions: " + interceptions + "\n" +
				"Rush Yds: " + rushYds + "\n" +
				"Rush TD: " + rushTD + "\n" +
				"Rec: " + rec + "\n" +
				"Rec Yds: " + recYds + "\n" +
				"Rec TD: " + recTD + "\n" + 
				"Fumbles Lost: " + fumblesLost + "\n" +
				"Two Point Conversions: " + twoPC + "\n" +
				"Total Fantasy Points: " + String.format("%.2f", totalFantasyPoints) + "\n\n";
	}
}
