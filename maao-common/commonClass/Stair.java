package commonClass;
/**
 * 
 */

/**
 * @author melissa.oussadi
 *
 */
public class Stair{
	
	private int 	stair_id;
	private String 	stair_name;
	
	public int getStair_id() {
		// TODO Auto-generated method stub
		return this.stair_id;
	}
	
	public void setStair_id(int stair_id) {
		// TODO Auto-generated method stub
		this.stair_id = stair_id;
	}
	
	public String getStair_name() {
		// TODO Auto-generated method stub
		return this.stair_name;
	}
	
	public void setStair_name(String stair_name) {
		// TODO Auto-generated method stub
		this.stair_name = stair_name;
		
	}
	
	public Stair() {
	}
	
	public Stair(int astair_id, String astair_name) {
		this.stair_id 		= astair_id;
		this.stair_name 	= astair_name;
	}
	
	public Stair(String astair_name) {
		this.stair_name 	= astair_name;
	}

}
