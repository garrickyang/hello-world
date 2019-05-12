package yanggui.kata.datamunging;

import java.util.regex.Pattern;

public class WeatherData implements Comparable<WeatherData> {
	private String day;
	private String MaxTemperature;
	private String MinTemperature;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMaxTemperature() {
		return MaxTemperature;
	}

	public void setMaxTemperature(String maxTemperature) {
		MaxTemperature = maxTemperature;
	}

	public String getMinTemperature() {
		return MinTemperature;
	}

	public void setMinTemperature(String mixTemprature) {
		MinTemperature = mixTemprature;
	}

	@Override
	public int compareTo(WeatherData o) {

		return compareSpread(o);
	}

	public int compareSpread(WeatherData input) {
		int spread1, spread2;
		spread1 = calculateSpread(this);
		spread2 = calculateSpread(input);

		return Integer.compare(spread1, spread2);
	}

	private int calculateSpread(WeatherData weatherDataWithSmallestSpread) {
		
		int high = 0;
		int low = 0;
		try {
			high = Integer.parseInt(preProcessData(weatherDataWithSmallestSpread.getMaxTemperature()));
			low = Integer.parseInt(preProcessData(weatherDataWithSmallestSpread.getMinTemperature()));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return high - low;
	}

	private String preProcessData(String input) {
		String P_COMM = "(\\d+).*";
		Pattern pattern = Pattern.compile(P_COMM);
		java.util.regex.Matcher matcher = pattern.matcher(input);
		if (matcher.matches()) {
			return matcher.group(1);
		}
		System.out.println("what?" + input);
		return "0";

	}

}
