package yanggui.kata.suppermarket;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SupperMarketPriceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void threeForDollar() {
		String priceStrategy = "THREE_FOR_DOLLAR";
		Product product = new Product();
		product.setSkuid("123456");
		product.setCurrency(Currency.getInstance(Locale.CHINA));
		product.setPrice(new BigDecimal("0.4"));
		assertEquals(new BigDecimal("1").setScale(2, BigDecimal.ROUND_HALF_UP), SupperMarketPrice.calculatePrice(product,3,priceStrategy));
	}
	@Test
	public void noDiscountOrder() {
		String priceStrategy = "";
		Product product = new Product();
		product.setSkuid("123456");
		product.setCurrency(Currency.getInstance(Locale.CHINA));
		product.setPrice(new BigDecimal("0.4"));
		assertEquals(new BigDecimal("1.20").setScale(2, BigDecimal.ROUND_HALF_UP), SupperMarketPrice.calculatePrice(product,3,priceStrategy));
	}
	@Test
	public void nullProduct() {
		
		assertEquals(new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_HALF_UP), SupperMarketPrice.calculatePrice(null,3,null));
	}
	@Test
	public void nullSku() {
		
		String priceStrategy = "THREE_FOR_DOLLAR";
		Product product = new Product();
		product.setSkuid("");
		product.setCurrency(Currency.getInstance(Locale.CHINA));
		product.setPrice(new BigDecimal("0.4"));
		assertEquals(new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_HALF_UP), SupperMarketPrice.calculatePrice(product,3,priceStrategy));
	}

}
