package com.chris.mm.web.service;

import com.chris.mm.module01.ModuleUtils;
import org.springframework.stereotype.Service;

/**
 * @author chrischan
 * create on 2019\7\17 0017 10:02
 * use for:
 */
@Service
public class ManService {
    public void show() {
        ModuleUtils.show();
    }
}
