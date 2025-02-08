package be.vinci.magic.models;

public class Car {

    private String brand;
    private String model;
    private int year;
    private double price;
    private double length;

    public Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.price = 0.0;
        this.length = 0.0;
    }

    public Car(String brand, String model, int year, double price, double length) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.length = length;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String toString() {
        return this.brand + " " + this.model + " " + this.year + " " + this.price + " " + this.length;
    }
}
