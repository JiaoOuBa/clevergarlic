package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Auther ck
 * @Date 2020/7/23 14:40
 * @Desc
 */
public class ReviewPlanRequest {

    @ApiModelProperty("操作类型：1.确认，2.取消...")
    @NotNull(message = "操作类型必传")
    private Integer operation;
    @ApiModelProperty("计划id")
    @NotEmpty(message = "计划id必传")
    private String planId;

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
}
