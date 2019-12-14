package com.chris.sec.service;

import com.chris.sec.consts.AppConstants;
import com.chris.sec.model.UserInfo;
import com.chris.sec.utils.JWTUtils;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by: Chris Chan
 * create on: 2019/10/11 12:31
 * use for:
 */
@Service
public class UserService implements UserDetailsService {
    private static Map<String, String> userMap = new HashMap<>(16);
    private static Map<String, String> userAuthMap = new HashMap<>(16);
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        UserInfo userInfo = findUser(username);
        if (null == userInfo) {
            return null;
        }
        return new User(username, userInfo.getPassword(), getAuthorityList(username));
    }

    /**
     * 返回密码
     * 这个方法可以假设是从数据库dao层获取到用户信息
     *
     * @param username
     * @return
     */
    private UserInfo findUser(String username) {
        if (null == userMap) {
            userMap = new HashMap<>(16);
        }
        //内置几个用户
        if (userMap.size() == 0) {
            userMap.put("zhangsanfeng", passwordEncoder.encode("123123"));
            userMap.put("lisifu", passwordEncoder.encode("123123"));
            userMap.put("songzihao", passwordEncoder.encode("123123"));
        }
        String password = userMap.get(username);
        if (StringUtils.isEmpty(password)) {
            return null;
        }
        return new UserInfo(username, password);
    }

    /**
     * 获取用户权限
     * 这个方法也可以在数据库中查询
     *
     * @param username
     * @return
     */
    public static String[] getAuthorities(String username) {

        if (null == userAuthMap) {
            userAuthMap = new HashMap<>(16);
        }
        //内置几个用户权限
        if (userAuthMap.size() == 0) {
            userAuthMap.put("zhangsanfeng", "ROLE_ADMIN,ROLE_USER");
            userAuthMap.put("lisifu", "ROLE_ADMIN,ROLE_USER");
            userAuthMap.put("songzihao", "ROLE_SYS,ROLE_ADMIN,ROLE_USER");
        }
        return userAuthMap.get(username).split(",");
    }

    /**
     * 获取用户权限集合
     *
     * @param username
     * @return
     */
    public static List<GrantedAuthority> getAuthorityList(String username) {
        return AuthorityUtils.createAuthorityList(getAuthorities(username));
    }

    /**
     * 自定义Basic方式登录
     * 涉及上次面试题
     *
     * @param request
     * @param response
     * @return
     */
    public String loginBasic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从头部取得数据
        String authToken = request.getHeader(AppConstants.KEY_AUTHORIZATION);
        if (StringUtils.isEmpty(authToken) || !authToken.startsWith("Basic ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        //解析
        String loginInfo = TextCodec.BASE64URL.decodeToString(authToken.replace("Basic ", ""));
        String[] split = loginInfo.split(":");
        if (split.length != 2) {
            throw new RuntimeException("token格式不正确");
        }
        String username = split[0];
        String password = split[1];

        return login(new UserInfo(username, password), response);
    }

    /**
     * 自定义登录
     *
     * @param loginUser
     * @param response
     * @return
     */
    public String login(UserInfo loginUser, HttpServletResponse response) throws IOException {
        String username = loginUser.getUsername();
        UserInfo userInfo = findUser(username);
        //测试 上一次面试相关 如果没找到用户 抛401
        if (null == userInfo) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        //如果密码不匹配 抛403
        if (!passwordEncoder.matches(loginUser.getPassword(), userInfo.getPassword())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }

        return JWTUtils.createJWTByLoginUser(loginUser, getAuthorities(username));
    }
}
