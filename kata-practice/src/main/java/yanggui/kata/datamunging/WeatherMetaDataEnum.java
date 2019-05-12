package yanggui.kata.datamunging;

public enum WeatherMetaDataEnum {
	DAY("Dy", 3, 6), MAX_TEMPRATURE("MxT", 7, 10), MIN_TEMPRATURE("MnT", 11, 16);

	public String getWeatherFiled() {
		return weatherFiled;
	}

	public int getStartChar() {
		return startChar;
	}


	public int getEndChar() {
		return endChar;
	}

	private String weatherFiled;
	private int startChar;
	private int endChar;

	WeatherMetaDataEnum(String weatherFiled, int starChar, int endChar){
		this.weatherFiled=weatherFiled;
		this.startChar=starChar;
		this.endChar=endChar;
	}

}
