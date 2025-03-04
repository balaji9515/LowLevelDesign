package chess.piece;

public abstract class Piece 
{
	private boolean white;
	private boolean dead=false;
	public abstract boolean isValid();
	public Piece(boolean white)
	{
		this.white = white;
	}
	
	public boolean isDead()
	{
		return dead;
	}
	
	public boolean isWhite()
	{
		return white;
	}
    
	public void setDead(boolean dead)
	{
		this.dead=dead;
	}
}
