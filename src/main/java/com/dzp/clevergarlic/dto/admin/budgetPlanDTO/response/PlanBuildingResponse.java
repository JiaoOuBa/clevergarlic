package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 计划-楼宇信息返回实体
 * @Auther ck
 * @Date 2020/7/22 13:46
 * @Desc
 */
public class PlanBuildingResponse {

    @JsonIgnore
    private String planBuildingId;

    @ApiModelProperty("计划id")
    private String planId;

    @ApiModelProperty("楼宇id")
    private String buildingId;

    @ApiModelProperty("楼宇名称")
    private String buildingName;

    @ApiModelProperty("房屋类型")
    private String buildingType;

    public String getPlanBuildingId() {
        return planBuildingId;
    }

    public void setPlanBuildingId(String planBuildingId) {
        this.planBuildingId = planBuildingId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }
}
