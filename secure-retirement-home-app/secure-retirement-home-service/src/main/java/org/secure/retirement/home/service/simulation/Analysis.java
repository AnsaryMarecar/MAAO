/**
 * 
 */
package org.secure.retirement.home.service.simulation;

/**
 * @author Ansary MARECAR
 *
 */
public class Analysis {
	Thread ti;
	public boolean analysisRisk(double param_value, int param_sensor_id) {
		
		boolean to_return = false;
		AnalysisRisk val_ar = new AnalysisRisk( param_sensor_id, param_value );
		//to_return = val_ar.seeMyLastValueCach();
		return to_return;
	}
	
	public boolean analysisFailure() {
		boolean to_return = false;
		
		return to_return;
	}
	public void analysis(double param_value, int param_sensor_id) {
		if (analysisFailure() && analysisRisk(param_value, param_sensor_id)) {
			
			
		}
	}
	
	
}
