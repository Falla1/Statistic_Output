package reader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFileChooser;

public class Reader {

	//A list of the files, each list has a list of values.
	private List<List<Double>> informationAboutFiles = new ArrayList<List<Double>>();

	/**
	 * Accepts files to be passed through a GUI
	 * @param fileToOutput
	 */
	public Reader(List<Template_Object> to){

		JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		chooser.showOpenDialog(chooser);
		File[] files = chooser.getSelectedFiles();

		System.out.println("Using files:");

		for(int i = 0 ; i < files.length ; i ++){

			System.out.print(files[i] + " ");

		}

		readFile(files,to);

	}

	/**
	 * Accepts files to be passed through CLI
	 * @param fileToOutput
	 * @param fileToRead
	 */
	public Reader(List<Template_Object> to, String... fileToRead){

		File[] files = new File[fileToRead.length];

		for(int i = 0 ; i < files.length ; i ++){
			files[i] = new File(fileToRead[i]);
		}

		readFile(files,to);

	}


	private void readFile(File[] files, List<Template_Object> to){

		for(int i = 0 ; i < files.length; i ++){

			informationAboutFiles.add(Data_Retriever.getData(files[i], to));

		}

	}

	/**
	 * Returning information about the files
	 * @return
	 */
	public List<List<Double>> getInformation() {
		return Collections.unmodifiableList(informationAboutFiles);
	}

}
