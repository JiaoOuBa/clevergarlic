package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

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
    private Integer buildingId;

    @ApiModelProperty("楼宇名称")
    private String buildingName;

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getPlanBuildingId() {
        return planBuildingId;
    }

    public void setPlanBuildingId(String planBuildingId) {
        this.planBuildingId = planBuildingId;
    }
}
