package summarizer;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import summarizer.exceptions.NegativePriceException;
import static org.junit.Assert.assertEquals;

public class SummarizerTest {
	
	static Summarizer summarizer;
	static ShoppingCart shoppingCart1;
	static ShoppingCart cartInShoppingCart;
	static Item item1;
	static Item item2;
	
	static ShoppingCart shoppingCart2;
	static Item item3;
	
	@BeforeClass
	public static void setUpSummarizer() {
		summarizer = new Summarizer();
	}
	
	@Before
	public void setUp() throws NegativePriceException {
		shoppingCart1 = EasyMock.mock(ShoppingCart.class);
		cartInShoppingCart = EasyMock.mock(ShoppingCart.class);
		shoppingCart2 = EasyMock.mock(ShoppingCart.class);
		item1 = EasyMock.mock(Item.class);
		item2 = EasyMock.mock(Item.class);
		item3 = EasyMock.mock(Item.class);
		
		EasyMock.expect(shoppingCart1.getItems()).andReturn(
				new IItem[] { item1, item2, cartInShoppingCart }
				).anyTimes();
		EasyMock.replay(shoppingCart1);
		
		EasyMock.expect(cartInShoppingCart.getItems()).andReturn(
				new IItem[] { item1, item2 }
				).anyTimes();
		EasyMock.replay(cartInShoppingCart);
		
		EasyMock.expect(shoppingCart2.getItems()).andReturn(
				new IItem[] { item3 }).anyTimes();
		EasyMock.replay(shoppingCart2);
		
		EasyMock.expect(item1.getPrice()).andReturn(1.5).anyTimes();
		EasyMock.replay(item1);
		
		EasyMock.expect(item2.getPrice()).andReturn(2.0).anyTimes();
		EasyMock.replay(item2);
		
		EasyMock.expect(item3.getPrice()).andThrow(new NegativePriceException()).anyTimes();
		EasyMock.replay(item3);
	}

	@Test
	public void testSummarizer() throws NegativePriceException {
		double expected = 7;
		assertEquals(expected, summarizer.sum(shoppingCart1), 1e-10);
	}
	
	@Test(expected = NegativePriceException.class)
	public void testSummarizerWithException() throws NegativePriceException {
		summarizer.sum(shoppingCart2);
	}
	
}
