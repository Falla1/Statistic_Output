package analyse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

import parse.Parser;
import reader.Template_Object;

public class Analyser {

	private File outputFile;
	private List<SummaryStatistics> stats;

	public Analyser(String string) {
		outputFile = new File(string);
	}

	/**
	 * Processes the information and saves the result to the output file
	 * @param information
	 * @param to
	 */
	public void processData(List<List<Double>> information, List<Template_Object> to){
		stats = new ArrayList<SummaryStatistics>();

		for(int i = 0 ; i < to.size() ; i ++){
			stats.add(new SummaryStatistics());
		}

		for(int i = 0 ; i < information.size() ; i ++){

			for(int j = 0 ; j < to.size() ; j ++){

				stats.get(j).addValue(information.get(i).get(j));

			}

		}
	}

	public void saveData(List<Template_Object> to) {

		if(stats == null){
			throw new Error("No stats to save");
		}

		PrintWriter pw = null;

		try {
			pw = new PrintWriter(outputFile);
			for(int i = 0 ; i < to.size() ; i ++){

				pw.println("Variable: " + to.get(i).getName());
				pw.println(Parser.parse(to.get(i).getInformation(), stats.get(i)));
			}
		} catch (FileNotFoundException e) {
			throw new Error("Failed to create the printer writer");
		}
		finally {
			if(pw != null){
				pw.flush();
				pw.close();
			}
		}


	}

}
