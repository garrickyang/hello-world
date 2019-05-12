package yanggui.kata.suppermarket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceStrategyService {
	private static PriceStrategyService priceStrategyService;

	static {
		priceStrategyService = new PriceStrategyService();
	}

	private static Map<String, PriceStrategy> strategyMap;
	public final static String THREE_FOR_DOLLAR ="THREE_FOR_DOLLAR";
	public final static String BUY_2_GIVEN_1 = "BUY_2_GIVEN_1";
	private PriceStrategyService(){
		init();
	}
	
	private void init() {
		strategyMap = new HashMap<>();
		
		PriceStrategy priceStrategyObject = new PriceStrategy(THREE_FOR_DOLLAR, 3, new BigDecimal("1"));
		PriceStrategy buyAndGivenStrategyObject = new BuyAndGiveStrategy(BUY_2_GIVEN_1, 2, null, 1);
		
		strategyMap.put(priceStrategyObject.getStrategyName(), priceStrategyObject);
		strategyMap.put(buyAndGivenStrategyObject.getStrategyName(), buyAndGivenStrategyObject);
		
			
		
	}

	public static PriceStrategyService getInstance(){
		
		return priceStrategyService;
	}

	public PriceStrategy getPriceStragety(String priceStrategy) {
		
		return strategyMap.get(priceStrategy);
	}

	
			

}
