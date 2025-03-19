package googledrive.filesystemcomponent;

import java.util.HashMap;
import java.util.Map;

import googledrive.permissionDecorator.PermissionDecorator;

public class Folder implements FileSystemComponent
{
     
	private String name;
	private Map<String,FileSystemComponent>child;

	private PermissionDecorator permissions;
	
	public Folder(String name)
	{
		super();
		this.name = name;
		this.child = new HashMap<String, FileSystemComponent>();
		this.permissions = new PermissionDecorator();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) 
	{
		// TODO Auto-generated method stub
		this.name=name;
	}

	@Override
	public void addFile(FileSystemComponent fileSystemComponent) 
	{
		// TODO Auto-generated method stub
		
	    child.put(fileSystemComponent.getName(),fileSystemComponent);
		
	}

	@Override
	public void deleteFile(FileSystemComponent fileSystemComponent) {
		// TODO Auto-generated method stub
		
		child.remove(fileSystemComponent.getName());
		
	}

	@Override
	public void display(String indent) {
		// TODO Auto-generated method stub
		
		System.out.println(indent+"File:"+name);
		
		for(Map.Entry<String,FileSystemComponent>it:child.entrySet())
		{
			it.getValue().display(indent);
		}
		
	}
	
	public Map<String, FileSystemComponent> getChild() 
	{
		return child;
	}

	public PermissionDecorator getPermissions() {
		return permissions;
	}
	
	public FileSystemComponent getChild(String name)
	{
		return child.get(name);
	}
	
	

}
