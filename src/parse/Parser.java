package parse;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class Parser {


	/**
	 * A = Average
	 * S = Std Dev
	 * Mi = Min
	 * Ma = Max
	 * SQ = Sum of Squares
	 * V = Variance
	 */

	public static String parse(String information, SummaryStatistics stats){


		StringBuilder stringBuilder = new StringBuilder();

		if(information.contains("A")){
			stringBuilder.append("Average: " + stats.getMean()+ "\n");
		}

		if(information.contains("S")){
			stringBuilder.append("Std Dev: " + stats.getStandardDeviation()+ "\n");
		}

		if(information.contains("Mi")){
			stringBuilder.append("Min: " + stats.getMin()+ "\n");
		}

		if(information.contains("Ma")){
			stringBuilder.append("Max: " + stats.getMax()+ "\n");
		}

		if(information.contains("SQ")){
			stringBuilder.append("Sum of Squares: " + stats.getSumsq()+ "\n");
		}

		if(information.contains("V")){
			stringBuilder.append("Variance: " + stats.getVariance() + "\n");
		}


		return stringBuilder.toString();
	}

}
