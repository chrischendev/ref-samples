package com.chris.dfz.aware;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 7:00
 * Use for: 一下子实现了Aware系列所有的接口，一共13个，哈哈
 */
@Component
@Getter
public class Ent06 implements
        BeanNameAware,
        BeanFactoryAware,
        BeanClassLoaderAware,
        ApplicationContextAware,
        MessageSourceAware,
        ApplicationEventPublisherAware,
        ResourceLoaderAware,
        EmbeddedValueResolverAware,
        EnvironmentAware,
        ImportAware,
        LoadTimeWeaverAware,
        ServletConfigAware,
        ServletContextAware {

    private String beanName;
    private BeanFactory beanFactory;
    private ClassLoader classLoader;
    private ApplicationContext applicationContext;
    private ApplicationEventPublisher applicationEventPublisher;
    private MessageSource messageSource;
    private ResourceLoader resourceLoader;
    private StringValueResolver stringValueResolver;
    private Environment environment;
    private AnnotationMetadata annotationMetadata;
    private LoadTimeWeaver loadTimeWeaver;
    private ServletConfig servletConfig;
    private ServletContext servletContext;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.stringValueResolver = resolver;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setImportMetadata(AnnotationMetadata importMetadata) {
        this.annotationMetadata = importMetadata;
    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        this.loadTimeWeaver = loadTimeWeaver;
    }

    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        this.servletConfig = servletConfig;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }


}
