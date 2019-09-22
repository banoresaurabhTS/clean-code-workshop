package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = "Rental Record for " + getName() + "\n";
    for (Rental each : rentals) {
      double thisAmount1 = each.amountFor();
	double thisAmount = thisAmount1;
      frequentRenterPoints = each.frequentRentalPoints(frequentRenterPoints);

      //show figures for this rental
      result += "\t" + each.getMovie().getTitle() + "\t" +
          String.valueOf(thisAmount) + "\n";
      totalAmount += thisAmount;
    }

    //add footer lines result
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints)
        + " frequent renter points";
    return result;
  }

//Provides the Statement as an HTML String
  public String htmlStatement() {
	    
	    
	    
	    String result = "<h1>Rental Record for " + getName() + "<h1><br/>";
		double totalAmount = totalAmount();
	    int frequentRenterPoints = freeRentalPoints();
    	for (Rental each : rentals) {
	
    		//show figures for this rental
    		result += "\t" + each.getMovie().getTitle() + "\t" +
		     String.valueOf(each.amountFor()) + "\n";

	    }

	    //add footer lines result
	    result += "Amount owed is <b>" + String.valueOf(totalAmount) + "</b><br/>";
	    result += "You earned <b>" + String.valueOf(frequentRenterPoints)
	        + "</b> frequent renter points";
	    
	    return result;	
  }

private int freeRentalPoints() {
	int frequentRenterPoints = 0;
	for (Rental each : rentals) {
		frequentRenterPoints = each.frequentRentalPoints(frequentRenterPoints);
	}
	return frequentRenterPoints;
}

private double totalAmount() {
	double totalAmount = 0;
	for (Rental each : rentals) {
	    totalAmount += each.amountFor();
	}
	return totalAmount;
}
}

