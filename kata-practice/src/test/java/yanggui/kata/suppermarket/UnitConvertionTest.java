package yanggui.kata.suppermarket;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitConvertionTest {



	@Test
	public void convert16OunceToPoundEnumUnit() {
		BigDecimal value = new BigDecimal("16");
		UnitEnum originUnit = UnitEnum.WEIGHT_OUNCE;
		UnitEnum needConverTo=UnitEnum.WEIGHT_POUND;
		assertEquals(new BigDecimal("1").setScale(2, BigDecimal.ROUND_HALF_UP), UnitConvertion.convertUnit(value, originUnit,needConverTo));
	}
	
	@Test
	public void convert4OunceToPoundWithEnumUnit() {
		BigDecimal value = new BigDecimal("4");
		UnitEnum originUnit = UnitEnum.WEIGHT_OUNCE;
		UnitEnum needConverTo=UnitEnum.WEIGHT_POUND;
		assertEquals(new BigDecimal("0.25").setScale(2, BigDecimal.ROUND_HALF_UP), UnitConvertion.convertUnit(value, originUnit,needConverTo));
	}
	
	@Test
	public void convert4OunceToPoundWithStringUnit() {
		BigDecimal value = new BigDecimal("4");
		String originUnit = "oz";
		String needConverTo="lb";
		assertEquals(new BigDecimal("0.25").setScale(2, BigDecimal.ROUND_HALF_UP), UnitConvertion.convertUnit(value, originUnit,needConverTo));
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void unKnownUnitConvert() {
		BigDecimal value = new BigDecimal("4");
		String originUnit = "oz";
		String needConverTo="ab";
		UnitConvertion.convertUnit(value, originUnit,needConverTo);
	}

}
