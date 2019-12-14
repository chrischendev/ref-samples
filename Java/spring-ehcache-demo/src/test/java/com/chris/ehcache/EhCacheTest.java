package com.chris.ehcache;

import com.chris.ehcache.model.UserModel;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.DiskStoreConfiguration;

/**
 * create by: Chris Chan
 * create on: 2019/6/23 9:33
 * use for:
 */
public class EhCacheTest {
    public static void main(String[] args) {
        test3();
    }

    /**
     * 程序配置方式
     */
    private static void test3() {
        //缓存管理器
        Configuration configuration=new Configuration();

        DiskStoreConfiguration diskStoreConfiguration=new DiskStoreConfiguration();
        //String diskStorePath="java.io.tmpdir/ehcache";
        String diskStorePath="D:\\ehcache";
        diskStoreConfiguration.setPath(diskStorePath);
        configuration.diskStore(diskStoreConfiguration);

        CacheManager cacheManager=CacheManager.create(configuration);
        //缓存配置文件
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setTimeToIdleSeconds(5);
        cacheConfiguration.setTimeToLiveSeconds(10);
        cacheConfiguration.setMaxEntriesLocalHeap(10000);
        cacheConfiguration.setMaxEntriesLocalDisk(1000000);
        cacheConfiguration.setName("user");//命名
        //创建缓存
        Cache cache = new Cache(cacheConfiguration);
        //添加到缓存管理器
        cacheManager.addCache(cache);

        UserModel user=new UserModel(1,"chris",42);
        Element element=new Element("chris",user);
        cache.put(element);

        Element element1 = cache.get("chris");
        System.out.println(element1.getObjectValue());

        cache.flush();
        cacheManager.shutdown();

    }

    /**
     * 网络资料源码
     */
    private static void test2() {
        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");

        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("HelloWorldCache");

        // 3. 创建元素
        Element element = new Element("key1", "value1");

        // 4. 将元素添加到缓存
        cache.put(element);

        // 5. 获取缓存
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        // 6. 删除元素
        cache.remove("key1");

        UserModel user = new UserModel(2,"kaly", 40);
        Element element2 = new Element("kaly", user);
        cache.put(element2);
        Element value2 = cache.get("kaly");
        UserModel user2 = (UserModel) value2.getObjectValue();
        System.out.println(user2);

        System.out.println(cache.getSize());

        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();
    }

    /**
     * xml文件配置方式
     */
    private static void test1() {
        CacheManager cacheManager=CacheManager.create("./src/main/resources/ehcache.xml");
        Cache cache=cacheManager.getCache("HelloWorldCache");
        Element element=new Element("key1","val1");
        cache.put(element);

        Element element1 = cache.get("key1");
        System.out.println(element1.getObjectValue());
    }
}
