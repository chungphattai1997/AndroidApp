package com.example.baitap5;

public class Food {
    int imageFood;
    String nameFood;

    public Food(int imageFood, String nameFood) {
        super();
        this.imageFood = imageFood;
        this.nameFood = nameFood;
    }

    public int getImageFood() {
        return imageFood;
    }

    public void setImageFood(int imageFood) {
        this.imageFood = imageFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }
}
