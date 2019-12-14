package com.chris.web.model;

import com.chris.poi.xls.XlsColumn;
import com.chris.poi.xls.XlsSheet;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Create by Chris Chan
 * Create on 2019/6/10 15:45
 * Use for:
 */
@XlsSheet("user")
@Data
@NoRepositoryBean
@AllArgsConstructor
public class UserXio {
    @XlsColumn("姓名")
    private String name;
    @XlsColumn("年龄")
    private int age;
    @XlsColumn("地址")
    private String address;
}
