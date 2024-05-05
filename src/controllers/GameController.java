package controllers;

import models.Game;
import models.GameStatus;
import models.Player;
import strategies.winningstrategy.WinningStrategy;

import java.util.List;

public class GameController {
    // Include all the functionality needed here that user will be interacted with the Game

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public GameStatus checkGameStatus(Game game) {
        return game.getGameStatus();
    }

    public Player getWinner(Game game) {
        return null;
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public void undo(Game game) {

    }
}
