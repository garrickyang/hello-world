package yanggui.kata.datamunging;


public class FootballMatch {
	
	private String teamName;
	private int forScore;
	private int AgainstScore;
	
	public int getForScore() {
		return forScore;
	}

	public void setForScore(int forScore) {
		this.forScore = forScore;
	}

	public int getAgainstScore() {
		return AgainstScore;
	}

	public void setAgainstScore(int againstScore) {
		AgainstScore = againstScore;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}



	public String getTeamName() {
		
		return teamName;
	}
	
	public int compareSmallestDifferenceBetweenForAndAgianst(FootballMatch input) {
		int difference, differenceCompare;
		difference = calculateScoreDifference(this);
		differenceCompare = calculateScoreDifference(input);

		return Integer.compare(difference, differenceCompare);
	}

	private int calculateScoreDifference(FootballMatch input) {	
		
		return Math.abs(input.getAgainstScore() - input.getForScore());
	}


}
