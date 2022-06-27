package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	private static FoodTruck[] fleetOfFoodTrucks = new FoodTruck[5];
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		userInput();
		userMenu();
		sc.close();
	}

	private static void userInput() {
		int count = 0;
		System.out.println("FOOD TRUCK PARADISE REGISTER");
		while (count < fleetOfFoodTrucks.length) {

			System.out.println("Enter the food truck name: ");
			String name = sc.nextLine();
			if (name.toLowerCase().equals("quit")) {
				System.out.println("Successfully stop adding more food truck");
				break;
			}
			System.out.println("Enter the food truck food type: ");
			String foodType = sc.nextLine();
			System.out.println("Enter the rating: ");
			double rating = sc.nextDouble();
			FoodTruck foodTruck = new FoodTruck(name, foodType, rating);
			fleetOfFoodTrucks[count] = foodTruck;
			count++;
			if (count == fleetOfFoodTrucks.length) {
				System.out.println("That was the last truck you can add to the program!");
				break;
			}
			sc.nextLine();

		}
	}
	private static void userMenu() {
		boolean isContinued = true;
		while (isContinued) {
			System.out.println("====MENU====");
			System.out.println("1. List all existing food trucks.");
			System.out.println("2. See the average rating of food trucks.");
			System.out.println("3. Display the highest-rated food truck.");
			System.out.println("4. Quit the program.");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("List of all food trucks below: ");
				displayFoodTruck(fleetOfFoodTrucks);
				break;
			case 2:
				System.out.println("Average Rating: ");
				System.out.println(averageRating(fleetOfFoodTrucks));
				break;
			case 3:
				System.out.println("The food truck(s) that have highest rate: ");
				highestRatedFoodTruck(fleetOfFoodTrucks);
				break;
			case 4:
				System.out.println("Exit program. Good Bye!");
				isContinued = false;
				break;
			}
		}
	}
	private static void displayFoodTruck(FoodTruck[] foodTruckGeneric) {
		for (FoodTruck foodTruck : foodTruckGeneric) {
			if (foodTruck != null) {
				System.out.println(foodTruck.toString());
			}
		}
	}

	private static double averageRating(FoodTruck[] foodTruckGeneric) {
		double sum = 0;
		int count = 0;
		for (FoodTruck foodTruck : foodTruckGeneric) {
			if (foodTruck != null) {
				sum += foodTruck.getRating();
				count++;
			}
		}
		return sum / count;

	}

	private static void highestRatedFoodTruck(FoodTruck[] foodTruckGeneric) {
		double max = 0;
		for (FoodTruck foodTruck : foodTruckGeneric) {
			if (foodTruck != null && foodTruck.getRating() > max) {
				max = foodTruck.getRating();
			}
		}
		for (FoodTruck foodTruck : foodTruckGeneric) {
			if (foodTruck != null && foodTruck.getRating() == max) {
				System.out.println(foodTruck.toString());
			}
		}
	}

}
