package yanggui.kata.datamunging;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class FileUtility {

	public static List<String> readFileToList(String fileName) {
		
		URL fileURL = FileUtility.class.getClassLoader().getResource(fileName);
		if(fileURL==null){
			return null;
		}
		String filePath = fileURL.getPath();
		FileReader fileReader;
		BufferedReader bufferedReader = null;
		ArrayList<String> fileContentList = new ArrayList<>();
		try {
			fileReader = new FileReader(new File(filePath));
			bufferedReader = new BufferedReader(fileReader);
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				fileContentList.add(line);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {

				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return fileContentList;
	}

}
