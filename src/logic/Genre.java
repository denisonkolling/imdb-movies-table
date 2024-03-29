package logic;

import data.Database;

import java.util.ArrayList;

public class Genre {

    private String name;

    public static final String ALL_GENRES = "-- All Genres --";

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Genre> getAllGenres(){
        return Database.getAllGenres();
    }
}
