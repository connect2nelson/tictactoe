package com.board.TicTacToe.domain;

import com.board.TicTacToe.domain.counter.SymbolCountMap;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class SymbolCountMapTest {

    Symbol symbolX = new Symbol("X");

    @Test
    public void shouldUpdateTheAppropriateRowSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        SymbolCountMap symbolCountMap = new SymbolCountMap(3, Arrays.asList(symbolX));

        symbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(symbolCountMap.getSymbolCountForRow(1, symbolX)).isEqualTo(1);
        assertThat(symbolCountMap.getSymbolCountForCol(1, symbolX)).isEqualTo(1);
    }

    @Test
    public void shouldUpdateTheAppropriateColSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        SymbolCountMap symbolCountMap = new SymbolCountMap(3, Arrays.asList(symbolX));
        symbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(symbolCountMap.getSymbolCountForCol(1, symbolX)).isEqualTo(1);
    }


    @Test
    public void shouldUpdateTheLeftDiagnolSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        SymbolCountMap symbolCountMap = new SymbolCountMap(3, Arrays.asList(symbolX));
        symbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(symbolCountMap.getSymbolCountForLeftDiagonal(symbolX)).isEqualTo(1);
    }

    @Test
    public void shouldUpdateTheRightDiagnolSymbolCountMapOnceAGivenMoveIsAccepted() throws Exception {

        SymbolCountMap symbolCountMap = new SymbolCountMap(3, Arrays.asList(symbolX));
        symbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        assertThat(symbolCountMap.getSymbolCountForRightDiagonal(symbolX)).isEqualTo(1);
    }
    @Test
    public void shouldReturnThreeAsSymbolCountMapOnceLeftDiagonalMovesAreAccepted() throws Exception {

        SymbolCountMap symbolCountMap = new SymbolCountMap(3, Arrays.asList(symbolX));
        symbolCountMap.updateCount(new Move(new Position(1,1), symbolX));
        symbolCountMap.updateCount(new Move(new Position(0,0), symbolX));
        symbolCountMap.updateCount(new Move(new Position(2,2), symbolX));
        assertThat(symbolCountMap.getSymbolCountForLeftDiagonal(symbolX)).isEqualTo(3);
    }

    @Test
    public void shouldReturnThreeAsSymbolCountMapOnceAllLeftMostColAreAccepted() throws Exception {

        SymbolCountMap symbolCountMap = new SymbolCountMap(3, Arrays.asList(symbolX));
        symbolCountMap.updateCount(new Move(new Position(0,0), symbolX));
        symbolCountMap.updateCount(new Move(new Position(0,1), symbolX));
        symbolCountMap.updateCount(new Move(new Position(0,2), symbolX));
        assertThat(symbolCountMap.getSymbolCountForCol(0, symbolX)).isEqualTo(3);
    }

    @Test
    public void shouldReturnThreeAsSymbolCountMapOnceAllLeftMostRowAreAccepted() throws Exception {

        SymbolCountMap symbolCountMap = new SymbolCountMap(3, Arrays.asList(symbolX));
        symbolCountMap.updateCount(new Move(new Position(0,0), symbolX));
        symbolCountMap.updateCount(new Move(new Position(1,0), symbolX));
        symbolCountMap.updateCount(new Move(new Position(2,0), symbolX));
        assertThat(symbolCountMap.getSymbolCountForRow(0, symbolX)).isEqualTo(3);
    }

    @Test
    public void shouldReturnZeroAsCountWhenQueriedForAnInvalidSymbol() throws Exception {

        SymbolCountMap symbolCountMap = new SymbolCountMap(3, Arrays.asList(symbolX));

        Symbol symbolX = new Symbol("X");
        Symbol symbolStar = new Symbol("*");
        symbolCountMap.updateCount(new Move(new Position(1,1), symbolX));

        assertThat(symbolCountMap.getSymbolCountForRow(1, symbolStar)).isEqualTo(0);

    }

}