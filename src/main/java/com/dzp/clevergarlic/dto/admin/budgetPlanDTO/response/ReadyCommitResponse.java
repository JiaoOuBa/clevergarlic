package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @Auther ck
 * @Date 2020/7/23 16:22
 * @Desc
 */
public class ReadyCommitResponse {

    @ApiModelProperty("主键id")
    private String readyCommitId;

    @ApiModelProperty("参数类型（1租金，2招商）")
    private Integer paramType;

    // @ApiModelProperty("参数类型名称")

    @ApiModelProperty("计划名称")
    private String planName;

    @ApiModelProperty("计划编号")
    private String planCode;

    @ApiModelProperty("计划起始时间")
    private Date planStartTime;

    @ApiModelProperty("计划结束时间")
    private Date planEndTime;

    @ApiModelProperty("状态")
    private Integer status;

    @ApiModelProperty("状态名")
    private String statusName;

    @ApiModelProperty("楼宇id")
    private Integer buildingId;

    @ApiModelProperty("楼宇名称")
    private String buildingName;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

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

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
