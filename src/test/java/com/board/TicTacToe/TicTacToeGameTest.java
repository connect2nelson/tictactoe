package com.board.TicTacToe;

import com.board.TicTacToe.domain.*;
import com.board.TicTacToe.exception.InvalidMoveException;
import com.board.TicTacToe.domain.player.ComputerPlayer;
import com.board.TicTacToe.domain.player.HumanPlayer;
import com.board.TicTacToe.domain.player.Players;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TicTacToeGameTest {

    @Mock
    private Board board;

    private Players players;

    @Mock
    private HumanPlayer humanPlayer;

    @Mock
    private ComputerPlayer computerPlayer;

    @Mock
    private TicTacToeGame ticTacToeGame;

    Move humanPlayerMove ;
    Move computerPlayerMove;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        players = mock(Players.class);
        humanPlayer = mock(HumanPlayer.class);
        computerPlayer = mock(ComputerPlayer.class);
        when(players.nextPlayer()).thenReturn(humanPlayer, computerPlayer);

        ticTacToeGame = new TicTacToeGame(board, players);

        humanPlayerMove = new Move(new Position(0, 0), new Symbol("X"));
        when(humanPlayer.nextMove()).thenReturn(humanPlayerMove);

        computerPlayerMove = new Move(new Position(0, 0), new Symbol("O"));
        when(computerPlayer.nextMove()).thenReturn(computerPlayerMove);
    }

    @Test
    public void shouldContinueAcceptingPlayerMovesTillTheGameIsDrawn() throws Exception {

        when(board.accept(humanPlayerMove)).thenReturn(GameState.PLAYABLE);
        when(board.accept(computerPlayerMove)).thenReturn(GameState.DRAW);
        ticTacToeGame.start();
        verify(board, times(1)).accept(humanPlayerMove);
        verify(board, times(1)).accept(computerPlayerMove);
    }

    @Test
    public void shouldContinuePlayingGameTillTheGameIsWon() throws Exception {

        when(board.accept(humanPlayerMove)).thenReturn(GameState.PLAYABLE);
        when(board.accept(computerPlayerMove)).thenReturn(GameState.WON);
        ticTacToeGame.start();
        verify(board, times(1)).accept(humanPlayerMove);
        verify(board, times(1)).accept(computerPlayerMove);
    }

    @Test
    public void shouldContinuePlayingGameWithSamePlayerWhenBoardMoveEnterWasWrong() throws Exception {
        when(board.accept(humanPlayerMove))
                .thenThrow(InvalidMoveException.class)
                .thenReturn(GameState.PLAYABLE);

        when(board.accept(computerPlayerMove)).thenReturn(GameState.WON);

        ticTacToeGame.start();
        verify(board, times(2)).accept(humanPlayerMove);
        verify(board, times(1)).accept(computerPlayerMove);
    }

}