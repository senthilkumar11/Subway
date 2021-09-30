package com.ht.subway.model;

public abstract class Filling implements Incrediants {

	public String getType() {
		return "Filling";
	}
	public static Incrediants getFilling(int selection) {
		if(selection==1)
			return new ChickenTikka();
		else if(selection==2)
			return new PaneerTikka();
		else if(selection==3)
			return new TurkeyMeat();
		else
			return null;
	}
}
