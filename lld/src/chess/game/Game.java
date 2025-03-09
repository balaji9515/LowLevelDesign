package chess.game;

import chess.board.ChessBoard;
import chess.board.Status;

public class Game implements Q08ChessBoardInterface {
   
	
	private Helper08 helper;
	private ChessBoard chessBoard;
	@Override
	public void init(Helper08 helper, String[][] chessBoard) 
	{
		// TODO Auto-generated method stub
		this.helper=helper;
		this.chessBoard=new ChessBoard(chessBoard);
		
	}

	@Override
	public String move(int startRow, int startCol, int endRow, int endCol) 
	{
		// TODO Auto-generated method stub
		return chessBoard.move(startRow, startCol, endRow, endCol);
	}

	@Override
	public Status getGameStatus() 
	{
		// TODO Auto-generated method stub
		return chessBoard.getGameState();
	}

	@Override
	public int getNextTurn() {
		// TODO Auto-generated method stub
		
		if(chessBoard.gameState!=Status.Active)return -1;
		return chessBoard.getNextTurn();
	}

}
