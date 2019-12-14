package com.chris.mm.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Chris Chen
 * 2019/5/30
 * Explain:
 */
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {
    /**
     * swagger:
     * title: <a style='font-size:20pt;color:#de55ff'>火星教育</a> 后端服务数据接口系统
     * author: Chris Chan
     * service-url: https://www.baidu.com/
     * description: ● 为了便于前端调用做统一封装，所有的接口请求和返回均采用统一的自定义协议进行打包。<br>● 本系统全部采用RequestBody模式，使用POST方式提交。
     * contact:
     * url: http://blog.csdn.net/xxkalychen
     * email: chriachen2018@163.com
     */
    private String version;
    private String title;
    private String author;
    private String serviceUrl;
    private String description;
    private Contact contact = new Contact();

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public class Contact {
        private String url;
        private String email;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
