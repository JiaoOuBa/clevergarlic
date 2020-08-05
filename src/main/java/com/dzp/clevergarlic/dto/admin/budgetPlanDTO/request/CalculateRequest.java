package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther ck
 * @Date 2020/8/5 11:00
 * @Desc
 */
@Data
public class CalculateRequest {

    @ApiModelProperty("计划id")
    private String planId;
}
