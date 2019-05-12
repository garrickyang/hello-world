package yanggui.kata.datamunging;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DataMungingTest {
	@Test
	public void testReadFile() {
		String fileName = "weather.dat";
		String expected = "  Dy MxT   MnT   AvT   HDDay  AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP";
		String actual = FileUtility.readFileToList(fileName).get(0);
		assertEquals(expected, actual);
	}
	@Test 
	public void testFileNotExist() {
		String fileName = "notExist.dat";
		assertNull(FileUtility.readFileToList(fileName));
		
	}

	@Test
	public void testWeatherDataTrans() {
		Map<String, WeatherData> map = new HashMap<>();
		String fileName = "weather.dat";
		List<String> weatherDataList = FileUtility.readFileToList(fileName);
		map=DataMunging.formatWeatherData(weatherDataList);
		assertEquals(31, map.size());
	}
	@Test
	public void testWeatherDataTransWithEmptyData() {
		Map<String, WeatherData> map = new HashMap<>();
		String fileName = "weatherEmpty.dat";
		List<String> weatherDataList = FileUtility.readFileToList(fileName);
		map=DataMunging.formatWeatherData(weatherDataList);
		assertEquals(0, map.size());
	}

	@Test
	public void testParseOneLine() {
		String oneLineMetaData = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
		WeatherData oneLineData = DataMunging.parseOnelineToWeatherData(oneLineMetaData);
		assertEquals("1", oneLineData.getDay());
		assertEquals("88", oneLineData.getMaxTemprature());
		assertEquals("59", oneLineData.getMinTemprature());

	}

	@Test
	public void testFindSmallestSpreadinWeatherData() {
		String fileName = "weather.dat";
		String dayString=DataMunging.findSmallestSpreadWeatherDay(fileName);
		System.out.println("smallliestSrepadDay:"+dayString);
	}
	@Test
	public void testPatternMatch(){
		String DATE_STRING = "90";
		String P_COMM = "(\\d+).*";

		Pattern pattern = Pattern.compile(P_COMM);
		java.util.regex.Matcher matcher = pattern.matcher(DATE_STRING);
		matcher.find();//必须要有这句
		System.out.printf("\nmatcher.group(0) value:%s", matcher.group(0));
		System.out.printf("\nmatcher.group(1) value:%s", matcher.group(1));
		System.out.printf("\nmatcher.group(1) value:%s", matcher.group(2));

	}

}
