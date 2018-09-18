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
     * @return all bowling frames of player
     */
    public List<BowlingFrame> getAllBowlingFrames(){
        return _bowlingFrames;
    }

    /**
     *  Adds points to last frame of player
     *  Also handles bonus points if previous frame is a strike or spare
     *
     * @param pins amount of pins the player has thrown5
     */
    public void addPointsToLastFrame(int pins){
        BowlingFrame currentFrame = getLastFrame();
        BowlingFrame secondLastFrame = getSecondLastFrame();

        if (secondLastFrame != null){
            //if there is a previous frame, there is no previous frame if its the players first throw
            BowlingFrame.scoreKind secondFrameScoreKind = secondLastFrame.getScoreKind();

            if (secondFrameScoreKind == BowlingFrame.scoreKind.STRIKE){
                //if previous frame was a strike
                currentFrame.addThrow(pins);
                currentFrame.addBonusPoints(pins);
            }
            else if (secondFrameScoreKind == BowlingFrame.scoreKind.SPARE){
                //if previous frame was a spare
                if (currentFrame.getAmountOfThrows() == 0){
                    //if player's current throw is first throw in this frame
                    currentFrame.addThrow(pins);
                    currentFrame.addBonusPoints(pins);
                }
                else{
                    //if player's current throw is the second throw in current frame
                    currentFrame.addThrow(pins);
                }
            }
            else if (secondFrameScoreKind == BowlingFrame.scoreKind.NORMAL){
                //if previous frame was neither a strike or spare so its a normal
                currentFrame.addThrow(pins);
            }
        }
        else{
            //this is the first frame of the player
            currentFrame.addThrow(pins);
        }
    }

    /**
     * @return the last frame of the player and if there is no frame where the player is allowed to play create new frame
     */
    public BowlingFrame getLastFrame(){
        if (_bowlingFrames.size() == 0 || !_bowlingFrames.get(_bowlingFrames.size() - 1).allowedToThrow()){
            //If a new frame has to be added add new frame
            _bowlingFrames.add(new BowlingFrame());
        }

        return _bowlingFrames.get(_bowlingFrames.size() - 1);
    }

    /**
     * @return the second last frame of the player and if there is no fra55me where the player is allowed to play create new frame
     */
    public BowlingFrame getSecondLastFrame(){
        if (_bowlingFrames.size() < 2){
            //If there's no prevous frame return null
            return null;
        }
        return _bowlingFrames.get(_bowlingFrames.size() - 2);
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

}
