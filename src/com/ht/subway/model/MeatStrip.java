package com.ht.subway.model;

public class MeatStrip extends Toppings{

	private double price=45.0;
	
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
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Meat Strip";
	}

}
