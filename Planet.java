package tyss.planetaryQuestion.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Planet {
	private String planetName;
	private List<String> gasses;
	private int moons;
	private String rings;
	
	static int moonCount=0;
	
	public Planet(String planetName,List<String> gasses,int moons,String rings)
	{
		this.planetName=planetName;
		this.gasses=gasses;
		this.moons=moons;
		this.rings=rings;
	}
	
	
	public String getPlanetName() {
		return planetName;
	}


	public List<String> getGasses() {
		return gasses;
	}


	public int getMoons() {
		return moons;
	}


	public String getRings() {
		return rings;
	}
	
	// Overriding toString() method //
		public String toString()
		{
			return "Planet Name: "+this.getPlanetName()+"\n"+"Planet's Atmosphere Gasses: "+this.getGasses()+"\n"+"Planet's Moon: "+this.getMoons()+"\n"+"Does Planet Contains Ring ? : "+this.getRings()+"\n"+"--------------------------------------------------"+"\n";
					
		}


	public static void main(String[] args) {
		List<Planet> planetsDetails=new ArrayList<>();
		planetsDetails.add(new Planet("Mercury",null,0,"No"));
		planetsDetails.add(new Planet("Venus",List.of("Carbon Dioxide","Nitrogen"),0,"No"));
		planetsDetails.add(new Planet("Earth",List.of("Nitrogen","Oxygen"),1,"No"));
		planetsDetails.add(new Planet("Jupiter",List.of("Hydrogen","Helium"),79,"Yes"));
		planetsDetails.add(new Planet("Saturn",List.of("Hydrogen","Helium"),83,"Yes"));
		planetsDetails.add(new Planet("Uranus",List.of("Hydrogen","Helium","Methane"),27,"Yes"));
		
		Scanner sc = new Scanner(System.in);
		boolean exit = true;
		while (exit) {
			System.out.println(
					"Enter Your Options:\n1.Planetary Details\n2.Total Moons Of All Planets Having Rings\n3.Multiple Gassess Composition Found On Planets"
							+ "\n4.Exit");
			int options = sc.nextInt();
			switch (options) {
			case 1: {
				planetsDetails.forEach(System.out::print);
			}
				break;

			case 2: {
				countOfMoons(planetsDetails);
			}
				break;

			case 3: {
				maxGasFoundInPlanets(planetsDetails);
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
	
	// LOGIC FOR RETREVING COUNT OF MOONS HAVING RINGS //
	public static void countOfMoons(List<Planet> planetDetails)
	{
		
		planetDetails.forEach(itt->
		{
			if(itt.getRings().equals("Yes"))
			{
				moonCount=moonCount+itt.getMoons();
			}
		});
		
		System.out.println("Total Number Of Moons Having Rings: "+moonCount);
	}
	
	public static void maxGasFoundInPlanets(List<Planet> planetDetails)
    {
        Map<String, Integer> gasCountMap = new HashMap<>();
        
       
        for (Planet planet : planetDetails) {
            List<String> gases = planet.getGasses();
            if (gases != null) {
                for (String gas : gases) {
                    gasCountMap.put(gas, gasCountMap.getOrDefault(gas, 0) + 1);
                }
            }
        }
        
        int maxCount = 0;
        String maxGas = null;
        for (Map.Entry<String, Integer> entry : gasCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxGas = entry.getKey();
            }
        }
        
        System.out.println("Gas found on maximum planets: " + maxGas);
    }
	
}
