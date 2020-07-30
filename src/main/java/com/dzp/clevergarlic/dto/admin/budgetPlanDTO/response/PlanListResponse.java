package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Auther ck
 * @Date 2020/7/22 14:00
 * @Desc
 */
public class PlanListResponse {

    @ApiModelProperty("计划id")
    private String planId;
    @ApiModelProperty("计划名称")
    private String planName;
    @ApiModelProperty("计划起始时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planStartTime;
    @ApiModelProperty("计划结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planEndTime;
    @ApiModelProperty("计划基准时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planBaseTime;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("状态名")
    private String statusName;
    @ApiModelProperty("创建人id")
    private Long adminId;
    @ApiModelProperty("创建人姓名")
    private String adminName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private Timestamp createTime;

    @ApiModelProperty("已确认参数楼数量")
    private Integer rightNum;
    @ApiModelProperty("本次预算总楼数")
    private Integer totalNum;

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
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

    public Date getPlanBaseTime() {
        return planBaseTime;
    }

    public void setPlanBaseTime(Date planBaseTime) {
        this.planBaseTime = planBaseTime;
    }
}
