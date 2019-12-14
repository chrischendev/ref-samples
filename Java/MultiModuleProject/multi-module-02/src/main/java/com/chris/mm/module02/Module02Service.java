package com.chris.mm.module02;

import com.chris.mm.base.libs.StudentModel;
import org.springframework.stereotype.Service;

/**
 * @author chrischan
 * create on 2019\7\17 0017 9:47
 * use for:
 */
@Service
public class Module02Service {
    public String getInfo() {
        return "天王盖地虎";
    }

    public StudentModel getStu() {
        return new StudentModel("Chris Chan", 42, "清河中学", 588);
    }
}
