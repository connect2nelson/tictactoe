package com.board.TicTacToe.domain;

import com.board.TicTacToe.domain.counter.SymbolCountMap;
import com.board.TicTacToe.exception.InvalidMoveException;
import com.board.TicTacToe.domain.winningPolicy.WinningPolicy;
import com.board.TicTacToe.exception.DuplicateMoveException;

import java.util.List;

public class Board {

    private final int gridSize;
    private int noOfVacantSpaces;
    private int rows, cols;

    private Symbol[][] grid;

    SymbolCountMap symbolCountMap;

    private WinningPolicy policy;

    public Board(int gridSize, WinningPolicy policy, List<Symbol> symbols) {
        this.rows = gridSize;
        this.cols = gridSize;
        this.gridSize = gridSize;
        this.noOfVacantSpaces = rows * cols;
        this.policy = policy;

        symbolCountMap = new SymbolCountMap(rows, symbols);

        initializeBoard(rows, cols);
    }

    private void initializeBoard(int rows, int cols) {
        grid = new Symbol[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }

    public int getNoOfVacantSpaces() {
        return noOfVacantSpaces;
    }

    public GameState accept(Move move) throws InvalidMoveException, DuplicateMoveException {

        checkIfInputMoveIsValid(move);

        noOfVacantSpaces--;
        registerTheInputMove(move);

        return policy.computeGameState(symbolCountMap, move.getSymbol());

    }

    private void registerTheInputMove(Move move) {
        int movePosX = move.getPosition().getX();
        int movePosY = move.getPosition().getY();
        grid[movePosX][movePosY] = move.getSymbol();
        symbolCountMap.updateCount(move);
    }

    private void checkIfInputMoveIsValid(Move move) throws
            InvalidMoveException, DuplicateMoveException {

        if (!isValid(move)) {
            throw new InvalidMoveException();
        }

        if (grid[move.getPosition().getX()][move.getPosition().getY()] != Symbol.EMPTY) {
            throw new DuplicateMoveException();
        }
    }

    private boolean isValid(Move move) {
        Position position = move.getPosition();
        return position.getX() < rows && position.getY() < cols;
    }

    public Symbol getSymbolForPosition(Position p) {
        return grid[p.getX()][p.getY()];
    }

    public int getGridSize() {
        return gridSize;
    }

    public void printBoard() {
        int boardSize = getGridSize();
        System.out.println("-----------------");
        System.out.println("Tic-Tac-Toe Board");
        System.out.println("-----------------");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(grid[i][j].getSymbol() + " | ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
}
