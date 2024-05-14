package tyss.scenarioDsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SongStoreUsingArrays {
	private int capacity;
	private Map<String, String[]> recentlyPlayed;
	
	public SongStoreUsingArrays(int capacity) {
		this.capacity=capacity;
		this.recentlyPlayed=new HashMap<>();
	}
	
	public void playSong(String user,String song)
	{
		if(!recentlyPlayed.containsKey(user))
		{
			recentlyPlayed.put(user, new String[capacity]);
		}
		
		String songs[]=recentlyPlayed.get(user);
		
		for(int i=0;i<capacity-1;i++)
		{
			songs[i]=songs[i+1];
		}
		
		songs[capacity-1]=song;
	}
	
	public String[] getRecentlyPlayedSongs(String user)
	{
		return recentlyPlayed.getOrDefault(user,new String[0]);
	}
	
	public static void main(String[] args) {
		SongStoreUsingArrays store=new SongStoreUsingArrays(3);
		store.playSong("varun","Tum Hi Ho");
		store.playSong("varun", "Radio Active");
		store.playSong("varun", "Kannoonjal");
		
		
		
		
		System.out.println(Arrays.toString(store.getRecentlyPlayedSongs("varun")));
		
		store.playSong("varun", "One Love");
		System.out.println(Arrays.toString(store.getRecentlyPlayedSongs("varun")));
		
		store.playSong("varun", "Tum Hi Ho");
		System.out.println(Arrays.toString(store.getRecentlyPlayedSongs("varun")));
		
		store.playSong("varun", "Kannoonjal");
		System.out.println(Arrays.toString(store.getRecentlyPlayedSongs("varun")));
	}
}
