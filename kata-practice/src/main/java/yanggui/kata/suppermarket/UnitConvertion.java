package yanggui.kata.suppermarket;

import java.math.BigDecimal;

public class UnitConvertion {

	public static BigDecimal convertUnit(BigDecimal value, UnitEnum originUnit, UnitEnum needConverTo) {

		return convertUnit(value, originUnit, needConverTo, 2);
	}

	public static BigDecimal convertUnit(BigDecimal value, UnitEnum originUnit, UnitEnum needConverTo, int scale) {

		if (originUnit == UnitEnum.UN_KOWN || needConverTo == UnitEnum.UN_KOWN) {
			throw new IllegalArgumentException("Un surpport Unit");
		}
		if (originUnit.getCategoryEnum() != needConverTo.getCategoryEnum()) {
			throw new IllegalArgumentException("Cannot convert" + originUnit.getUnit() + ":" + needConverTo.getUnit());
		}
		return value == null ? new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP)
				: value.multiply(needConverTo.getRate()).divide(originUnit.getRate(), scale, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal convertUnit(BigDecimal value, String originUnit, String needConverTo) {
		return convertUnit(value, getUnitEnum(originUnit), getUnitEnum(needConverTo));
	}

	private static UnitEnum getUnitEnum(String originUnit) {
		if (null != originUnit && !originUnit.isEmpty()) {
			for (UnitEnum unitEnum : UnitEnum.values()) {
				if (originUnit.equals(unitEnum.getUnit())) {
					return unitEnum;
				}
			}
		}
		return UnitEnum.UN_KOWN;
	}

}
