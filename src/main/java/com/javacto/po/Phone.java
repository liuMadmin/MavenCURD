package com.javacto.po;

public class Phone {
    private int id;
    private String pName;
    private String color;
    private double money;

    public Phone(int id, String pName, String color, double money) {
        this.id = id;
        this.pName = pName;
        this.color = color;
        this.money = money;
    }

    public Phone(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", pName='" + pName + '\'' +
                ", color='" + color + '\'' +
                ", money=" + money +
                '}';
    }
}
