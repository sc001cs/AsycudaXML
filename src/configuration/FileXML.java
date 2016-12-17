package configuration;

public class FileXML {

	private String path;
	private String absolutePath;
	private String createdDate;
	
	public FileXML(String path, String absolutePath, String createdDate) {
		super();
		this.path = path;
		this.absolutePath = absolutePath;
		this.createdDate = createdDate;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getAbsolutePath() {
		return absolutePath;
	}
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
}
