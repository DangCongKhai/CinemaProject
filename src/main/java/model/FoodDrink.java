/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */
public class FoodDrink {
    private int food_drink_ID;
    private String name;
    private String type;
    private long price;
    private String description;

    public FoodDrink(int food_drink_ID, String name, String type, long price, String description) {
        this.food_drink_ID = food_drink_ID;
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public int getFood_drink_ID() {
        return food_drink_ID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
    
    
}
