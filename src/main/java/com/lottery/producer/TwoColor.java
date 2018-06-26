package com.lottery.producer;

import com.lottery.dto.LotteryPool;
import com.lottery.util.LotteryUtil;

import java.util.Arrays;

public class TwoColor {
    public static final int RED_COUNT = 6;
    public static final int BLUE_COUNT = 1;
    // 双色球池
    private LotteryPool twoColorPool;
    private int[] red;
    private int[] blue;

    public TwoColor() {
        super();
        // 双色球：红球1-33；篮球1-16
        this.twoColorPool = new LotteryPool(LotteryUtil.TWO_COLOR_RED, LotteryUtil.TWO_COLOR_BLUE);
    }

    public String getTwoColor() {
        this.red = LotteryUtil.getFromPool(RED_COUNT, twoColorPool.getRed());
        this.blue = LotteryUtil.getFromPool(BLUE_COUNT, twoColorPool.getBlue());
        return "双色球： " + Arrays.toString(red) + Arrays.toString(blue);
    }

}
