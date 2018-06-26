package com.lottery.builder;

import com.lottery.producer.SupperLottery;
import com.lottery.producer.TwoColor;
import com.lottery.proof.reader.BaseLotteryReader;
import com.lottery.proof.reader.LotteryProofReader;
import com.lottery.util.LotteryUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LotteryProofReaderWindow {

    private JTextField jTextField;
    private JTextField pathJTextField;
    private JLabel label;

    /**
     * 打开校验窗口
     */
    public void startCheckWindow(JFrame jf) {
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
        label = LotteryBuilder.getShowLabel();
        jf.add(label);
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
        return LotteryBuilder.getJButton("twoColor", 100, 140, 150, 70, (ActionEvent e) -> {
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
        return LotteryBuilder.getJButton("supper", 250, 140, 150, 70, (ActionEvent e) -> {
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

}
