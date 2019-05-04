package yanggui.kata.suppermarket;

import java.math.BigDecimal;
import java.util.Currency;

public class Product {
	private String productName;
	private BigDecimal price;
	private String skuid;
	private Currency currency;
	private String unit;
	
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSkuid() {
		return skuid;
	}
	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}


}
