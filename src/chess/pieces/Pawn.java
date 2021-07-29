package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0);
		
		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			//se a posicao de uma linha acima existir e estiver vazia ele pode mover pra la
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//no primeiro movimento ele pode mover duas casas
			p.setValues(position.getRow() - 2, position.getColumn());
			//para mover duas casas a primeira casa tb tem que estar livre, seria o teste do p2
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			//se a posicao de uma linha acima existir e estiver vazia ele pode mover pra la
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//testando as duas casas nas diagonais
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			//se a posicao de uma linha acima existir e estiver vazia ele pode mover pra la
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			//se a posicao de uma linha acima existir e estiver vazia ele pode mover pra la
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		else {
			p.setValues(position.getRow() + 1, position.getColumn());
			//se a posicao de uma linha acima existir e estiver vazia ele pode mover pra la
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//no primeiro movimento ele pode mover duas casas
			p.setValues(position.getRow() + 2, position.getColumn());
			//para mover duas casas a primeira casa tb tem que estar livre, seria o teste do p2
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			//se a posicao de uma linha acima existir e estiver vazia ele pode mover pra la
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			//testando as duas casas nas diagonais
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			//se a posicao de uma linha acima existir e estiver vazia ele pode mover pra la
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			//se a posicao de uma linha acima existir e estiver vazia ele pode mover pra la
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}

		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
