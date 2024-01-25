package shopping;
import java.util.Comparator;
import java.util.LinkedList;

public class RetailerComparator implements Comparator<Retailer> {

	public int compare(Retailer r1, Retailer r2) {
		int tot1 = 0;
		int tot2 = 0;
		LinkedList<Product> shopList1 = r1.getShoplist();
		LinkedList<Product> shopList2 = r2.getShoplist();
		
		for(Product p1 : shopList1) {
			tot1 += p1.totalCost();
		}
		tot1 /= shopList1.size();
		
		for(Product p2 : shopList2) {
			tot2 += p2.totalCost();
		}
		tot2 /= shopList2.size();
		
		if (tot1 > tot2) return 1;
		else if (tot1 == tot2) return 0;
		else return -1;
	}
}
