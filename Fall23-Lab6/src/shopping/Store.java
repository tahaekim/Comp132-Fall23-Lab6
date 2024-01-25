package shopping;
import java.util.HashMap;
import java.util.ArrayList;

public class Store{
	private String name;
    private HashMap<Retailer, Integer> map;
	
    public Store(String name) {
    	map = new HashMap<Retailer, Integer>();
    	this.name = name;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Retailer, Integer> getMap() {
		return map;
	}

	public void setMap(HashMap<Retailer, Integer> map) {
		this.map = map;
	}

	public void addRetailer(Retailer r, int itemCount) {
		map.put(r, itemCount);
    }
	
	public ArrayList<String> multishoppers(HashMap<Retailer, Integer> shopStore) {
		ArrayList<String> identicalRetailers = new ArrayList<>();
		for (Retailer key1 : shopStore.keySet()) {
			if(map.containsKey(key1)) {
				identicalRetailers.add(key1.getName());
			}
        }
		identicalRetailers.sort(String::compareTo);
		return identicalRetailers;
	}
}
