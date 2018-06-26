package com.lottery.enums;

import com.lottery.util.LotteryUtil;

public enum LotteryRules {
    FIRST_PRIZE_TWO_COLOR(LotteryUtil.TWO_COLOR, 6, 1, 1),
    SECOND_PRIZE_TWO_COLOR(LotteryUtil.TWO_COLOR, 6, 0, 2),
    THIRD_PRIZE_TWO_COLOR(LotteryUtil.TWO_COLOR, 5, 1, 3),
    FOURTH_PRIZE_TWO_COLOR(LotteryUtil.TWO_COLOR, 5, 0, 4),
    FOURTH_PRIZE_TWO_COLOR_2(LotteryUtil.TWO_COLOR, 4, 1, 4),
    FIFTH_PRIZE_TWO_COLOR(LotteryUtil.TWO_COLOR, 4, 0, 5),
    FIFTH_PRIZE_TWO_COLOR_2(LotteryUtil.TWO_COLOR, 3, 1, 5),
    SIXTH_PRIZE_TWO_COLOR(LotteryUtil.TWO_COLOR, 2, 1, 6),
    SIXTH_PRIZE_TWO_COLOR_2(LotteryUtil.TWO_COLOR, 1, 1, 6),
    SIXTH_PRIZE_TWO_COLOR_3(LotteryUtil.TWO_COLOR, 0, 1, 6),
    FIRST_PRIZE_SUPPER(LotteryUtil.SUPPER_LOTTERY, 5, 2, 1),
    SECOND_PRIZE_SUPPER(LotteryUtil.SUPPER_LOTTERY, 5, 1, 2),
    THIRD_PRIZE_SUPPER(LotteryUtil.SUPPER_LOTTERY, 5, 0, 3),
    THIRD_PRIZE_SUPPER_2(LotteryUtil.SUPPER_LOTTERY, 4, 2, 3),
    FOURTH_PRIZE_SUPPER(LotteryUtil.SUPPER_LOTTERY, 4, 1, 4),
    FOURTH_PRIZE_SUPPER_2(LotteryUtil.SUPPER_LOTTERY, 3, 2, 4),
    FIFTH_PRIZE_SUPPER(LotteryUtil.SUPPER_LOTTERY, 4, 0, 5),
    FIFTH_PRIZE_SUPPER_2(LotteryUtil.SUPPER_LOTTERY, 3, 1, 5),
    FIFTH_PRIZE_SUPPER_3(LotteryUtil.SUPPER_LOTTERY, 2, 2, 5),
    SIXTH_PRIZE_SUPPER(LotteryUtil.SUPPER_LOTTERY, 3, 0, 6),
    SIXTH_PRIZE_SUPPER_2(LotteryUtil.SUPPER_LOTTERY, 1, 2, 6),
    SIXTH_PRIZE_SUPPER_3(LotteryUtil.SUPPER_LOTTERY, 2, 1, 6),
    SIXTH_PRIZE_SUPPER_4(LotteryUtil.SUPPER_LOTTERY, 0, 2, 6),
    ;

    public final String type;
    public final int red;
    public final int blue;
    public final int prize;

    public static int findPrize(String type, int red, int blue) {
        for (LotteryRules lotteryRules : values()) {
            if (lotteryRules.type.equals(type) && red == lotteryRules.red && blue == lotteryRules.blue) {
                return lotteryRules.prize;
            }
        }
        return 0;
    }

    LotteryRules(String type, int red, int blue, int prize) {
        this.type = type;
        this.red = red;
        this.blue = blue;
        this.prize = prize;
    }
}
