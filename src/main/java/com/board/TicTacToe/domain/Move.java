package com.board.TicTacToe.domain;

public class Move {

    private final Position p;
    private final Symbol symbol;

    public Move( Position p, Symbol symbol) {
        this.p = p;
        this.symbol = symbol;
    }

    public Position getPosition() {
        return p;
    }

    public Symbol getSymbol() {
        return symbol;
    }

}
