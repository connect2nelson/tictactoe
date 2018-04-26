package com.board.TicTacToe.domain.winningPolicy;


import com.board.TicTacToe.domain.GameState;
import com.board.TicTacToe.domain.Symbol;
import com.board.TicTacToe.domain.counter.LinearSymbolCounter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CornerMatchWinnigPolicyTest {

    @Test
    public void shouldDeclareTheGameIsWonIfTheCornerSymbolsMatch(){
        CornerMatchWinnigPolicy cornerMatchWinnigPolicy = new CornerMatchWinnigPolicy();

        List<Symbol> symbols = Collections.singletonList(new Symbol("X"));
        Symbol symbolX = new Symbol("X");

        Symbol[][] grid = new Symbol[3][3];

        grid[0][0]= symbolX;
        grid[0][2]= symbolX;
        grid[2][0]= symbolX;
        grid[2][2]= symbolX;

        assertThat(cornerMatchWinnigPolicy.computeGameState(grid, new LinearSymbolCounter(3, symbols), symbolX)).isEqualTo(GameState.WON);
    }

    @Test
    public void shouldDeclareTheGameIsWonIfTheCornerSymbolsDontMatch(){
        CornerMatchWinnigPolicy cornerMatchWinnigPolicy = new CornerMatchWinnigPolicy();

        List<Symbol> symbols = Collections.singletonList(new Symbol("X"));
        Symbol symbolX = new Symbol("X");

        Symbol[][] grid = new Symbol[3][3];

        grid[0][0]= symbolX;
        grid[0][2]= symbolX;
        grid[2][0]= symbolX;
        grid[2][2]= new Symbol("Y");

        assertThat(cornerMatchWinnigPolicy.computeGameState(grid, new LinearSymbolCounter(3, symbols), symbolX)).isEqualTo(GameState.PLAYABLE);
    }
}