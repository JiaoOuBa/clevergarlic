package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanBuildingResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/7/23 10:11
 * @Desc
 */
public class PlanInfoResponse {

    @ApiModelProperty("计划id")
    private String planId;
    @ApiModelProperty("计划名称")
    private String planName;
    @ApiModelProperty("计划编号")
    private String planCode;
    @ApiModelProperty("计划开始时间")
    private Date planStartTime;
    @ApiModelProperty("计划结束时间")
    private Date planEndTime;
    @ApiModelProperty("楼宇信息集合")
    private List<PlanBuildingResponse> planBuildingList;

    @ApiModelProperty("创建人id")
    private Long adminId;
    @ApiModelProperty("创建人姓名")
    private String adminName;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;
    @ApiModelProperty("审核人id")
    private Long reviewAdminId;
    @ApiModelProperty("审核人姓名")
    private String reviewAdminName;
    @ApiModelProperty("审核时间")
    private Timestamp reviewTime;

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

    public List<PlanBuildingResponse> getPlanBuildingList() {
        return planBuildingList;
    }

    public void setPlanBuildingList(List<PlanBuildingResponse> planBuildingList) {
        this.planBuildingList = planBuildingList;
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

    public Long getReviewAdminId() {
        return reviewAdminId;
    }

    public void setReviewAdminId(Long reviewAdminId) {
        this.reviewAdminId = reviewAdminId;
    }

    public String getReviewAdminName() {
        return reviewAdminName;
    }

    public void setReviewAdminName(String reviewAdminName) {
        this.reviewAdminName = reviewAdminName;
    }

    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }
}
