package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanBuildingResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/7/22 15:19
 * @Desc
 */
public class SavePlanRequest {

    @ApiModelProperty("计划id（新增不传，修改必传）")
    private String planId;
    @ApiModelProperty("计划名称")
    @NotEmpty(message = "计划名称不能为空！")
    private String planName;
    @ApiModelProperty("计划起始时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planStartTime;
    @ApiModelProperty("计划结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planEndTime;
    @ApiModelProperty("baseTime")
    private Date baseTime;
    @JsonIgnore
    private Integer status;
    @JsonIgnore
    private Long adminId;
    @JsonIgnore
    private String planCode;// FP+年月日+公司编码+5位流水
    @JsonIgnore
    private String planVersion;// 版本号
    @ApiModelProperty("计划楼宇集合")
    @NotEmpty(message = "请选择楼宇！")
    private List<PlanBuildingResponse> planBuildingList;

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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getPlanVersion() {
        return planVersion;
    }

    public void setPlanVersion(String planVersion) {
        this.planVersion = planVersion;
    }

    public Date getBaseTime() {
        return baseTime;
    }

    public void setBaseTime(Date baseTime) {
        this.baseTime = baseTime;
    }
}
