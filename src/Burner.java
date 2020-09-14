
public class Burner {
	public enum Temperature {BLAZING , HOT, WARM, COLD;} //enum temperature
	private Temperature myTemperature; //private variables for temp and setting
	private Setting mySetting;
	int timer = 0; //default timer set to 0
	public static final int TIME_DURATION = 2;//constant for time duration
	
	public Burner() {//constructor setting burners to off and temperature to cold
		super();
		mySetting = Setting.OFF;
		myTemperature = Temperature.COLD;
	}
	
	

	public Temperature getMyTemperature() { //temperature getter and setter
		return myTemperature;
	}

	public void setMyTemperature(Temperature myTemperature) {
		this.myTemperature = myTemperature;
	}

	public Setting getMySetting() {//setting getter and setter
		return mySetting;
	}

	public void setMySetting(Setting mySetting) {
		this.mySetting = mySetting;
	}
	
	public void plusButton() {
		Setting s = this.getMySetting(); //plus button has switch statement if called
		switch(s){
			case OFF://if off turns to low and adjusts time
				timer += TIME_DURATION;
				mySetting = Setting.LOW;
				 break;
			case LOW://if low turns to med and adjusts time
				timer += TIME_DURATION;
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM://if med turns to high and adjusts time
				timer += TIME_DURATION;
				mySetting = Setting.HIGH;
				break;
			case HIGH://if high nothing happens
				break;
		}
	}
	public void minusButton() {
		Setting s = this.getMySetting();//minus button has switch statement if called
		switch(s){
			case OFF://if off nothing happens
				 break;
			case LOW://if low turns to off and adjusts time
				timer += TIME_DURATION;
				mySetting = Setting.OFF;
				break;
			case MEDIUM://if med turns to low and adjusts time
				timer += TIME_DURATION;
				mySetting = Setting.LOW;
				break;
			case HIGH://if high turns to med and adjusts time
				timer += TIME_DURATION;
				mySetting = Setting.MEDIUM;
				break;
		}
	}
	
	public void updateTemperature() {
		if (timer !=0) {
			timer--;
			if(timer%2 ==0) {//if time is a multiple of two start tests
				if (myTemperature == Temperature.COLD && mySetting != Setting.OFF) {//if burner is cold but not off set to warm
					myTemperature = Temperature.WARM;
					return;
				}
				if ((mySetting == Setting.MEDIUM || mySetting == Setting.HIGH) && myTemperature == Temperature.WARM) {// if burner is on med or high and it is already warm set to hot
					myTemperature = Temperature.HOT;
					return;
				}
				if (mySetting == Setting.HIGH && myTemperature == Temperature.HOT) {// if burner is on high and it is already hot set to blazing
					myTemperature = Temperature.BLAZING;
					return;
				}
				if ((mySetting == Setting.MEDIUM || mySetting == Setting.LOW || mySetting == Setting.OFF) && myTemperature == Temperature.BLAZING) {// if burner is on med or low and it is already blazing set to hot
					myTemperature = Temperature.HOT;
					return;
				}
				if ((mySetting == Setting.LOW || mySetting == Setting.OFF) && myTemperature == Temperature.HOT) {// if burner is on low or off and it is already hot set to warm
					myTemperature = Temperature.WARM;
					return;
				}
				if (myTemperature == Temperature.WARM && mySetting == Setting.OFF) {// if burner is on off and it is already warm set to cold
					myTemperature = Temperature.COLD;
					return;
				}
			}
		}
	}
	public void display() {
		Temperature t = this.getMyTemperature();//display has switch statement if called
		System.out.print(this.getMySetting().toString());//prints Setting's string
		switch(t){
			case COLD://depending on cold, warm, hot, or blazing prints a different message following it
				System.out.println(".....coooool");
				break;
			case WARM:
				System.out.println(".....warm");
				break;
			case HOT:
				System.out.println(".....CAREFUL");
				break;
			case BLAZING:
				System.out.println(".....VERY HOT! DON'T TOUCH");
				break;
		}
	}
}
