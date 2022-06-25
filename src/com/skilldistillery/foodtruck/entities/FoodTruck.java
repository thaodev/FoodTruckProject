package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	/*
	 * unique numeric id, a name, food type, and a numeric rating.
	 */
	private int id;
	private String name;
	private String foodType;
	private double rating;
	private static int nextTruckId = 0;
	
	
	public FoodTruck() {
	}


	public FoodTruck(String name, String foodType, double rating) {
		this.id = nextTruckId ++;
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFoodType() {
		return foodType;
	}


	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "FoodTruck [id=" + id + ", name=" + name + ", foodType=" + foodType + ", rating=" + rating + "]";
	}
	
	
	
	
}
