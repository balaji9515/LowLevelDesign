package chess.move;

import chess.board.ChessBoard;

public class StraightMove implements Move
{

	@Override
	public boolean canMove(ChessBoard board, int startRow, int startCol, int endRow, int endCol) 
	{
		 int rowDelta=endRow-startRow;
		    int colDelta=endCol-startCol;
		    if(endRow!=startRow && endCol!=startCol) return false;

		    if(startRow==endRow){
		      colDelta=colDelta>0?1:-1;
		      startCol+=colDelta;
		      while(startCol!=endCol){
		          if(board.getPiece(startRow, startCol)!=null) return false;
		          startCol+=colDelta;
		      }
		    }
		    if(startCol==endCol){
		        rowDelta=rowDelta>0?1:-1;
		        startRow+=rowDelta;
		        while(startRow!=endRow){
		            if(board.getPiece(startRow, startCol)!=null) return false;
		            startRow+=rowDelta;
		        }
		    }
		    return true;
		
	}
	

}
