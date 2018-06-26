package com.lottery.dto;

import java.util.List;

public class LotteryPool {
    private List<String> red;
    private List<String> blue;

    public LotteryPool(List<String> red, List<String> blue) {
        this.red = red;
        this.blue = blue;
    }

    public List<String> getRed() {
        return red;
    }

    public List<String> getBlue() {
        return blue;
    }
}
