package repository;

import config.MysqlConfig;
import model.PlayerData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    public List<PlayerData> getTop5Player(){
        List<PlayerData> listPlayers = new ArrayList<>();
        Connection connection = MysqlConfig.getConnection();
        String query = "SELECT * FROM player ORDER BY playerCount ASC LIMIT 5";

        try {
            ResultSet resultSet = connection.prepareStatement(query).executeQuery();
            while (resultSet.next()){
                PlayerData playerData = new PlayerData();
                playerData.setPlayerName(resultSet.getString("playerName"));
                playerData.setPoint(resultSet.getInt("playerCount"));

                listPlayers.add(playerData);
            }
        }catch (Exception e){
            System.out.println("Loi cau query getAllRoles" + e.getMessage());
        }

        return listPlayers;
    }
    public int deleteOldData(){
        int isDeleted = 0;
        Connection connection = MysqlConfig.getConnection();
        String query = "DELETE FROM player";
        try {
            isDeleted = connection.prepareStatement(query).executeUpdate();
        }catch (Exception ex){
            System.out.println("Loi xoa data cu"+ex.getMessage());
        }
        return isDeleted;
    }

    public int addPlayer(String playerName, int playerCount){
        int isAddSuccess = 0;
        Connection connection = MysqlConfig.getConnection();
        String query = "INSERT INTO `db_gameDoanSo`.`player` (`playerName`, `playerCount`) VALUES (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,playerName);
            statement.setInt(2,playerCount);

            isAddSuccess = statement.executeUpdate();
        }catch (Exception e){
            System.out.println("Loi add player" + e.getMessage());
        }finally {
            try {
                connection.close();
            }catch (Exception e){

            }
        }
        return isAddSuccess;
    }
}
