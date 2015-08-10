package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Template_Reader {

	/**
	 * A = Average
	 * S = Std Dev
	 * Mi = Min
	 * Ma = Max
	 * SQ = Sum of Squares
	 * V = Variance
	 */

	//Holds the information about the template file
	private List<Template_Object> information;
	private File templateFile;

	public static String separator;

	public Template_Reader(String templateFileName){
		information = new ArrayList<Template_Object>();

		try{
			templateFile = new File(templateFileName);
		}
		catch (Exception e){
			throw new Error(e);
		}
		readTemplate();
	}

	private void readTemplate(){

		Scanner sc;
		try {
			sc = new Scanner(templateFile);
		} catch (FileNotFoundException e) {
			throw new Error(e);
		}

		//Getting the separator between number and text.
		if(sc.hasNextLine()){
			separator = sc.next();
		}
		else{
			throw new Error("Template was empty");
		}

		int i = 0 ;

		//Retrieving the information from the template
		while(sc.hasNextLine()){

			String line = sc.nextLine();

			if(!line.isEmpty()){

				String[] splitLine = line.split(separator);

				if(splitLine.length != 2){
					throw new Error("Seems to be an error @: " + line);
				}
				information.add(new Template_Object(i,splitLine[1],splitLine[0]));
			}

			i++;
		}
	}

	public List<Template_Object> getInformation() {
		return Collections.unmodifiableList(information);
	}


}
