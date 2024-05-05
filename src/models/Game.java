package models;

import strategies.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private GameStatus gameStatus;
    private int nextMovePlayerIndex;
    private List<WinningStrategy> winningStrategies;

    public static Builder getBuilder() {
        return new Builder();
    }

    private Game(int dimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.nextMovePlayerIndex = 0;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public Move makeMove() {
        return null;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        private Builder() {
            this.players = new ArrayList<>();
            this.dimension = 0;
            this.winningStrategies = new ArrayList<>();
        }

        private void validateBoardDimension() {
            if (dimension <= 0) {
                throw new RuntimeException("Dimension cannot be negative");
            }
        }

        private void validateBotCount() {
            int count = 0;
            for(Player player : players) {
                if(player.getPlayerType().equals(PlayerType.BOT)) {
                    count += 1;
                    if (count > 1) {
                        throw new RuntimeException("Only one bot is allowed per Game");
                    }
                }
            }
        }

        private void validateUniqueSymbols() {
            Set<Character> symbolSet = new HashSet<>();
            for(Player player : players) {
                symbolSet.add(player.getSymbol().getAChar());
            }
            if (symbolSet.size() != dimension - 1) {
                throw new RuntimeException("Every player should have a unique symbol");
            }
        }


        private void validations() {
            validateBoardDimension();
            validateBotCount();
            validateUniqueSymbols();
        }

        public Game build() {
            // check validations
            validations();
            return new Game(dimension, players, winningStrategies);
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }
    }
}
