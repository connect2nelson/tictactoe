package com.board.TicTacToe.config;

import java.io.IOException;

public interface ConfigReader {
    GameConfiguration readGameConfig() throws IOException;
}
