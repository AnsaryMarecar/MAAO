/**
 * 
 */
package org.secure.retirement.home.client;

import java.util.Locale;
import org.secure.retirement.home.frame.FrameHome;
import org.secure.retirement.home.frame.FrameSettings;
import org.secure.retirement.home.frame.FrameType_sensor;

/**
 * @author Ansary MARECAR
 *
 */
public class AppClient {
	public static void main (String[] args) {
		Locale.setDefault(Locale.ENGLISH);
		//FrameHome frameHome = new FrameHome();
		FrameSettings frameSettings = new FrameSettings();
		System.out.println("FRAMEHome was launched");
	}

}
