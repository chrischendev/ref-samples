package com.chris.lottery.calc.doublecolor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by: Chris Chan
 * create on: 2019/6/30 4:42
 * use for: 中奖结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrizeResult {
    private int level;
    private int count;
}
