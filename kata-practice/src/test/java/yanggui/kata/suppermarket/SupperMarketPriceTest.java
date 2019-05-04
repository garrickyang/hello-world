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
		product.setUnit("piece");
		Order order = new Order();
		order.setProduct(product);
		order.setPriceStrategy(priceStrategy);
		order.setQuantity(new BigDecimal(3));
		order.setUnit("piece");
		assertEquals(new BigDecimal("1").setScale(2, BigDecimal.ROUND_HALF_UP), SupperMarketPrice.calculatePrice(order));
	}
	@Test
	public void noDiscountOrder() {
		Product product = new Product();
		product.setSkuid("123456");
		product.setCurrency(Currency.getInstance(Locale.CHINA));
		product.setPrice(new BigDecimal("0.4"));
		Order order = new Order();
		order.setProduct(product);
		order.setQuantity(new BigDecimal(3));
		assertEquals(new BigDecimal("1.20").setScale(2, BigDecimal.ROUND_HALF_UP), SupperMarketPrice.calculatePrice(order));
	}
	@Test
	public void nullProduct() {
		Order order = new Order();
		assertEquals(new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_HALF_UP), SupperMarketPrice.calculatePrice(order));
	}
	@Test
	public void nullSku() {
		
		String priceStrategy = "THREE_FOR_DOLLAR";
		Product product = new Product();
		product.setSkuid("");
		product.setCurrency(Currency.getInstance(Locale.CHINA));
		product.setPrice(new BigDecimal("0.4"));
		product.setUnit("piece");
		Order order = new Order();
		order.setProduct(product);
		order.setPriceStrategy(priceStrategy);
		order.setQuantity(new BigDecimal(3));
		order.setUnit("piece");
		assertEquals(new BigDecimal("0.00").setScale(2, BigDecimal.ROUND_HALF_UP), SupperMarketPrice.calculatePrice(order));
	}
	
	@Test
	public void calculate4OunceForPriceByPound() {
		Product product = new Product();
		product.setSkuid("123456");
		product.setCurrency(Currency.getInstance(Locale.CHINA));
		product.setPrice(new BigDecimal("1.99"));
		product.setUnit("lb");
		Order order = new Order();
		order.setProduct(product);
		order.setQuantity(new BigDecimal(4));
		order.setUnit("oz");
		assertEquals(new BigDecimal("0.50").setScale(2, BigDecimal.ROUND_HALF_UP), SupperMarketPrice.calculatePrice(order));
	}

}
