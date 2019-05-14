/**
 * 
 */
package org.secure.retirement.home.simulator.client;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ansary MARECAR
 *
 */
public class CreateGeneratedValues {

	/**
	 * 
	 */
	public CreateGeneratedValues() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double min = 15;
		double max = 30;
		double[] array_double = new double [1000];
		for (int i = 0 ; i< 1000 ; i++) {
			double random = Math.random() * (max - min) + 15;
			System.out.print(random+",");
		}
	}

}
