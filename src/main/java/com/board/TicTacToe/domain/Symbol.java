package com.board.TicTacToe.domain;

public class Symbol {

    public static final Symbol EMPTY = new Symbol("_");

    String symbol ;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Symbol symbol1 = (Symbol) o;

        return symbol != null ? symbol.equals(symbol1.symbol) : symbol1.symbol == null;
    }

    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
