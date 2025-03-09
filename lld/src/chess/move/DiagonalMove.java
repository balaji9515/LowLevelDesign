package chess.move;

import chess.board.ChessBoard;

public class DiagonalMove implements Move {

	@Override
	public boolean canMove(ChessBoard board, int startRow, int startCol, int endRow, int endCol) 
	{
		
         int rowDelta=endRow-startRow;
         int colDelta=endCol-startCol;
         
         if(Math.abs(colDelta)!=Math.abs(rowDelta))return false;
         
         colDelta=colDelta>0?1:-1;
         rowDelta=rowDelta>0?1:-1;
         
         while(startRow!=endRow)
         {
        	 if(board.getPiece(startRow, startCol)!=null)
        	 {
        		 return false;
        	 }
        	 
        	 startRow+=rowDelta;
        	 startCol+=colDelta;
         }
		return false;
         
	}

}
