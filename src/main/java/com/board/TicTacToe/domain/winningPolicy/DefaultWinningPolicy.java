package com.board.TicTacToe.domain.winningPolicy;

import com.board.TicTacToe.domain.GameState;
import com.board.TicTacToe.domain.Symbol;
import com.board.TicTacToe.domain.counter.LinearSymbolCountMap;

public class DefaultWinningPolicy implements WinningPolicy {

    @Override
    public GameState computeGameState(LinearSymbolCountMap linearSymbolCountMap, Symbol symbol) {

        final int WINNING_COUNT = linearSymbolCountMap.getGridSize();

        for (int i = 0; i < linearSymbolCountMap.getGridSize(); i++) {

            if (linearSymbolCountMap.getSymbolCountForCol(i, symbol) == WINNING_COUNT)
                return GameState.WON;

            if (linearSymbolCountMap.getSymbolCountForRow(i, symbol) == WINNING_COUNT)
                return GameState.WON;
        }

        if (linearSymbolCountMap.getSymbolCountForLeftDiagonal(symbol) == WINNING_COUNT)
            return GameState.WON;

        if (linearSymbolCountMap.getSymbolCountForRightDiagonal(symbol) == WINNING_COUNT)
            return GameState.WON;

        if ( linearSymbolCountMap.getNoOfMovesAccounted() == linearSymbolCountMap.getGridSize() * linearSymbolCountMap.getGridSize()){
            return GameState.DRAW;
        }

        return GameState.PLAYABLE;
    }
}
