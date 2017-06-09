package chess.engine.piece;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import chess.engine.Alliance;
import chess.engine.board.Board;
import chess.engine.board.Move;
import chess.engine.board.Tile;

public class Knight extends Piece {

	private final static int[] CANDIDATE_MOVE_COORDINATES = { -17, -15, -10, -6, 6, 10, 15, 17 };

	Knight(final Alliance alliance, final int piecePosition) {
		super(alliance, piecePosition);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Move> calculateLegalMoves(Board board) {
		final List<Move> legalMoves = new ArrayList<>();
		for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
			final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
			if (isValidTileCoordinate(candidateDestinationCoordinate)) {
				final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
				if (!candidateDestinationTile.isTileOccupied()) {
					legalMoves.add(new Move());
				} else {
					final Piece pieceAtDestination = candidateDestinationTile.getPiece();
					final Alliance pieceAtDestinationAllegiance = pieceAtDestination.getPieceAllegiance();
					if (this.pieceAlliance != pieceAtDestinationAllegiance) {
						legalMoves.add(new Move());
					}
				}
			}
		}
		return ImmutableList.copyOf(legalMoves);
	}

	private boolean isValidTileCoordinate(int candidateDestinationCoordinate) {
		// TODO Auto-generated method stub
		return candidateDestinationCoordinate >= 0 && candidateDestinationCoordinate < 64;
	}
}
