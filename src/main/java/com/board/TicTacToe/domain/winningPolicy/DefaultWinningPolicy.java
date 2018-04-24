package com.board.TicTacToe.domain.winningPolicy;

import com.board.TicTacToe.domain.GameState;
import com.board.TicTacToe.domain.Symbol;
import com.board.TicTacToe.domain.counter.SymbolCountMap;

public class DefaultWinningPolicy implements WinningPolicy {

    @Override
    public GameState computeGameState(SymbolCountMap symbolCountMap, Symbol symbol) {

        final int WINNING_COUNT = symbolCountMap.getGridSize();

        for (int i = 0; i < symbolCountMap.getGridSize(); i++) {

            if (symbolCountMap.getSymbolCountForCol(i, symbol) == WINNING_COUNT)
                return GameState.WON;

            if (symbolCountMap.getSymbolCountForRow(i, symbol) == WINNING_COUNT)
                return GameState.WON;
        }

        if (symbolCountMap.getSymbolCountForLeftDiagonal(symbol) == WINNING_COUNT)
            return GameState.WON;

        if (symbolCountMap.getSymbolCountForRightDiagonal(symbol) == WINNING_COUNT)
            return GameState.WON;

        if ( symbolCountMap.getNoOfMovesAccounted() == symbolCountMap.getGridSize() * symbolCountMap.getGridSize()){
            return GameState.DRAW;
        }

        return GameState.PLAYABLE;
    }
}
