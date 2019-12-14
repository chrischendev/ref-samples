package com.chris.web.dao.sql;

/**
 * Create by Chris Chan
 * Create on 2019/5/16 14:30
 * Use for:
 */
public interface Qo03Sql {
    String SQL_FIND_SCHOOLS="select s.*, stu.name as stu_name, stu.age as stu_age, c.name as class_name, g.name as grade_name, s.name as school_name\n" +
            "from cc_test_school as s\n" +
            "       left join cc_test_grade as g on g.school_id = s.id\n" +
            "       left join cc_test_class as c on c.grade_id = g.id\n" +
            "       left join cc_test_stu as stu on stu.class_id = c.id";
}
