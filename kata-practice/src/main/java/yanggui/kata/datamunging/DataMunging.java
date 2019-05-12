package yanggui.kata.datamunging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataMunging {
	
	public static String findSmallestSpreadWeatherDay(String fileName) {
		Map<String, WeatherData> map = new HashMap<>();
		List<String> weatherDataList = FileUtility.readFileToList(fileName);
		map = DataMunging.formatWeatherData(weatherDataList);
		WeatherData smallestObject = findSmallestSpreadWeatherDay(map);
		return smallestObject.getDay();
	}

	public static Map<String, WeatherData> formatWeatherData(List<String> weatherDataList) {
		Map<String, WeatherData> weatheDateMap = new HashMap<>();

		if (weatherDataList == null || weatherDataList.size() == 0) {
			return weatheDateMap;
		}

		WeatherData weatherData;
		for (int i = 2; i < weatherDataList.size(); i++) {
			weatherData = parseOnelineToWeatherData(weatherDataList.get(i));
			if (weatherData.getDay().isEmpty()) {
				continue;
			}
			weatheDateMap.put(weatherData.getDay(), weatherData);
		}
		return weatheDateMap;
	}

	public static WeatherData parseOnelineToWeatherData(String onelineData) {
		WeatherData weatherData = new WeatherData();
		weatherData.setDay(subSpecificString(onelineData, WeatherMetaDataEnum.DAY));
		weatherData.setMaxTemprature(subSpecificString(onelineData, WeatherMetaDataEnum.MAX_TEMPRATURE));
		weatherData.setMinTemprature(subSpecificString(onelineData, WeatherMetaDataEnum.MIN_TEMPRATURE));

		return weatherData;
	}

	private static String subSpecificString(String onelineData, WeatherMetaDataEnum metaEnum) {
		if (onelineData.length() < metaEnum.getEndChar()) {
			return "";
		}
		return onelineData.substring(metaEnum.getStartChar() - 1, metaEnum.getEndChar()).trim();
	}

	private static WeatherData findSmallestSpreadWeatherDay(Map<String, WeatherData> map) {
		WeatherData weatherDataWithSmalllestSpread = null, temp;
		for (Map.Entry<String, WeatherData> entry : map.entrySet()) {
			temp = entry.getValue();
			if (weatherDataWithSmalllestSpread == null) {
				weatherDataWithSmalllestSpread = temp;
				continue;
			}
			if (weatherDataWithSmalllestSpread.compareSpread(temp) == 1) {
				weatherDataWithSmalllestSpread = temp;
			}
		}

		return weatherDataWithSmalllestSpread;
	}
}
