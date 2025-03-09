package chess.board;

import chess.factory.ChessPieceFactory;
import chess.piece.Piece;

public class ChessBoard 
{
	public Piece board[][];
	
	public ChessPieceFactory factory=ChessPieceFactory.getInstance();
	
	public Status gameState;
	
	public int nextTurn=0;
	
	public ChessBoard(String [][]chessBoard)
	{
		// TODO Auto-generated constructor stub
		board=new Piece[chessBoard.length][chessBoard[0].length];
		 for(int row=0;row<board.length;row++)
		      for(int col=0;col<board[0].length;col++)
		        if(chessBoard[row][col].length()>=2){
		          char color=chessBoard[row][col].charAt(0);
		          char type=chessBoard[row][col].charAt(1);
		          board[row][col] = factory.createPiece(color, type);
		          
		      }
		
	}
	
	public String move(int startRow, int startCol, int endRow, int endCol)
	{
		 if(gameState!=Status.Active) return "invalid";
		 Piece startPiece=getPiece(startRow, startCol);
		 Piece endPiece=getPiece(endRow, endCol);
		 if(startPiece==null ||!isValid(endRow, endCol))
		     return "invalid";
		 if(endPiece!=null && endPiece.getColour()
		         ==startPiece.getColour()) return "invalid";
		 if(!startPiece.canMove(this, startRow,
		     startCol, endRow, endCol)) return "invalid";
		 board[startRow][startCol]=null;
		 board[endRow][endCol]=startPiece;
		 nextTurn=nextTurn==0?1:0;
		 if(endPiece!=null && endPiece.getType()=='K')
		     gameState=endPiece.getColour()=='B'?Status.BlackWin:Status.WhiteWin;
		 if(endPiece==null) return "";
		//  return "WP";
		 return ""+endPiece.getColour()+endPiece.getType();
		}
	
	public Piece getPiece(int row, int col){
	    if(!isValid(row, col)) return null;
	    return board[row][col];
	}
	
	private boolean isValid(int row, int col) {
	    return row>=0 && row<board.length && col>=0 && col<board[0].length;
	}
	
	public int getNextTurn(){
	    return nextTurn;
	}

	public Status getGameState(){
	    return gameState;
	}
}
