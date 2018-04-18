package domains;

import java.util.TreeSet;

public class CheckUserResponse {

	private Boolean result;
	private String message;
	private TreeSet<String> options;
	
	public CheckUserResponse() {
		super();
		this.options = new TreeSet<>();
	}
	
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TreeSet<String> getOptions() {
		return options;
	}
	public void setOptions(TreeSet<String> options) {
		this.options = options;
	}
}
