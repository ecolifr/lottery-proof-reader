package com.lottery.proof.reader;

import com.lottery.dto.Lottery;
import com.lottery.enums.LotteryRules;
import com.lottery.producer.SupperLottery;
import com.lottery.producer.TwoColor;
import com.lottery.util.LotteryUtil;

/**
 * 彩票校验器
 */
public class LotteryProofReader {

    /**
     * 校验双色球
     *
     * @param numbers
     * @return
     */
    public static String twoColor(String[] numbers) {
        String[] red = new String[TwoColor.RED_COUNT];
        String[] blue = new String[TwoColor.BLUE_COUNT];
        System.arraycopy(numbers, 0, red, 0, TwoColor.RED_COUNT);
        System.arraycopy(numbers, TwoColor.RED_COUNT, blue, 0, TwoColor.BLUE_COUNT);
        return proofReader(new Lottery(red, blue, LotteryUtil.TWO_COLOR));
    }

    /**
     * 校验大乐透
     *
     * @param numbers
     * @return
     */
    public static String supper(String[] numbers) {
        String[] red = new String[SupperLottery.RED_COUNT];
        String[] blue = new String[SupperLottery.BLUE_COUNT];
        System.arraycopy(numbers, 0, red, 0, SupperLottery.RED_COUNT);
        System.arraycopy(numbers, SupperLottery.RED_COUNT, blue, 0, SupperLottery.BLUE_COUNT);
        return proofReader(new Lottery(red, blue, LotteryUtil.SUPPER_LOTTERY));
    }

    /**
     * 校验方法
     *
     * @param lottery
     * @return
     */
    private static String proofReader(Lottery lottery) {
        StringBuilder sb = new StringBuilder();
        BaseLotteryReader.LOTTERY.stream().forEach(readLottery -> {
            sb.append(compare(readLottery, lottery));
            sb.append(" ");
        });
        return sb.toString();
    }

    /**
     * 比较方法
     * 先比较红色，在比较蓝色
     *
     * @param pick
     * @param source
     * @return
     */
    private static int compare(Lottery pick, Lottery source) {
        int hitTheRed = 0;
        int hitTheBlue = 0;
        int previous = 0;
        // 匹配红色
        for (String sourceRed : source.getRed()) {
            for (int i = previous; i < pick.getRed().length; i++) {
                if (sourceRed.equals(pick.getRed()[i])) {
                    hitTheRed++;
                    previous = i;
                    pick.getRed()[i] = "-1";
                    break;
                }
            }
        }
        // 匹配蓝色
        previous = 0;
        for (String sourceBlue : source.getBlue()) {
            for (int i = previous; i < pick.getBlue().length; i++) {
                if (sourceBlue.equals(pick.getBlue()[i])) {
                    hitTheBlue++;
                    previous = i;
                    pick.getBlue()[i] = "-1";
                    break;
                }
            }
        }
        return LotteryRules.findPrize(source.getType(), hitTheRed, hitTheBlue);
    }
}
