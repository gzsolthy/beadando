package summarizer;

import summarizer.exceptions.NegativePriceException;

public class Item implements IItem {
	
	private double price;

	public double getPrice() throws NegativePriceException {
		return this.price;
	}

}
