package com.chris.dfz.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * Create by Chris Chan
 * Create on 2019/12/27 18:26
 * Use for:
 */
@Configuration
@ComponentScan("com.chris.dfz.el")
@PropertySource(value = "classpath:static/info.yml", factory = YamlPropertySourceFactory.class)
public class ElConfig {
    //1. 一个普通字符串的值
    @Value("I lave my homeland.")
    private String strVal;

    //2. 获取系统名称
    @Value("#{systemProperties['os.name']}")
    private String osName;

    //3. 获取一个随机数
    @Value("#{T(java.lang.Math).random()*100.0}")
    private double rndNumber;

    //4. 从别的对象中获取一个值
    @Value("#{strValueService.mh}")
    private String fromAnotherBean;

    //5. 读取文本文件
    @Value("classpath:static/info.txt")
    private Resource txtFile;

    //6. 读取配置文件变量
    @Value("${book.author}")
    private String bookAuthor;

    //7. 读取网址内容
    @Value("https://www.baidu.com")
    private Resource url;

    @Autowired
    Environment env;

    //下面这个bean必须有，否则找不到配置文件
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * 打印变量的值
     */
    public void show() {
        try {
            System.out.println(strVal);
            System.out.println(osName);
            System.out.println(rndNumber);
            System.out.println(rndNumber);
            System.out.println(fromAnotherBean);

            System.out.println(env.getProperty("book.name"));
            System.out.println(bookAuthor);

            System.out.println(IOUtils.toString(txtFile.getInputStream()));
            System.out.println(IOUtils.toString(url.getInputStream()));


        } catch (Exception e) {

        }
    }
}
