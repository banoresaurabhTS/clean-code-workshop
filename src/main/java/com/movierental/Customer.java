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
	 	return new TextStatement().display();
  }

  
//Provides the Statement as an HTML String
  public String htmlStatement() {
	    String result = "<h1>Rental Record for " + getName() + "<h1><br/>";
		double totalAmount = totalAmount();
	    int frequentRenterPoints = freeRentalPoints();
    	for (Rental each : rentals) {
    		//show figures for this rental
    		result += "\t" + each.getMovie().getTitle() + "\t" +
		     String.valueOf(each.amountFor()) + "<br/>";

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

private class TextStatement	{
	public String display() {
		   String result = "Rental Record for " + getName() + "\n";
			double totalAmount = totalAmount();
		    int frequentRenterPoints = freeRentalPoints();
	  	
		    for (Rental each : rentals) {
	  		//show figures for this rental
		    	result += "\t" + each.getMovie().getTitle() + "\t" +
			    String.valueOf(each.amountFor()) + "\n";

		    }
		    //add footer lines result
		    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		    result += "You earned" + String.valueOf(frequentRenterPoints)
		        + " frequent renter points";
		    return result;
	}
}
}

