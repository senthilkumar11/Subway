package com.ht.subway.model;

public class ChickenTikka extends Filling{
	private double price=120.0;
	
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
		return "Chicken Tikka";
	}
}
