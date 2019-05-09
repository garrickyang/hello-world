package yanggui.kata.suppermarket;

import java.math.BigDecimal;

public class Order {
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	private Product product;
	private BigDecimal quantity;
	private String unit;
	private String priceStrategy;
	public String getPriceStrategy() {
		return priceStrategy;
	}
	public void setPriceStrategy(String priceStrategy) {
		this.priceStrategy = priceStrategy;
	}

}
