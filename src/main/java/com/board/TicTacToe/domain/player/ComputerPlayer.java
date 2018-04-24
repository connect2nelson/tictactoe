package com.board.TicTacToe.domain.player;


import com.board.TicTacToe.domain.Board;
import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.Position;
import com.board.TicTacToe.domain.Symbol;

public class ComputerPlayer extends Player {
    private final Board board;

    public ComputerPlayer(Symbol symbol, String name, Board boardState) {
        super(symbol, name);
        this.board = boardState;
    }

    @Override
    public Move nextMove() {

        for (int i = 0; i < board.getGridSize(); i++) {
            for (int j = 0; j < board.getGridSize(); j++) {
                Position position = new Position(i, j);
                if (board.getSymbolForPosition(position)== Symbol.EMPTY) {
                    System.out.println("Computer placed the marker at position  = " + position);
                    return new Move(position, getSymbol());
                }
            }
        }

        return null;
    }
}

