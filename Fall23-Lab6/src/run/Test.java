/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Ahmet Taha Ekim, 79234>
********************************************************************************/

package run;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import shopping.*;


public class Test {

	public static void main(String[] args) {
		
//TODO 1 Define two ArrayList (of Java collections) with type Product named: `listOfProducts`  and `listOfProperProducts`
		ArrayList<Product> listOfProducts = new ArrayList<>();
		ArrayList<Product> listOfProperProducts = new ArrayList<>();
		
		listOfProducts.add(new Product(16, 1000, 1200, 0.5));
		listOfProducts.add(new Product(32, 1000, 600, 0.2));
		listOfProducts.add(new Product(16, 1000, 700, 0.1));
		listOfProducts.add(new Product(32, 950, 1000, 0.3));
		listOfProducts.add(new Product(16, 320, 480, 0.1));
		listOfProducts.add(new Product(4, 850, 480, 0.1));
		listOfProducts.add(new Product(32, 900, 700, 0.4));
		listOfProducts.add(new Product(16, 650, 1100, 0.3));
		listOfProducts.add(new Product(64, 2100, 500, 0.3));
		listOfProducts.add(new Product(2, 300, 450, 0.2));
		listOfProducts.add(new Product(12, 600, 700, 0.3));
		
//TODO 2: Check each Product object in the ArrayList with proper() method, and put the suggested 
 //           products into a LinkedList (of Java collections) named `listOfProperProducts` 
 //                                  that you defined in TODO 1.
		for(Product p : listOfProducts) {
			if(p.proper()) {
				listOfProperProducts.add(p);
			}
		}
//	
		
		System.out.println("List of Products are as follow:");
	

	
//TODO 3: Sort the list of proper products using the Collections.sort() method.
		Collections.sort(listOfProperProducts);
	
	
	
//TODO 4: Use toString() method of Product class to display all products in the list.
		System.out.println(Product.toString(listOfProducts));
//
    
	    System.out.println("---------------------------------");
	    System.out.println("List of proper Products are as follow:");
    
//TODO 5: Use toString() method of Product class to display the list of proper products.    
	    System.out.println(Product.toString(listOfProperProducts));
//
    
    System.out.println("----------------------------------------------");
    
    
    Retailer u1=new Retailer("Ali",1);
    Retailer u2=new Retailer("Ahmet",2);
    Retailer u3=new Retailer("Efe",3);
    Retailer u4=new Retailer("Mete",4);
    
    u1.addProduct(listOfProducts.get(0));
    u1.addProduct(listOfProducts.get(1));
    u1.addProduct(listOfProducts.get(2));
    u1.addProduct(listOfProducts.get(3));
    u1.addProduct(listOfProducts.get(4));
    u1.addProduct(listOfProducts.get(8));
    
    u3.addProduct(listOfProducts.get(4));
    u4.addProduct(listOfProducts.get(4));
    u4.addProduct(listOfProducts.get(3));
    
    u2.addProduct(listOfProducts.get(1));
    u2.addProduct(listOfProducts.get(7));
    u2.addProduct(listOfProducts.get(2));
    u2.addProduct(listOfProducts.get(4));
    u2.addProduct(listOfProducts.get(6));
    u2.addProduct(listOfProducts.get(9));
    
    System.out.println("----------------------------------------------");
    System.out.println("The shopper  "+ u1.getName()+ "  should pay  " + u1.getMoneyOwed());
    System.out.println("The shopper  "+ u2.getName()+ "  should pay  " + u2.getMoneyOwed());
    System.out.println("The shopper  "+ u3.getName()+ "  should pay  " + u3.getMoneyOwed());
    System.out.println("The shopper  "+ u4.getName()+ "  should pay  " + u4.getMoneyOwed());
    System.out.println("----------------------------------------------");

//TODO 6: Use removeGood() method of Retailer class to remove the possible extra products of all retailers.
   u1.removeProduct();
   u2.removeProduct();
   u3.removeProduct();
   u4.removeProduct();
//    
    
    System.out.println("The Retailer   "+ u1.getName() + "  should pay " + u1.getMoneyOwed());
    System.out.println("The Retailer   "+ u2.getName() + "  should pay " + u2.getMoneyOwed());
    System.out.println("The Retailer   "+ u3.getName() + "  should pay " + u3.getMoneyOwed());
    System.out.println("The Retailer   "+ u4.getName() + "  should pay " + u4.getMoneyOwed());
    System.out.println("----------------------------------------------");
    
    Collections.sort(listOfProducts);
    
    System.out.println("List of Products after sort are as follow:");

//TODO 7: Use toString() method of Product class to display the sorted list of all products.
    System.out.println(Product.toString(listOfProducts));
//
    
    
//TODO 8: Create two Store objects: center1 and center2 with name fields set to `Center1` and `Center2`, respectively.   
    Store center1 = new Store("Center1");
    Store center2 = new Store("Center2");
//

    center1.addRetailer(u1,2);
    center1.addRetailer(u2, 4);
    center1.addRetailer(u3, 1);
    center1.addRetailer(u4, 2);
       
    center2.addRetailer(u1, 4);
    center2.addRetailer(u2, 2);
    
    System.out.println("----------------------------------------------");
    
 //TODO 9: Using multishoppers() method of Store class, find Retailers shopping from both center1 and center2 Stores and display them.     
    HashMap<Retailer, Integer> map2 = center2.getMap();
    ArrayList<String> multishoppers = center1.multishoppers(map2);
    System.out.println(multishoppers.toString());
//    
    
    // TODO 10: Create an arraylist of retailers called retailerList, and a RetailerComparator class called retailerComp.
    ArrayList<Retailer> retailerList = new ArrayList<>();
    retailerList.add(u1);
    retailerList.add(u2);
    retailerList.add(u3);
    retailerList.add(u4);
    RetailerComparator retailerComp = new RetailerComparator();
    
    // TODO 11: Sort retailerList using retailerList.sort() and providing retailerComp.
    retailerList.sort(retailerComp);
    
    
    // TODO 12: Print out the sorted retailerList
    System.out.println(Retailer.toString(retailerList));
    System.out.println("\n-----------------------In-Lab Tests-----------------------\n");
		// Test 1: Adding and Displaying Reviews
		System.out.println("Test 1: Adding and Displaying Reviews");
		Product testProduct = new Product(20, 500, 200, 0.2);
		testProduct.addReview(u1.getId(), "Great product, very useful.");
		testProduct.addReview(u2.getId(), "Good value for money.");
		testProduct.addReview(u1.getId(), "Trying to add another review, should not be added.");
		System.out.println("Reviews for testProduct: ");
		System.out.println(testProduct.displayReviews());
		// Test 2: Testing Dynamic Pricing
		System.out.println("Test 2: Testing Dynamic Pricing");
		System.out.println("Initial Price: " + testProduct.getPrice());
		testProduct.sell(4);
		System.out.println("Price after selling 4 units: " + testProduct.getPrice());
		testProduct.sell(1);
		System.out.println("Price after selling 1 more unit: " + testProduct.getPrice());
		// Test 3: Testing Data Analytics
		System.out.println("\nTest 3: Data Analytics");
		listOfProducts.get(0).sell(2);
		listOfProducts.get(1).sell(1);
		listOfProducts.get(2).sell(3);
		listOfProducts.get(3).sell(4);
		listOfProducts.get(0).addReview(u1.getId(), "Excellent product, highly recommended.");
		listOfProducts.get(0).addReview(u2.getId(), "Good quality, worth the price.");
		listOfProducts.get(0).addReview(u3.getId(), "Very nice!");
		listOfProducts.get(1).addReview(u1.getId(), "Satisfactory performance.");
		listOfProducts.get(2).addReview(u3.getId(), "Decent product, but there are better options.");
		listOfProducts.get(2).addReview(u4.getId(), "Met my expectations.");
		listOfProducts.get(3).addReview(u1.getId(), "Not as good as expected.");

		listOfProducts.get(4).addReview(u2.getId(), "Fantastic! Works perfectly.");
		displayAnalytics(retailerList, listOfProducts);
		Collections.sort(listOfProducts);
		System.out.println(Product.toString(listOfProducts));
	}
	public static void displayAnalytics(ArrayList<Retailer> retailers, ArrayList<Product> products) {
    	int max1 = 0;
    	int number = 0;
    	double bestSellerPrice;
		int bestSellerRating;
		int bestSellerWeight;
		double bestSellerShipCost ;
    	for(Product p1 : products) {
    		number++;
    		if(p1.getNumSold() > max1) {
    			max1 = p1.getNumSold();
    			bestSellerPrice = p1.getPrice();
    			bestSellerRating = p1.getRating();
    			bestSellerWeight = p1.getWeight();
    			bestSellerShipCost = p1.getShipCost();
    		}
    	}
    	System.out.println("Best Seller Product: Product No-" + number + " with " +  max1 + " units sold.");
    	
    	String mostvaluable;
    	int max2 = 0;
    	for(Retailer r1 : retailers) {
    		LinkedList<Product> shoplist = r1.getShoplist();
    		
    		if(shoplist.size() > max2) {
    			max2 = shoplist.size();
    			mostvaluable = r1.getName();
    		}
    	}
    	
    	
    	int max3 = 0;
    	double mostReviewedPrice;
		int mostReviewedRating;
		int mostReviewedWeight;
		double mostReviewedShipCost;
    	for(Product p1 : products) {
    		HashMap<Integer, String> reviews = p1.getReviews();
    		if(reviews.size() > max3) {
    			max3 = reviews.size();
    			mostReviewedPrice = p1.getPrice();
    			mostReviewedRating = p1.getRating();
    			mostReviewedWeight = p1.getWeight();
    			mostReviewedShipCost = p1.getShipCost();
    		}
    	}
    	
    	
    }
}
