package com.faintdream.test1;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public interface FontStyle {

    /**
     * 从文件中获取字体
     * @param file 字体文件
     * @return Font 获取的字体
     * */
    Font fontByFile(File file) throws Exception;

    /**
     * 设置全局字体
     * @param font 字体
     * */
    void globalFontSet(Font font) throws Exception;

    /**
     * 为某一个组件设置字体
     * @param component 要设置字体的组件
     * @param font 字体
     * */
    void fontSet(JComponent component,Font font) throws Exception;

}
