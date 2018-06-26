package com.lottery.dto;

public class Lottery {
    private String[] red;
    private String[] blue;
    private String type;

    public String[] getRed() {
        return red;
    }

    public String[] getBlue() {
        return blue;
    }

    public String getType() {
        return type;
    }

    public Lottery(String[] red, String[] blue) {
        this.red = red;
        this.blue = blue;
    }

    public Lottery(String[] red, String[] blue, String type) {
        this.red = red;
        this.blue = blue;
        this.type = type;
    }
}
