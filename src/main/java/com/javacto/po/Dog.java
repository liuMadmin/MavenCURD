package com.javacto.po;
/*
* 定义实体类
* */
public class Dog {
    private int id;
    private String dName;
    private int health;
    private String strain;

    public Dog(int id, String dName, int health, String strain) {
        this.id = id;
        this.dName = dName;
        this.health = health;
        this.strain = strain;
    }

    public Dog(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(String strain) {
        this.strain = strain;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", dName='" + dName + '\'' +
                ", health=" + health +
                ", strain='" + strain + '\'' +
                '}';
    }
}

