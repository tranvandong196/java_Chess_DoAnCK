package chess.engine.classic.player.ai;

import chess.engine.classic.board.Board;
import chess.engine.classic.board.Move;

public interface MoveStrategy {

    long getNumBoardsEvaluated();

    Move execute(Board board);

}
