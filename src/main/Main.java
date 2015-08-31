package main;

import java.util.Arrays;

import analyse.Analyser;
import reader.Reader;
import reader.Template_Object;
import reader.Template_Reader;
import saver.Saver;

public class Main {


	/**
	 * 0 - csv or stats
	 * [if csv]
	 * 	1 - Template File Name
	 * 	2 - Output File
	 * 	3 - Name of Variable
	 *  4 - Variable number (Should be the same amount of file names to compare) (Seperated by a comma)
	 * 	5 - Directory of files
	 *  6...n - File names to compare
	 * [if stats]
	 * 	1 - Template File Name
	 * 	2 - Output File
	 * 	3... -
	 *
	 * @param args
	 */
	public Main(String args[]){

		if(!(args.length >= 3)){
			throw new Error("Not enough args");
		}

		int buffer;

		if(!args[0].equals("csv")
				&& !args[0].equals("stats")){
			throw new Error("Make sure the first arg is : csv or stats");
		}

		Template_Reader to = new Template_Reader(args[1]);

		Reader reader;

		if(args.length >= 7){

			String[] fileNames;

			fileNames = Arrays.copyOfRange(args, 6 , args.length);

			reader = new Reader(to.getInformation(),args[5],fileNames);
		}
		else{
			reader = new Reader(to.getInformation());
		}

		if(args[0].equals("csv")){

			String [] parameterValues = args[4].split(",");

			Saver saver = new Saver(args[2],args[3]);
			saver.saveAsCsv(reader.getInformation(),to.getInformation(),parameterValues);
		}
		else if(args[0].equals("stats")){
			Analyser a = new Analyser(args[2]);
			//TODO Fix this
			//a.processData(reader.getInformation(),to.getInformation());
			//a.saveData(to.getInformation());
		}

	}

	public static void main(String args[]){
		new Main(args);
	}

}
