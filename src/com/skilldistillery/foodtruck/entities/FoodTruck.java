package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private int rating;
	private String nameTruck;
	private String foodType;
	private int idNum;
	private int count = 1;


	public FoodTruck() {

	}

	public FoodTruck(String nameTruck, String foodType, int rating) {
		this.idNum = count++;
		this.nameTruck = nameTruck;
		this.foodType = foodType;
		this.rating = rating;
		
		
	}
//These are all of the getters and setters for rating, 
//	averageRating, nameTruck, foodType, and idNum

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	
	public String getNameTruck() {
		return nameTruck;
	}

	public void setNameTruck(String nameTruck) {
		this.nameTruck = nameTruck;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	@Override
	public String toString() {
		return "FoodTruck [rating=" + rating + ", nameTruck=" + nameTruck + ", foodType=" + foodType + ", idNum="
				+ idNum + "]";
	}

	

}
