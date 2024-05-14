package tyss.scenarioDsa.IPLQuestion;

import java.util.List;

public class Team {
	private String teamName;
	private int points;
	private List<String> lastFiveMatches;
	
	public Team(String teamName,int points,List<String> lastFiveMatches)
	{
		this.teamName=teamName;
		this.points=points;
		this.lastFiveMatches=lastFiveMatches;
	}
	
	// getters //
	
	public String getTeamName()
	{
		return teamName;
	}
	public int getPoints()
	{
		return points;
	}
	public List<String> getLastFiveMatches()
	{
		return lastFiveMatches;
	}
	
	// Overriding toString() method //
	public String toString()
	{
		return "Team Name: "+this.getTeamName()+"\n"+"Team Points: "+this.getPoints()+"\n"+"Last 5 Matches: "+this.getLastFiveMatches()+"\n"+"\n"+"--------------------------------------------------"+"\n";
				
	}
	
	public boolean teamHavingConsecutiveLosses(int consecutiveLosses)
	{
		int losses=0;
		for(String result: getLastFiveMatches())
		{
			if(result.equals("Lost"))
			{
				losses++;
				
				if(losses==consecutiveLosses)
				{
					return true;
				}	
			}
			else
			{
				losses=0; // making the counter 0 if it does not have any cons losse
			}
			
		}
		return false;
	}
}
