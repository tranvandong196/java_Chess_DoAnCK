package chess.engine.piece;

import java.util.List;

import chess.engine.Alliance;
import chess.engine.board.Board;
import chess.engine.board.Move;


public abstract class Piece {

	final Alliance pieceAlliance;
	final int piecePosition;

	Piece(final Alliance alliance,final int piecePosition) {
          
          this.piecePosition = piecePosition;
          this.pieceAlliance = alliance;
      }
	
	public abstract List<Move> calculateLegalMoves(final Board board);

	public Alliance getPieceAllegiance() {
		// TODO Auto-generated method stub
		return this.pieceAlliance;
	}
}
