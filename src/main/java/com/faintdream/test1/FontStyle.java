package com.faintdream.test1;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public interface FontStyle {

    /**
     * 设置字体样式
     * @param font 要设置样式的字体
     * */
    void setFontStyle(Font font) throws Exception;

    /**
     * 设置全局字体
     * @param font 字体
     * */
    void setGlobalFont(Font font) throws Exception;

    /**
     * 为某一个组件设置字体
     * @param component 要设置字体的组件
     * @param font 字体
     * */
    void setFont(JComponent component,Font font) throws Exception;

}
