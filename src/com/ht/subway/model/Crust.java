package com.ht.subway.model;

public abstract class Crust implements Incrediants{
	
	public String getType() {
		return "Crust";
	}
	
	public static Incrediants getCrust(int selection) {
		if(selection==1)
			return new Hard();
		else if(selection==2)
			return new Thin();
		else if(selection==3)
			return new Soft();
		else
			return null;
	}

}
