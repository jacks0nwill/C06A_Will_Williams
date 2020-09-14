
public class Burner {
	public enum Temperature {BLAZING, HOT, WARM, COLD}
	private Temperature myTemperature;
	private Setting mySetting;
	int timer;
	public static final int TIME_DURATION = 2;
	
	public Burner(Temperature myTemperature, Setting mySetting, int timer) {
		super();
		this.myTemperature = myTemperature;
		this.mySetting = mySetting;
		this.timer = timer;
	}
	
}
