package com.board.TicTacToe.domain.player;

import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.Symbol;

public abstract class Player {
    private Symbol symbol;
    private String name;

    public Player(Symbol symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public abstract Move nextMove();
}