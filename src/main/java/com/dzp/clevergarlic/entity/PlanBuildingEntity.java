package com.dzp.clevergarlic.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 预测计划-楼宇entity
 *
 * @Auther ck
 * @Date 2020/7/22 17:09
 * @Desc
 */
public class PlanBuildingEntity {

    @ApiModelProperty("主键id")
    private String planBuildingId;
    @ApiModelProperty("计划id")
    private String planId;
    @ApiModelProperty("楼宇id")
    private Integer buildingId;
    @ApiModelProperty("楼宇名称")
    private String buildingName;

    @ApiModelProperty("租金参数id")
    private String leaseId;
    @ApiModelProperty("招商参数id")
    private String businessId;

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

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(String leaseId) {
        this.leaseId = leaseId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
