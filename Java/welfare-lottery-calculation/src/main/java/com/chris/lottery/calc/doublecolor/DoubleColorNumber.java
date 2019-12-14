package com.chris.lottery.calc.doublecolor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/6/30 1:41
 * use for: 双色球号码组
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoubleColorNumber {
    private List<Integer> redColorList;
    private Integer blueColor;

    public static DoubleColorNumber build(Integer... nums) {
        DoubleColorNumber number = new DoubleColorNumber();
        if (nums.length != 7) {
            new RuntimeException("num length must equals 7.");
        }
        List<Integer> redNumList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            redNumList.add(nums[i]);
        }
        number.setRedColorList(redNumList);
        number.setBlueColor(nums[6]);
        return number;
    }
}
