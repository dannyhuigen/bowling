package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.bowling.BowlingFrame;
import sample.bowling.BowlingGame;
import sample.bowling.BowlingPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        testGame();
//        launch(args);
    }

    private static void testGame(){
        BowlingPlayer player1 = new BowlingPlayer("Danny");
//        BowlingPlayer player2 = new BowlingPlayer("Niels");

        List<BowlingPlayer> players = new ArrayList<BowlingPlayer>();
        players.add(player1);
//        players.add(player2);

        BowlingGame game = new BowlingGame(players);

        Scanner scanner = new Scanner(System.in);

        while (true){

            for (BowlingPlayer player : game.getAllPlayers()){
                System.out.println(player.getName() + "'s score:");

                for (BowlingFrame frame : player.getAllBowlingFrames()){

                    String outputString = "";

                    if (frame.getAmountOfThrows() == 1){
                        outputString += frame.getFrameScore().get(0) + " - ";
                    }
                    if (frame.getAmountOfThrows() == 2){
                        outputString += frame.getFrameScore().get(0) + "|" + frame.getFrameScore().get(1) + " - ";
                    }

                    switch (frame.getScoreKind()){
                        case NORMAL:
                            outputString += "Normal";
                            break;
                        case SPARE:
                            outputString += "Spare";
                            break;
                        case STRIKE:
                            outputString += "Strike";
                            break;
                        default:
                            outputString += "Error";
                    }

                    if (frame.getAmountOfBonusScores() == 1){
                        outputString += "BONUSSCRE : " + frame.getFrameBonusScore().get(0) + " - ";
                    }
                    if (frame.getAmountOfBonusScores() == 2){
                        outputString += "BONUSSCRE : " + frame.getFrameBonusScore().get(0) + "|" + frame.getFrameBonusScore().get(1) + " - ";
                    }
                    System.out.println(outputString);
                }
                System.out.println("\n------------");
            }

            System.out.println();
            System.out.println("How many pins has " + game.getCurrentPlayer().getName() + " thrown");
            int amountPins = scanner.nextInt();

            game.getCurrentPlayer().addPointsToLastFrame(amountPins);

        }


    }
}
