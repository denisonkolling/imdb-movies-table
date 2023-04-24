package logic;

import data.Database;

import java.util.ArrayList;

public class ShowType {

    private String name;

    public ShowType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<ShowType> getAllShowTypes(){
        return Database.getAllShowTypes();
    }
}
