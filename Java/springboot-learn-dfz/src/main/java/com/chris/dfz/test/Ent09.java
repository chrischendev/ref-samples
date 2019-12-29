package com.chris.dfz.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 12:19
 * Use for:
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ent09 {
    private String msg;

    public void say() {
        System.out.println("测试信息: " + this.msg);
    }
}
