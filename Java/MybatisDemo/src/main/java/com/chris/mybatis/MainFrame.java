package com.chris.mybatis;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * MybatisDemo
 * com.chris.mybatis
 * Created by Chris Chen
 * 2018/6/12
 * Explain:
 */
public class MainFrame {
    private JButton btnTest;

    public MainFrame() {
        btnTest.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("点击按钮");
            }
        });
    }
}
