package tyss.scenarioDsa.IPLQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IPLDriver {
	static List<Team> teams = new ArrayList<>();
	static List<String> teamsWithConsecutiveLosses = new ArrayList<>();

	// LOGIC FOR CONSECUTIVE LOSSESS //
	public void teamsWithConsecutiveLossess() {
		// retreiveing team with consecutive lossess //

		int consecutiveLosses = 2;

		for (Team teamName : teams) {
			if (teamName.teamHavingConsecutiveLosses(consecutiveLosses)) {
				teamsWithConsecutiveLosses.add(teamName.getTeamName());
			}
		}

		System.out.println("Teams Having Consecutive Losses: ");
		for (String teamNames : teamsWithConsecutiveLosses) {
			System.out.println(teamNames);
		}
	}

	// LOGIC FOR AVERAGE POINTS //
	public void averagePoints() {
		int totalPoints = 0;
		int numOfTeams = 0;
		for (Team team : teams) {
			if (teamsWithConsecutiveLosses.contains(team.getTeamName())) {
				totalPoints = totalPoints + team.getPoints();
				numOfTeams++;
			}
		}

		double avg = (double) totalPoints / numOfTeams;
		System.out.println("Average points Of the teams having consecutive losses: " + avg);
	}

	public static void main(String[] args) {

		teams.add(new Team("GT", 20, List.of("Win", "Win", "Lost", "Lost", "Win")));
		teams.add(new Team("LSG", 18, List.of("Win", "Lost", "Lost", "Win", "Win")));
		teams.add(new Team("RR", 16, List.of("Win", "Lost", "Win", "Lost", "Lost")));
		teams.add(new Team("DC", 14, List.of("Win", "Win", "Lost", "Win", "Lost")));
		teams.add(new Team("RCB", 14, List.of("Lost", "Win", "Win", "Lost", "Lost")));
		teams.add(new Team("KKR", 12, List.of("Lost", "Win", "Win", "Lost", "Win")));
		teams.add(new Team("PBKS", 12, List.of("Lost", "Win", "Lost", "Win", "Lost")));
		teams.add(new Team("CSK", 8, List.of("Lost", "Lost", "Win", "Lost", "Win")));
		teams.add(new Team("MI", 6, List.of("Lost", "Win", "Lost", "Win", "Win")));
		teams.add(new Team("SRH", 12, List.of("Win", "Lost", "Lost", "Lost", "Lost")));

		Scanner sc = new Scanner(System.in);
		IPLDriver iplDriver = new IPLDriver();
		boolean exit = true;
		while (exit) {
			System.out.println(
					"Enter Your Options:\n1.List Of Performance\n2.Get Consecutive Losses\n3.Get Average Points"
							+ "\n4.Exit");
			int options = sc.nextInt();
			switch (options) {
			case 1: {
				teams.forEach(System.out::print);
			}
				break;

			case 2: {
				iplDriver.teamsWithConsecutiveLossess();
			}
				break;

			case 3: {
				iplDriver.averagePoints();
			}
				break;
			case 4: {
				exit = false;
				System.out.println("Thank You");
			}
				break;

			default: {
				System.out.println("Invalid Options");
			}
			}
		}
	}
}
