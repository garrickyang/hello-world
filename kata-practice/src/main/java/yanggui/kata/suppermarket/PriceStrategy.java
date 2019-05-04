package yanggui.kata.suppermarket;

import java.math.BigDecimal;


public class PriceStrategy {
	public static String THREE_FOR_DOLLAR ="THREE_FOR_DOLLAR";
	public String getStrategyName() {
		return strategyName;
	}
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getDefaultQuantity() {
		return quadefaultQntity;
	}
	public void setDefaultQuantity(int defaultUnit) {
		this.quadefaultQntity = defaultUnit;
	}
	public BigDecimal getDefaultPrice() {
		return defaultPrice;
	}
	public void setDefaultPrice(BigDecimal defaultPrice) {
		this.defaultPrice = defaultPrice;
	}
	private String strategyName;
	private Product product;
	private int quadefaultQntity;
	private BigDecimal defaultPrice;

}
