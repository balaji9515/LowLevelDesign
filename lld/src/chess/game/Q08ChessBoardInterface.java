package chess.game;

import chess.board.Status;

public interface Q08ChessBoardInterface 
{
	void init(Helper08 helper, String[][] chessboard);
	String move(int startRow, int startCol, int endRow, int endCol);
	Status getGameStatus();
	int getNextTurn();
}

	class Helper08
	{
	   void print(String s)
	   {
		   System.out.print(s);
	    }
	   void println(String s)
	   {
		   print(s+"\n");
	    }
	}

