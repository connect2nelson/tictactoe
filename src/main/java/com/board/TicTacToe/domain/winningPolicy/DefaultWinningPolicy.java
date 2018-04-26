package com.board.TicTacToe.domain.winningPolicy;

import com.board.TicTacToe.domain.GameState;
import com.board.TicTacToe.domain.Symbol;
import com.board.TicTacToe.domain.counter.LinearSymbolCounter;

public class DefaultWinningPolicy implements WinningPolicy {

    @Override
    public GameState computeGameState(Symbol[][] gridSymbol, LinearSymbolCounter linearSymbolCounter, Symbol symbol) {

        final int WINNING_COUNT = linearSymbolCounter.getGridSize();

        for (int i = 0; i < linearSymbolCounter.getGridSize(); i++) {

            if (linearSymbolCounter.getSymbolCountForCol(i, symbol) == WINNING_COUNT)
                return GameState.WON;

            if (linearSymbolCounter.getSymbolCountForRow(i, symbol) == WINNING_COUNT)
                return GameState.WON;
        }

        if (linearSymbolCounter.getSymbolCountForLeftDiagonal(symbol) == WINNING_COUNT)
            return GameState.WON;

        if (linearSymbolCounter.getSymbolCountForRightDiagonal(symbol) == WINNING_COUNT)
            return GameState.WON;

        if ( linearSymbolCounter.getNoOfMovesAccounted() == linearSymbolCounter.getGridSize() * linearSymbolCounter.getGridSize()){
            return GameState.DRAW;
        }

        return GameState.PLAYABLE;
    }
}
