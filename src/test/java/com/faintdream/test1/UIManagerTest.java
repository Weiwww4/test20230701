package com.faintdream.test1;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import java.beans.PropertyChangeListener;

public class UIManagerTest {
    public static void main(String[] args) {
        PropertyChangeListener[] propertyChangeListeners = UIManager.getPropertyChangeListeners();

        for (PropertyChangeListener changeListener : propertyChangeListeners) {
            System.out.println(changeListener);
        }

        LookAndFeel lookAndFeel = UIManager.getLookAndFeel();
        System.out.println(lookAndFeel);
        String description = lookAndFeel.getDescription();
        System.out.println(description);


        UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        for(UIManager.LookAndFeelInfo a : installedLookAndFeels){
            System.out.println(a);
        }
    }
}
