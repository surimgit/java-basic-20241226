package app;

import java.util.Scanner;

public class ManualCar extends Car implements Vehicle{
	private int gear;
	
	public ManualCar(String vin, String color, boolean isStart, int gear) {
		super(vin, color, isStart);
		this.gear = gear;
	}

	public void setGear() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("현재기어: " + gear);
		System.out.print("0~6까지의 기어를 입력하세요: ");
		gear = scanner.nextInt();
		System.out.println("현재기어: " + gear);
	}
	
	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	@Override
	public void accelerate() {
		System.out.println("수동 변속기 자동차가 가속합니다!");
	}

	@Override
	public void stop() {
		System.out.println("수동 변속기 자동차가 정차합니다!");
	}

	@Override
	public void setStart() {
		setStart(false);
	}
}