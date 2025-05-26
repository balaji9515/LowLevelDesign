package googledrive;

import googledrive.fileproxy.FileSystemProxy;
import googledrive.filesystemcomponent.File;
import googledrive.filesystemcomponent.FileSystemComponent;
import googledrive.filesystemcomponent.Folder;
import googledrive.filesystemmanager.FileSystemManager;
import googledrive.filesystemmanager.FileSystemSearch;
import googledrive.observers.EmailObserver;
import googledrive.observers.FileAddObservable;
import googledrive.operation.FileOperation;
import googledrive.operation.addOperation;
import googledrive.permissionDecorator.Permissions;
import googledrive.storage.Cloudstorage;
import googledrive.user.Role;
import googledrive.user.User;

public class GoogleDrive 
{
	
	public static void main(String Args[])
	{
		User user1=new User("Balaji","1234",Role.ADMIN);
		User user2=new User("Bal","1345",Role.OTHER);
		
		FileSystemManager  fileSystemManager=FileSystemManager.getInstance();
		Folder root=fileSystemManager.getRoot();
		
		root.getPermissions().setPermission(user1,Permissions.WRITE);
		root.getPermissions().setPermission(user2,Permissions.WRITE);
		File resume=new File("Resume");
		resume.getPermissions().setPermission(user1,Permissions.WRITE);
		resume.getPermissions().setPermission(user2,Permissions.READ);
		FileOperation fileOperation=new  addOperation(root,resume);
		fileOperation.execute();
		FileAddObservable addObservable=new FileAddObservable();
		addObservable.addObserver(new EmailObserver());
		addObservable.notifyObservers("notification: file is added");
		
		
         FileSystemProxy fileSystemProxy=new FileSystemProxy(resume,user1);
         
         fileSystemProxy.display("");
         
         File x= (File) root.getChild("Resume");
          x.setContent("fjnwjfio");
          
          FileSystemSearch fileSystemSearch=new FileSystemSearch();
         FileSystemComponent file= fileSystemSearch.search(root,"Resume");
         
         
         fileSystemManager.setStorageStrategy(new Cloudstorage());
         
         fileSystemManager.getStorageStrategy().saveFile(resume);
         
         
          
          
         
		
		
	}

}
