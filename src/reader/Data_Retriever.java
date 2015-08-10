package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data_Retriever {


	public static List<Double> getData(File file, List<Template_Object> template){
		Scanner sc;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			throw new Error(e);
		}

		//Line number
		int i = 0;
		List<Double> data = new ArrayList<Double>();

		for(Template_Object to : template){

			//Template_Object line number
			int j = to.getLineNumber();
			String line = "";

			try{
				//We continue until we hit a line we are interested in
				//May need to hold onto the line we are interested in ... ?
				while(i != j){
					line = sc.nextLine();
					i++;
				}
			}
			catch (Exception e){
				throw new Error("It seems the template does not match the file: " + file.getAbsolutePath());
			}

			String[] seperatedData = line.split(Template_Reader.separator);

			if(seperatedData.length != 2){
				throw new Error("Invalid line in File: " + file.getAbsolutePath() + "\nLine: " + line + "\nNext line was: " + sc.nextLine());
			}

			data.add(Double.valueOf(seperatedData[1]));

		}

		return data;
	}
}
