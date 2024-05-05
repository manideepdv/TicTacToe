package strategies.winningstrategy;

import models.Board;
import models.Move;
import models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {
    private final Map<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character character = move.getPlayer().getSymbol().getAChar();

        if (!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }

        HashMap<Character, Integer> currRowMap = rowMaps.get(row);

        if(!currRowMap.containsKey(character)) {
            currRowMap.put(character, 0);
        }

        currRowMap.put(character, currRowMap.get(character) + 1);

        return currRowMap.get(character).equals(board.getDimension());
    }
}
