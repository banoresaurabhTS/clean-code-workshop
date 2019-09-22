package com.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

double amountFor() {
	double thisAmount1 = 0;
		  //determine amounts for each line
		  switch (movie.getPriceCode()) {
		    case Movie.REGULAR:
		      thisAmount1 += 2;
		      if (daysRented > 2)
		        thisAmount1 += (daysRented - 2) * 1.5;
		      break;
		    case Movie.NEW_RELEASE:
		      thisAmount1 += daysRented * 3;
		      break;
		    case Movie.CHILDRENS:
		      thisAmount1 += 1.5;
		      if (daysRented > 3)
		        thisAmount1 += (daysRented - 3) * 1.5;
		      break;
		  }
	return thisAmount1;
}

int frequentRentalPoints(int frequentRenterPoints) {
	  frequentRenterPoints++;
	  if (isCodeApplicable()) frequentRenterPoints++;
	return frequentRenterPoints;
}

private boolean isCodeApplicable() {
	return (getMovie().getPriceCode() == Movie.NEW_RELEASE)
	      &&
	      getDaysRented() > 1;
}

}