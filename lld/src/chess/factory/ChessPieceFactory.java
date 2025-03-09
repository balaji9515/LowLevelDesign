package chess.factory;

import chess.move.DiagonalMove;
import chess.move.Move;
import chess.move.StraightMove;
import chess.piece.King;
import chess.piece.Knight;
import chess.piece.Pawn;
import chess.piece.Piece;

public class ChessPieceFactory
{
	Move straightMove=new StraightMove();
	Move diagonalMove=new DiagonalMove();
    private static ChessPieceFactory instance;
    private ChessPieceFactory()
    {
    	
    }
    public static ChessPieceFactory getInstance()
    {
    	if(instance!=null)
    	
    		return instance;
    		
    		
 
    		synchronized (ChessPieceFactory.class) 
    		{
    			if(instance==null)
    			{
    				instance=new ChessPieceFactory();
    			}
				
			}
    		
    	return instance;
    }
     
    public Piece createPiece(char colour,char type)
    {
    	switch(type)
    	{
    	  case 'Q':return new Piece(type,colour,new Move[] {straightMove,diagonalMove});
    	  case 'R':return new Piece(type,colour,new Move[] {straightMove});
    	  case 'B':return new Piece(type,colour,new Move[] {diagonalMove});
    	  case 'K':return new King(type,colour);
    	  case 'H':return new Knight(colour, type);
    	  case 'P':return new Pawn(type,colour);    	  
    	}
    	return null;
    }
}
