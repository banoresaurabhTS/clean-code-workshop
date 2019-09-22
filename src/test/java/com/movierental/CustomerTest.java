package com.movierental;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {
    @Test
    public void TestGeneratedStatement(){
    	
    	Customer customer = new Customer("Saurabh");
    	customer.addRental(new Rental(new Movie("John Wick", Movie.REGULAR), 5));
    	customer.addRental(new Rental(new Movie("Up", Movie.CHILDRENS), 15));
    	customer.addRental(new Rental(new Movie("Batla House", Movie.NEW_RELEASE), 1));
    	
    	assertEquals("Rental Record for Saurabh\n" + 
    			"	John Wick	6.5\n" + 
    			"	Up	19.5\n" + 
    			"	Batla House	3.0\n" + 
    			"Amount owed is 29.0\n" + 
    			"You earned 3 frequent renter points", customer.statement());
    	
    	
    }

}