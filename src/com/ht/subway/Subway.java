package com.ht.subway;

import java.util.Scanner;

import com.ht.subway.service.OrderServiceImpl;

public class Subway {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Welcome to Subway:\r\n" + "1)	Order 'Sub' off the day\r\n"
					+ "2)	Order your own 'Sub'\r\n" + "3)	Exit");
			int step = sc.nextInt();

			switch (step) {
			case 1:
				OrderServiceImpl orderOfTheDay = new OrderServiceImpl();
				orderOfTheDay.createOrderOfTheDay();
				break;
			case 2:
				OrderServiceImpl order = new OrderServiceImpl();
				order.createOwnOrder();
				break;

			default:
				sc.close();
				System.exit(0);

			}
		}
		
	}

}
