package com.board.TicTacToe;


import com.board.TicTacToe.config.FileConfigReader;
import com.board.TicTacToe.config.GameConfiguration;
import com.board.TicTacToe.domain.Board;
import com.board.TicTacToe.domain.player.ComputerPlayer;
import com.board.TicTacToe.domain.player.HumanPlayer;
import com.board.TicTacToe.domain.player.Player;
import com.board.TicTacToe.domain.player.Players;
import com.board.TicTacToe.domain.winningPolicy.DefaultWinningPolicy;
import com.board.TicTacToe.input.ConsoleInputReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ConsoleApplication {

    public static void main(String[] args) throws IOException {

        ConsoleApplication consoleApplication = new ConsoleApplication();
        consoleApplication.playGame();
    }

    private void playGame() throws IOException, NullPointerException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader
                .getResource("configuration.properties")
                .getFile());

        FileConfigReader fileConfigReader = new FileConfigReader(file);
        GameConfiguration gameConfiguration = fileConfigReader.readGameConfig();

        int gridSize = gameConfiguration.getSize();

        Board board = new Board(gridSize, new DefaultWinningPolicy(), gameConfiguration.getListOfPlayerSymbols());

        Player player1 = new HumanPlayer(gameConfiguration.getPlayer1Symbol(), "Player 1", new ConsoleInputReader());
        Player player2 = new HumanPlayer(gameConfiguration.getPlayer2Symbol(), "Player 2", new ConsoleInputReader());
        Player player3 = new ComputerPlayer(gameConfiguration.getPlayer3Symbol(), "Computer", board);

        ArrayList<Player> playerList = new ArrayList<>();
        playerList.addAll(Arrays.asList(player1, player2, player3));

        //Randomize the player turns.
        Collections.shuffle(playerList);

        Players players = new Players(playerList);
        TicTacToeGame ticTacToeGame = new TicTacToeGame(board, players);
        ticTacToeGame.start();
    }
}
