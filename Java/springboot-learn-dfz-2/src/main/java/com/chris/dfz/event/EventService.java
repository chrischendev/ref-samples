package com.chris.dfz.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 6:05
 * Use for:
 */
@Service
public class EventService {
    @Autowired
    MyEventPublisher myEventPublisher;

    public void test01() {
        myEventPublisher.publish("我和我的祖国,一刻也不能分割。");
    }
}
