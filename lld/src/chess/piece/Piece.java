package chess.piece;

import chess.board.ChessBoard;
import chess.move.Move;

public  class Piece 
{
	 private char colour,type;
	 private Move moves[];
	 
	 Piece(char colour,char type)
	 {
		 this.colour=colour;
		 this.type=type;
		 moves=new Move[0];
	 }
	 
	 public Piece(char colour,char type,Move moves[])
	 {
		 this(colour,type);
		 this.moves=moves;
		 
	 }
     
	 public boolean canMove(ChessBoard board,int startRow,int startCol,int endRow,int endCol)
	 {
		 for(Move move:moves)
		 {
			 if(move.canMove(board, startRow, startCol, endRow, endCol))return true;
		 }
		return false;
	 }
	public char getColour() {
		return colour;
	}

	public char getType() {
		return type;
	}
	 
	 
}
