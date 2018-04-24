package com.board.TicTacToe;

import com.board.TicTacToe.domain.Board;
import com.board.TicTacToe.domain.GameState;
import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.player.Player;
import com.board.TicTacToe.domain.player.Players;
import com.board.TicTacToe.exception.DuplicateMoveException;
import com.board.TicTacToe.exception.InvalidMoveException;

class TicTacToeGame {
    private Board board;
    private Players players;

    TicTacToeGame(Board board, Players players) {
        this.board = board;
        this.players = players;
    }

    void start()  {

        GameState gameState = GameState.PLAYABLE;
        boolean currentMoveIsInvalid;

        board.printBoard();

        do {
            Player player = players.nextPlayer();
            Move move = player.nextMove();

            do {
                try {
                    gameState = board.accept(move);

                    switch (gameState) {
                        case WON:
                            System.out.println("Congratulations, " + player.getName() + " , You WON :)");
                            break;
                        case DRAW:
                            System.out.println("Oh Geez, Game is a DRAW !!! Better luck next time to all the players ");
                            break;
                    }
                    board.printBoard();
                    currentMoveIsInvalid = false;

                } catch (InvalidMoveException | DuplicateMoveException e) {
                    currentMoveIsInvalid = true;
                    System.out.println("Entered move is not valid ! Please enter again.");
                    move = player.nextMove();
                }
            } while( currentMoveIsInvalid );

        } while (gameState == GameState.PLAYABLE);
    }
}
