package shopping;

import java.util.ArrayList;
import java.util.HashMap;

public class Product implements Comparable<Product> {
	private int rating;
	private double price;
	private int weight;
	private double shipCost;
	private int numSold;
	private HashMap<Integer, String> reviews;
	private static int priceHikeCounter;
	private static double hikeRatio;
     
    public Product() {
    	
    }
    
    public Product(int rating, double price, int weight, double shipCost) {
    	this.rating = rating;
    	this.weight = weight;
    	this.price = price;
    	this.shipCost = shipCost;
    	priceHikeCounter = 5;
    	hikeRatio = 1.03;
    	reviews = new HashMap<Integer, String>();
    }
    
    public int getRating() {
		return rating;
	}
	
	public HashMap<Integer, String> getReviews() {
		return reviews;
	}

	public void setReviews(HashMap<Integer, String> reviews) {
		this.reviews = reviews;
	}

	public static int getPriceHikeCounter() {
		return priceHikeCounter;
	}

	public static void setPriceHikeCounter(int priceHikeCounter) {
		Product.priceHikeCounter = priceHikeCounter;
	}

	public static double getHikeRatio() {
		return hikeRatio;
	}

	public static void setHikeRatio(double hikeRatio) {
		Product.hikeRatio = hikeRatio;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getNumSold() {
		return numSold;
	}
	
	public void setNumSold(int numSold) {
		this.numSold = numSold;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getShipCost() {
		return numSold;
	}
	
	public void setShipCost(double shipCost) {
		this.shipCost = shipCost;
	}
	
	public void sell(int sold) {
		numSold += sold;
	}
	
	public double totalCost() {
		return price + weight * shipCost;
	}
	
	public boolean proper() {
		return (rating >= 16 && price <= 1000);
	}
	
	public int compareTo(Product p2) {
		double expP1 = this.price * this.numSold + this.numSold * this.weight * this.shipCost;
	    double expP2 = p2.price * p2.numSold + p2.numSold * p2.weight * p2.shipCost;

	    return Double.compare(expP1, expP2);
	}
	
	public static String toString(ArrayList<Product> listOfProducts) {
		int n = listOfProducts.size();
		
		for(int i = 0; i < n - 1 ; i++) {
			for(int b = 0; b < n - i - 1; b++) {
				if(listOfProducts.get(b).compareTo(listOfProducts.get(b + 1)) > 0) {
					Product temp = listOfProducts.get(b + 1);
					listOfProducts.set(b + 1, listOfProducts.get(b));
					listOfProducts.set(b, temp);
				}
			}
		}
		
		StringBuilder str = new StringBuilder();
	    for (Product p : listOfProducts) {
	        str.append("Rating = ").append(p.getRating()).append(", price = ").append(p.getPrice()).append(", total cost = ").append(p.totalCost()).append("\n");
	    }

	    return str.toString();
	}
	
	public void addReview(int retailerId, String review) {
		if(!reviews.containsKey(retailerId)) {
			reviews.put(retailerId,review);
		}
	}
	
	public String displayReviews() {
		String result = "";
		for(int i : reviews.keySet()) {
			result += ("Retailer ID: " + i + ", Review:" + reviews.get(i) + "\n");
		}
		return result;
	}
	
	public void dynamicPricing() {
		if(numSold % priceHikeCounter == 0) {
			this.price *= hikeRatio; 
		}
	}
}
