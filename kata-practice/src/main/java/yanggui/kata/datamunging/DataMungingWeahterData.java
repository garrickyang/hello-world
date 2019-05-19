package yanggui.kata.datamunging;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataMungingWeahterData {

	public String findSmallestSpreadWeatherDay(String fileName) {
		List<String> weatherDataList = FileUtility.readFileToList(fileName);
		Map<String, WeatherData> map = formatWeatherData(weatherDataList);
		WeatherData smallestObject = findSmallestSpreadWeatherDay(map);
		return smallestObject.getDay();
	}

	 Map<String, WeatherData> formatWeatherData(List<String> weatherDataList) {
		Map<String, WeatherData> weatherDateMap = new HashMap<>();

		if (weatherDataList == null || weatherDataList.size() == 0) {
			return weatherDateMap;
		}

		WeatherData weatherData;
		for (int i = 2; i < weatherDataList.size(); i++) {
			weatherData = parseOnelineToWeatherData(weatherDataList.get(i));
			if (weatherData.getDay().isEmpty()) {
				continue;
			}
			weatherDateMap.put(weatherData.getDay(), weatherData);
		}
		return weatherDateMap;
	}

	WeatherData parseOnelineToWeatherData(String onelineData) {
		WeatherData weatherData = new WeatherData();
		weatherData.setDay(subSpecificString(onelineData, WeatherMetaDataEnum.DAY));
		weatherData.setMaxTemperature(subSpecificString(onelineData, WeatherMetaDataEnum.MAX_TEMPRATURE));
		weatherData.setMinTemperature(subSpecificString(onelineData, WeatherMetaDataEnum.MIN_TEMPRATURE));

		return weatherData;
	}

	private static String subSpecificString(String onelineData, WeatherMetaDataEnum metaEnum) {
		if (onelineData.length() < metaEnum.getEndChar()) {
			return "";
		}
		return onelineData.substring(metaEnum.getStartChar() - 1, metaEnum.getEndChar()).trim();
	}

	WeatherData findSmallestSpreadWeatherDay(Map<String, WeatherData> map) {
		WeatherData weatherDataWithSmallestSpread = null;
		WeatherData temp;
		for (Map.Entry<String, WeatherData> entry : map.entrySet()) {
			temp = entry.getValue();
			if (null == weatherDataWithSmallestSpread) {
				weatherDataWithSmallestSpread = temp;
				continue;
			}
			if (weatherDataWithSmallestSpread.compareSpread(temp) == 1) {
				weatherDataWithSmallestSpread = temp;
			}
		}

		return weatherDataWithSmallestSpread;
	}
}
