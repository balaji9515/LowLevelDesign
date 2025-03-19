package googledrive.filesystemcomponent;

import googledrive.permissionDecorator.PermissionDecorator;

public class NullFile implements FileSystemComponent{

	
	PermissionDecorator decorator;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public void setName(String name) {
		return;
		
	}

	@Override
	public void addFile(FileSystemComponent fileSystemComponent) {
		// TODO Auto-generated method stub
		
		return;
		
	}

	@Override
	public void deleteFile(FileSystemComponent fileSystemComponent)
	{
		// TODO Auto-generated method stub
		
		return ;
		
	}

	@Override
	public void display(String indent) {
		// TODO Auto-generated method stub
		
		System.out.println("null file");
		
	}

	public PermissionDecorator getPermissions() {
		return decorator;
	}

}
