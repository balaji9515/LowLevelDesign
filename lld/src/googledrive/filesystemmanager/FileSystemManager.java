package googledrive.filesystemmanager;

import googledrive.filesystemcomponent.Folder;
import googledrive.storage.LocalStorage;
import googledrive.storage.StorageStrategy;

public class FileSystemManager 
{
	private static FileSystemManager instance;
	private Folder root;
	private StorageStrategy storageStrategy;
	
	
	private FileSystemManager()
	{
		this.root=new Folder("root");
		this.storageStrategy=new LocalStorage();
	}
	
	public static FileSystemManager getInstance()
	{
		if(instance==null)
		{
			synchronized (FileSystemManager.class) 
			{
				if(instance==null)
				{
					instance=new FileSystemManager();
				}
			}
		}
		
		return instance;
	}
	
	public Folder getRoot()
	{
		return root;
	}

	public StorageStrategy getStorageStrategy() 
	{
		return storageStrategy;
	}

	public void setStorageStrategy(StorageStrategy storageStrategy) 
	{
		this.storageStrategy = storageStrategy;
	}
	
	

}
