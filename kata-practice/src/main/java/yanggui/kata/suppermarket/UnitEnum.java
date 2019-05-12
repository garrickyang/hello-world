package yanggui.kata.suppermarket;

import java.math.BigDecimal;

public enum UnitEnum {
	WEIGHT_POUND(CategoryEnum.LENGTH,"lb", new BigDecimal("1")),	
	WEIGHT_OUNCE(CategoryEnum.LENGTH,"oz", new BigDecimal("16")), //i pound=16 ounce
	UN_KOWN(null,"unkown",null);
	public CategoryEnum getCategoryEnum() {
		return categoryEnum;
	}

	public String getUnit() {
		return unit;
	}

	public BigDecimal getRate() {
		return rate;
	}

	private CategoryEnum categoryEnum;
	private String unit;
	private BigDecimal rate;
	
	UnitEnum(CategoryEnum categoryEnum, String unit, BigDecimal rate) {
		this.categoryEnum = categoryEnum;
		this.unit = unit;
		this.rate = rate;
	}
}

enum CategoryEnum{
	LENGTH(UnitEnum.WEIGHT_POUND);
	
	private UnitEnum baseUnit;
	
	CategoryEnum(UnitEnum baseUnit) {
		this.baseUnit=baseUnit;
	}
	
	public UnitEnum getBaseUnit(){
		return baseUnit;
	}	
	
}
