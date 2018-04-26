package com.board.TicTacToe.domain.counter;

import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.Symbol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinearSymbolCounter {

    private Map<Symbol, int[]> countMap = new HashMap<>();

    private int gridSize;
    private int noOfMovesAccounted ;

    public LinearSymbolCounter(int gridSize, List<Symbol> symbols) {
        this.gridSize = getRowIndexInCountArray(gridSize);
        initialize(symbols);
    }

    public int getGridSize() {
        return gridSize;
    }

    private void initialize(List<Symbol> symbols) {
        symbols.forEach((symbol) -> countMap.put(symbol,
                new int[2 * getRowIndexInCountArray(gridSize) + 2]));
    }

    public int getNoOfMovesAccounted() {
        return noOfMovesAccounted;
    }

    public void updateCount(Move move) {

        updateRowCountForMove(move);
        updateColCountForMove(move);

        if (move.getPosition().getX() == move.getPosition().getY()) {
            updateLeftDiagonalCountForMove(move);
        }

        if (move.getPosition().getX() + move.getPosition().getY() == gridSize - 1) {
            updateRightDiagonalCountForMove(move);
        }
        noOfMovesAccounted++;
    }

    private void updateRightDiagonalCountForMove(Move move) {
        int[] symbolCountArray = countMap.get(move.getSymbol());
        symbolCountArray[getIndexInCountArrayForDiagonal(1)]++;
    }

    private void updateLeftDiagonalCountForMove(Move move) {
        int[] symbolCountArray = countMap.get(move.getSymbol());
        symbolCountArray[getIndexInCountArrayForDiagonal(0)]++;
    }

    private void updateColCountForMove(Move move) {
        int[] symbolCountArray = countMap.get(move.getSymbol());
        symbolCountArray[getColIndexInCountArray(move.getPosition().getX())]++;
    }

    private void updateRowCountForMove(Move move) {
        int[] symbolCountArray = countMap.get(move.getSymbol());

        symbolCountArray[getRowIndexInCountArray(move.getPosition().getY())]++;
    }

    public int getSymbolCountForRow(int row, Symbol symbol) {

        int[] rowWiseSymbolCount = this.countMap.get(symbol);
        if (rowWiseSymbolCount == null)
            return 0;

        return rowWiseSymbolCount[getRowIndexInCountArray(row)];
    }

    public int getSymbolCountForCol(int col, Symbol symbol) {
        int[] symbolCount = this.countMap.get(symbol);
        if (symbolCount == null) {
            return 0;
        }

        return symbolCount[getColIndexInCountArray(col)];
    }

    private int getRowIndexInCountArray(int row) {
        return row;
    }

    private int getColIndexInCountArray(int col) {
        return  col + gridSize;
    }

    private int getIndexInCountArrayForDiagonal(int diagonalNo) {
        return 2 * gridSize + diagonalNo;
    }

    public int getSymbolCountForLeftDiagonal(Symbol symbol) {
        int[] symbolCount = this.countMap.get(symbol);
        if (symbolCount == null) {
            return 0;
        }

        return symbolCount[getIndexInCountArrayForDiagonal(0)];
    }

    public int getSymbolCountForRightDiagonal(Symbol symbol) {
        int[] symbolCount = this.countMap.get(symbol);
        if (symbolCount == null) {
            return 0;
        }

        return symbolCount[getIndexInCountArrayForDiagonal(1)];
    }

}
