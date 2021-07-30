package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "P";
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
			
			//#Movimento especial En Passant branco
			//so posso fazer o movimento se o peao estiver na linha 5 do xadrez ou 3 da matriz
			if (position.getRow() == 3) {
				//posicao na esquerda do peao
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				// se a posicao existe, se tem uma peca oponente e se a peca que está la está vulneravel ao En Passant
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					//peao pode mover para a posicao acima do peao vulneravel
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				//posicao na direita do peao
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				// se a posicao existe, se tem uma peca oponente e se a peca que está la está vulneravel ao En Passant
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					//peao pode mover para a posicao acima do peao vulneravel
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
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
			
			//#Movimento especial En Passant preto
			//so posso fazer o movimento se o peao estiver na linha 4 do xadrez ou 4 da matriz
			if (position.getRow() == 4) {
				//posicao na esquerda do peao
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				// se a posicao existe, se tem uma peca oponente e se a peca que está la está vulneravel ao En Passant
				if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					//peao pode mover para a posicao acima do peao vulneravel
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				//posicao na direita do peao
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				// se a posicao existe, se tem uma peca oponente e se a peca que está la está vulneravel ao En Passant
				if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					//peao pode mover para a posicao acima do peao vulneravel
					mat[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}

		return mat;
	}

}
