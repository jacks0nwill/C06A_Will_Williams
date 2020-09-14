
public enum Setting {
	 OFF ("[---]"), LOW("[--+]"), MEDIUM("[-++]"), HIGH("[+++]");//enum setting options
	 private String set;
	
	Setting (String aSetting){ //constructor 
		set = aSetting;
	}
	
	public String toString() {//to string method
		return set;
	}
}
