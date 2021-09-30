package com.ht.subway.service;

import java.util.LinkedList;
import java.util.List;

import com.ht.subway.model.Incrediants;

public class Order {
	private LinkedList<Incrediants> subway = new LinkedList<Incrediants>();
	
	public void addItem(Incrediants inc) {
		subway.add(inc);
	}

	public void addItems(List<Incrediants> incs) {
		subway.addAll(incs);
	}
	
	public void generateBill() {
		System.out.println("Invoice for Sub");
		Double total=0.0;
		for(Incrediants inc:subway) {
			System.out.println(inc.getType()+" - "+inc.getName()+"  -"+inc.getPrice()+"₹");
			total+=inc.getPrice();
		}
		System.out.println("Total - "+total+"₹");
	}
	
	
}
