package app;

public class Car{
	
	private String vin;
	private String color;
	private boolean isStart;
	
	public Car(String vin, String color, boolean isStart) {
		super();
		this.vin = vin;
		this.color = color;
		this.isStart = isStart;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
}
