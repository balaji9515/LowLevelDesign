package chess.move;

import chess.board.ChessBoard;

public interface Move 
{
	boolean canMove(ChessBoard board,int startRow,int startCol,int endRow,int endCol);

}
