package org.secure.retirement.home.simulator.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.secure.retirement.home.simulator.frame.FrameSimulator;


/** Assumes UTF-8 encoding. JDK 7+. */
public final class Parser {

  public static void to_parse(int param_sensor_id, FrameSimulator param_frame) {
	  
	  try {
			File file = new File("data_"+param_sensor_id+".properties");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			line = bufferedReader.readLine();
			System.out.println("line: "+line);
			String[] lines = line.split(",");
			for (int i = 0; i<lines.length; i++) {
				stringBuffer.append(lines[i]);
				stringBuffer.append("\n");
				ArrayList<String> val_history = new ArrayList<String>();
				val_history.add(param_sensor_id+"/"+lines[i]);
				try {
					ClientTransmission.transmission("Historic", "ADD", val_history, param_frame);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
  
  /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser.to_parse(1, new FrameSimulator());
	}

  
} 