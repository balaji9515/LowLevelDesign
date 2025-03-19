package googledrive.filesystemcomponent;

import googledrive.permissionDecorator.PermissionDecorator;

public interface FileSystemComponent 
{   
	String getName();
	void setName(String name);
	void addFile(FileSystemComponent fileSystemComponent);
	void deleteFile(FileSystemComponent fileSystemComponent);
	void display(String indent);
	PermissionDecorator getPermissions();	


}
