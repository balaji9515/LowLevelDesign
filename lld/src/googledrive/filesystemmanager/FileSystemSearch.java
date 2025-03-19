package googledrive.filesystemmanager;

import googledrive.filesystemcomponent.FileSystemComponent;
import googledrive.filesystemcomponent.Folder;

public class FileSystemSearch 
{
	public FileSystemComponent search (FileSystemComponent component,String name)
	{
		if(component.getName().equals(name))
		{
			return component;
		}
		if(component instanceof Folder)
		{
			 Folder folder = (Folder) component;
	            for (FileSystemComponent child : folder.getChild().values()) {
	                FileSystemComponent found = search(child, name);
	                if (found != null) {
	                    return found;
	                }
	            }
		}
		
		return null;
	}

}
