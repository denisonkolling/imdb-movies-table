package data;
import logic.Genre;
import logic.Show;
import logic.ShowType;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.exit;

public class Database {
    public static Connection connection = null;

    private static String CONN_STRING = "jdbc:postgresql://localhost:5432/IMDB";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "102030";
    private static String GET_ALL_GENRES_SQL = "SELECT DISTINCT genres FROM tab_basics";
    private static String GET_ALL_TYPES_SQL = "SELECT DISTINCT titleType FROM tab_basics";

    private static String FIND_SHOWS_SQL = "SELECT primarytitle, startyear, averagerating, numvotes\n" +
            "FROM tab_basics\n" +
            "INNER JOIN tab_ratings\n" +
            "ON tab_basics.tconst = tab_ratings.tconst\n" +
            "WHERE startYear = '2000' and averagerating > 8 and numvotes > 50000 and titletype = 'movie'\n";

    public static void connect(){
        if (connection != null) {
            return;
        }else{
            try { connection = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            } catch (SQLException e){
                e.printStackTrace();
                exit(-1);
            }
        }
    }

    public static ArrayList<Genre> getAllGenres() {
        connect();
        ArrayList<Genre> genres = new ArrayList<Genre>();

        try{
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_GENRES_SQL);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                genres.add(new Genre(rs.getString("genres")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return genres;
    }

    public static ArrayList<ShowType> getAllShowTypes(){
        connect();
        ArrayList<ShowType> types = new ArrayList<ShowType>();

        try{
            PreparedStatement stmt = connection.prepareStatement(GET_ALL_TYPES_SQL);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                types.add(new ShowType(rs.getString("titleType")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return types;

    }


    public static ArrayList<Show> findShows(Integer minShows, String titleType, String genre){
        connect();
        ArrayList<Show> shows = new ArrayList<Show>();

        try{
            PreparedStatement stmt = connection.prepareStatement(FIND_SHOWS_SQL);
            stmt.setInt(1, minShows);
            stmt.setString(2, titleType);
            stmt.setString(3, genre);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                shows.add(new Show(
                        rs.getString("primaryTitle"),
                        rs.getInt("startYear"),
                        rs.getFloat("averageRating"),
                        rs.getInt("numVotes")
                ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return shows;
    }

}