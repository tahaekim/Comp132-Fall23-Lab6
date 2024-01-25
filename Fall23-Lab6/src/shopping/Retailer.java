package shopping;
import java.util.LinkedList;
import java.util.ArrayList;

public class Retailer {
	private String name;
    private int id;
    private LinkedList<Product> shoplist;
    private double moneyOwed;
    
    public Retailer(String name, int id) {
    	this.name = name;
    	this.id = id;
    	shoplist = new LinkedList<>();
    	moneyOwed = 0;
    }
    
    public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Product> getShoplist() {
		return shoplist;
	}

	public void setShoplist(LinkedList<Product> shoplist) {
		this.shoplist = shoplist;
	}

	public double getMoneyOwed() {
		return moneyOwed;
	}

	public void setMoneyOwed(double moneyOwed) {
		this.moneyOwed = moneyOwed;
	}

	public boolean addProduct(Product product) {
		if(product.proper()) {
			shoplist.add(product);
			System.out.println("A product was added to the shoplist of " + name);
			moneyOwed += product.getPrice();
			return true;
		}
		else {
			System.out.println("We do not recommend this product");
			return false;
		}
	}
	
	public boolean removeProduct() {
		if (moneyOwed > 4000) {
			try {
				Product removed = shoplist.remove(2);
				
				if(removed != null) {
					moneyOwed -= removed.getPrice();
					System.out.println("A product was removed from " + this.name);
					return true;
				}
				else return false;
			} 
			catch (IndexOutOfBoundsException e) {
				System.out.println("Error: " + e.getMessage());
                return false;
			}
		}
		else return false;
	}

	public static String toString(ArrayList<Retailer> list) {
		String str = "";
		for(Retailer r : list) {
			double tot = r.getMoneyOwed();
			tot /= r.getShoplist().size();
			str += ("Name: " + r.getName() + ", " + "Id: " + r.getId() + ", " + "moneyOwed: " + r.getMoneyOwed() + ", " + "score: " + tot + "\n");
		}
		return str;
	}
}
