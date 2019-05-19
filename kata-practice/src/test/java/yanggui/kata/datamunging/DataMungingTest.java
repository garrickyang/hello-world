package yanggui.kata.datamunging;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DataMungingTest {
	@Test
	public void testReadFile() {
		String fileName = "weather.dat";
		String expected = "  Dy MxT   MnT   AvT   HDDay  AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP";
		String actual = Objects.requireNonNull(FileUtility.readFileToList(fileName)).get(0);
		assertEquals(expected, actual);
	}
	@Test 
	public void testFileNotExist() {
		String fileName = "notExist.dat";
		assertNull(FileUtility.readFileToList(fileName));
		
	}

	@Test
	public void testWeatherDataTrans() {
		Map<String, WeatherData> map;
		String fileName = "weather.dat";
		List<String> weatherDataList = FileUtility.readFileToList(fileName);
		DataMungingWeahterData dataMungingWeahterData= new DataMungingWeahterData();
		map=dataMungingWeahterData.formatWeatherData(weatherDataList);
		assertEquals(31, map.size());
	}
	@Test
	public void testWeatherDataTransWithEmptyData() {
		Map<String, WeatherData> map = new HashMap<>();
		String fileName = "weatherEmpty.dat";
		List<String> weatherDataList = FileUtility.readFileToList(fileName);
		DataMungingWeahterData dataMungingWeahterData= new DataMungingWeahterData();
		map=dataMungingWeahterData.formatWeatherData(weatherDataList);
		assertEquals(0, map.size());
	}

	@Test
	public void testParseOneLine() {
		String oneLineMetaData = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
		DataMungingWeahterData dataMungingWeahterData=new DataMungingWeahterData();
		WeatherData oneLineData = dataMungingWeahterData.parseOnelineToWeatherData(oneLineMetaData);
		assertEquals("1", oneLineData.getDay());
		assertEquals("88", oneLineData.getMaxTemperature());
		assertEquals("59", oneLineData.getMinTemperature());

	}

	@Test
	public void testFindSmallestSpreadinWeatherData() {
		String fileName = "weather.dat";
		DataMungingWeahterData dataMungingWeahterData=new DataMungingWeahterData();
		String dayString=dataMungingWeahterData.findSmallestSpreadWeatherDay(fileName);
		System.out.println("smalliestSrepadDay:"+dayString);
	}

	@Test
	public void testFindSmallestDifferenceData() {
		String fileName = "football.dat";
		DataMungingFootball dataMungingFootball = new DataMungingFootball();
		String teamName=dataMungingFootball.findSmallestDifferenceTeam(fileName);
		System.out.println("smalliestSrepadDay:"+teamName);

	}
}
