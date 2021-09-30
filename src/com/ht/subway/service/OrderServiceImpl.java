package com.ht.subway.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.ht.subway.model.Crust;
import com.ht.subway.model.Filling;
import com.ht.subway.model.Incrediants;
import com.ht.subway.model.Toppings;

public class OrderServiceImpl {

	static Scanner sc = new Scanner(System.in);

	public static Incrediants AddCrust() {
		System.out.println(
				"Select “Crust” (max of 1)\r\n" + "1)	Hard - 10 ₹\r\n" + "2)	Thin -  10 ₹\r\n" + "3)	Soft  -  12 ₹");
		Incrediants crust = Crust.getCrust(sc.nextInt());
		if (crust == null) {
			System.err.println("Invalid input");
			return AddCrust();
		} else {
			return crust;
		}
	}

	public static Incrediants AddFilling() {
		System.out.println("Select “Filling” (max of 1)\r\n" + "1)	Chicken Tikka - 120 ₹\r\n"
				+ "2)	Paneer Tikka   - 100 ₹\r\n" + "3)	Turkey Meat    - 130 ₹");

		Incrediants filling = Filling.getFilling(sc.nextInt());
		if (filling == null)
			return AddFilling();
		else
			return filling;
	}

	public static List<Incrediants> AddToppings(Incrediants filling) {
		List<Incrediants> toppingsList = new LinkedList<Incrediants>();

		System.out.println("Select “Toppings” (max of 3)\r\n" + "1)	Cucumber     -  25 ₹ \r\n"
				+ "2)	Tomato          -  20 ₹ \r\n" + "3)	Meat strip      -  45 ₹\r\n" + "4)	Cabbage       -  20 ₹");

		String selections[] = sc.nextLine().split(",");
		boolean error = false;
		Incrediants minimum = null;
		if (selections.length <= 3) {
			for (String selection : selections) {
				Incrediants toppings = Toppings.getToppings(selection);
				if (minimum == null)
					minimum = toppings;
				if (toppings == null) {
					error = true;
					System.err.println("Invalid input");
					break;
				}
				if (filling.isVeg()) {
					if (!toppings.isVeg()) {
						error = true;
						System.err.println("Cannot apply " + toppings.getName() + " on " + filling.getName());
						break;
					}
				}
				if (minimum.getPrice() > toppings.getPrice())
					minimum = toppings;
				toppingsList.add(toppings);
			}
		} else {
			System.err.println("Invalid input");
			error = true;
		}
		if (selections.length == 3)
			minimum.setPrice(0.0);

		if (error)
			return AddToppings(filling);
		else
			return toppingsList;

	}

	public void createOwnOrder() {

		Order order = new Order();
		Incrediants crust = AddCrust();
		order.addItem(crust);
		Incrediants filling = AddFilling();
		order.addItem(filling);
		sc.nextLine();
		order.addItems(AddToppings(filling));
		order.generateBill();
	}

	public void createOrderOfTheDay() {
		Order order = new Order();
		Random random = new Random();
		int randomNum = random.nextInt(4);//random number generator
		if(randomNum==0)
			randomNum++;
		Incrediants crust = Crust.getCrust(randomNum);
		order.addItem(crust);
		randomNum = random.nextInt(4);//random number generator 
		if(randomNum==0)
			randomNum++;
		Incrediants filling = Filling.getFilling(randomNum);
		order.addItem(filling);
		randomNum = random.nextInt(4);
		if(randomNum==0)
			randomNum++;
		String str = "";
		for (int i = 0; i < randomNum;) {
			int temp = random.nextInt(5);
			if (temp != 0) {
				if (filling.isVeg()) {
					if (!str.contains(String.valueOf(temp)) && temp != 3) {
						str += temp + ",";
						i++;
					}
				} else {
					if (!str.contains(String.valueOf(temp))) {
						str += temp + ",";
						i++;
					}
				}
			}
		}
		List<Incrediants> toppingsList = new LinkedList<Incrediants>();

		System.out.println(str.length());
		String selections[] = str.substring(0, str.length() - 1).split(",");
		Incrediants minimum = null;
		if (selections.length <= 3) {
			for (String selection : selections) {
				Incrediants toppings = Toppings.getToppings(selection);
				if (minimum == null)
					minimum = toppings;
				if (minimum.getPrice() > toppings.getPrice())
					minimum = toppings;

				toppingsList.add(toppings);
			}
		}
		if (selections.length == 3)
			minimum.setPrice(0.0);

		order.addItems(toppingsList);
		order.generateBill();
	}
}
