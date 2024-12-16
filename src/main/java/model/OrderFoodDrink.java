/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mac
 */
public class OrderFoodDrink {
    private int orderID;
    private FoodDrink food_drink;
    private int ticketID;
    private int quantity;
    private long total_price;

    public OrderFoodDrink(int orderID, FoodDrink food_drink, int ticketID, int quantity, long total_price) {
        this.orderID = orderID;
        this.food_drink = food_drink;
        this.ticketID = ticketID;
        this.quantity = quantity;
        this.total_price = total_price;
    }
    
    public OrderFoodDrink(FoodDrink food_drink){
        this.food_drink = food_drink;
        this.ticketID = ticketID;
        this.quantity = 0;
        this.total_price = 0;
    }

    public int getOrderID() {
        return orderID;
    }

    public FoodDrink getFood_drink() {
        return food_drink;
    }

    
    public int getTicketID() {
        return ticketID;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal_price(long total_price) {
        this.total_price = total_price;
    }
    
    
}
