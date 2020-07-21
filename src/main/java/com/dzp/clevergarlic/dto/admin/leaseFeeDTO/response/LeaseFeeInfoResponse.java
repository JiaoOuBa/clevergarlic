package com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Auther ck
 * @Date 2020/7/21 11:31
 * @Desc
 */
public class LeaseFeeInfoResponse {

    @ApiModelProperty("租金ID（新增不传，修改传）")
    private String leaseFeeId;
    @ApiModelProperty("所属集团ID")
    private Integer projectCompanyId;
    @ApiModelProperty("所属组织ID")
    private Integer projectOrganizeId;
    @ApiModelProperty("楼宇ID")
    private Integer buildingId;
    @ApiModelProperty("楼宇名称")
    private String buildingName;
    @ApiModelProperty("楼层")
    private Integer floorCode;
    @ApiModelProperty("单元")
    private Integer unit;
    @ApiModelProperty("楼层属性")
    private String floorProperty;
    @ApiModelProperty("租金月份（yyyy-MM）")
    private Date dateMonth;
    @ApiModelProperty("计租方式")
    private String leaseWay;
    @ApiModelProperty("租金单价")
    private BigDecimal leaseUnitPrice;
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

    public Integer getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(Integer floorCode) {
        this.floorCode = floorCode;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
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

    public BigDecimal getLeaseUnitPrice() {
        return leaseUnitPrice;
    }

    public void setLeaseUnitPrice(BigDecimal leaseUnitPrice) {
        this.leaseUnitPrice = leaseUnitPrice;
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
}
