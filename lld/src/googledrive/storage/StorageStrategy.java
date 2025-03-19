package googledrive.storage;

import googledrive.filesystemcomponent.File;

public interface StorageStrategy 
{
	void saveFile(File file);
	File getFile(String fileName);

}
