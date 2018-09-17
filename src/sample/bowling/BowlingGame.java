package sample.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    final private int _maxFrames = 10;
    private List<BowlingPlayer> _bowlingPlayers;

    public BowlingGame(List<BowlingPlayer> bowlingPlayers){
        _bowlingPlayers = bowlingPlayers;

    }

    /**
     * @return the current round all players are on
     */
    public int getCurrentRound(){
        return 0;
    }

    /**
     *
     * @return all bowlingplayers in game
     */
    public List<BowlingPlayer> getAllPlayers(){
        return _bowlingPlayers;
    }

    /**
     * @return The player who'se turn it is to throw in his frame
     */
    public BowlingPlayer getCurrentPlayer(){

        int lowestFrames = 999;

        for (BowlingPlayer player : _bowlingPlayers){
            int currenPlayerFrames = player.getCompletedFrames();

            if (currenPlayerFrames < lowestFrames) lowestFrames = currenPlayerFrames;
        }

        for (BowlingPlayer player : _bowlingPlayers){
            if (player.getCompletedFrames() == lowestFrames){
                return player;
            }
        }

        System.out.println("Something went terriibly wrong @ getCurrentPlayer");
        return _bowlingPlayers.get(0);
    }


}
