
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
		if (mySetting != Setting.HIGH) {
			if (mySetting == Setting.OFF) {
				timer += TIME_DURATION;
				mySetting = Setting.LOW;
			}
			if (mySetting == Setting.LOW) {
				timer += TIME_DURATION;
				mySetting = Setting.MEDIUM;
			}
			if (mySetting == Setting.MEDIUM) {
				timer += TIME_DURATION;
				mySetting = Setting.HIGH;
			}
		}
	}
	public void minusButton() {
		if (mySetting != Setting.OFF) {
			if (mySetting == Setting.HIGH) {
				timer += TIME_DURATION;
				mySetting = Setting.MEDIUM;
			}
			if (mySetting == Setting.MEDIUM) {
				timer += TIME_DURATION;
				mySetting = Setting.LOW;
			}
			if (mySetting == Setting.LOW) {
				timer += TIME_DURATION;
				mySetting = Setting.OFF;
			}
		}
	}
	public void updateTemperature() {
		if (timer !=0) {
			timer--;
			if(timer%2 ==0) {
				if (myTemperature == Temperature.COLD && mySetting != Setting.OFF) {
					myTemperature = Temperature.WARM;
				}
				if ((mySetting == Setting.MEDIUM || mySetting == Setting.HIGH) && myTemperature == Temperature.WARM) {
					myTemperature = Temperature.HOT;
				}
				if (mySetting == Setting.HIGH && myTemperature == Temperature.HOT) {
					myTemperature = Temperature.BLAZING;
				}
				if ((mySetting == Setting.MEDIUM || mySetting == Setting.LOW || mySetting == Setting.OFF) && myTemperature == Temperature.BLAZING) {
					myTemperature = Temperature.HOT;
				}
				if ((mySetting == Setting.LOW || mySetting == Setting.OFF) && myTemperature == Temperature.HOT) {
					myTemperature = Temperature.WARM;
				}
				if (myTemperature == Temperature.WARM && mySetting == Setting.OFF) {
					myTemperature = Temperature.COLD;
				}
			}
		}
	}
}
