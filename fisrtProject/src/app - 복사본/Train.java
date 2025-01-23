package app;

public class Train{
	private String trainNumber;
	private String departureStation;
	private String arrivalStation;
	private boolean isStart;
	
	public Train(String trainNumber, String departureStation, String arrivalStation, boolean isStart) {
		this.trainNumber = trainNumber;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.isStart = isStart;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
}