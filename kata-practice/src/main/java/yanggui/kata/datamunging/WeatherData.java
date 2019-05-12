package yanggui.kata.datamunging;

import java.util.regex.Pattern;

public class WeatherData implements Comparable<WeatherData> {
	private String day;
	private String MaxTemprature;
	private String MinTemprature;

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMaxTemprature() {
		return MaxTemprature;
	}

	public void setMaxTemprature(String maxTemprature) {
		MaxTemprature = maxTemprature;
	}

	public String getMinTemprature() {
		return MinTemprature;
	}

	public void setMinTemprature(String mixTemprature) {
		MinTemprature = mixTemprature;
	}

	@Override
	public int compareTo(WeatherData o) {

		return compareSpread(o);
	}

	public int compareSpread(WeatherData input) {
		int spread1, spread2;
		spread1 = calculateSpread(this);
		spread2 = calculateSpread(input);
		
		if (spread1 > spread2) {
			return 1;
		}
		if (spread1 < spread2) {
			return -1;
		}
		return 0;
	}

	private int calculateSpread(WeatherData weatherDataWithSmalllestSpread) {
		
		int high = 0;
		int low = 0;
		try {
			high = Integer.parseInt(preProcessData(weatherDataWithSmalllestSpread.getMaxTemprature()));
			low = Integer.parseInt(preProcessData(weatherDataWithSmalllestSpread.getMinTemprature()));
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
