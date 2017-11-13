package summarizer;

import summarizer.exceptions.NegativePriceException;

public class Summarizer {
	
	public double sum(ShoppingCart cart) throws NegativePriceException {
    	double summary = 0;
    	for (IItem i : cart.getItems()) {
    		if (i instanceof ShoppingCart) {
    			summary+= sum((ShoppingCart)i);
    		}
    		else {
    			summary+= i.getPrice();
        	}
    	}
    	return summary;
    }

}
