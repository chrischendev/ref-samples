package com.chris.web.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Chris Chen
 * 2018/10/13
 * Explain: 监控数据采集 接口
 */

public interface ITestApi {

    @PostMapping("/getSchool")
    ResponseEntity<?> getSchool();

    //    ResponseEntity<?> searchVehicleList(SearchVehicleListParams params);
    @PostMapping("/getGradeList")
    ResponseEntity<?> getGradeList();

    @PostMapping("/getClassList")
    ResponseEntity<?> getClassList();

    @PostMapping("/getStuList")
    ResponseEntity<?> getStuList(int page, int pageSize, int flag);

}
