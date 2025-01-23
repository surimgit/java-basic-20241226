package app;

public class FreightTrain extends Train implements Vehicle {
	
	private double cargoWeight;
		
	public FreightTrain(String trainNumber, String departureStation, String arrivalStation, boolean isStart, double cargoWeight) {
		super(trainNumber, departureStation, arrivalStation, isStart);
		this.cargoWeight = cargoWeight;
	}

	public double getCargoWeight() {
		return cargoWeight;
	}

	public void setCargoWeight(double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	
	@Override
	public void accelerate() {
		System.out.println("화물 열차가 천천히 가속합니다!");
	}

	@Override
	public void stop() {
		System.out.println("화물 열차가 천천히 정차합니다!");
	}

	@Override
	public void setStart() {
		setStart(false);
	}
}