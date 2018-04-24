package com.board.TicTacToe.config;

import com.board.TicTacToe.domain.Symbol;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;


public class FileConfigReaderTest {

    @Test
    public void shouldReadProperConfigurationFromFile() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader
                .getResource("configuration.properties")
                .getFile());

        FileConfigReader fileConfigReader = new FileConfigReader(file);
        GameConfiguration gameConfiguration = fileConfigReader.readGameConfig();
        assertEquals(gameConfiguration.getPlayer1Symbol(), new Symbol("X"));
        assertEquals(gameConfiguration.getPlayer2Symbol(), new Symbol("O"));
        assertEquals(gameConfiguration.getPlayer3Symbol(), new Symbol("C"));
        assertEquals(gameConfiguration.getSize(), 3);
    }

    @Test(expected = IOException.class)
    public void shouldThrowIoExceptionWhenFileNotFound() throws Exception {
        FileConfigReader fileConfigReader = new FileConfigReader(new File("test"));
        fileConfigReader.readGameConfig();
    }
}