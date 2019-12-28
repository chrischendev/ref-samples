package com.chris.dfz.profiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Chris Chan
 * Create on 2019/12/28 20:15
 * Use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ent03 {
    private String name;

    public void say() {
        System.out.println("My name is " + name + ".");
    }
}
