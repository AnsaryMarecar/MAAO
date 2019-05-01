package org.secure.retirement.home.simulator.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Sensor;


/** Assumes UTF-8 encoding. JDK 7+. */
public final class Parser {


  
  public static ArrayList<Historic> to_parse(int param_sensor_id) {
	  ArrayList<Historic> val_history = new ArrayList<Historic>();
	  Sensor val_sensor;
	  try {
			File file = new File("data_"+param_sensor_id+".properties");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
				val_sensor = new Sensor(1);
				val_history.add(new Historic(val_sensor,20));
				
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  return val_history;
  }
  
  /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser.to_parse(1);
	}

  
} 