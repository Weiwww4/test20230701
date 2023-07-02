package com.faintdream.test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo01 {
    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("窗口示例");

        // 设置窗口大小和位置
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // 居中显示窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 创建提示文本标签
        JLabel label = new JLabel("请确认");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));

        // 创建确认按钮
        JButton button = new JButton("确认");
        button.setFont(new Font("Arial", Font.PLAIN, 16));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭窗口
                frame.dispose();
                System.out.println("Close Window");
            }
        });

        // 将文本标签和按钮添加到面板
        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        // 将面板添加到窗口
        frame.add(panel);

        // 显示窗口
        frame.setVisible(true);
    }
}