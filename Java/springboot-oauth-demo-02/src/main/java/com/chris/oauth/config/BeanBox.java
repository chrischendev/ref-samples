package com.chris.oauth.config;

import com.chris.oauth.consts.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * create by: Chris Chan
 * create on: 2019/10/12 12:35
 * use for:
 */
@Configuration
public class BeanBox {
    /**
     * 密码编码器
     * 这个实例中security和oauth都是用一个密码编码器
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * jwt生成处理
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * token转换器
     * @return
     */
    @Bean
    protected JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "mySecretKey".toCharArray());
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"));
        converter.setSigningKey(AppConstants.JWT_SECRET_KEY_NORMAL);//设置JWT指纹
        return converter;
    }

}
