package com.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental>{
	
	public int freeRentalPoints() {
		int frequentRenterPoints = 0;
		for (Rental each : this) {
			frequentRenterPoints = each.frequentRentalPoints(frequentRenterPoints);
		}
		return frequentRenterPoints;
	}

	public double totalAmount() {
		double totalAmount = 0;
		for (Rental each : this) {
		    totalAmount += each.amountFor();
		}
		return totalAmount;
	}


}
