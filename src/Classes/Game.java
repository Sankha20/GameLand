package Classes;

import General.Connector;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Game {

    String id;
    String name;
    BigDecimal price;
    String amount;
    String genre;
    String date;

    public Game(String id, String name, BigDecimal price, String amount, String genre, String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.genre = genre;
        this.date = date;
    }
    
    public static ArrayList<Game> selectGames() {
        return selectGames("", "");
    }

    public static ArrayList<Game> selectGames(String filter, String condition) {
        ArrayList<Game> games = new ArrayList<>();
        ResultSet resultSet;
        
        String query = String.format("SELECT * FROM games ");
        
        switch(filter) {
            case "name":
                query += String.format("WHERE game_name LIKE \"%%%s%%\"", condition);
                break;
            default:
                query += ";";
        }
        
        System.out.println("SELECT_GAMES: " + query);


        try {

            Connection connection = Connector.createConnection();
            Statement statement;
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // game_id, game_name, game_price, game_amount, game_genre, game_release
                
                String id = resultSet.getString("game_id");
                String name = resultSet.getString("game_name");
                String price = resultSet.getString("game_price");
                String amount = resultSet.getString("game_amount");
                String genre = resultSet.getString("game_genre");
                String date = resultSet.getString("game_release");

                BigDecimal intPrice = new BigDecimal(price);

                Game g = new Game(id, name, intPrice, amount, genre, date);
                games.add(g);
            }

            statement.close();
            connection.close();
            resultSet.close();

        } catch (SQLException e) {
            System.err.println("Job > SelectAllFromDatabase > SQLException");
            System.err.println(e);
        } catch (Exception e) {
            System.err.println("Job > SelectAllFromDatabase > Exception");
            System.err.println(e);
        }

        return games;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
