package com.chris.dfz.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 12:24
 * Use for:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles("dev")
public class TestTest {
    @Autowired
    private Ent09 ent09;

    @Test
    public void test(){
        ent09.say();
    }
    @Test
    public void test1(){
        Assert.assertEquals(ent09.getMsg(),"生产环境");
    }
}
