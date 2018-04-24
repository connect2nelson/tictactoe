package com.board.TicTacToe.domain.winningPolicy;

import com.board.TicTacToe.domain.GameState;
import com.board.TicTacToe.domain.counter.SymbolCountMap;
import com.board.TicTacToe.domain.Symbol;

public interface WinningPolicy {
    
    GameState computeGameState(SymbolCountMap symbolCountMap, Symbol symbol );

}
