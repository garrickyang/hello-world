package yanggui.kata.suppermarket;

import java.math.BigDecimal;

public class SupperMarketPrice {

	public static BigDecimal calculatePrice(Product product, int totalProductNumber, String priceStrategy) {
		BigDecimal totalPrice = new BigDecimal("0").setScale(2, BigDecimal.ROUND_HALF_UP);
		if (product==null||product.getSkuid() == null || product.getSkuid().isEmpty()) {
			return totalPrice;
		}
		if (totalProductNumber < 1) {
			return totalPrice;
		}
		if (priceStrategy != null && !priceStrategy.isEmpty()) {
			totalPrice = calculateStrategyPrice(product, totalProductNumber, priceStrategy);
		} else {
			totalPrice = calculateNormalPrice(product, totalProductNumber);
		}
		return totalPrice;
	}

	private static BigDecimal calculateNormalPrice(Product product, int totalProductNumber) {
		return product.getPrice().multiply(new BigDecimal(totalProductNumber)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private static BigDecimal calculateStrategyPrice(Product product, int totalProductNumber, String priceStrategy) {
		PriceStrategy priceStrategyObject = getPriceStrategy(priceStrategy);
		BigDecimal totalPrice=new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
		if (priceStrategyObject != null) {
			if (totalProductNumber >= priceStrategyObject.getDefaultUnit()) {
				int strategyUnit = totalProductNumber / priceStrategyObject.getDefaultUnit();
				int leftProductTotalNumber = totalProductNumber % priceStrategyObject.getDefaultUnit();
				BigDecimal strategyTotalPrice = priceStrategyObject.getDefaultPrice()
						.multiply(new BigDecimal(strategyUnit));
				BigDecimal leftProductTotalPrice = calculateNormalPrice(product, leftProductTotalNumber);
				totalPrice = strategyTotalPrice.add(leftProductTotalPrice);
			}
		}
		return totalPrice;
	}

	private static PriceStrategy getPriceStrategy(String priceStrategy) {

		PriceStrategy priceStrategyObject = new PriceStrategy();
		priceStrategyObject.setStrategyName(priceStrategyObject.THREE_FOR_DOLLAR);
		priceStrategyObject.setDefaultPrice(new BigDecimal("1"));
		priceStrategyObject.setDefaultUnit(3);
		return priceStrategyObject;

	}

}
