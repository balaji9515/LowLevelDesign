package googledrive.operation;

public abstract class FileOperation 
{
	
	
	public final void execute()
	{
		if(validate())
		{
			performOperation();
			logOperation();
		}
	}
	public abstract boolean validate();
	public abstract void performOperation();
	public abstract void logOperation();
	

}
