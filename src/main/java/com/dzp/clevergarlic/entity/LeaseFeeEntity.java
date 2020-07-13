package com.dzp.clevergarlic.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 租金信息表entity
 * @Auther ck
 * @Date 2020/7/13 10:53
 * @Desc
 */
public class LeaseFeeEntity {

    //lease_fee_id  租金ID
    private String leaseFeeId;
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
    //date_month  租金月份（yyyy-MM）
    private Date dateMonth;
    //lease_way  计租方式
    private String leaseWay;
    //lease_unit_price  租金单价
    private BigDecimal leaseUnitPrice;
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


    @Override
    public String toString() {
        return "LeaseFeeEntity{" +
                "leaseFeeId='" + leaseFeeId + '\'' +
                ", projectCompanyId=" + projectCompanyId +
                ", projectOrganizeId=" + projectOrganizeId +
                ", buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", floorCode=" + floorCode +
                ", unit=" + unit +
                ", floorProperty='" + floorProperty + '\'' +
                ", dateMonth=" + dateMonth +
                ", leaseWay='" + leaseWay + '\'' +
                ", leaseUnitPrice=" + leaseUnitPrice +
                ", status=" + status +
                ", deleted=" + deleted +
                ", adminId=" + adminId +
                ", createTime=" + createTime +
                ", reviewAdminId=" + reviewAdminId +
                ", reviewTime=" + reviewTime +
                ", updateTime=" + updateTime +
                ", version='" + version + '\'' +
                ", linkedDataVersion='" + linkedDataVersion + '\'' +
                '}';
    }

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

}
