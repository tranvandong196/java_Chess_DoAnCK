package chess.pgn;

import chess.engine.classic.board.Board;
import chess.engine.classic.board.Move;
import chess.engine.classic.player.Player;

public interface PGNPersistence {

    void persistGame(Game game);

    Move getNextBestMove(Board board, Player player, String gameText);

}
