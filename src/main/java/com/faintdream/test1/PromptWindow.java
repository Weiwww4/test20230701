package com.faintdream.test1;

import com.faintdream.tool.util.IOUtil;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class PromptWindow extends JFrame implements FontStyle{

    public static void main(String[] args) throws IOException, FontFormatException {
        // new PromptWindow().show();
        new PromptWindow().setVisible(true);
    }


    /**
     * 构造方法
     * */
    public PromptWindow() throws HeadlessException, IOException, FontFormatException {
        super();
        init();
    }

    /**
     * 显示窗口
     * */
    public void show(){
        // 显示窗口
        setVisible(true);
    }

    public void init() throws IOException, FontFormatException {
        // 设置窗口标题
        setTitle("窗口示例");

        // 设置窗口大小和位置
        setSize(300, 200);
        setLocationRelativeTo(null); // 居中显示窗口
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font MyFont = PromptWindow.fontByFile(IOUtil.getFile("Alimama_ShuHeiTi_Bold.ttf")).deriveFont(Font.PLAIN, 8);
        getContentPane().setFont(MyFont);

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 创建提示文本标签
        JLabel label = new JLabel("以下操作将有一定风险,请确认");
        label.setHorizontalAlignment(JLabel.CENTER);
        // label.setFont(new Font("Default", Font.PLAIN, 20));
        PromptWindow.setFont(label);

        // 创建确认按钮
        JButton button = new JButton("确认");
        // button.setFont(new Font("Default", Font.PLAIN, 16));
        PromptWindow.setFont(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭窗口
                dispose();
                System.out.println("关闭窗口[Close Window]");
            }
        });

        // 将文本标签和按钮添加到面板
        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        // 将面板添加到窗口
        add(panel);
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

    /**
     * 从文件中读取字体
     * @param file  文件路径
     * @throws IOException,FontFormatException 读取文件相关的问题
     * */
    public static Font fontByFile(File file) throws IOException, FontFormatException {

        // 从字体文件加载字体
        Font font = Font.createFont(Font.TRUETYPE_FONT, file);

        // 注册字体到图形环境
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        return font;
    }

    /**
     * 设置字体样式
     *
     * @param font 要设置样式的字体
     */
    @Override
    public void setFontStyle(Font font) throws Exception {

    }

    /**
     * 设置全局字体
     * @param font 字体
     * */
    public void setGlobalFont(Font font) {
        // 获取默认字体属性
        FontUIResource fontUIResource = new FontUIResource(font);

        // 设置全局字体
        UIManager.put("Button.font", fontUIResource); // 设置按钮栏字体
        UIManager.put("Label.font", fontUIResource); // 设置文本标签字体
        UIManager.put("TextField.font", fontUIResource); // 设置文本输入框字体
        UIManager.put("InternalFrame.titleFont", fontUIResource); // 设置标题栏字体
        // 添加其他需要设置字体的 Swing 组件

        // 刷新 Swing 组件以应用全局字体
        SwingUtilities.updateComponentTreeUI(new JFrame());
    }

    /**
     * 为某一个组件设置字体
     *
     * @param component 要设置字体的组件
     * @param font      字体
     */
    @Override
    public void setFont(JComponent component, Font font) throws Exception {

    }


}