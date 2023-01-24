package ncs.test4;

public class Cargoplane extends Plane{
	
	public Cargoplane() {}
	
	public Cargoplane(String airplaneName, int fuelSize) {
		this.setPlaneName(airplaneName);
		this.setFuelSize(fuelSize);
	}
	
	@Override
	public void flight(int distance) {
		this.setFuelSize(this.getFuelSize() - (distance/10)*50);
	}
}
