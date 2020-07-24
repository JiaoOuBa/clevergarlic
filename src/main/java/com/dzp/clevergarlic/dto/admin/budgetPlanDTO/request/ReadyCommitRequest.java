package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther ck
 * @Date 2020/7/23 15:35
 * @Desc
 */
public class ReadyCommitRequest {


    @ApiModelProperty("主键id")
    private String readyCommitId;

    @ApiModelProperty("参数类型（1租金，2招商）")
    private Integer paramType;

    @ApiModelProperty("计划id")
    private String planId;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("计划-楼宇id")
    private String planBuildingId;

    public String getReadyCommitId() {
        return readyCommitId;
    }

    public void setReadyCommitId(String readyCommitId) {
        this.readyCommitId = readyCommitId;
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPlanBuildingId() {
        return planBuildingId;
    }

    public void setPlanBuildingId(String planBuildingId) {
        this.planBuildingId = planBuildingId;
    }
}
