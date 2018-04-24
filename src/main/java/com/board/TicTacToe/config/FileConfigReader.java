package com.board.TicTacToe.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileConfigReader implements ConfigReader {
    private static final String SIZE = "size";
    private static final String PLAYER_1_SYMBOL = "player1.symbol";
    private static final String PLAYER_2_SYMBOL = "player2.symbol";
    private static final String COMPUTER_SYMBOL = "computer.symbol";
    private File configFile;

    public FileConfigReader(File configFile) {
        this.configFile = configFile;
    }

    @Override
    public GameConfiguration readGameConfig() throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(configFile);
        prop.load(fileInputStream);
        int size = Integer.parseInt(prop.getProperty(SIZE));
        String player1Symbol = prop.getProperty(PLAYER_1_SYMBOL);
        String player2Symbol = prop.getProperty(PLAYER_2_SYMBOL);
        String computerSymbol = prop.getProperty(COMPUTER_SYMBOL);
        return new GameConfiguration(size, player1Symbol, player2Symbol, computerSymbol);
    }
}
