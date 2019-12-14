package com.chris.lottery.calc.doublecolor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by: Chris Chan
 * create on: 2019/6/30 4:14
 * use for: 号码匹配结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchResult {
    //红球匹配数量
    private int matchRedNum;
    //蓝球是否匹配
    private boolean isMatchBlue;
}
