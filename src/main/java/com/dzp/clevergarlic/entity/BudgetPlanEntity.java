package com.dzp.clevergarlic.entity;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanBuildingResponse;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 预算计划entity
 *
 * @Auther ck
 * @Date 2020/7/22 13:22
 * @Desc
 */
public class BudgetPlanEntity {

    private String planId;
    private String planName;
    private String planCode;
    private Date planStartTime;
    private Date planEndTime;
    private List<PlanBuildingResponse> planBuildingList;
    private Integer status;
    private String statusName;
    private Long adminId;
    private String adminName;
    private Timestamp createTime;

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

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }
}
