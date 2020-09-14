
public class Burner {
	public enum Temperature {BLAZING , HOT, WARM, COLD;
	}
	private Temperature myTemperature;
	private Setting mySetting;
	int timer = 0;
	public static final int TIME_DURATION = 2;
	
	public Burner() {
		super();
		mySetting = Setting.OFF;
		myTemperature = Temperature.COLD;
	}
	
	public void display() {
		Temperature t = this.getMyTemperature();
		System.out.print(this.getMySetting().toString());
		switch(t){
			case COLD:
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

	public Temperature getMyTemperature() {
		return myTemperature;
	}

	public void setMyTemperature(Temperature myTemperature) {
		this.myTemperature = myTemperature;
	}

	public Setting getMySetting() {
		return mySetting;
	}

	public void setMySetting(Setting mySetting) {
		this.mySetting = mySetting;
	}
	
	public void plusButton() {
		Setting s = this.getMySetting();
		switch(s){
			case OFF:
				timer += TIME_DURATION;
				mySetting = Setting.LOW;
				 break;
			case LOW:
				timer += TIME_DURATION;
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				timer += TIME_DURATION;
				mySetting = Setting.HIGH;
				break;
			case HIGH:
				break;
		}
	}
	public void minusButton() {
		Setting s = this.getMySetting();
		switch(s){
			case OFF:
				 break;
			case LOW:
				timer += TIME_DURATION;
				mySetting = Setting.OFF;
				break;
			case MEDIUM:
				timer += TIME_DURATION;
				mySetting = Setting.LOW;
				break;
			case HIGH:
				timer += TIME_DURATION;
				mySetting = Setting.MEDIUM;
				break;
		}
	}
	
	public void updateTemperature() {
		if (timer !=0) {
			timer--;
			if(timer%2 ==0) {
				if (myTemperature == Temperature.COLD && mySetting != Setting.OFF) {
					myTemperature = Temperature.WARM;
					return;
				}
				if ((mySetting == Setting.MEDIUM || mySetting == Setting.HIGH) && myTemperature == Temperature.WARM) {
					myTemperature = Temperature.HOT;
					return;
				}
				if (mySetting == Setting.HIGH && myTemperature == Temperature.HOT) {
					myTemperature = Temperature.BLAZING;
					return;
				}
				if ((mySetting == Setting.MEDIUM || mySetting == Setting.LOW || mySetting == Setting.OFF) && myTemperature == Temperature.BLAZING) {
					myTemperature = Temperature.HOT;
					return;
				}
				if ((mySetting == Setting.LOW || mySetting == Setting.OFF) && myTemperature == Temperature.HOT) {
					myTemperature = Temperature.WARM;
					return;
				}
				if (myTemperature == Temperature.WARM && mySetting == Setting.OFF) {
					myTemperature = Temperature.COLD;
					return;
				}
			}
		}
	}
}
