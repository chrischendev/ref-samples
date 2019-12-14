package com.chris.file.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Chris Chen
 * 2018/12/12
 * Explain: 上传参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadParams {
    private String fileName;
    private int[] dataByteArray;//数据数组
}
