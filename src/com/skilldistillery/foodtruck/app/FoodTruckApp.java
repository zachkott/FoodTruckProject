package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	Scanner sc = new Scanner(System.in);
	FoodTruck[] foodTrucks = new FoodTruck[5];

	private int rating;

//	private int count = 0;
	private int userInput = 1;
	private int highestRate;
	private double averageRate;

	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.welcome();

		// Welcome message *possibly change this to a method and call the method
		// WelcomeMessage()

	}

	public void welcome() {
		String answer;
		boolean choice;

		System.out.println("///////////////////////////////////////////////////////");
		System.out.println("/                                                     /");
		System.out.println("/        - Welcome to the Meals On Wheels app! -      /");
		System.out.println("/                                                     /");
		System.out.println("/ This app allows you to enter the name, food type,   /");
		System.out.println("/ and rating of up to 5 food trucks that you ate at!  /");
		System.out.println("/                                                     /");
		System.out.println("/ If you dined at less than 5 trucks, please enter    /");
		System.out.println("/ the word quit as the food truck's name.             /");
		System.out.println("/ This will take you to the main menu.                /");
		System.out.println("/                                                     /");
		System.out.println("/ Now that you know how the app works, would you      /");
		System.out.println("/ to start adding food trucks?                        /");
		System.out.println("/                                                     /");
		System.out.println("/ Enter (yes/no)                                      /");
		System.out.println("/                                                     /");
		System.out.println("///////////////////////////////////////////////////////");

		while (true) {
			answer = sc.nextLine();
			if (answer.equalsIgnoreCase("yes")) {
				choice = true;
				System.out.println("Awesome! Lets get started...");
				addFoodTruck();

			} else if (answer.equalsIgnoreCase("no")) {
				choice = false;
				System.out.println("Have a good Day!");
				break;
			}
//			 else {
//				System.out.println("Invalid response. Please try again.");
//			}
		}

	}

	public void addFoodTruck() {

		String foodType;

		int id;

		for (int i = 0; i < foodTrucks.length; i++) {
			id = i + 1;
			System.out.println();
			System.out.println("Add a food truck or enter quit to see the main menu (add/quit)");
			String name = sc.nextLine();

			if (name.equalsIgnoreCase("quit")) {
				mainMenu();

			} else if (name.equalsIgnoreCase("add")) {
			}
//			} else {
//				System.out.println("Invalid response. Please use (add/quit)");
//				nextTruck = sc.nextLine();
//				}

			System.out.println("Please enter the name of the food truck: \n");
			name = sc.nextLine();

			if (!name.equalsIgnoreCase("quit")) {
				System.out.println("Please enter the type of food that this truck served: ");
				foodType = sc.nextLine();

				System.out.println("Please enter a rating based upon the satisfaction of your dining experience \n"
						+ "The rating system is numerical: \n" + "1: Extremely dissastisfied (\u2b50) \n" + 
						"2: Satisfied (\u2b50\u2b50)\n"
						+ "3: Great!  (\u2b50\u2b50\u2b50)  \n" + 
						"4: Excellent! (\u2b50\u2b50\u2b50\u2b50)  \n"
						+ "5: Perfection (\u2b50\u2b50\u2b50\u2b50\u2b50)");
				rating = sc.nextInt();

				FoodTruck truck = new FoodTruck(name, foodType, rating, id);
				foodTrucks[i] = truck;

//			}
				if (name.equalsIgnoreCase("quit")) {
					break;
				}
			} else if (name.equalsIgnoreCase("quit")) {
				break;
			}

		}
		mainMenu();
	}

	public void mainMenu() {
//System.out.println("In main menu");
		while (userInput != 4) {
			System.out.println();
			System.out.println("Please choose an option from the  menu.");
			System.out.println();

			System.out.println("///////////////////////////////////////////////////////");
			System.out.println("/                                                     /");
			System.out.println("/                  - Main Menu -                      /");
			System.out.println("/                                                     /");
			System.out.println("/   1: Print a list of all the existing food trucks.  /");
			System.out.println("/   2: See the average rating of all food trucks.     /");
			System.out.println("/   3: Display the highest rated food truck.          /");
			System.out.println("/   4: Quit the program                               /");
			System.out.println("/                                                     /");
			System.out.println("///////////////////////////////////////////////////////");
			userInput = sc.nextInt();

			// for some reason i am getting an infinite loop no matter what case i choose

//		do {
			switch (userInput) {
			case 1:
				System.out.println();
				System.out.println("This is a list of all of the food trucks you dined at today:");
				listOfFoodTrucks();
				break;

			case 2:
				System.out.println();
				System.out.println("This is the average rating of all of the food trucks you dined at today: "
						+ averageRating(foodTrucks));
				break;

			case 3:
				System.out.println("This is the highest rated food truck that you dined at today: \n" + highestRated(foodTrucks));
				System.out.println();

				break;

			case 4:
				quitProgram();
				break;

			default:
				System.out.println("Invalid input. Please Try again.");
				break;
			}
		}

//		} while (userInput != 4);

	}

	public void listOfFoodTrucks() {
		System.out.println("In list of trucks.");
		for (int i = 0; i < foodTrucks.length; i++) {
			if (!(foodTrucks[i] == null)) {
				System.out.println(foodTrucks[i].toString());
			}

		}

	}

	public double averageRating(FoodTruck[] ratings) {
		double avg = 0;
		double sum = 0;
		int count = 0;

		for (int r = 0; r < ratings.length; r++) {
			if (ratings[r] != null) {
				double avgRate = ratings[r].getRating();
				sum = sum + avgRate;
				count = r + 1;
			}
		}
		avg = sum / count;
		return avg;
	}

	// initial test code to make sure all user input follows the correct path
//
//		System.out.println("In average rating");
//		averageRate = 2.2;
//		return averageRate;

	public FoodTruck highestRated(FoodTruck[] foodTrucks) {
		int i = 0;
		FoodTruck highestRate = foodTrucks[0];
		while (i < 4) {
			if (foodTrucks[i] != null) {
				if (foodTrucks[i].getRating() > highestRate.getRating()) {
					highestRate = foodTrucks[i];
				}
			}
			i++;
		}

		return highestRate;
	}
	// initial test code to make sure all user input follows the correct path
//
//		System.out.println("In highest rated");
//		int highestRate = 3;
//		return highestRate;

	public void quitProgram() {
		System.out.println("App terminating...");
		System.out.println("Have a Wonderful Day!");
		// added system.exit because my loop wasn't ending when the user pressed 4.
		System.exit(0);

	}
}
