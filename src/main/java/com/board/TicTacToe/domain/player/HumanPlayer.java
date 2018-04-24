package com.board.TicTacToe.domain.player;

import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.Position;
import com.board.TicTacToe.domain.Symbol;
import com.board.TicTacToe.input.InputReader;

public class HumanPlayer extends Player {
    private final InputReader reader;

    public HumanPlayer(Symbol symbol, String name, InputReader reader) {
        super(symbol, name);
        this.reader = reader;
    }

    @Override
    public Move nextMove() {
        System.out.println("Player : " + this.getName()
                + "; please enter co-ordinate for marker in format x,y (origin is 0,0) : ");
        Position markerPosition = reader.getMarkerPosition();
        return new Move( markerPosition, getSymbol());
    }
}