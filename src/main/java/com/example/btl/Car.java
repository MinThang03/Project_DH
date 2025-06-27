package com.example.btl;

public class Car {
    private String model;
    private String price;
    private String type;
    private String range;
    private String seats;
    private String capacity;
    private String imageResId;

    public Car(String model, String price, String type, String range, String seats, String capacity, String imageResId) {
        this.model = model;
        this.price = price;
        this.type = type;
        this.range = range;
        this.seats = seats;
        this.capacity = capacity;
        this.imageResId = imageResId;
    }

    // Getters
    public String getModel() { return model; }
    public String getPrice() { return price; }
    public String getType() { return type; }
    public String getRange() { return range; }
    public String getSeats() { return seats; }
    public String getCapacity() { return capacity; }
    public String getImageResId() { return imageResId; }
}
