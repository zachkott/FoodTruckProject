package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

			//  Week 2 Food Truck Project.
			// Zachary Kotterer.		

public class FoodTruckApp {
	Scanner sc = new Scanner(System.in);
	FoodTruck[] foodTrucks = new FoodTruck[5];

	private int rating;
	private int userInput = 1;


	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();
		fta.welcome();

		
	}
	
    // This is the first method that will be called in this application.
	// It is the only method that will be called in the main method.
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

		}

	}

	// This method will  be called if the user enters yes in the welcome menu.
	// This is the method that confused me the most. I felt very repetitive  with my if else-statements.
	public void addFoodTruck() {

		// A total of 3 local variables to collect all the food truck info and assign it to an index value
		// in the  foodTrucks array.
		String foodType;
		int id;
		
		// This for loop will execute through each index of the array and store its info as well as assign
		// it a unique  ID.
		
		for (int i = 0; i < foodTrucks.length; i++) {
			id = i + 1;
			
			System.out.println();
			System.out.println("Add a food truck or enter quit to see the main menu (add/quit)");
			String name = sc.nextLine();

			// There are various nested if-else statements within this for loop that will cause the loop to break if 
			// the word quit is entered.
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
						+ "The rating system is numerical: \n" + "1: Extremely dissastisfied (\u2b50) \n"
						+ "2: Satisfied (\u2b50\u2b50)\n" + "3: Great!  (\u2b50\u2b50\u2b50)  \n"
						+ "4: Excellent! (\u2b50\u2b50\u2b50\u2b50)  \n"
						+ "5: Perfection (\u2b50\u2b50\u2b50\u2b50\u2b50)");
				rating = sc.nextInt();

				FoodTruck truck = new FoodTruck(name, foodType, rating, id);
				foodTrucks[i] = truck;


				if (name.equalsIgnoreCase("quit")) {
					break;
				}
			} else if (name.equalsIgnoreCase("quit")) {
				break;
			}

		}
		mainMenu();
	}
	
	
	// This method will be called  when the user enters the word quit as a food truck name
	public void mainMenu() {

		// This while loop with execute until the user enters a 4, in which case the loop will be  broken
		// and the quitProgram  method will be called to terminate the program.
		while (userInput != 4) {
			System.out.println();
			System.out.println("Please choose an option from the  menu.");
			System.out.println();

			// W.I.P
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

			// for some reason I am getting an infinite loop no matter what case I choose *fixed with System.exit(0)


			switch (userInput) {
			case 1:
				System.out.println();
				System.out.println("This is a list of all of the food trucks you dined at today:");
				listOfFoodTrucks();
				break;

			case 2:
				System.out.println();
				System.out.println("This is the average rating of all of the food trucks you dined at today: \n"
						+ ""
						+ averageRating(foodTrucks));
				break;

			case 3:
				System.out.println(
						"This is the highest rated food truck that you dined at today: \n" 
						+ highestRated(foodTrucks));
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

	}

	// This is the method that will be called if the user enters option 1.

	public void listOfFoodTrucks() {
		System.out.println("In list of trucks.");
		for (int i = 0; i < foodTrucks.length; i++) {
			if (!(foodTrucks[i] == null)) {
				System.out.println(foodTrucks[i].toString());
			}

		}

	}

	// This is the method that will be called if the user enters a 2
	// This method will return a value of ratings from the foodTruck array
	public double averageRating(FoodTruck[] ratings) {
		
		//Three local variables used to calculate the sum of all ratings and divide it by the current count.
		double avg = 0;
		double sum = 0;
		int count = 0;

		// This for loop will run through the index values  stored in the foodTruck array  until 
		// the index value equals the stored value.
		for (int r = 0; r < ratings.length; r++) {
			
			// Nested if statement that runs through each index and finds the sum of all the ratings 
			// and divides it by the count to determine the average rating.
			if (ratings[r] != null) {
				double avgRate = ratings[r].getRating();
				sum = sum + avgRate;
				count = r + 1;
			}
		}
		avg = sum / count;
		return avg;
	}

	// This is the method that will be called if the user enters a 3
	public FoodTruck highestRated(FoodTruck[] foodTrucks) {
		
		FoodTruck highestRate = foodTrucks[0];
		int i = 0;
		
		// A while loop that executes through each index of the foodTrucks array until if gets to the max index
		while (i < 5) {
			
			// Nested if-statements inside the while loop that go through the 
			// index and call the getRating method created in FoodTruck.
			// Once the loop ends the index with the highest value will be returned
			if (foodTrucks[i] != null) {
				if (foodTrucks[i].getRating() > highestRate.getRating()) {
					highestRate = foodTrucks[i];
				}
			}
			i++;
		}

		return highestRate;
	}

	// If the user enters a 4 this method will  be called to terminate the program.
	public void quitProgram() {
		System.out.println("App terminating...");
		System.out.println("Have a Wonderful Day!");
		
		// I added system.exit because my loop wasn't ending when the user pressed 4.
		System.exit(0);

	}
}
