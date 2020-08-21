package com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Auther ck
 * @Date 2020/7/21 11:31
 * @Desc
 */
public class LeaseFeeInfoResponse {

    @ApiModelProperty("计划id")
    private String planId;

    @ApiModelProperty("租金ID")
    private String leaseFeeId;
    @ApiModelProperty("所属集团ID")
    private Integer projectCompanyId;
    @ApiModelProperty("所属组织ID")
    private Integer projectOrganizeId;
    @ApiModelProperty("楼宇ID")
    private String buildingId;
    @ApiModelProperty("楼宇名称")
    private String buildingName;
    @ApiModelProperty("楼层")
    private Integer floorCode;
    @ApiModelProperty("单元")
    private String unit;
    @ApiModelProperty("楼层属性")
    private String floorProperty;
    @ApiModelProperty("租金月份（yyyy-MM）")
    private Date dateMonth;
    @ApiModelProperty("计租方式")
    private String leaseWay;

    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("状态名")
    private String statusName;
    @ApiModelProperty("创建人id")
    private Long adminId;
    @ApiModelProperty("创建人姓名")
    private String adminName;
    @ApiModelProperty("审核人")
    private Long reviewAdminId;
    @ApiModelProperty("审核人姓名")
    private String reviewAdminName;
    @ApiModelProperty("审核时间")
    private Timestamp reviewTime;
    @ApiModelProperty("版本号")
    private String version;
    @ApiModelProperty("关联数据版本")
    private String linkedDataVersion;
    @ApiModelProperty("数据来源（1.设置，2.api）")
    private Integer dataSource;

    @ApiModelProperty("设定方式(1.按单元，2.按楼层，3.按整楼)")
    private Integer installType;
    @ApiModelProperty("设定值")
    private String installValue;

    @ApiModelProperty("租金单价集合")
    private List<LeasePrice> priceList;

    public String getLeaseFeeId() {
        return leaseFeeId;
    }

    public void setLeaseFeeId(String leaseFeeId) {
        this.leaseFeeId = leaseFeeId;
    }

    public Integer getProjectCompanyId() {
        return projectCompanyId;
    }

    public void setProjectCompanyId(Integer projectCompanyId) {
        this.projectCompanyId = projectCompanyId;
    }

    public Integer getProjectOrganizeId() {
        return projectOrganizeId;
    }

    public void setProjectOrganizeId(Integer projectOrganizeId) {
        this.projectOrganizeId = projectOrganizeId;
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

    public Integer getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(Integer floorCode) {
        this.floorCode = floorCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFloorProperty() {
        return floorProperty;
    }

    public void setFloorProperty(String floorProperty) {
        this.floorProperty = floorProperty;
    }

    public Date getDateMonth() {
        return dateMonth;
    }

    public void setDateMonth(Date dateMonth) {
        this.dateMonth = dateMonth;
    }

    public String getLeaseWay() {
        return leaseWay;
    }

    public void setLeaseWay(String leaseWay) {
        this.leaseWay = leaseWay;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLinkedDataVersion() {
        return linkedDataVersion;
    }

    public void setLinkedDataVersion(String linkedDataVersion) {
        this.linkedDataVersion = linkedDataVersion;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    public List<LeasePrice> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<LeasePrice> priceList) {
        this.priceList = priceList;
    }

    public Integer getInstallType() {
        return installType;
    }

    public void setInstallType(Integer installType) {
        this.installType = installType;
    }

    public String getInstallValue() {
        return installValue;
    }

    public void setInstallValue(String installValue) {
        this.installValue = installValue;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

}
