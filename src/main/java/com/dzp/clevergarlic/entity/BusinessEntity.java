package com.dzp.clevergarlic.entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 招商信息表entity
 * @Auther ck
 * @Date 2020/7/13 11:01
 * @Desc
 */
public class BusinessEntity {

    //business_id  招商ID
    private String businessId;
    //project_company_id  所属集团ID
    private Integer projectCompanyId;
    //project_organize_id  所属组织ID
    private Integer projectOrganizeId;
    //building_id  楼宇ID
    private Integer buildingId;
    //building_name  楼宇名称
    private String buildingName;
    //floor_code  楼层
    private Integer floorCode;
    //unit  单元
    private Integer unit;
    //floor_property  楼层属性
    private String floorProperty;
    //empty_date  空置期
    private String emptyDate;
    //before_decorate_date  起租前装修期
    private String beforeDecorateDate;
    //free_date  免租期
    private String freeDate;
    //after_decorate_date  届满后装修期
    private String afterDecorateDate;
    //contract_start_time  合同开始时间
    private Date contractStartTime;
    //contract_end_time  合同结束时间
    private Date contractEndTime;
    //contract_date  合同周期（租期）
    private String contractDate;
    //renew_percent  续约概率
    private String renewPercent;
    //commission_way  结佣方式
    private String commissionWay;
    //month_commission  佣金（月）
    private BigDecimal monthCommission;
    //commission  佣金（金额）
    private BigDecimal commission;
    //status  状态
    private Integer status;
    //deleted  是否删除标识（1，0）
    private Integer deleted;
    //admin_id  创建人
    private Long adminId;
    //create_time  创建时间
    private Timestamp createTime;
    //review_admin_id  审核人
    private Long reviewAdminId;
    //review_time  审核时间
    private Timestamp reviewTime;
    //update_time  最后修改时间
    private Timestamp updateTime;
    //version  版本号
    private String version;
    //linked_data_version  关联数据版本
    private String linkedDataVersion;
    //数据来源（设置/api）
    private Integer dataSource;


    @Override
    public String toString() {
        return "BusinessEntity{" +
                "businessId='" + businessId + '\'' +
                ", projectCompanyId=" + projectCompanyId +
                ", projectOrganizeId=" + projectOrganizeId +
                ", buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", floorCode=" + floorCode +
                ", unit=" + unit +
                ", floorProperty='" + floorProperty + '\'' +
                ", emptyDate='" + emptyDate + '\'' +
                ", beforeDecorateDate='" + beforeDecorateDate + '\'' +
                ", freeDate='" + freeDate + '\'' +
                ", afterDecorateDate='" + afterDecorateDate + '\'' +
                ", contractStartTime=" + contractStartTime +
                ", contractEndTime=" + contractEndTime +
                ", contractDate='" + contractDate + '\'' +
                ", renewPercent='" + renewPercent + '\'' +
                ", commissionWay='" + commissionWay + '\'' +
                ", monthCommission=" + monthCommission +
                ", commission=" + commission +
                ", status=" + status +
                ", deleted=" + deleted +
                ", adminId=" + adminId +
                ", createTime=" + createTime +
                ", reviewAdminId=" + reviewAdminId +
                ", reviewTime=" + reviewTime +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                ", linkedDataVersion='" + linkedDataVersion + '\'' +
                ", dataSource=" + dataSource +
                '}';
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

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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

    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
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
