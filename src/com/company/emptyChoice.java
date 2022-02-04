package com.company;

public class emptyChoice extends Exception {
    @Override
    public String getMessage() {
        return "pole nie może być puste";
    }
}
