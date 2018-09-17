package sample.bowling;

public class BowlingGame {

    final private int _maxRounds = 10;
    private int _currentRound = 1;
    private BowlingPlayer[] _bowlingPlayers;

    public BowlingGame(BowlingPlayer[] bowlingPlayers){
        _bowlingPlayers = bowlingPlayers;
    }

}
