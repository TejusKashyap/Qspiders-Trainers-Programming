package tyss.scenarioDsa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SongStore {
	
	private int capacity;
	private Map<String, LinkedList<String>> recentlyPlayed;
	
	SongStore(int capacity)
	{
		this.capacity=capacity;
		recentlyPlayed=new HashMap<>();
	}
	
	public void playSongs(String user, String song)
	{
		LinkedList<String> songs=recentlyPlayed.getOrDefault(user, new LinkedList<>());
		songs.remove(song);
		
		if(songs.size()>=capacity)
		{
			songs.removeFirst();
		}
		songs.addLast(song);
		recentlyPlayed.put(user, songs);
	}
	
	public List<String> getRecentlyPlayed(String user)
	{
		return recentlyPlayed.getOrDefault(user, new LinkedList<String>());
	}
	
	public static void main(String[] args) {
		SongStore store=new SongStore(3);
		
		store.playSongs("varun", "Tum Hi Ho");
		store.playSongs("varun", "Radio Active");
		store.playSongs("varun", "Kannoonjal");
		
		System.out.println(store.getRecentlyPlayed("varun"));
		
		store.playSongs("varun", "One Love");
		System.out.println(store.getRecentlyPlayed("varun"));
		
		store.playSongs("varun", "Tum Hi Ho");
		System.out.println(store.getRecentlyPlayed("varun"));
		
		store.playSongs("varun", "Kannoonjal");
		System.out.println(store.getRecentlyPlayed("varun"));
	}
	
}
