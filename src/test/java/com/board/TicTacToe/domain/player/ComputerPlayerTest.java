package com.board.TicTacToe.domain.player;


import com.board.TicTacToe.domain.Board;
import com.board.TicTacToe.domain.Move;
import com.board.TicTacToe.domain.Position;
import com.board.TicTacToe.domain.Symbol;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ComputerPlayerTest {

    @Mock
    private Board board;

    @Before
    public void setUp() throws Exception {
        given(board.getGridSize()).willReturn(3);
    }

    @Test
    public void shouldGenerateAValidMoveWhenTheBoardIsEmpty() {

        when(board.getSymbolForPosition(isA(Position.class))).thenReturn(Symbol.EMPTY);

        ComputerPlayer computerPlayer = new ComputerPlayer(new Symbol("C"), "Computer", board);
        Move move = computerPlayer.nextMove();
        assertThat(move.getPosition().getX()).isLessThan(board.getGridSize());
        assertThat(move.getPosition().getY()).isLessThan(board.getGridSize());
        assertThat(move.getSymbol()).isEqualTo(new Symbol("C"));

    }

    @Test
    public void shouldGenerateAValidMoveIfBoardIsAlreadyContainingSomeMarkers() {

        when(board.getSymbolForPosition(isA(Position.class)))
                .thenReturn(new Symbol("X"))
                .thenReturn(new Symbol("Y"))
                .thenReturn(new Symbol("Z"))
                .thenReturn(Symbol.EMPTY);

        ComputerPlayer computerPlayer = new ComputerPlayer(new Symbol("C"), "Computer", board);
        Move move = computerPlayer.nextMove();
        assertThat(move.getPosition().getX()).isLessThan(board.getGridSize());
        assertThat(move.getPosition().getY()).isLessThan(board.getGridSize());
        assertThat(move.getSymbol()).isEqualTo(new Symbol("C"));

        Mockito.verify(board, times(4)).getSymbolForPosition(isA(Position.class));

    }
}