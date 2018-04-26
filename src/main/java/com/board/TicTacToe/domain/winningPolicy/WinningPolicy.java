package com.board.TicTacToe.domain.winningPolicy;

import com.board.TicTacToe.domain.GameState;
import com.board.TicTacToe.domain.counter.LinearSymbolCountMap;
import com.board.TicTacToe.domain.Symbol;

public interface WinningPolicy {
    
    GameState computeGameState(LinearSymbolCountMap linearSymbolCountMap, Symbol symbol );

}
