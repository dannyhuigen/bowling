package sample.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingFrame {

    List<Integer> _score = new ArrayList<Integer>();
    List<Integer> _bonusScore = new ArrayList<Integer>();

    /**
     * @param pinsAmount the amounts of pins thrown at the single throw, max a total of 10
     */
    public void addThrow(int pinsAmount){
        if (allowedToThrow()){
            _score.add(pinsAmount);
        }
        else{
            System.out.println("something went wrong adding pinAmount to frame...");
        }
    }

    /**
     * function to add bonus points to throw used for extra points if previous frame was spare or strike
     * @param pinsAmount amount of bonus points
     */
    public void addBonusPoints(int pinsAmount){
        _bonusScore.add(pinsAmount);
        System.out.println(_bonusScore);
    }

    /**
     * @return int list with 2 indexes 0 = first throw, 1 = second throw
     *  index 1 will be empty if the player thrown a strike
     */
    public List<Integer> getFrameScore(){
        return _score;
    }

    /**
     * @return bonus score of frame, used for extra points if previous frame was spare or strike
     */
    public List<Integer> getFrameBonusScore(){
        return _bonusScore;
    }

    /**
     * @return amount of bonus scores 1 if previous game was spare and 2 if precious game was a strike
     */
    public int getAmountOfBonusScores(){
        return _bonusScore.size();
    }

    /**
     * @return the amount of throws in the current frame, max should be 2
     */
    public int getAmountOfThrows(){
        return _score.size();
    }

    /**
     * @return boolean if you're allowed to throw this frame or if this frame is done
     */
    public boolean allowedToThrow(){
        scoreKind currentScoreKind = getScoreKind();
        if (currentScoreKind == scoreKind.STRIKE){
            return false;
        }
        else if (getAmountOfThrows() == 2){
            return false;
        }
        //neither a strike has been thrown or 2 throws so we're allowed to throw
        else{
            return true;
        }
    }

    /**
     * @return the total points of the frame
     */
    public int getTotalPoints(){
        int amountThrows = getAmountOfThrows();
        if (amountThrows == 0){
            return 0;
        }
        else if(amountThrows == 1){
            return _score.get(0);
        }
        else if(amountThrows == 2){
            return _score.get(0) + _score.get(1);
        }
        System.out.println("something went terribly wrong");
        return 0;
    }

    /**
     * @return scoreKind of current this frame either score kind NORMAL , SPARE or STRIKE
     */
    public scoreKind getScoreKind(){
        //either a strike or split has been thrown
        if(getTotalPoints() >= 10){
            if (getAmountOfThrows() == 1){
                //10 points have been achieved in 1 throw so its a strike
                return scoreKind.STRIKE;
            }
            else if (getAmountOfThrows() == 2){
                //10 points have been achieved in 2 throws so its a spare
                return scoreKind.SPARE;
            }
        }
        //Neither a strike or spare has been thrown so it has to be a normal score kind
        return scoreKind.NORMAL;
    }

    /**
     * Enum for bowling score kind pretty self explaining
     */
    public enum scoreKind{
        NORMAL,
        SPARE,
        STRIKE
    }

}
