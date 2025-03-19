package googledrive.storage;

import googledrive.filesystemcomponent.File;
import googledrive.filesystemcomponent.NullFile;

public class Cloudstorage implements StorageStrategy{

	@Override
	public void saveFile(File file) 
	{
		// TODO Auto-generated method stub
		
		System.out.println("file saved in the cloud");
		
	}

	@Override
	public File getFile(String fileName) 
	{
		// TODO Auto-generated method stub
		System.out.println("file saved in the cloud");
		return new File(new NullFile());

	}

}
