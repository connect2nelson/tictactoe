package com.board.TicTacToe.config;

import com.board.TicTacToe.domain.Symbol;

import java.util.Arrays;
import java.util.List;

public class GameConfiguration {
    private int size;
    private String player1Symbol;
    private String player2Symbol;
    private String player3Symbol;

    GameConfiguration(int size, String player1Symbol,
                      String player2Symbol,
                      String player3Symbol) {
        this.size = size;
        this.player1Symbol = player1Symbol;
        this.player2Symbol = player2Symbol;
        this.player3Symbol = player3Symbol;
    }

    public int getSize() {
        return size;
    }

    public Symbol getPlayer1Symbol() {
        return new Symbol(player1Symbol);
    }

    public Symbol getPlayer2Symbol() {
        return new Symbol(player2Symbol);
    }

    public Symbol getPlayer3Symbol() {
        return new Symbol(player3Symbol);
    }

    public List<Symbol> getListOfPlayerSymbols(){
        return  Arrays.asList(getPlayer1Symbol(), getPlayer2Symbol(), getPlayer3Symbol());
    }
}
