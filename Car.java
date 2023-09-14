package week1.day1;


public class Car {

		public void applyGear() {
			System.out.println("Apply Gear");
		}	
		public void switchOnAc() {
			System.out.println("Switch on Ac");
		}
		public void applyAccelerate() {
			System.out.println("Apply accelerate");
		}
		public static void main(String[] args) {
			
			Car audi = new Car();
			audi.applyGear();
			audi.switchOnAc();
			audi.applyAccelerate();
	
}
}
