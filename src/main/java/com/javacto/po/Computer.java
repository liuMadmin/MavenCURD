package com.javacto.po;
/*
* 定义实体类
* */
public class Computer {
    private int id;
    private String cName;
    private String color;
    private double money;

    public Computer(int id, String cName, String color, double money) {
        this.id = id;
        this.cName = cName;
        this.color = color;
        this.money = money;
    }

    public Computer(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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
        return "Computer{" +
                "id=" + id +
                ", cName='" + cName + '\'' +
                ", color='" + color + '\'' +
                ", money=" + money +
                '}';
    }
}
