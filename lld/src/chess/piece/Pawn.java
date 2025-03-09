package chess.piece;

import chess.board.ChessBoard;

public class Pawn extends Piece {

	public Pawn(char colour, char type) {
		super(colour, type);
		// TODO Auto-generated constructor stub
	}

	
	public boolean canMove(ChessBoard board,int startRow,int startCol,int endRow,int endCol)
	{
		Piece pawn=board.getPiece(startRow,startCol);
		
		if(board.getPiece(endRow,endCol)==null)
		{
			if(startCol!=endCol)
			{
				return false;
			}
			return (pawn.getColour()=='W' && endRow-startRow==1)||(pawn.getColour()=='B' && endRow-startRow==-1);
		}
		else
		{
			 if(Math.abs(startCol-endCol)!=1) return false;
		      return (pawn.getColour()=='W' && endRow-startRow==1)
		              ||  (pawn.getColour()=='B' && endRow-startRow==-1);
			
		}
		
		
	}

}
