package yanggui.kata.suppermarket;

import java.math.BigDecimal;

public class BuyAndGiveStrategy extends PriceStrategy {

	private int givenQuantity;

	public int getGivenQuantity() {
		return givenQuantity;
	}

	public void setGivenQuantity(int givenQuantity) {
		this.givenQuantity = givenQuantity;
	}

	public BuyAndGiveStrategy(String strategyName, int pricingQuantity, BigDecimal defaultPrice, int givenQuantity) {
		super(strategyName, pricingQuantity, defaultPrice);
		this.givenQuantity = givenQuantity;

	}

	@Override
	public BigDecimal getStategyPrice(Product product) {
		int calculateQuanty=getDefaultQuantity()-givenQuantity;
		return product.getPrice().multiply(new BigDecimal(calculateQuanty));
	}

}
