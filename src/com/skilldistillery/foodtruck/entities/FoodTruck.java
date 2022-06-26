package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private int rating;
	private String nameTruck;
	private String foodType;
	private int idNum = 0;
	private static int count = 1;


	public FoodTruck() {

	}

	public FoodTruck(String nameTruck, String foodType, int rating, int idNum) {
		this.nameTruck = nameTruck;
		this.foodType = foodType;
		this.rating = rating;
		this.idNum = count++;
		
		
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
		return "FoodTruck [Name:  " + nameTruck + 
				", Type Of Food: " + foodType + 
				", Rating: " + starRating(rating) +
				", ID: "+ idNum + "]";
	}
public String starRating(int rating) {
	String stars = "";
	switch (this.rating) {
	case 1:
		stars = "\u2b50";
		return stars;
	case 2:
		stars = "\u2b50\u2b50";
		return stars;
	case 3:
		stars = "\u2b50\u2b50\u2b50";
		return stars;
	case 4:
		stars = "\u2b50\u2b50\u2b50\u2b50";
		return stars;
	case 5:
		stars = "\u2b50\u2b50\u2b50\u2b50\u2b50";
		return stars;
	}
	return stars;
}
	

}
