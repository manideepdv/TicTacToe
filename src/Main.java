import controllers.GameController;
import models.*;
import strategies.winningstrategy.ColumnWinningStrategy;
import strategies.winningstrategy.DiagonalWinningStrategy;
import strategies.winningstrategy.RowWinningStrategy;
import strategies.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Game Starts");
        Scanner scanner = new Scanner(System.in);

        // int dimension = scanner.nextInt();
        GameController gameController = new GameController();

        int dimension = 3;

        // Take player info from user input
        List<Player> players = new ArrayList<>();
        players.add(
                new Player(new Symbol('V'), "Venkata", PlayerType.HUMAN)
        );
        players.add(
                new Bot(new Symbol('B'), "Bot", PlayerType.BOT, BotDifficultyLevel.EASY)
        );

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        Game game = gameController.startGame(dimension, players, winningStrategies);

        gameController.printBoard(game);

        // Let's play Game

        while (gameController.checkGameStatus(game).equals(GameStatus.IN_PROGRESS)) {
            // 1. Show Board
            gameController.printBoard(game);

            // 2. Make Move
            System.out.println("Do you want to undo ?");
            String isUndo = scanner.next();

            if (isUndo.equalsIgnoreCase("y")) {
                // make undo move
                gameController.undo(game);
                continue;
            }
            gameController.makeMove(game);
        }
    }
}