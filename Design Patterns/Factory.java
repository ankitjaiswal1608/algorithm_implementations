abstract class Vehicle {

	int wheel;
	
	abstract int getWheel();
}

class Bike extends Vehicle {

	int wheel;

	public Bike() {
		this.wheel = 2;
	}
	
	public int getWheel() {
		return wheel;
	}
}

class Car extends Vehicle {
	
	int wheel;

	public Car() {
		this.wheel = 4;
	}
	
	public int getWheel() {
		return wheel;
	}
}

class VehicleFactory {

	public static Vehicle getVehicle(VehicleType vehicleType) {

		Vehicle instance;

		switch (vehicleType) {
			case CAR: instance = new Car(); 
			break;
			case BIKE: instance = new Bike(); 
			break;
			default: instance = null; 
		}

		return instance;
	}
}

enum VehicleType {
	CAR,BIKE;
}

class Factory {
	
	public static void main(String[] args) {

		Vehicle car = VehicleFactory.getVehicle(VehicleType.CAR);
		System.out.println("Car has "+car.getWheel()+" wheels.");

		Vehicle bike = VehicleFactory.getVehicle(VehicleType.BIKE);
		System.out.println("Bike has "+bike.getWheel()+" wheels.");
	}
}