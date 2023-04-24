package com.skillstorm.general;

import java.util.Comparator;

public class Athlete {
	
	private String name;
	private Integer win;
	private Integer loss;
	
	public Athlete(String name, Integer win, Integer loss) {
		this.name = name;
		this.win = win;
		this.loss = loss;
	}
	
	public double winRatio() {
		double winningRatio = (double) this.win / (this.win + this.loss) * 100;
		return winningRatio;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWin() {
		return this.win;
	}
	
	public int getLoss() {
		return this.loss;
	}
	
	@Override
	public String toString() {
		return String.format("Athlete: %s, Wins: %d, Losses: %d, Win ratio: %.0f%%%n",
				this.name, this.win, this.loss, winRatio());
	}
	
	public static class AthleteComparator implements Comparator<Athlete>{

	@Override
	public int compare(Athlete o1, Athlete o2) {
		if(o1 == null || o2 == null) {
			throw new NullPointerException("Cannot be null");	
		} else if (o1.win + o1.loss > 30 && o2.win + o2.loss > 30){
			Double thisT = o1.winRatio();
			Double otherO = o2.winRatio();
			return otherO.compareTo(thisT);
			
		} else {	
			Double thisA = o1.winRatio();
			Double otherB = o2.winRatio();
			return otherB.compareTo(thisA);
		}
	}

}

	

}
