package com.chris.dfz.construct.jsr250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Create by Chris Chan
 * Create on 2019/12/28 20:30
 * Use for: jsr250模式
 */
public class Ent05 {
    public Ent05() {
        System.out.println("Ent05 create.");
    }

    @PostConstruct
    public void init() {
        System.out.println("Ent05 is inited.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Ent05 is destroied.");
    }
}
