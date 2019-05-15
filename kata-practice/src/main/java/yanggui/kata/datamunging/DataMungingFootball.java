package yanggui.kata.datamunging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DataMungingFootball {

	public String findSmallestDifferenceTeam(String fileName) {
		List<String> footballRecords = FileUtility.readFileToList(fileName);
		List<FootballMatch> footballMatchData = formatFootballData(footballRecords);
		FootballMatch footballMatch = findSmallestDifferenceTeam(footballMatchData);
		return footballMatch.getTeamName();
	}

	public FootballMatch findSmallestDifferenceTeam(List<FootballMatch> footballMatchDataList) {
		FootballMatch footballMatch = footballMatchDataList.get(0);
		for(int i=1;i<footballMatchDataList.size();i++){
			int compareResult=footballMatch.compareSmallestDifferenceBetweenForAndAgianst(footballMatchDataList.get(i));
			if(compareResult==1){
				footballMatch=footballMatchDataList.get(i);
			}
		}
		return footballMatch;
	}

	private List<FootballMatch> formatFootballData(List<String> footballRecords) {
		List<FootballMatch> footBallMatchRecordList = new ArrayList<>();
		if (null == footballRecords || footballRecords.isEmpty()) {
			return null;
		}
		FootballMatch footballMatch;
		for (int i = 0; i < footballRecords.size(); i++) {

			footballMatch = parserData(footballRecords.get(i));
			if(null!=footballMatch){
				footBallMatchRecordList.add( footballMatch);
			}
		}
		return footBallMatchRecordList;
	}

	private FootballMatch parserData(String input) {
		
		String teamName = "";
		String forScore;
		String againstScore;
		String teamNumberString;
		teamNumberString= input.substring(0, 5).trim();
		teamName = input.substring(7, 22).trim();
		forScore = input.substring(43, 47).trim();
		againstScore = input.substring(50, 56).trim();
		if(validateData(teamNumberString)&&validateData(forScore)&&validateData(againstScore)){
			FootballMatch footballMatch = new FootballMatch();
			footballMatch.setForScore(Integer.parseInt(forScore));
			footballMatch.setAgainstScore(Integer.parseInt(againstScore));
			footballMatch.setTeamName(teamName);
			return footballMatch;
		}
	
		return null;
	}

	private boolean validateData(String input) {
		
		String number = "^\\d+$";
		Pattern pattern = Pattern.compile(number);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
}
