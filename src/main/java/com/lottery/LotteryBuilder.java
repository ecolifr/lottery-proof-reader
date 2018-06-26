package com.lottery;

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
    private JButton twoColorButton = getTwoColorButton();
    private JButton supperLotteryButton = getSupperLotteryButton();
    private JLabel label;
    private JTextField jTextField;
    private JTextField pathJTextField;

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
     * 打开彩票生成器窗口
     */
    private void startLotteryProducer() {
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("彩票生成器");
        jf.setSize(500, 300);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setLayout(null);

        jf.add(twoColorButton);
        jf.add(supperLotteryButton);
        label = getShowLabel();
        jf.add(label);
    }

    /**
     * 打开校验窗口
     */
    private void startCheckWindow() {
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("校验窗口");
        jf.setSize(500, 300);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        jf.setLayout(null);

        jTextField = getJTextField();
        pathJTextField = pathJTextField();
        jf.add(jTextField);
        jf.add(pathJTextField);
        jf.add(getTwoColorSubmitButton());
        jf.add(getSupperSubmitButton());
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
            startLotteryProducer();
        });
    }

    /**
     * 打开校验窗口按钮
     */
    private JButton getCheckWindow() {
        return getJButton("校验", 100, 121, 300, 70, (ActionEvent e) -> {
            restart();
            startCheckWindow();
        });
    }

    private JTextField getJTextField() {
        JTextField jTextField = new JTextField(1);
        jTextField.setBounds(100, 15, 300, 50);
        return jTextField;
    }

    private JTextField pathJTextField() {
        JTextField jTextField = new JTextField(1);
        jTextField.setBounds(100, 70, 300, 50);
        return jTextField;
    }

    /**
     * 确认校验按钮
     *
     * @return
     */
    private JButton getTwoColorSubmitButton() {
        return getJButton("twoColor", 100, 140, 150, 70, (ActionEvent e) -> {
            String path = pathJTextField.getText();
            BaseLotteryReader.findPickNumbers(path, TwoColor.RED_COUNT, TwoColor.BLUE_COUNT);
            submit(LotteryUtil.TWO_COLOR);
        });
    }

    /**
     * 确认校验按钮
     *
     * @return
     */
    private JButton getSupperSubmitButton() {
        return getJButton("supper", 250, 140, 150, 70, (ActionEvent e) -> {
            String path = pathJTextField.getText();
            BaseLotteryReader.findPickNumbers(path, SupperLottery.RED_COUNT, SupperLottery.BLUE_COUNT);
            submit(LotteryUtil.SUPPER_LOTTERY);
        });
    }

    private void submit(String type) {
        String input = jTextField.getText();
        String[] numbers = input.split(",");
        if (numbers.length != 7) {
            label.setText("需7位数字");
            return;
        }
        if (type.equals(LotteryUtil.SUPPER_LOTTERY)) {
            label.setText(LotteryProofReader.supper(numbers));
        } else if (type.equals(LotteryUtil.TWO_COLOR)) {
            label.setText(LotteryProofReader.twoColor(numbers));
        }
    }

    /**
     * 获取双色球按钮
     *
     * @return 双色球按钮
     */
    private JButton getTwoColorButton() {
        return getJButton("双色球", 100, 15, 300, 70, (ActionEvent e) -> {
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
        return getJButton("大乐透", 100, 121, 300, 70, (ActionEvent e) -> {
            SupperLottery supperLottery = new SupperLottery();
            label.setText(supperLottery.getSupperLottery());
        });
    }

    /**
     * 获取显示
     *
     * @return 显示label
     */
    private JLabel getShowLabel() {
        JLabel label = new JLabel("", JLabel.CENTER);
        label.setBounds(100, 200, 300, 80);
        label.setFont(new Font("Dialog", 1, 18));
        return label;
    }

    private JButton getJButton(String text, int x, int y, int width, int height, ActionListener actionListener) {
        JButton jButton = new JButton(text);
        jButton.setBounds(x, y, width, height);
        jButton.addActionListener(actionListener);
        return jButton;
    }

}
