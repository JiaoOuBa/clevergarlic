package com.dzp.clevergarlic.dto.admin.calculateDTO;

import lombok.Data;

import java.util.List;

/**
 * 计算前数据类
 * @Auther ck
 * @Date 2020/8/5 11:25
 * @Desc
 */
@Data
public class BeforeCalculate {

    /**
     * 计划信息
     */
    private String planCode;

    /**
     * 楼宇参数集合
     */
    private List<BuildingInfo> buildingParamData;

    /**
     * 计算前最终版本
     */
    private String version;
}
