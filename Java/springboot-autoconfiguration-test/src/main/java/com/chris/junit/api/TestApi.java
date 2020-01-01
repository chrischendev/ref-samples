package com.chris.junit.api;

import com.chris.sad.ChrisService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/12/30 1:56
 * Use for:
 */
@RestController
@RequestMapping("/api")
public class TestApi implements ApplicationContextAware {
    private ApplicationContext context;
    //包被排除，自定义的自动配置失效了
    //@Autowired
    //ChrisService chrisService;

    @GetMapping("/test")
    public String test() {
        if (this.context.containsBean(ChrisService.class.getName())) {
            ChrisService chrisService = this.context.getBean(ChrisService.class);
            chrisService.say();
            return "Test success.";
        }
        return "Not found bean.";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
