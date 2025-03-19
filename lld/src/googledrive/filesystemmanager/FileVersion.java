package googledrive.filesystemmanager;

import java.security.Timestamp;

public class FileVersion 
{
	private String content;
	private Timestamp timestamp;
	public FileVersion(String content, Timestamp timestamp) {
		super();
		this.content = content;
		this.timestamp = timestamp;
	}
	public String getContent() {
		return content;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}

}
