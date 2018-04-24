package com.board.TicTacToe.input;

import com.board.TicTacToe.domain.Position;

import java.util.Scanner;


public class ConsoleInputReader implements InputReader {

    @Override
    public Position getMarkerPosition() {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] split = input.split(",");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        return new Position(x, y);
    }
}
