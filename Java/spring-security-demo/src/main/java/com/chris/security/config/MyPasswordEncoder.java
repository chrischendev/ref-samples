package com.chris.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 19:56
 * use for:
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return String.valueOf(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence);
    }
}
