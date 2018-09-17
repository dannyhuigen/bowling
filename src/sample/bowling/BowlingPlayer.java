package sample.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingPlayer {

    private String _name;
    private List<BowlingFrame> _bowlingFrames;

    public BowlingPlayer(String playerName){
        _name = playerName;
        _bowlingFrames = new ArrayList<BowlingFrame>();
    }

    /**
     * @return name of player
     */
    public String getName(){
        return _name;
    }

    /**
     *
     * @return current points of player
     */
    public int getPoints(){
        for (BowlingFrame frame : _bowlingFrames){

        }
    }

    public List<BowlingFrame> getAllBowlingFrames(){
        return _bowlingFrames;
    }

    /**
     * @return the amount of completed frames
     */
    public int getCompletedFrames(){
        int amountOfFrames = 0;
        for (BowlingFrame frame : _bowlingFrames){
            if (!frame.allowedToThrow()){
                amountOfFrames++;
            }
        }
        return amountOfFrames;
    }

    /**
     * @return the last frame of the player and if there is no frame where the player is allowed to play create new frame
     */
    public BowlingFrame getLastFrame(){

        //If a new frame has to be added add new frame
        if (_bowlingFrames.size() == 0 || !_bowlingFrames.get(_bowlingFrames.size() - 1).allowedToThrow()){
            _bowlingFrames.add(new BowlingFrame());
        }

        return _bowlingFrames.get(_bowlingFrames.size() - 1);
    }
}
