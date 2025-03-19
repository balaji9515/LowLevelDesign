package googledrive.operation;

import googledrive.filesystemcomponent.File;
import googledrive.filesystemcomponent.Folder;

public class addOperation  extends FileOperation
{
	private Folder folder;
    private File file;
    
    
	public addOperation(Folder folder, File file)
	{
		
		this.folder = folder;
		this.file = file;
	}

	@Override
	public boolean validate() 
	{
		return folder.getChild(file.getName())==null;
	}

	@Override
	public void performOperation() {
		// TODO Auto-generated method stub
		folder.addFile(file);
	}

	@Override
	public void logOperation() {
		// TODO Auto-generated method stub
		System.out.println(file.getName()+" added in to the "+folder.getName());
	}

}
