package chess.game;

import chess.board.ChessBoard;
import chess.board.Status;

public class Game {
   
	
	private ChessBoard chessBoard;
	
	public void init(String[][] chessBoard) 
	{
		// TODO Auto-generated method stub
		this.chessBoard=new ChessBoard(chessBoard);
		
	}

	
	public String move(int startRow, int startCol, int endRow, int endCol) 
	{
		// TODO Auto-generated method stub
		return chessBoard.move(startRow, startCol, endRow, endCol);
	}

	
	public Status getGameStatus() 
	{
		// TODO Auto-generated method stub
		return chessBoard.getGameState();
	}

	
	public int getNextTurn() {
		// TODO Auto-generated method stub
		
		if(chessBoard.gameState!=Status.Active)return -1;
		return chessBoard.getNextTurn();
	}

}
