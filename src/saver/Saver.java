package saver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import reader.Reader.ReaderInformation;
import reader.Template_Object;

public class Saver {

	private File outputFile;
	private String VariableName;

	public Saver(String string, String VariableName) {
		outputFile = new File(string);
		this.VariableName = VariableName;
	}

	public void saveAsCsv(List<ReaderInformation> information,
			List<Template_Object> to, String[] parameterValues) {


		PrintWriter pw = null;
		try {
			pw = new PrintWriter(outputFile);

			for(int j = 0 ; j < to.size() ; j ++){
				pw.print(to.get(j).getName() + ",");
			}

			pw.println(VariableName);

			for(int k = 0 ; k < information.size() ; k ++){

				List<List<Double>> fileInformation = information.get(k).getInformation();

				for(int i = 0 ; i < fileInformation.size() ; i ++){

					for(int j = 0 ; j < to.size() ; j ++){
						pw.print(fileInformation.get(i).get(j) + ",");
					}

					pw.println(parameterValues[k]);
					pw.flush();
				}
			}

		} catch (FileNotFoundException e) {
			throw new Error(e);
		}
		finally {
			if(pw != null){
				pw.close();
			}
		}



	}

}
