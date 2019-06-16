package org.secure.retirement.home.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AnalysisMix {
	
	   AnalysisMix(@JsonProperty("sensor_mac") String sensor_mac,
            @JsonProperty("sensor_ip") String sensor_ip,
            @JsonProperty("type_sensor_name") String type_sensor_name,
	   		@JsonProperty("room_name") String room_name,
			@JsonProperty("historic_datetime") String historic_datetime, 
            @JsonProperty("historic_value") String historic_value,
			@JsonProperty("countAnal") String countAnal,
			@JsonProperty("countAll") String countAll,
			@JsonProperty("countType") String countType,
			@JsonProperty("countRoom") String countRoom, 
			@JsonProperty("countDate") String countDate
			){}
	   
	   
   

}
