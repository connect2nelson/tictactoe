package com.board.TicTacToe.domain.player;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class PlayersTest {

    private ArrayList<Player> playerList;
    private Players players;

    @Mock
    private HumanPlayer humanPlayer1;

    @Mock
    private HumanPlayer humanPlayer2;

    @Mock
    private ComputerPlayer computerPlayer;

    @Before
    public void setUp() throws Exception {
        playerList = new ArrayList<>();
        playerList.add(humanPlayer1);
        playerList.add(computerPlayer);
        playerList.add(humanPlayer2);
    }

    @Test
    public void shouldReturnNextPlayerInOrder() throws Exception {
        players = new Players(playerList);

        Player player = players.nextPlayer();
        assertThat(humanPlayer1).isEqualTo(player);


        player = players.nextPlayer();
        assertThat(computerPlayer).isEqualTo(player);


        player = players.nextPlayer();
        assertThat(humanPlayer2).isEqualTo(player);

    }

    @Test
    public void shouldCycleTheTurnsOfThePlayer() throws Exception {
        players = new Players(playerList);

        //Get the 3 players in sequence
        players.nextPlayer();
        players.nextPlayer();
        players.nextPlayer();

        //Cycle the turn to the player who started first
        Player player = players.nextPlayer();
        assertThat(humanPlayer1).isEqualTo(player);
    }
}