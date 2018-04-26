package com.board.TicTacToe.domain.winningPolicy;

import com.board.TicTacToe.domain.GameState;
import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.Position;
import com.board.TicTacToe.domain.Symbol;
import com.board.TicTacToe.domain.counter.LinearSymbolCountMap;
import com.board.TicTacToe.exception.DuplicateMoveException;
import com.board.TicTacToe.exception.InvalidMoveException;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class DefaultWinningPolicyTest {

    private LinearSymbolCountMap linearSymbolCountMap = new LinearSymbolCountMap(3,
            Arrays.asList(new Symbol("X"), new Symbol("O"), new Symbol("C")));

    @Test
    public void shouldReturnGameStateAsPlayableIfNoWinningCountIsObtained()
            throws DuplicateMoveException, InvalidMoveException {

        WinningPolicy winningPolicy = new DefaultWinningPolicy();
        Symbol symbolX = new Symbol("X");
        linearSymbolCountMap.updateCount(new Move(new Position(0, 0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(0, 1), symbolX));

        assertThat(winningPolicy.computeGameState(linearSymbolCountMap, symbolX)).isEqualTo(GameState.PLAYABLE);
    }

    @Test
    public void shouldReturnGameStateAsDRAWIfNoMoreMovesLeftToBePlayed()
            throws DuplicateMoveException, InvalidMoveException {

        WinningPolicy winningPolicy = new DefaultWinningPolicy();
        Symbol symbolX = new Symbol("X");
        Symbol symbolO = new Symbol("O");
        Symbol symbolC = new Symbol("C");
        linearSymbolCountMap.updateCount(new Move(new Position(0, 0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(0, 1), symbolO));
        linearSymbolCountMap.updateCount(new Move(new Position(0, 2), symbolC));
        linearSymbolCountMap.updateCount(new Move(new Position(1, 0), symbolO));
        linearSymbolCountMap.updateCount(new Move(new Position(1, 1), symbolC));
        linearSymbolCountMap.updateCount(new Move(new Position(1, 2), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(2, 0), symbolO));
        linearSymbolCountMap.updateCount(new Move(new Position(2, 1), symbolC));
        linearSymbolCountMap.updateCount(new Move(new Position(2, 2), symbolX));

        assertThat(winningPolicy.computeGameState(linearSymbolCountMap, symbolX)).isEqualTo(GameState.DRAW);
    }

    @Test
    public void shouldReturnGameStateAsWonIfThereAreSameSymbolsInACol()
            throws DuplicateMoveException, InvalidMoveException {

        WinningPolicy winningPolicy = new DefaultWinningPolicy();
        Symbol symbolX = new Symbol("X");
        linearSymbolCountMap.updateCount(new Move(new Position(0, 0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(0, 1), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(0, 2), symbolX));

        assertThat(winningPolicy.computeGameState(linearSymbolCountMap, symbolX)).isEqualTo(GameState.WON);
    }

    @Test
    public void shouldReturnGameStateAsWonIfThereAreSameSymbolsInARow()
            throws DuplicateMoveException, InvalidMoveException {

        WinningPolicy winningPolicy = new DefaultWinningPolicy();
        Symbol symbolX = new Symbol("X");
        linearSymbolCountMap.updateCount(new Move(new Position(0, 0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(1, 0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(2, 0), symbolX));

        assertThat(winningPolicy.computeGameState(linearSymbolCountMap, symbolX)).isEqualTo(GameState.WON);
    }

    @Test
    public void shouldReturnGameStateAsWonIfThereAreSameSymbolsInTheLeftDiagonal()
            throws DuplicateMoveException, InvalidMoveException {

        WinningPolicy winningPolicy = new DefaultWinningPolicy();
        Symbol symbolX = new Symbol("X");
        linearSymbolCountMap.updateCount(new Move(new Position(0, 0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(1, 1), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(2, 2), symbolX));

        assertThat(winningPolicy.computeGameState(linearSymbolCountMap, symbolX)).isEqualTo(GameState.WON);
    }

    @Test
    public void shouldReturnGameStateAsWonIfThereAreSameSymbolsInTheRightDiagonal()
            throws DuplicateMoveException, InvalidMoveException {

        WinningPolicy winningPolicy = new DefaultWinningPolicy();
        Symbol symbolX = new Symbol("X");
        linearSymbolCountMap.updateCount(new Move(new Position(0, 2), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(1, 1), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(2, 0), symbolX));

        assertThat(winningPolicy.computeGameState(linearSymbolCountMap, symbolX)).isEqualTo(GameState.WON);
    }

}