package org.secure.retirement.home.service.cache;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


import org.secure.retirement.home.common.Historic;
import org.secure.retirement.home.common.Historics;
import org.secure.retirement.home.common.Sensor;
import org.secure.retirement.home.common.Type_sensor;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class GuavaCache {
   
	private Map<Integer, Historics> att_data;
	
	private Sensor att_sensor;
	private LoadingCache<Integer, Historics> cache;
	private Historics att_historics;
	
	public static void main(String args[]) {
		Sensor s1 = new Sensor(1,new Type_sensor(1,"",3),10, 12);
		Historic historic1 = new Historic(10, s1, 10.5);	
		Historic historic2 = new Historic(11, s1, 10.9);	
		Historic historic3 = new Historic(12, s1, 10.12);	
		Historic historic4 = new Historic(13, s1, 14);	
		
		GuavaCache g1 = new GuavaCache(s1);
		System.out.println("creation");
		g1.edition();
		
		System.out.println("edition 1");
		g1.edition(historic1);
		
		System.out.println("edition 2");
		g1.edition(historic2);
		
		System.out.println("edition 3");
		g1.edition(historic3);
		
		System.out.println(" edition 4");
		g1.edition(historic4);
		System.out.println("fin edition 4");
		
	}
	
	public GuavaCache(Sensor param_sensor) {
		this.att_sensor = param_sensor;
	}
	
	private void create() {
      this.cache = 
         CacheBuilder.newBuilder()
         .maximumSize(100)                             // maximum 100 records can be cached
         .expireAfterAccess(120, TimeUnit.SECONDS)     // cache will expire after 30 minutes of access
         .build(new CacheLoader<Integer, Historics>() {  // build the cacheloader

			@Override
			public Historics load(Integer key) throws Exception {
				// TODO Auto-generated method stub
				return getValue();
			}
      });
	}
	
	public static GuavaCache [] createAllCach(ArrayList<Sensor> param_sensors_array) {
		GuavaCache []gc = new GuavaCache [ param_sensors_array.size()];
		for(int i = 0 ; i <  param_sensors_array.size() ; i++) {
			gc[i] = new GuavaCache(param_sensors_array.get(i));
			gc[i].edition();
		}
		return gc;
	}
	
	public Historics select(){
       Historics to_return = null;
		try {
         //cache will be populated with corresponding
         to_return = this.cache.get(this.getAtt_sensor().getSensor_id());
      } catch (ExecutionException e) {
         e.printStackTrace();
      }
      return to_return;
   }

   private Historics getValue() {
	   this.att_data = new HashMap<Integer, Historics>();
	   this.att_data.put(att_sensor.getSensor_id(), att_historics);
	   //database.containsKey(key);
	   for (Integer i : this.att_data.keySet()) {
		   System.out.println("key: " + i + " value: " + this.att_data.get(i).toString());
	   }
	   return this.att_data.get(att_sensor.getSensor_id());		
   }

   public boolean isCurrentRisq(int param_iter) {
	boolean to_return = false;
	double value = this.getAtt_historics().getHistoric_array().get(param_iter).getHistoric_value();
	double min = this.getAtt_sensor().getSensor_min();
	double max = this.getAtt_sensor().getSensor_max();
	System.out.println("param_iter="+param_iter+" min: "+min+" max: "+max+" value: "+value);
	if (min > value || value > max ) {
		to_return = true;
	}
	return to_return; 
   }
   
   public boolean isRisq() {
		boolean to_return = false;
		int size = this.getAtt_historics().getHistoric_array().size();
		//if((this.getAtt_sensor().getType_sensor().getType_sensor_interval()) == size) {
			for(int i = 0 ; (i < size) && !to_return ; i++) {
				to_return = isCurrentRisq(i);
			}
		//}
		return to_return;
   }
   
   public boolean isCurrentFailure(int param_iter, Instant param_instant_ref) {
		boolean to_return = false;
		Instant value = this.getAtt_historics().getHistoric_array().get(param_iter).getHistoric_datetime();
		System.out.println("param_instant_ref = "+param_instant_ref+" value:"+value);
		if (!( param_instant_ref.isAfter(value) )) {
			to_return = true;
			System.out.println("param_iter="+param_iter+"isCurrentFAILURE/if param_instant_ref.isAfter(value)/");
		}
		else {
			System.out.println("param_iter="+param_iter+"isCurrentFAILURE/else param_instant_ref.isAfter(value)/");
			//this.getAtt_historics().getHistoric_array().remove(param_iter);
		}
		return to_return; 
	   }
   
   public boolean isFailure() {
		boolean to_return = true;
		int val_interval = this.getAtt_sensor().getType_sensor().getType_sensor_interval();
		int val_size = this.getAtt_historics().getHistoric_array().size();
		Instant value = this.getAtt_historics().getHistoric_array().get(val_size).getHistoric_datetime();
		if((this.getAtt_sensor().getType_sensor().getType_sensor_interval()+1) == val_size) {
			for(int i = 0 ; (i < val_size) && to_return ; i++) {
				to_return = isCurrentFailure(i,value);
				System.out.println("i: "+i+" to_return : "+to_return);
			}
		}
		return to_return;
  }
   public void removeHistoric() {
	   if(	this.getAtt_sensor().getType_sensor().getType_sensor_interval() <=
			this.getAtt_historics().getHistoric_array().size()
		) {
		   this.att_historics.getHistoric_array().remove(0);
	   }
   }

   public boolean edition(Historic param_historic) {
	   
	   this.cache.invalidate(this.getAtt_sensor().getSensor_id());
	   if(this.getAtt_historics().getHistoric_array()==null) {
		   ArrayList<Historic> historic_array = new ArrayList<Historic>();
		   this.setAtt_historics(new Historics(this.getAtt_sensor().getSensor_id(),historic_array));
	   }
	   try {
		   removeHistoric();
		   this.getAtt_historics().getHistoric_array().add(param_historic);
		   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   create();
	   System.out.println(this.getAtt_historics().getHistoric_array().toString());
	   return this.isRisq();
   }
   
   public void edition() {
	   try {
		   this.setAtt_historics(select());
		   System.out.println(this.getAtt_historics().toString());
		   cache.invalidate(this.getAtt_sensor().getSensor_id());
	   }
	   catch(Exception e) {
		   System.out.println("do not exist");
		   ArrayList<Historic> historic_array = new ArrayList<Historic>();
		   this.setAtt_historics(new Historics(this.getAtt_sensor().getSensor_id(),historic_array));
	   }
	   create();
	   this.setAtt_historics(select()); //?
	   System.out.println(this.getAtt_historics().toString());
   }





	/**
	 * @return the att_sensor
	 */
	public Sensor getAtt_sensor() {
		return att_sensor;
	}


	/**
	 * @param att_sensor the att_sensor to set
	 */
	public void setAtt_sensor(Sensor att_sensor) {
		this.att_sensor = att_sensor;
	}


	/**
	 * @return the att_historics
	 */
	public Historics getAtt_historics() {
		return att_historics;
	}


	/**
	 * @param att_historics the att_historics to set
	 */
	public void setAtt_historics(Historics att_historics) {
		this.att_historics = att_historics;
	}



}