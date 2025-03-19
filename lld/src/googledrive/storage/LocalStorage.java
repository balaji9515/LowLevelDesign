package googledrive.storage;

import java.util.HashMap;
import java.util.function.BiFunction;

import googledrive.filesystemcomponent.File;
import googledrive.filesystemcomponent.NullFile;



public class LocalStorage implements StorageStrategy {
	private HashMap<String,File> localStorage;

	@Override
	public void saveFile(File file) {
		// TODO Auto-generated method stub

		localStorage.put(file.getName(),file);

		System.out.println(file.getName() + ": file saved locally");

	}

	@Override
	public File getFile(String fileName) {
		return localStorage.getOrDefault(fileName,new File(new NullFile()));
	}

}
