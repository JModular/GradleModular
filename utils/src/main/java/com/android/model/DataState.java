package com.android.model;

/**
 * Created by Arison on 2017/6/27.
 */

public class DataState {
    String value;
    boolean isClicked;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}
