package yanggui.kata.suppermarket;

import java.math.BigDecimal;

public class SupperMarketPrice {

	public static BigDecimal calculatePrice(Order order){
		if(order.getProduct()!=null && order.getQuantity() !=null ){
			unifyUnit(order);
			return calculatePrice(order.getProduct(), order.getQuantity(), order.getPriceStrategy());	
		}
		return new BigDecimal(0).setScale(2);
		
		
	}
	private static void unifyUnit(Order order) {
		if(order.getUnit()==order.getProduct().getUnit()){
			return;
		}
		order.setQuantity(UnitConvertion.convertUnit(order.getQuantity(), order.getUnit(), order.getProduct().getUnit()));
		order.setUnit(order.getProduct().getUnit());
		
	}
	public static BigDecimal calculatePrice(Product product, BigDecimal totalProductNumber, String priceStrategy) {
		BigDecimal totalPrice = new BigDecimal("0").setScale(2, BigDecimal.ROUND_HALF_UP);
		if (product==null||product.getSkuid() == null || product.getSkuid().isEmpty()) {
			return totalPrice;
		}
		
		if (totalProductNumber.compareTo(new BigDecimal(0))==-1) {
			return totalPrice;
		}
		if (priceStrategy != null && !priceStrategy.isEmpty()) {
			totalPrice = calculateStrategyPrice(product, totalProductNumber, priceStrategy);
		} else {
			totalPrice = calculateNormalPrice(product, totalProductNumber);
		}
		return totalPrice;
	}

	private static BigDecimal calculateNormalPrice(Product product, BigDecimal totalProductNumber) {
		return product.getPrice().multiply(totalProductNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	private static BigDecimal calculateStrategyPrice(Product product, BigDecimal totalProductNumber, String priceStrategy) {
		PriceStrategy priceStrategyObject = getPriceStrategy(priceStrategy);
		BigDecimal totalPrice=new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);
		if (priceStrategyObject != null) {
			if (totalProductNumber.compareTo(new BigDecimal(priceStrategyObject.getDefaultQuantity()))>-1) {
				BigDecimal[] divideAndRemainder = totalProductNumber.divideAndRemainder(new BigDecimal(priceStrategyObject.getDefaultQuantity()));
				BigDecimal strategyPriceQuantity=divideAndRemainder[0];
				BigDecimal normalPriceQuantity=divideAndRemainder[1];
				BigDecimal strategyTotalPrice = priceStrategyObject.getDefaultPrice().multiply(strategyPriceQuantity);
				BigDecimal leftProductTotalPrice = calculateNormalPrice(product, normalPriceQuantity);
				totalPrice = strategyTotalPrice.add(leftProductTotalPrice);
			}
		}
		return totalPrice;
	}

	private static PriceStrategy getPriceStrategy(String priceStrategy) {

		PriceStrategy priceStrategyObject = new PriceStrategy();
		priceStrategyObject.setStrategyName(priceStrategyObject.THREE_FOR_DOLLAR);
		priceStrategyObject.setDefaultPrice(new BigDecimal("1"));
		priceStrategyObject.setDefaultQuantity(3);
		return priceStrategyObject;

	}

}
