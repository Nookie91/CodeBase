import java.util.Scanner;

public class Efficiency
{
	public static void main(String [] args)
	{
		Scanner keyboard = new Scanner(System.in);
        
        double fuelEfficiency;

		System.out.print("Enter vehicle make: ");
		String vehicleMake = keyboard.nextLine();
		System.out.print("Enter vehicle model: ");
		String vehicleModel = keyboard.nextLine();
		System.out.print("Enter kilometres travelled: ");
		double kilometresTravelled = keyboard.nextDouble();
		System.out.print("Enter litres of fuel used: ");
		double fuelUsed = keyboard.nextDouble();
		
		fuelEfficiency = fuelUsed / (kilometresTravelled / 100);
		System.out.print("Fuel efficiency for a ");
		System.out.print(vehicleMake + " " + vehicleModel+ ": ");
		System.out.printf("%.2f litres/100 km\n", fuelEfficiency);
		
	}
}
