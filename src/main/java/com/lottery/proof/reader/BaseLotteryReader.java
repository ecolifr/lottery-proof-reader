package com.lottery.proof.reader;

import com.lottery.dto.Lottery;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BaseLotteryReader {

    public static List<Lottery> LOTTERY = new ArrayList<>();

    /**
     * 读取文件中选中的号码
     *
     * @param path
     * @param redCount
     * @param blueCount
     */
    public static void findPickNumbers(String path, final int redCount, final int blueCount) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.printf("找不到指定文件【%s】\n", path);
            return;
        }
        try (FileReader fileReader = new FileReader(path); BufferedReader in = new BufferedReader(fileReader)) {
            LOTTERY.clear();
            in.lines().forEach((String num) -> {
                String[] numbers = num.split(",");

                String[] red = new String[redCount];
                String[] blue = new String[blueCount];
                System.arraycopy(numbers, 0, red, 0, redCount);
                System.arraycopy(numbers, redCount, blue, 0, blueCount);
                LOTTERY.add(new Lottery(red, blue));

            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
