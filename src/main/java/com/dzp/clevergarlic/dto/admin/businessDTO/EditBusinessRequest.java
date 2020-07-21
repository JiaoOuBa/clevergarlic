package com.dzp.clevergarlic.dto.admin.businessDTO;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Auther ck
 * @Date 2020/7/13 16:36
 * @Desc
 */
public class EditBusinessRequest {

    @ApiModelProperty("操作类型（1.提交，2.保存为草稿）")
    private Integer operation;
    @ApiModelProperty("招商ID（新增不传）")
    private String businessId;
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
    @ApiModelProperty("空置期")
    private String emptyDate;
    @ApiModelProperty("起租前装修期")
    private String beforeDecorateDate;
    @ApiModelProperty("免租期")
    private String freeDate;
    @ApiModelProperty("届满后装修期")
    private String afterDecorateDate;
    @ApiModelProperty("合同开始时间")
    private Date contractStartTime;
    @ApiModelProperty("合同结束时间")
    private Date contractEndTime;
    @ApiModelProperty("合同周期（租期）")
    private String contractDate;
    @ApiModelProperty("续约概率")
    private String renewPercent;
    @ApiModelProperty("结佣方式")
    private String commissionWay;
    @ApiModelProperty("佣金（月）")
    private BigDecimal monthCommission;
    @ApiModelProperty("佣金（金额）")
    private BigDecimal commission;
    @ApiModelProperty("状态")
    private Integer status;
    @ApiModelProperty("创建人")
    private Long adminId;
    @ApiModelProperty("版本号")
    private String version;
    @ApiModelProperty("关联数据版本")
    private String linkedDataVersion;
    @ApiModelProperty("数据来源（1.设置，2.api）")
    private Integer dataSource;

    public Integer getOperation() {
        return operation;
    }

    public void setOperation(Integer operation) {
        this.operation = operation;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
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

    public String getEmptyDate() {
        return emptyDate;
    }

    public void setEmptyDate(String emptyDate) {
        this.emptyDate = emptyDate;
    }

    public String getBeforeDecorateDate() {
        return beforeDecorateDate;
    }

    public void setBeforeDecorateDate(String beforeDecorateDate) {
        this.beforeDecorateDate = beforeDecorateDate;
    }

    public String getFreeDate() {
        return freeDate;
    }

    public void setFreeDate(String freeDate) {
        this.freeDate = freeDate;
    }

    public String getAfterDecorateDate() {
        return afterDecorateDate;
    }

    public void setAfterDecorateDate(String afterDecorateDate) {
        this.afterDecorateDate = afterDecorateDate;
    }

    public Date getContractStartTime() {
        return contractStartTime;
    }

    public void setContractStartTime(Date contractStartTime) {
        this.contractStartTime = contractStartTime;
    }

    public Date getContractEndTime() {
        return contractEndTime;
    }

    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getRenewPercent() {
        return renewPercent;
    }

    public void setRenewPercent(String renewPercent) {
        this.renewPercent = renewPercent;
    }

    public String getCommissionWay() {
        return commissionWay;
    }

    public void setCommissionWay(String commissionWay) {
        this.commissionWay = commissionWay;
    }

    public BigDecimal getMonthCommission() {
        return monthCommission;
    }

    public void setMonthCommission(BigDecimal monthCommission) {
        this.monthCommission = monthCommission;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
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
