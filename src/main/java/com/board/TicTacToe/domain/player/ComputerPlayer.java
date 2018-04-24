package com.board.TicTacToe.domain.player;


import com.board.TicTacToe.domain.Board;
import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.Position;
import com.board.TicTacToe.domain.Symbol;

import java.util.Random;

public class ComputerPlayer extends Player {
    private final Board board;
    private static Random random = new Random();

    public ComputerPlayer(Symbol symbol, String name, Board board) {
        super(symbol, name);
        this.board = board;
    }

    @Override
    public Move nextMove() {

        for (int i = 0; i < board.getGridSize(); i++) {
            for (int j = 0; j < board.getGridSize(); j++) {
                Position position = new Position(i, j);
                if (board.getSymbolForPosition(position) == Symbol.EMPTY) {
                    System.out.println("Computer placed the marker at position  = " + position);
                    return new Move(position, getSymbol());
                }
            }
        }
        return null;
    }

}

