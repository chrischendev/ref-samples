
package com.chris.web.api;

import com.api.enhance.ApiEnhanceManager;
import com.api.enhance.annotation.TimeLimit;
import com.chris.poi.xls.XlsDataWorkBook;
import com.chris.servlet.poi.XlsIOUtils;
import com.chris.web.dao.Qo03SchoolDao;
import com.chris.web.model.UserXio;
import com.chris.web.model.qo02.Qo02StuEntity;
import com.chris.web.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * REST controller for managing users.
 */
@RestController
@RequestMapping("/api")
public class TestApi implements ITestApi {
    @Autowired
    Qo03SchoolDao schoolDao;
    @Autowired
    SchoolService schoolService;

    @TimeLimit(1000 * 5)
    @GetMapping("/testSearch")
    public ResponseEntity<?> testSearch() {
        return ResponseEntity.ok("搜索结果成功");
    }

    @TimeLimit(1000 * 1)
    @GetMapping("/map")
    public ResponseEntity<?> map() {
        return ResponseEntity.ok(ApiEnhanceManager.getTimeLimitMap());
    }

    @Override
    public ResponseEntity<?> getSchool() {
//        return ResponseEntity.ok(schoolDao.findSchools());
        return ResponseEntity.ok(schoolService.searchSchoolPage(0, 10).getContent());
    }

    @Override
    public ResponseEntity<?> getGradeList() {
        return null;
    }

    @Override
    public ResponseEntity<?> getClassList() {
        return null;
    }

    @Override
    public ResponseEntity<?> getStuList(int page, int pageSize, int flag) {
        return ResponseEntity.ok(schoolService.searchStuPage(page, pageSize, flag));
    }

    @PostMapping("/getStuPage")
    public ResponseEntity<?> getStuPage(int page, int pageSize, int flag) {
        Page<Qo02StuEntity> pageData = schoolService.searchStuPage3(page, pageSize, flag);
        return ResponseEntity.ok().header("x-total-count", String.valueOf(pageData.getTotalElements())).body(pageData.getContent());
    }

    @PostMapping("/getStuExtList")
    public ResponseEntity<?> getStuExtList(int flag) {
        return ResponseEntity.ok(schoolService.searchStuPage1(0, 10, flag));
    }

    @PostMapping("/getStuExtPage")
    public ResponseEntity<?> getStuExtPage(int flag) {
        return ResponseEntity.ok(schoolService.searchStuExtPage(0, 10, flag).getContent());
    }

    @PostMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("test called success!");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/testExport")
    public ResponseEntity<?> testExport(HttpServletResponse response) throws IOException, IllegalAccessException {
        XlsDataWorkBook workBook = XlsDataWorkBook.get()
                .addDataList(UserXio.class, "用户", new ArrayList<>());
        XlsIOUtils.writeToResponse("用户", response, workBook);
        return ResponseEntity.ok().build();
    }
}
