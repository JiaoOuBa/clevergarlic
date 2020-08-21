package com.dzp.clevergarlic.dto.admin.demoDTO;

import java.sql.Date;

/**
 * @Auther ck
 * @Date 2020/7/2 13:51
 * @Desc
 */
public class DemoListResponse {

    private Integer buildingCollectionId;
    private String buildingId;
    private Integer staffId;
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")*/
    private Date createTime;

    public Integer getBuildingCollectionId() {
        return buildingCollectionId;
    }

    public void setBuildingCollectionId(Integer buildingCollectionId) {
        this.buildingCollectionId = buildingCollectionId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
