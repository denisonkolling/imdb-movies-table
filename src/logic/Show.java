package logic;

import data.Database;

import java.util.ArrayList;

public class Show {
    private String primaryTitle;
    private Integer startYear;
    private Float averageRating;
    private Integer numVotes;

    public Show(String primaryTitle, Integer startYear, Float averageRating, Integer numVotes) {
        this.primaryTitle = primaryTitle;
        this.startYear = startYear;
        this.averageRating = averageRating;
        this.numVotes = numVotes;
    }

    public static ArrayList<Show> findShows(Integer minShows, String titleType, String genre){
        return Database.findShows(minShows, titleType, genre);
    }

    public String getPrimaryTitle() {
        return primaryTitle;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public Integer getNumVotes() {
        return numVotes;
    }
}
