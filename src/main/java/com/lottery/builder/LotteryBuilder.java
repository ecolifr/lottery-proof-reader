package com.lottery.builder;

import com.lottery.producer.SupperLottery;
import com.lottery.producer.TwoColor;
import com.lottery.proof.reader.BaseLotteryReader;
import com.lottery.proof.reader.LotteryProofReader;
import com.lottery.util.LotteryUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 彩票号码生成器
 *
 * @author Administrator
 */
public class LotteryBuilder {

    private JFrame jf = new JFrame();
    private JButton lottery = getLottery();
    private JLabel label;

    /**
     * 打开窗口
     */
    public void startJframe() {
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("彩票生成器");
        jf.setSize(500, 300);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setLayout(null);
        jf.add(lottery);
        jf.add(getCheckWindow());
        label = getShowLabel();
        jf.add(label);
    }

    /**
     * 重器jframe
     */
    private void restart() {
        jf.dispose();
        jf = new JFrame();
    }

    /**
     * 彩票生成器按钮
     *
     * @return
     */
    private JButton getLottery() {
        return getJButton("彩票生成器", 100, 15, 300, 70, (ActionEvent e) -> {
            restart();
            new LotteryProducer().startLotteryProducer(jf);
        });
    }

    /**
     * 打开校验窗口按钮
     */
    private JButton getCheckWindow() {
        return getJButton("校验", 100, 121, 300, 70, (ActionEvent e) -> {
            restart();
            new LotteryProofReaderWindow().startCheckWindow(jf);
        });
    }

    /**
     * 获取显示
     *
     * @return 显示label
     */
    public static JLabel getShowLabel() {
        JLabel label = new JLabel("", JLabel.CENTER);
        label.setBounds(100, 200, 300, 80);
        label.setFont(new Font("Dialog", 1, 18));
        return label;
    }

    /**
     * 初始化按钮
     * @param text
     * @param x
     * @param y
     * @param width
     * @param height
     * @param actionListener
     * @return
     */
    public static JButton getJButton(String text, int x, int y, int width, int height, ActionListener actionListener) {
        JButton jButton = new JButton(text);
        jButton.setBounds(x, y, width, height);
        jButton.addActionListener(actionListener);
        return jButton;
    }

}
