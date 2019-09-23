package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private Rentals rentals = new Rentals();

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
	 	return new TextStatement().display(this.getName(), this.rentals);
  }

  
//Provides the Statement as an HTML String
  public String htmlStatement() {
	    String result = "<h1>Rental Record for " + getName() + "<h1><br/>";
		double totalAmount = rentals.totalAmount();
	    int frequentRenterPoints = rentals.freeRentalPoints();
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


private class TextStatement	{
	public String display(String name, Rentals rentals) {
		   String result = "Rental Record for " + getName() + "\n";
			
		   
	  	
		    for (Rental each : rentals) {
	  		//show figures for this rental
		    	result += "\t" + each.getMovie().getTitle() + "\t" +
			    String.valueOf(each.amountFor()) + "\n";

		    }
		    //add footer lines result
		    result += "Amount owed is " + String.valueOf(rentals.totalAmount()) + "\n";
		    result += "You earned" + String.valueOf(rentals.freeRentalPoints())
		        + " frequent renter points";
		    return result;
	}
}
}

