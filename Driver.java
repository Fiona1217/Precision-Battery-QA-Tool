public class Driver {

	public static void main(String[] args) {
		BatteryChecker batteryChecker = new BatteryChecker();
		Battery battery = new Battery();

		String userDecision = "no";
		int totalTolerance = 0;
		
		do {
			System.out.println("Enter battery dimensions (expected: D: 3.50 , H: 10.30)");
			
			/* Using static methods from class User, prompt the user to
			 * enter the diameter and height as measured.
			 */
			double userInputDiameter = User.inputDouble("Enter measured diameter: ");
			double userInputHeight = User.inputDouble("Enter expected height: ");
			
			// set the dimensions into an instance of Battery
			battery.setDiameter(userInputDiameter);
			battery.setHeight(userInputHeight);
			
			/* Use the toString method of class Battery
			 * to output the information for the battery.
			 * .toString()
			 */
			String batteryToString = battery.toString();
			System.out.println(batteryToString);
		
			/* Use the BatteryChecker method to check if the
			 * battery is within specifications for diameter and height
			 * by passing that method the Battery reference-value as an argument.
			 */
			boolean batteryTolerance = batteryChecker.checkWithinTolerance(battery);
			
			/* Report to the user if the battery is within tolerance or not.
			 * (See Sample Program Run for report format)
			 * Keep track of how many were not within tolerance for later reporting
			 */
			if(batteryTolerance == true) {
				System.out.println("The battery is within the tolerance.");
			}
			else {
				System.out.println("The battery is not within the tolerance.");
				totalTolerance += 1;
			}
			// Print out your name on screen
			System.out.println("Program by Fiona Ang");
			
			/* Using a loop ask if there is more data to enter (yes, no)
			 * by using static methods from class User, and continue
			 * only if the user enters some form of yes
			 * e.g. "YES" "yEs" "yeS" would be acceptable (any capitalization)
			 * if yes, processing should repeat in outputting the menu as above.
			 */
			userDecision = User.inputString("Continue Program (yes/no)?");
			System.out.println(""); //a space for readability
		}while(userDecision.equalsIgnoreCase("yes"));

		System.out.println("Thank you for using the program :)");
		
		/* If there is no more data to enter, let the user know how many times
		 * the battery were out of tolerance.
		 */
		System.out.printf("Number of batteries that were out of tolerance: %d", totalTolerance);
	}
}
