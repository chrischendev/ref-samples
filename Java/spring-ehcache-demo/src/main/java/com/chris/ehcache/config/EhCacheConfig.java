package com.chris.ehcache.config;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.DiskStoreConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by: Chris Chan
 * create on: 2019/6/23 10:10
 * use for:
 */
@Configuration
@EnableCaching
public class EhCacheConfig {
    @Bean
    public CacheManager cacheManager() {
        //缓存管理器
        net.sf.ehcache.config.Configuration configuration = new net.sf.ehcache.config.Configuration();

        DiskStoreConfiguration diskStoreConfiguration = new DiskStoreConfiguration();
        //String diskStorePath="java.io.tmpdir/ehcache";
        String diskStorePath = "D:\\ehcache";
        diskStoreConfiguration.setPath(diskStorePath);
        configuration.diskStore(diskStoreConfiguration);
        configuration.setName("chris_cache_manager");

        CacheManager cacheManager = CacheManager.create(configuration);

        //添加一个User的cache todo 就不能通过注解动态添加吗 需要研究JHipster项目中ehcache的使用方式
        //缓存配置文件
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setTimeToIdleSeconds(5);
        cacheConfiguration.setTimeToLiveSeconds(10);
        cacheConfiguration.setMaxEntriesLocalHeap(10000);
        cacheConfiguration.setMaxEntriesLocalDisk(1000000);
        cacheConfiguration.setName("User");//命名
        //创建缓存
        Cache cache = new Cache(cacheConfiguration);
        //添加到缓存管理器
        cacheManager.addCache(cache);

        return cacheManager;
    }

    @Bean
    public EhCacheCacheManager ehCacheCacheManager(CacheManager cacheManager) {
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(cacheManager);
        return ehCacheCacheManager;
    }

//    @Bean
//    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
//        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
//        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        return ehCacheManagerFactoryBean;
//    }
}
