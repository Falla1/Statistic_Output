package reader;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFileChooser;

public class Reader {


	private List<ReaderInformation> information = new ArrayList<ReaderInformation>();

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
		information.add(new ReaderInformation());
		readFile(files,to,0);

	}

	/**
	 * Accepts files to be passed through CLI
	 * @param args
	 * @param fileToOutput
	 * @param fileToRead
	 */
	public Reader(List<Template_Object> to, String args, String... fileToRead){

		List<List<File>> filesForEach = new ArrayList<List<File>>();

		File[] filesInDir = new File(args).listFiles();

		for(int j = 0 ; j < fileToRead.length ; j ++){
			filesForEach.add(new ArrayList<File>());
			for(int i = 0 ; i < filesInDir.length ; i ++ ){

				if(filesInDir[i].getName().contains(fileToRead[j])){
					filesForEach.get(j).add(filesInDir[i]);
				}
			}
		}

		for(int i = 0 ; i < filesForEach.size() ; i ++){
			List<File> files = filesForEach.get(i);
			File[] fileArray = new File[files.size()];
			fileArray = files.toArray(fileArray);
			information.add(new ReaderInformation());
			readFile(fileArray,to, i);
		}




	}


	private void readFile(File[] files, List<Template_Object> to, int informationValue){

		for(int i = 0 ; i < files.length; i ++){

			information.get(informationValue).add(Data_Retriever.getData(files[i], to));

		}
	}



	public class ReaderInformation{

		//A list of the files, each list has a list of values.
		private List<List<Double>> informationAboutFiles = new ArrayList<List<Double>>();



		/**
		 * Returning information about the files
		 * @return
		 */
		public List<List<Double>> getInformation() {
			return Collections.unmodifiableList(informationAboutFiles);
		}



		public void add(List<Double> data) {
			informationAboutFiles.add(data);
		}

	}



	public List<ReaderInformation> getInformation() {
		return information;
	}

}
