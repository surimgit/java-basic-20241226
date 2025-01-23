package app;

public class App {
	
	public static void main(String[] args) {
		ManualCar manualCar = new ManualCar("10가1234", "blue", false, 0);
		AutomaticCar automaticCar = new AutomaticCar("10가1234", "blue", false);
		PassengerTrain passengerTrain = new PassengerTrain("KTX001", "서울", "부산", false, 200);
		FreightTrain freightTrain = new FreightTrain("Cargo001", "부산", "구미", true, 100.0);
	}
}
