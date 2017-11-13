package summarizer;

import summarizer.exceptions.NegativePriceException;

public interface IItem {
	
	double getPrice() throws NegativePriceException;
	
}
