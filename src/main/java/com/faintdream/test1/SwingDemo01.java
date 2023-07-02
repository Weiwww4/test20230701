package com.faintdream.test1;

import com.faintdream.tool.util.IOUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class SwingDemo01 {
    public static void main(String[] args) throws IOException, FontFormatException {
        // 创建窗口
        JFrame frame = new JFrame("窗口示例");

        // 设置窗口大小和位置
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // 居中显示窗口
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font MyFont = SwingDemo01.fontByFile(IOUtil.getFile("Alimama_ShuHeiTi_Bold.ttf")).deriveFont(Font.PLAIN, 8);
        frame.getContentPane().setFont(MyFont);

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 创建提示文本标签
        JLabel label = new JLabel("以下操作将有一定风险,请确认");
        label.setHorizontalAlignment(JLabel.CENTER);
        // label.setFont(new Font("Default", Font.PLAIN, 20));
        SwingDemo01.setFont(label);

        // 创建确认按钮
        JButton button = new JButton("确认");
        // button.setFont(new Font("Default", Font.PLAIN, 16));
        SwingDemo01.setFont(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭窗口
                frame.dispose();
                System.out.println("关闭窗口[Close Window]");
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

    public static void setFont(JComponent component, File file){
        try {
            // 从字体文件加载字体
            Font font = fontByFile(file);

            // 设置按钮的字体
            component.setFont(font.deriveFont(Font.PLAIN, 14));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    public static void setFont(JComponent component){
        setFont(component, IOUtil.getFile("Alimama_ShuHeiTi_Bold.ttf"));
    }

    public static Font fontByFile(File file) throws IOException, FontFormatException {

        // 从字体文件加载字体
        Font font = Font.createFont(Font.TRUETYPE_FONT, file);

        // 注册字体到图形环境
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        return font;
    }
}