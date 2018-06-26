package com.lottery.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LotteryUtil {
    public static final String TWO_COLOR = "TWO_COLOR" ;
    public static final String SUPPER_LOTTERY = "SUPPER_LOTTERY" ;


	public static final List<String> TWO_COLOR_RED = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33");
	public static final List<String> TWO_COLOR_BLUE = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16");
	public static final List<String> SUPPER_RED = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35");
	public static final List<String> SUPPER_BLUE = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12");

	/**
	 * 从池中拿出球
	 * @param num
	 * @param pool
	 * @return
	 */
	public static int[] getFromPool(Integer num, List<String> pool) {
		int[] forRed = new int[num];
		List<String> redPool = new ArrayList<>();
		redPool.addAll(pool);
		for (int i = 0; i < forRed.length; i++) {
			int index = (int)(0 + Math.random() * (redPool.size()));
			forRed[i] = Integer.parseInt(redPool.get(index));
			redPool.remove(String.valueOf(forRed[i]));
		}
		Arrays.sort(forRed);
		return forRed;
	}
}
