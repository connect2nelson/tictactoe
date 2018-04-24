package com.board.TicTacToe.domain.player;

import java.util.ArrayList;

public class Players {
    private ArrayList<Player> playerList;
    private int currentPlayerIndex;

    public Players(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public Player nextPlayer() {
        Player player = playerList.get(currentPlayerIndex);
        currentPlayerIndex++;
        if (currentPlayerIndex == playerList.size()) {
            currentPlayerIndex = 0;
        }
        return player;
    }

}
