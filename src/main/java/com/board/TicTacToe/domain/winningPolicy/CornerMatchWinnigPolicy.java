package com.board.TicTacToe.domain.winningPolicy;

import com.board.TicTacToe.domain.GameState;
import com.board.TicTacToe.domain.Symbol;
import com.board.TicTacToe.domain.counter.LinearSymbolCounter;

public class CornerMatchWinnigPolicy implements  WinningPolicy {


    @Override
    public GameState computeGameState(Symbol[][] grid, LinearSymbolCounter linearSymbolCounter, Symbol symbol) {

        int gridSize = linearSymbolCounter.getGridSize();

        if ( grid[0][0] == symbol
                && grid[0][gridSize-1] == symbol
                && grid[gridSize-1][0] == symbol
                && grid[gridSize-1][gridSize-1] == symbol){
            return GameState.WON;
        }
        return GameState.PLAYABLE;
    }
}
