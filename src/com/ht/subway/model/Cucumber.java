package com.ht.subway.model;

public class Cucumber extends Toppings{

	private double price=25.0;
	
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}


	@Override
	public boolean isVeg() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Cucumber";
	}

}
