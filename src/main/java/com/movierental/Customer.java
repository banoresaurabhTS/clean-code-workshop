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
      double thisAmount1 = 0;
		  //determine amounts for each line
		  switch (each.getMovie().getPriceCode()) {
		    case Movie.REGULAR:
		      thisAmount1 += 2;
		      if (each.getDaysRented() > 2)
		        thisAmount1 += (each.getDaysRented() - 2) * 1.5;
		      break;
		    case Movie.NEW_RELEASE:
		      thisAmount1 += each.getDaysRented() * 3;
		      break;
		    case Movie.CHILDRENS:
		      thisAmount1 += 1.5;
		      if (each.getDaysRented() > 3)
		        thisAmount1 += (each.getDaysRented() - 3) * 1.5;
		      break;
		  }
	double thisAmount = thisAmount1;
      // add frequent renter points
      frequentRenterPoints++;
      // add bonus for a two day new release rental
      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
          &&
          each.getDaysRented() > 1) frequentRenterPoints++;

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
	    
	  double totalAmount = 0;
	    
	    int frequentRenterPoints = 0;
	    
	    String result = "<h1>Rental Record for " + getName() + "<h1><br/>";
	    
	    for (Rental each : rentals) {
	      
	      double thisAmount1 = 0;
			  //determine amounts for each line
			  switch (each.getMovie().getPriceCode()) {
			    case Movie.REGULAR:
			      thisAmount1 += 2;
			      if (each.getDaysRented() > 2)
			        thisAmount1 += (each.getDaysRented() - 2) * 1.5;
			      break;
			    case Movie.NEW_RELEASE:
			      thisAmount1 += each.getDaysRented() * 3;
			      break;
			    case Movie.CHILDRENS:
			      thisAmount1 += 1.5;
			      if (each.getDaysRented() > 3)
			        thisAmount1 += (each.getDaysRented() - 3) * 1.5;
			      break;
			  }
		double thisAmount = thisAmount1;
	     
	      // add frequent renter points
	      frequentRenterPoints++;
	      
	      // add bonus for a two day new release rental
	      if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
	          &&
	          each.getDaysRented() > 1) frequentRenterPoints++;

	      //show figures for this rental
	      result += "&nbsp &nbsp &nbsp &nbsp &nbsp" + each.getMovie().getTitle() + "&nbsp &nbsp &nbsp &nbsp &nbsp" +
	          String.valueOf(thisAmount) + "<br/>";
	      totalAmount += thisAmount;
	    }

	    //add footer lines result
	    result += "Amount owed is <b>" + String.valueOf(totalAmount) + "</b><br/>";
	    result += "You earned <b>" + String.valueOf(frequentRenterPoints)
	        + "</b> frequent renter points";
	    
	    return result;	
  }
}

