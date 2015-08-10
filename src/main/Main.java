package main;

import java.util.Arrays;

import analyse.Analyser;
import reader.Reader;
import reader.Template_Object;
import reader.Template_Reader;

public class Main {


	/**
	 * 0 - Template File Name
	 * 1 - Output File
	 * 2... -
	 *
	 * @param args
	 */
	public Main(String args[]){

		if(!(args.length >= 2)){
			throw new Error("Not enough args");
		}

		Template_Reader to = new Template_Reader(args[0]);

		Reader reader;

		if(args.length >= 3){

			String[] outputFiles;

			//TODO Check if this works
			outputFiles = Arrays.copyOfRange(args, 2, args.length);

			reader = new Reader(to.getInformation(),outputFiles);
		}
		else{
			reader = new Reader(to.getInformation());
		}

		Analyser a = new Analyser(args[1]);
		a.processData(reader.getInformation(),to.getInformation());

		a.saveData(to.getInformation());

	}

	public static void main(String args[]){
		new Main(args);
	}

}
