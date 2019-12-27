package com.chris.dfz.el;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Create by Chris Chan
 * Create on 2019/12/27 18:25
 * Use for: 字符串值
 */
@Component
@Data
public class StrValueService {
    @Value("位卑未敢忘忧国")
    private String mh;
}
