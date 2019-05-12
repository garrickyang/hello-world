package yanggui.kata.suppermarket;

import java.math.BigDecimal;


public class PriceStrategy {
	private String strategyName;
	private int defaultQuantity;
	private BigDecimal defaultPrice;

	public PriceStrategy(String strategyName, int pricingQuantity, BigDecimal defaultPrice){
		this.strategyName = strategyName;
		this.defaultQuantity=pricingQuantity;
		this.defaultPrice = defaultPrice;
		
	}
	public String getStrategyName() {
		return strategyName;
	}
	public void setStrategyName(String strategyName) {
		
		this.strategyName = strategyName;
	}

	public int getDefaultQuantity() {
		return defaultQuantity;
	}
	public void setDefaultQuantity(int defaultUnit) {
		this.defaultQuantity = defaultUnit;
	}
	public BigDecimal getDefaultPrice() {
		return defaultPrice;
	}
	public void setDefaultPrice(BigDecimal defaultPrice) {
		this.defaultPrice = defaultPrice;
	}
	public BigDecimal getStrategyPrice(Product product) {
		return getDefaultPrice();
	}

}
