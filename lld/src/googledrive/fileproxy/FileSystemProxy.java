package googledrive.fileproxy;

import googledrive.filesystemcomponent.FileSystemComponent;
import googledrive.permissionDecorator.PermissionDecorator;
import googledrive.permissionDecorator.Permissions;
import googledrive.user.User;

public class FileSystemProxy implements FileSystemComponent 
{
	FileSystemComponent realComponent;
	User currentUser;
	
	

	public FileSystemProxy(FileSystemComponent component, User currentUser) 
	{
		super();
		this.realComponent = component;
		this.currentUser = currentUser;
	}

	@Override
	public String getName() 
	{
		return realComponent.getName();
	}

	@Override
	public void setName(String name) {

           if(hasWritePermission())
           {
        	   realComponent.setName(name);
           }
           else
           {
        	   throw new SecurityException("no permission bro");
           }
		
	}

	@Override
	public void addFile(FileSystemComponent fileSystemComponent) 
	{
		if(hasWritePermission())
		{
			realComponent.addFile(realComponent);		}
		else
		{
			throw new SecurityException("no permission bro");
		}
	}

	@Override
	public void deleteFile(FileSystemComponent fileSystemComponent) 
	{
		// TODO Auto-generated method stub
		
		if(hasWritePermission())
		{
			fileSystemComponent.deleteFile(fileSystemComponent);
		}
		else
			throw new SecurityException("no permission bro");
	}

	@Override
	public void display(String indent) 
	{
		if(hasReadPermission())
		{
			realComponent.display(indent);
			
		}
		else
			throw new SecurityException("no permission bro");
		
		
		
	}
	
	
	private boolean hasWritePermission()
	{
         Permissions permission=realComponent.getPermissions().getUserPermission(currentUser);
         return permission==Permissions.WRITE;
	}
     
	private boolean hasReadPermission()
	{
		Permissions permission=realComponent.getPermissions().getUserPermission(currentUser);
        return permission!=Permissions.NONE;

	}

	@Override
	public PermissionDecorator getPermissions() {
		// TODO Auto-generated method stub
		return new PermissionDecorator();
	}
}
