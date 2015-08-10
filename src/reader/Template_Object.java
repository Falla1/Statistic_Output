package reader;

public class Template_Object {


	private int lineNumber;
	private String information;
	private String name;

	/**
	 * Holds the information about a line in the template
	 */
	public Template_Object(int lineNumber, String information, String name){
		this.lineNumber = lineNumber;
		this.information = information;
		this.name = name;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public String getInformation() {
		return information;
	}

	public String getName() {
		return name;
	}

}
