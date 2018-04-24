#Build Status

[![Build Status](https://travis-ci.org/connect2nelson/tictactoe.svg?branch=master)](https://travis-ci.org/connect2nelson/tictactoe)


# Game Design And Assumptions

- Modelled a trivial TicTacToe Game in such a manner that TicTacToe board size is customizable to any nxn grid using an external configuration file.
- The symbol for each player can be chosen from the external configuration file.
- By default, there are 3 players out of which 2 are human players and later is a Computer player.
- Current algorithm has O(n) time and space complexity to determine whether a given move results a WIN / DRAW for the player making the move. The space required to store the symbol count for n-rows and n-cols along with the 2 diagonals is considerable if the number of players are more than the grid size..   

# How to run test :

``./gradlew clean build``