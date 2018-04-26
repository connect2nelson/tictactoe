package com.board.TicTacToe.counter;

import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.Position;
import com.board.TicTacToe.domain.Symbol;
import com.board.TicTacToe.domain.counter.LinearSymbolCountMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


public class LinearSymbolCountMapTest {

    private Symbol symbolX = new Symbol("X");

    @Test
    public void shouldUpdateTheAppropriateRowSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        LinearSymbolCountMap linearSymbolCountMap = new LinearSymbolCountMap(3, Collections.singletonList(symbolX));

        linearSymbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(linearSymbolCountMap.getSymbolCountForRow(1, symbolX)).isEqualTo(1);
        assertThat(linearSymbolCountMap.getSymbolCountForCol(1, symbolX)).isEqualTo(1);
    }

    @Test
    public void shouldUpdateTheAppropriateColSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        LinearSymbolCountMap linearSymbolCountMap = new LinearSymbolCountMap(3, Collections.singletonList(symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(linearSymbolCountMap.getSymbolCountForCol(1, symbolX)).isEqualTo(1);
    }


    @Test
    public void shouldUpdateTheLeftDiagnolSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        LinearSymbolCountMap linearSymbolCountMap = new LinearSymbolCountMap(3, Collections.singletonList(symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(linearSymbolCountMap.getSymbolCountForLeftDiagonal(symbolX)).isEqualTo(1);
    }

    @Test
    public void shouldUpdateTheRightDiagnolSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        LinearSymbolCountMap linearSymbolCountMap = new LinearSymbolCountMap(3, Collections.singletonList(symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(linearSymbolCountMap.getSymbolCountForRightDiagonal(symbolX)).isEqualTo(1);
    }
    @Test
    public void shouldReturnThreeAsSymbolCountMapOnceLeftDiagonalMovesAreAccepted() throws Exception {

        LinearSymbolCountMap linearSymbolCountMap = new LinearSymbolCountMap(3, Collections.singletonList(symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(0,0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(2,2), symbolX));
        assertThat(linearSymbolCountMap.getSymbolCountForLeftDiagonal(symbolX)).isEqualTo(3);
    }

    @Test
    public void shouldReturnThreeAsSymbolCountMapOnceAllLeftMostColAreAccepted() throws Exception {

        LinearSymbolCountMap linearSymbolCountMap = new LinearSymbolCountMap(3, Collections.singletonList(symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(0,0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(0,1), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(0,2), symbolX));
        assertThat(linearSymbolCountMap.getSymbolCountForCol(0, symbolX)).isEqualTo(3);
    }

    @Test
    public void shouldReturnThreeAsSymbolCountMapOnceAllLeftMostRowAreAccepted() throws Exception {

        LinearSymbolCountMap linearSymbolCountMap = new LinearSymbolCountMap(3, Collections.singletonList(symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(0,0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(1,0), symbolX));
        linearSymbolCountMap.updateCount(new Move(new Position(2,0), symbolX));
        assertThat(linearSymbolCountMap.getSymbolCountForRow(0, symbolX)).isEqualTo(3);
    }

    @Test
    public void shouldReturnZeroAsCountWhenQueriedForAnInvalidSymbol() throws Exception {

        LinearSymbolCountMap linearSymbolCountMap = new LinearSymbolCountMap(3, Collections.singletonList(symbolX));

        Symbol symbolX = new Symbol("X");
        Symbol symbolStar = new Symbol("*");
        linearSymbolCountMap.updateCount(new Move(new Position(1,1), symbolX));

        assertThat(linearSymbolCountMap.getSymbolCountForRow(1, symbolStar)).isEqualTo(0);

    }

}