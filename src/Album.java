//PA03 Binary Search Tree
//IST 311
//By Ritvik Kumar Kothapalli

import java.util.List;

public class Album implements Comparable<Album> {
    private int id;
    private List<String> artists;
    private String title;
    private int numSongs;

    public Album(int id, List<String> artists, String title, int numSongs) {
        this.id = id;
        this.artists = artists;
        this.title = title;
        this.numSongs = numSongs;
    }

    //Added Overrides
    @Override
    public int compareTo(Album o) {
        return Integer.compare(this.numSongs, o.numSongs);
    }

    @Override
    public String toString() {
        return "ID: " + id + " NUM_SONGS: " + numSongs + " -- " + artists.toString();
    }

    // Adding Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumSongs() {
        return numSongs;
    }

    public void setNumSongs(int numSongs) {
        this.numSongs = numSongs;
    }
}

//END