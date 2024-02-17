package com.example.animal;

public class sportItem {
    int smallImage,num;
    String name;

    public sportItem(String name,int smallImage,int num) {
        this.name = name;
        this.smallImage=smallImage;
        this.num = num;
    }

    public int getSmallImage() {
        return smallImage;
    }
}
