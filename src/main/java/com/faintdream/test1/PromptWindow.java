package com.faintdream.test1;

import com.faintdream.tool.util.IOUtil;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class PromptWindow extends JFrame implements FontStyle {

    // 全局字体
    private final Font globalFont = fontByFile(IOUtil.getFile("simsun.ttc"));

    public static void main(String[] args) throws IOException, FontFormatException {
        PromptWindow promptWindow = new PromptWindow();
        promptWindow.setVisible(true);
    }


    /**
     * 构造方法
     */
    public PromptWindow() throws HeadlessException, IOException, FontFormatException {
        super();
        init();
    }

    public void init() throws IOException, FontFormatException {

        // 设置全局样式
        globalFontSet(globalFont);

        // 设置窗口标题
        setTitle("窗口示例");

        // 设置窗口属性
        setSize(300, 200);
        setLocationRelativeTo(null); // 居中显示窗口
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(IOUtil.getURL("纸箱.png")));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });

        // 创建面板
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // 创建提示文本标签
        JLabel label = new JLabel("操作有一定风险,请确认!!!");
        label.setHorizontalAlignment(JLabel.CENTER);

        // 创建确认按钮
        JButton button = new JButton("确认");
        button.setPreferredSize(new Dimension(70, 35)); // 设置按钮尺寸
        button.addActionListener(e -> closeWindow());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button);

        // 将文本标签和按钮添加到面板
        panel.add(label, BorderLayout.CENTER);
        panel.add(buttonPanel,BorderLayout.SOUTH);

        // 将面板添加到窗口
        add(panel);
    }


    /**
     * 从文件中读取字体
     *
     * @param file 文件路径
     * @throws IOException,FontFormatException 读取文件相关的问题
     */
    @Override
    public Font fontByFile(File file) throws IOException, FontFormatException {

        // 从字体文件加载字体
        Font font = Font.createFont(Font.TRUETYPE_FONT, file);

        return font;
    }

    /**
     * 设置全局字体
     *
     * @param font 字体
     */
    @Override
    public void globalFontSet(Font font) {

        // 设置字体样式
        font = processFont(font);

        // 注册字体
        registerFont(font);

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
    public void fontSet(JComponent component, Font font) {

        // 设置字体样式
        font = processFont(font);

        // 注册字体
        registerFont(font);

        // 设置按钮的字体
        component.setFont(font);
    }


    /**
     * 设置字体样式(加工字体)
     *
     * @param font 要设置样式的字体
     * @return Font 设置完成后的字体
     */
    private Font processFont(Font font) {
        return font.deriveFont(Font.BOLD, 16);
    }

    /**
     * 注册字体到图形环境
     *
     * @param font 要注册的字体
     */
    private void registerFont(Font font) {
        // 注册字体到图形环境
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
    }

    /**
     * 关闭窗口
     */
    public void closeWindow(){
        // 关闭窗口
        dispose();
        System.out.println("关闭窗口[Close Window]");
    }

}