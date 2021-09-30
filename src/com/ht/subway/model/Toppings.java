package com.ht.subway.model;

public abstract class Toppings implements Incrediants {

	public String getType() {
		return "Toppings";
	}
	
	public static Incrediants getToppings(String selection) {
		if(selection.equals("1"))
			return new Cucumber();
		else if(selection.equals("2"))
			return new Tomato();
		else if(selection.equals("3"))
			return new MeatStrip();
		else if(selection.equals("4"))
			return new Cabbage();
		else
			return null;
		
	}
}
