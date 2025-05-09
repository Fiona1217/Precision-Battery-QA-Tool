public class BatteryChecker {
	private final double EPSILON_DIAMETER = 1.0E-1 + 1.0E-14;
	private final double EPSILON_HEIGHT = 3.0E-1 + 1.0E-14;

	public boolean checkWithinTolerance(Battery battery) {
		double differenceDiameter = 0;
		double differenceHeight = 0;
		boolean diameterCheck = false;
		boolean heightCheck = false;
				
		//Find the differences between user's inputs and expected inputs
		differenceDiameter = Math.abs(battery.getDiameter() - Battery.EXPECTED_DIAMETER);
		differenceHeight = Math.abs(battery.getHeight() - Battery.EXPECTED_HEIGHT);
		
		//Check if the difference is less than or equal to the EPSILON value
		diameterCheck = (differenceDiameter <= EPSILON_DIAMETER);
		heightCheck = (differenceHeight <= EPSILON_HEIGHT);
		
		// return a boolean that indicates if the battery meets the specifications
		return diameterCheck && heightCheck;
	}
}
