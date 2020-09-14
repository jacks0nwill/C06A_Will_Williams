
public enum Setting {
	 OFF ("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	 private String set;
	
	Setting (String aSetting){
		set = aSetting;
	}
	public String toString() {
		return set;
	}
}
