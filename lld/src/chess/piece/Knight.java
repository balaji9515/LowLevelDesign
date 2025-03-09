package chess.piece;

import chess.board.ChessBoard;

public class Knight extends Piece{

	public Knight(char colour, char type)
	{
		super(colour, type);
		// TODO Auto-generated constructor stub
	}
	public boolean canMove(ChessBoard board,int startRow,int startCol,int endRow,int endCol)
	{
		int rowDelta=Math.abs(startRow-endRow);
		int colDelta=Math.abs(startCol-endCol);
		
		return (rowDelta==2 && colDelta==1)||(rowDelta==1 || colDelta==2);
	}
	

	

}
