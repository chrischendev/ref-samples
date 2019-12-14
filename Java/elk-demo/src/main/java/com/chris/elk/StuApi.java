package com.chris.elk;

import com.chris.es.jest.utils.JestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * create by: Chris Chan
 * create on: 2019/7/30 11:52
 * use for:
 */
@RestController
@RequestMapping("/stu")
public class StuApi {
    @Autowired
    StuDao stuDao;

    @GetMapping("/add")
    public String add() {
        //stuDao.save(new Stu("kalychen", 11, "上海杨浦", "提高班"));
        Stu stu = new Stu("kalychen", 11, "上海杨浦", "提高班");
        JestUtil.init(1000 * 10, "http://192.168.0.114:9200/");
        try {
            JestUtil.save(stu, "stu_test");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return " add stu success.";
    }
    @GetMapping("/add1")
    public String add1() {
        stuDao.save(new Stu("willchan", 11, "上海杨浦", "提高班"));
        return " add1 stu success.";
    }
}
