package service;

import model.PlayerData;
import repository.PlayerRepository;

import java.util.List;

public class GameService {
    public List<PlayerData> getTop5Players(){
        PlayerRepository playerRepository = new PlayerRepository();
        return playerRepository.getTop5Player();
    }
    public int deleteOldData(){
        PlayerRepository playerRepository = new PlayerRepository();
        return playerRepository.deleteOldData();
    }

    public int addPlayer(String playerName, int playerCount){
        PlayerRepository playerRepository = new PlayerRepository();
        return playerRepository.addPlayer(playerName,playerCount);
    }
}
