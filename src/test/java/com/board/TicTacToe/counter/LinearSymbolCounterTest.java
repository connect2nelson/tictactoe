package com.board.TicTacToe.counter;

import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.Position;
import com.board.TicTacToe.domain.Symbol;
import com.board.TicTacToe.domain.counter.LinearSymbolCounter;
import org.junit.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


public class LinearSymbolCounterTest {

    private Symbol symbolX = new Symbol("X");

    @Test
    public void shouldUpdateTheAppropriateRowSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        LinearSymbolCounter linearSymbolCounter = new LinearSymbolCounter(3, Collections.singletonList(symbolX));

        linearSymbolCounter.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(linearSymbolCounter.getSymbolCountForRow(1, symbolX)).isEqualTo(1);
        assertThat(linearSymbolCounter.getSymbolCountForCol(1, symbolX)).isEqualTo(1);
    }

    @Test
    public void shouldUpdateTheAppropriateColSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        LinearSymbolCounter linearSymbolCounter = new LinearSymbolCounter(3, Collections.singletonList(symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(linearSymbolCounter.getSymbolCountForCol(1, symbolX)).isEqualTo(1);
    }


    @Test
    public void shouldUpdateTheLeftDiagnolSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        LinearSymbolCounter linearSymbolCounter = new LinearSymbolCounter(3, Collections.singletonList(symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(linearSymbolCounter.getSymbolCountForLeftDiagonal(symbolX)).isEqualTo(1);
    }

    @Test
    public void shouldUpdateTheRightDiagnolSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        LinearSymbolCounter linearSymbolCounter = new LinearSymbolCounter(3, Collections.singletonList(symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(linearSymbolCounter.getSymbolCountForRightDiagonal(symbolX)).isEqualTo(1);
    }
    @Test
    public void shouldReturnThreeAsSymbolCountMapOnceLeftDiagonalMovesAreAccepted() throws Exception {

        LinearSymbolCounter linearSymbolCounter = new LinearSymbolCounter(3, Collections.singletonList(symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(1,1), symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(0,0), symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(2,2), symbolX));
        assertThat(linearSymbolCounter.getSymbolCountForLeftDiagonal(symbolX)).isEqualTo(3);
    }

    @Test
    public void shouldReturnThreeAsSymbolCountMapOnceAllLeftMostColAreAccepted() throws Exception {

        LinearSymbolCounter linearSymbolCounter = new LinearSymbolCounter(3, Collections.singletonList(symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(0,0), symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(0,1), symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(0,2), symbolX));
        assertThat(linearSymbolCounter.getSymbolCountForCol(0, symbolX)).isEqualTo(3);
    }

    @Test
    public void shouldReturnThreeAsSymbolCountMapOnceAllLeftMostRowAreAccepted() throws Exception {

        LinearSymbolCounter linearSymbolCounter = new LinearSymbolCounter(3, Collections.singletonList(symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(0,0), symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(1,0), symbolX));
        linearSymbolCounter.updateCount(new Move(new Position(2,0), symbolX));
        assertThat(linearSymbolCounter.getSymbolCountForRow(0, symbolX)).isEqualTo(3);
    }

    @Test
    public void shouldReturnZeroAsCountWhenQueriedForAnInvalidSymbol() throws Exception {

        LinearSymbolCounter linearSymbolCounter = new LinearSymbolCounter(3, Collections.singletonList(symbolX));

        Symbol symbolX = new Symbol("X");
        Symbol symbolStar = new Symbol("*");
        linearSymbolCounter.updateCount(new Move(new Position(1,1), symbolX));

        assertThat(linearSymbolCounter.getSymbolCountForRow(1, symbolStar)).isEqualTo(0);

    }

}