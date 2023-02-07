package service;

import model.PlayerData;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    public List<PlayerData> top5Player = new ArrayList<>();
    public List<PlayerData> getTop5Player(){
        if(top5Player.size()>5){
            for(PlayerData playerData : top5Player){
                if(playerData.getPoint() ==  findMaxCount(top5Player)){
                    top5Player.remove(playerData);
                }
            }
        }else{

        }
        return top5Player;
    }

    private int findMaxCount(List<PlayerData> top5Player) {
        int maxCount = 0;
        for(PlayerData playerData : top5Player){
            if(playerData.getPoint() > maxCount){
                maxCount = playerData.getPoint();
            }
        }
        return maxCount
    }

    public PlayerData saveGame(String name, int countPoint) {
        PlayerData savePlayer = new PlayerData();
        savePlayer.setPlayerName(name);
        savePlayer.setPoint(countPoint);
        return savePlayer;
    }
}
