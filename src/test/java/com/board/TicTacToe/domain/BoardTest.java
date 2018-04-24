package com.board.TicTacToe.domain;

import com.board.TicTacToe.domain.winningPolicy.WinningPolicy;
import com.board.TicTacToe.exception.InvalidMoveException;
import com.board.TicTacToe.exception.DuplicateMoveException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.mock;


public class BoardTest {
    Board board;

    WinningPolicy winningPolicy;

    @Before
    public void setUp() throws Exception {
        winningPolicy = mock(WinningPolicy.class);
        board = new Board(3, winningPolicy,
                Arrays.asList(new Symbol("X"), new Symbol("O"), new Symbol("I")));
    }

    @Test
    public void shouldCreateABoardForGivenSize() {
        assertThat(board.getNoOfVacantSpaces()).isEqualTo(9);
    }

    @Test
    public void shouldAcceptAMove() throws InvalidMoveException, DuplicateMoveException {
        Position p = new Position(1, 1);
        board.accept(new Move(p, new Symbol("X")));
        assertThat(board.getNoOfVacantSpaces()).isEqualTo(8);
    }

    @Test
    public void shouldAcceptMoreThanOneMove() throws InvalidMoveException, DuplicateMoveException {
        Position p = new Position(1, 1);
        board.accept(new Move(p, new Symbol("X")));

        p = new Position(2, 2);
        board.accept(new Move(p, new Symbol("X")));

        assertThat(board.getNoOfVacantSpaces()).isEqualTo(7);
    }


    @Test(expected = DuplicateMoveException.class)
    public void shouldNotAcceptADuplicateMove() throws InvalidMoveException, DuplicateMoveException {
        Position p = new Position(1, 1);
        board.accept(new Move(p, new Symbol("X")));
        board.accept(new Move(p, new Symbol("X")));
    }


    @Test(expected = InvalidMoveException.class)
    public void shouldThrowAnInvalidMoveExceptionIfThePositionOfTheMoveIsOutOfTheBoard()
            throws InvalidMoveException, DuplicateMoveException {
        Position p = new Position(10, 10);
        Move invalidMove = new Move(p, new Symbol("X"));
        board.accept(invalidMove);
    }

    @Test
    public void shouldReturnSymbolForAGivenPositionOnTheBoard() throws DuplicateMoveException, InvalidMoveException {

        Position p = new Position(1, 1);
        Move x = new Move(p, new Symbol("X"));
        board.accept(x);

        Symbol symbolForPosition = board.getSymbolForPosition(p);

        assertThat(symbolForPosition).isEqualTo(x.getSymbol());

    }
}