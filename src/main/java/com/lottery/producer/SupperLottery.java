package com.lottery.producer;

import com.lottery.dto.LotteryPool;
import com.lottery.util.LotteryUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupperLottery {
    public static final int RED_COUNT = 5;
    public static final int BLUE_COUNT = 2;
    // 大乐透池
    private LotteryPool supperLotteryPool;
    private int[] red;
    private int[] blue;

    public SupperLottery() {
        super();
        // 大乐透：红球1-15；篮球1-12
        this.supperLotteryPool = new LotteryPool( LotteryUtil.SUPPER_RED, LotteryUtil.SUPPER_BLUE);
    }

    public String getSupperLottery() {
        this.red = LotteryUtil.getFromPool(RED_COUNT, supperLotteryPool.getRed());
        this.blue = LotteryUtil.getFromPool(BLUE_COUNT, supperLotteryPool.getBlue());
        return "大乐透： " + Arrays.toString(red) + Arrays.toString(blue);
    }

}
