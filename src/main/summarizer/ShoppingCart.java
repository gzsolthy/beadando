package summarizer;

public class ShoppingCart implements IItem {
	
	private IItem[] items;
	
	public IItem[] getItems(){
		return this.items;
	}

	public double getPrice() {
		return 0;
	}

}
