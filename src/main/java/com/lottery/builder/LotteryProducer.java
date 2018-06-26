package com.lottery.builder;

import com.lottery.producer.SupperLottery;
import com.lottery.producer.TwoColor;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * 彩票生成器
 */
public class LotteryProducer {

    private JLabel label;

    /**
     * 打开彩票生成器窗口
     */
    public void startLotteryProducer(JFrame jf) {
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("彩票生成器");
        jf.setSize(500, 300);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setLayout(null);

        jf.add(getTwoColorButton());
        jf.add(getSupperLotteryButton());
        label = LotteryBuilder.getShowLabel();
        jf.add(label);
    }

    /**
     * 获取双色球按钮
     *
     * @return 双色球按钮
     */
    private JButton getTwoColorButton() {
        return LotteryBuilder.getJButton("双色球", 100, 15, 300, 70, (ActionEvent e) -> {
            TwoColor t = new TwoColor();
            label.setText(t.getTwoColor());
        });
    }

    /**
     * 获取大乐透按钮
     *
     * @return 大乐透按钮
     */
    private JButton getSupperLotteryButton() {
        return LotteryBuilder.getJButton("大乐透", 100, 121, 300, 70, (ActionEvent e) -> {
            SupperLottery supperLottery = new SupperLottery();
            label.setText(supperLottery.getSupperLottery());
        });
    }
}
