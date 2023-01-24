package ncs.test4;

public class Airplane extends Plane {

	public Airplane() {
	}

	public Airplane(String planeName, int fuelSize) {
		super();
		this.setPlaneName(planeName);
		this.setFuelSize(fuelSize);
	}
	
	@Override
	public void flight(int distance) {
		this.setFuelSize(this.getFuelSize() - (distance/10)*30);
	}
}
