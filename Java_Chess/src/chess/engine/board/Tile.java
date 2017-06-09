package chess.engine.board;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import chess.engine.board.Tile.EmptyTile.OccupiedTile;
import chess.engine.piece.Piece;

public abstract class Tile {

	protected final int tileCoordinate;
	
	private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

	private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
		final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();
		for (int i = 0; i < 64; i++) {
			emptyTileMap.put(i, new EmptyTile(i));
		}
		return ImmutableMap.copyOf(emptyTileMap);
	}

	public static Tile createTile(final int tileCoordinate, final Piece piece) {

		if (piece == null) {
			return EMPTY_TILES_CACHE.get(tileCoordinate);
		}
		else
		return new OccupiedTile(tileCoordinate, piece);
	}

	Tile(int tileCoordinate) {
		this.tileCoordinate = tileCoordinate;
	}

	public abstract boolean isTileOccupied();

	public abstract Piece getPiece();

	public static final class EmptyTile extends Tile {
		EmptyTile(int coordinate) {
			super(coordinate);
		}

		@Override
		public boolean isTileOccupied() {
			return false;
		}

		@Override
		public Piece getPiece() {
			return null;
		}

		public static final class OccupiedTile extends Tile {
			private Piece pieceOnTile;

			OccupiedTile(int tileCoordinate, Piece pieceOnTile) {
				super(tileCoordinate);
				this.pieceOnTile = pieceOnTile;
			}

			@Override
			public boolean isTileOccupied() {
				return true;
			}

			@Override
			public Piece getPiece() {
				return this.pieceOnTile;
			}

		}
	}
}
