package googledrive.filesystemcomponent;

import java.util.ArrayList;
import java.util.List;

import googledrive.filesystemmanager.FileVersion;
import googledrive.permissionDecorator.PermissionDecorator;
import googledrive.storage.StorageStrategy;

public class File implements FileSystemComponent {
	private String fileName;

	private String content;
	StorageStrategy storageStrategy;
	private List<FileVersion> fileVersion;
	

	private PermissionDecorator permissions;

	public File(String fileNamme) 
	{
		super();
		this.fileName = fileNamme;
		this.content = "";
		fileVersion = new ArrayList<FileVersion>();
		this.permissions = new PermissionDecorator();
	}

	public File(NullFile nullFile) {
		// TODO Auto-generated constructor stub
		this.fileName = nullFile.getName();
	}

	public File(File file) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.fileName;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.fileName = name;

	}

	@Override
	public void addFile(FileSystemComponent fileSystemComponent) 
	{
		// TODO Auto-generated method stub

		System.out.println("file added successfully");
			

	}

	@Override
	public void deleteFile(FileSystemComponent fileSystemComponent) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("cannot add file");

	}

	@Override
	public void display(String indent) {
		// TODO Auto-generated method stub
		System.out.println(indent + "File:" + fileName);

	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<FileVersion> getFileVersions() {
		return fileVersion;
	}

	public PermissionDecorator getPermissions() {
		return permissions;
	}

}
