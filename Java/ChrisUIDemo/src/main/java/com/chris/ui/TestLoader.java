package com.chris.ui;

/**
 * ChrisUIDemo
 * com.chris.ui
 * Created by Chris Chen
 * 2018/6/17
 * Explain: 为加载外部jar包中的类临时借用
 */
public class TestLoader {
    public String say(String content) {
        System.out.println(content);
        return "When I say what I say, who is in favor of it? Who is against?";
    }
}
